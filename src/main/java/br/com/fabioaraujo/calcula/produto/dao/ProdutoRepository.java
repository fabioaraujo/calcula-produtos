package br.com.fabioaraujo.calcula.produto.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fabioaraujo.calcula.produto.dto.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
  public Produto findItemByNome(String nome);
}