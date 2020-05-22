package br.com.fabioaraujo.calcula.produto.dto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDTOResponse {
	private Long id = 0L;
	private String nome= "";
	private Integer horasTrabalhadas = 0;
	private List<ItemDTO> itens = new ArrayList<>();
	
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
	public List<ItemDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}
}
