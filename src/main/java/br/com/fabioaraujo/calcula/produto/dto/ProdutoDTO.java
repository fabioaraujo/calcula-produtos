package br.com.fabioaraujo.calcula.produto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {
	private Long id = 0L;
	private String nome= "";
	private Integer horasTrabalhadas = 0;
	private List<ItemUtilizadoDTO> itens = new ArrayList<>();
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
	public List<ItemUtilizadoDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemUtilizadoDTO> itens) {
		this.itens = itens;
	}
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setId(getId());
		produto.setHorasTrabalhadas(getHorasTrabalhadas());
		produto.setNome(getNome());
		
		List<ItemUtilizado> itensUtilizados = itens.stream().map(
												item -> new ItemUtilizado(
														new ItemUtilizadoId(id, item.getIdItem()), item.getQuantidade()))
										.collect(Collectors.toList());
		produto.setItens(itensUtilizados);
		
		return produto;
	}
	
}
