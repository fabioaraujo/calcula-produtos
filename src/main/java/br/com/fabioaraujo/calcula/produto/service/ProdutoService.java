package br.com.fabioaraujo.calcula.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabioaraujo.calcula.produto.dao.ProdutoRepository;
import br.com.fabioaraujo.calcula.produto.dto.Produto;

@Service
public class ProdutoService {
	@Autowired 
	private ProdutoRepository produtoRepository;
	 

  public Iterable<Produto> listar(){
    return produtoRepository.findAll();
  }

  public Produto getProduto(Long id) {
    return produtoRepository.findById(id).orElse(null);
  }

  public Long criar(Produto produto) {
    produto = produtoRepository.save(produto);
    return produto.getId();
  }
}