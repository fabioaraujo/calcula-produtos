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
import br.com.fabioaraujo.calcula.produto.service.ProdutoService;

@RestController
@RequestMapping("produto")
class ProdutoController {
	@Autowired 
	private ProdutoService produtoService;

  @PostMapping("criar")
  @ResponseBody
  public Produto criar(@RequestBody Produto produto) {
    Long id = produtoService.criar(produto);
    produto.setId(id);
    return produto;
  }

  @GetMapping("getById")
  @ResponseBody
  public Produto getProduto(@RequestParam Long id) {
    return produtoService.getProduto(id);
  }

  @GetMapping("listar")
  @ResponseBody
  public Iterable<Produto> listar(){
    return produtoService.listar();
  }
}