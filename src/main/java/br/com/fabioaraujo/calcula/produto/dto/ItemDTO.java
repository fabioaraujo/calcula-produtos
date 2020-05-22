package br.com.fabioaraujo.calcula.produto.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ItemDTO {
	private Long id;
	private String nome;
	private Double custo;
	private TipoUnidade tipoUnidade;
	private Integer quantidade;
	
	public ItemDTO() { }
	
	public ItemDTO(Item item, Integer quantidade) {
		this.id = item.getId();
		this.nome = item.getNome();
		this.custo = item.getCusto();
		this.tipoUnidade = item.getTipoUnidade();
		this.quantidade = quantidade;
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

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(TipoUnidade tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
