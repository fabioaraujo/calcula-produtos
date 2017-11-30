package br.com.fabioaraujo.calcula.produto.dao

import br.com.fabioaraujo.calcula.produto.dto.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait ItemRepository extends CrudRepository[Item, java.lang.Long] {
  def findItemByNome(nome: String): Item
}