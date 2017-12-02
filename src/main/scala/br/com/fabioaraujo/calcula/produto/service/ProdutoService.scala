package br.com.fabioaraujo.calcula.produto.service

import br.com.fabioaraujo.calcula.produto.dao.ProdutoRepository
import br.com.fabioaraujo.calcula.produto.dto.Produto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService(@Autowired val produtoRepository: ProdutoRepository) {

  def listar(): java.lang.Iterable[Produto] = {
    produtoRepository.findAll
  }

  def getProduto(id: Long): Produto = {
    produtoRepository.findOne(id)
  }

  def criar(produto: Produto): Long = {
    produtoRepository.save(produto)
    produto.id
  }
}