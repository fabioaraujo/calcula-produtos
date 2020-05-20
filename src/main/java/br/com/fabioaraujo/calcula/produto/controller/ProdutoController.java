package br.com.fabioaraujo.calcula.produto.controller;

import java.net.URI;
import java.util.List;

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

import br.com.fabioaraujo.calcula.produto.dto.Produto;
import br.com.fabioaraujo.calcula.produto.dto.ProdutoDTO;
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
				ItemController.class, "getProduto", produto.getId()).build();
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
	public ResponseEntity<Produto> getProduto(@PathVariable("id") Long id) {
		Produto produto = produtoService.getProduto(id);
		produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		return ResponseEntity.ok(produto);
	}

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Produto>> listar(){
		List<Produto> listar = produtoService.listar();
		for (Produto produto : listar) {
			produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		}
		return ResponseEntity.ok(listar);
	}
}