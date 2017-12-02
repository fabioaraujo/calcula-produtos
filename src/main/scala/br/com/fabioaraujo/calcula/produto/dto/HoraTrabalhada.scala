package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence.{Entity, Id}

import scala.beans.BeanProperty

@Entity
class HoraTrabalhada {
  @BeanProperty
  @Id var id: Long = _
  @BeanProperty var custo: Double = _
}
