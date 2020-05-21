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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemUtilizado other = (ItemUtilizado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemUtilizado [id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + ", item=" + item
				+ "]";
	}

}
