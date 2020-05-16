package br.com.fabioaraujo.calcula.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioaraujo.calcula.produto.dto.Produto;
import br.com.fabioaraujo.calcula.produto.dto.ProdutoDTO;
import br.com.fabioaraujo.calcula.produto.service.HoraTrabalhadaService;
import br.com.fabioaraujo.calcula.produto.service.ProdutoService;

@RestController
@RequestMapping("produto")
class ProdutoController {
	@Autowired 
	private ProdutoService produtoService;
	@Autowired 
	private HoraTrabalhadaService horaTrabalhadaService;

	@PostMapping("criar")
	@ResponseBody
	public Produto criar(@RequestBody ProdutoDTO produtoDTO) {
		Produto produto = produtoDTO.toProduto();
		Long id = produtoService.criar(produto);
		produto.setId(id);
		produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		return produto;
	}

	@GetMapping("getById")
	@ResponseBody
	public Produto getProduto(@RequestParam Long id) {
		Produto produto = produtoService.getProduto(id);
		produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		return produto;
	}

	@GetMapping("listar")
	@ResponseBody
	public Iterable<Produto> listar(){
		Iterable<Produto> listar = produtoService.listar();
		for (Produto produto : listar) {
			produto.setCustoHoraTrabalhada(horaTrabalhadaService.getHora());
		}
		return listar;
	}
}