package br.com.fabioaraujo.calcula.produto.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ItemUtilizado {

	@EmbeddedId ItemUtilizadoId id = new ItemUtilizadoId();
	private Integer quantidade;
	@OneToOne
	@JoinColumn(insertable = false, updatable = false, name = "ID_PRODUTO") Produto produto;
	@OneToOne
	@JoinColumn(insertable = false, updatable = false, name = "ID_ITEM") Item item;

	public ItemUtilizado() {}
	
	public ItemUtilizado(ItemUtilizadoId id, Integer quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}

	public ItemUtilizadoId getId() {
		return id;
	}
	public void setId(ItemUtilizadoId id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
		this.id.setIdProduto(produto.getId());
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
		this.id.setIdItem(item.getId());
	}


}
