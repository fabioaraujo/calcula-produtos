package br.com.fabioaraujo.calcula.produto.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.fabioaraujo.calcula.produto.dto.HoraTrabalhada;
import br.com.fabioaraujo.calcula.produto.dto.Produto;
import br.com.fabioaraujo.calcula.produto.dto.ProdutoDTO;
import br.com.fabioaraujo.calcula.produto.dto.ProdutoDTOResponse;
import br.com.fabioaraujo.calcula.produto.service.HoraTrabalhadaService;
import br.com.fabioaraujo.calcula.produto.service.ProdutoService;

@RestController
@RequestMapping("produtos")
class ProdutoController {
	@Autowired 
	private ProdutoService produtoService;
	@Autowired 
	private HoraTrabalhadaService horaTrabalhadaService;

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO produtoDTO) {
		produtoDTO.setId(null);
		Produto produto = save(produtoDTO);
		UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(
				ProdutoController.class, "getProduto", produto.getId()).build();
		URI uri = uriComponents.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping()
	@ResponseBody
	public ResponseEntity<Produto> atualizar(@RequestBody ProdutoDTO produtoDTO) {
		save(produtoDTO);
		return ResponseEntity.noContent().build();
	}

	private Produto save(ProdutoDTO produtoDTO) {
		Produto produto = produtoDTO.toProduto();
		Long id = produtoService.criar(produto);
		produto.setId(id);
		produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		return produto;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ProdutoDTOResponse> getProduto(@PathVariable("id") Long id) {
		Produto produto = produtoService.getProduto(id);
		if(produto != null)
			produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		return ResponseEntity.ok(produto.toDTO());
	}

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<ProdutoDTOResponse>> listar(){
		List<Produto> listar = produtoService.listar();
		final HoraTrabalhada custoHora = horaTrabalhadaService.getHora();
		List<ProdutoDTOResponse> retorno = listar.stream().map(p -> {
			p.setCustoHoraTrabalhada(custoHora);
			return p.toDTO();
		}).collect(Collectors.toList());
		
		return ResponseEntity.ok(retorno);
	}
}