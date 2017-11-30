package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence.Embeddable

import scala.beans.BeanProperty

@Embeddable
class ItemUtilizadoId extends Serializable {
  @BeanProperty var idProduto : Long =_
  @BeanProperty var idItem : Long =_
}
