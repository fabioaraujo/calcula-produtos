package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence.{Column, EmbeddedId, Entity, OneToOne}

import scala.beans.BeanProperty

@Entity
class ItemUtilizado {
  @BeanProperty @EmbeddedId var id : ItemUtilizadoId = new ItemUtilizadoId
  @BeanProperty var quantidade : Int = _
  @OneToOne @Column(insertable = false, updatable = false) var produto : Produto = _
  @OneToOne @Column(insertable = false, updatable = false)var item: Item = _

  def setItem(item: Item): Unit ={
    this.item = item
    id.idItem = item.id
  }

  def getItem : Item = item

  def setProduto(produto: Produto): Unit ={
    this.produto = produto
    id.idProduto = produto.id
  }

  def getProduto : Produto = produto
}
