package br.com.fabioaraujo.calcula.produto.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemUtilizadoId implements Serializable {

	@Column(name = "ID_PRODUTO") 
	private Long idProduto;

	@Column(name = "ID_ITEM") 
	private Long idItem;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}


}
