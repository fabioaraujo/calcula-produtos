package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence._

import br.com.fabioaraujo.calcula.produto.dto.TipoUnidade.TipoUnidade

import scala.beans.BeanProperty

@Entity
class Item () extends Serializable{

  @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty var id : Long = _
  @BeanProperty var nome : String = _
  @BeanProperty var custo : Double = _
  @BeanProperty var tipoUnidade : TipoUnidade = _


}
