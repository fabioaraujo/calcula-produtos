package br.com.fabioaraujo.calcula.produto.dao

import br.com.fabioaraujo.calcula.produto.dto.Produto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait ProdutoRepository extends CrudRepository[Produto, java.lang.Long] {
  def findItemByNome(nome: String): Produto
}