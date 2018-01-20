package br.com.fabioaraujo.calcula.produto.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HoraTrabalhada {
	@Id 
	private Long id;
	private Double custo;

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
