package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence.{Entity, Id}

import scala.beans.BeanProperty

@Entity
class HoraTrabalhada {
  @BeanProperty
  @Id val id: Long = 1
  @BeanProperty var custo: Double = 10.0
}
