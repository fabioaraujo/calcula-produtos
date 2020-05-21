package br.com.fabioaraujo.calcula.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemUtilizadoDTO {
	@JsonProperty("id")
	private Long idItem;
	private Integer quantidade;
	
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
