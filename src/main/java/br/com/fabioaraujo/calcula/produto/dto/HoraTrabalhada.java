package br.com.fabioaraujo.calcula.produto.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HoraTrabalhada {
	@Id @JsonIgnore
	private Long id;
	private Double custo;

	public HoraTrabalhada() {}
	
	public HoraTrabalhada(Long id, Double valorHoraTrabalhada) {
		this.id = id;
		this.custo = valorHoraTrabalhada;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}


}
