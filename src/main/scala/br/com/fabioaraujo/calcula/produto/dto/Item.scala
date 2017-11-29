package br.com.fabioaraujo.calcula.produto.dto

import scala.beans.BeanProperty

class Item extends Serializable  {
  @BeanProperty var id : Long = _
  @BeanProperty var nome : String = _
  @BeanProperty var custo : Double = _
  @BeanProperty var horaTrabalhada : Item = _
}
