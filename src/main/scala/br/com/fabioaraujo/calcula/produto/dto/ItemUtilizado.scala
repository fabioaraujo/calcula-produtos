package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class ItemUtilizado {
  @BeanProperty
  @EmbeddedId var id: ItemUtilizadoId = new ItemUtilizadoId
  @BeanProperty var quantidade: Int = _
  @OneToOne
  @JoinColumn(insertable = false, updatable = false, name = "ID_PRODUTO") var produto: Produto = _
  @OneToOne
  @JoinColumn(insertable = false, updatable = false, name = "ID_ITEM") var item: Item = _

  def getItem: Item = item

  def setItem(item: Item): Unit = {
    this.item = item
    id.idItem = item.id
  }

  def getProduto: Produto = produto

  def setProduto(produto: Produto): Unit = {
    this.produto = produto
    id.idProduto = produto.id
  }
}
