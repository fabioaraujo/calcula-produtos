package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence.{Column, Embeddable}

import scala.beans.BeanProperty

@Embeddable
class ItemUtilizadoId extends Serializable {
  @BeanProperty
  @Column(name = "ID_PRODUTO") var idProduto: Long = _
  @BeanProperty
  @Column(name = "ID_ITEM") var idItem: Long = _
}
