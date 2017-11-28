package br.com.fabioaraujo.calcula.produto.dto

import scala.beans.BeanProperty

case class Item(
     var id : Long,
     var nome : String,
     var custo : Double,
     var horaTrabalhada : Item,
     var itensConfeccao : List[Item]
  ){

  def this(nome : String, custo : Double) = this(0L, nome, custo, new Item, List())

  def this() = this("", 0)
}
