package br.com.fabioaraujo.calcula.produto.dto

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty var id: Long = _
  @BeanProperty var nome: String = _
  @BeanProperty var horasTrabalhadas: Int = _
  @OneToMany(mappedBy = "produto")
  @BeanProperty var itens: java.util.List[ItemUtilizado] = _

  def getCustoTotal: Double = {
    val horaTrabalhada = new HoraTrabalhada
    var custoTotal = 0.0
    if (horasTrabalhadas != null)
      custoTotal = horasTrabalhadas * horaTrabalhada.getCusto
    if (itens != null && itens.size > 0)
      custoTotal += itens.stream().mapToDouble(i => i.item.getCusto * i.quantidade).sum

    custoTotal
  }
}
