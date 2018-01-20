package br.com.fabioaraujo.calcula.produto.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fabioaraujo.calcula.produto.dto.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	public Item findItemByNome(String nome);
}