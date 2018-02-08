package br.com.fabioaraujo.calcula.produto.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;
	private String nome= "";
	private Integer horasTrabalhadas = 0;
	@OneToMany(mappedBy = "produto")
	private List<ItemUtilizado> itens = new ArrayList<>();
	@Transient
	private HoraTrabalhada custoHora;

	@Transactional
	public Double getCustoTotal() {
		Double custoTotal = 0.0D;
		if (horasTrabalhadas != null) {
			custoTotal = horasTrabalhadas * custoHora.getCusto();
		}
		if (itens != null && itens.size() > 0) {
			custoTotal += itens.stream().mapToDouble(i -> i.item.getCusto() * i.getQuantidade()).sum();
		}
		return custoTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public List<ItemUtilizado> getItens() {
		return itens;
	}

	public void setItens(List<ItemUtilizado> itens) {
		this.itens = itens;
	}

public void setCustoHoraTrabalhada(HoraTrabalhada custoHora) {
	this.custoHora = custoHora;
}
}
