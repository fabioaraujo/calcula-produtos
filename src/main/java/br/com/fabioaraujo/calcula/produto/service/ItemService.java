package br.com.fabioaraujo.calcula.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabioaraujo.calcula.produto.dao.ItemRepository;
import br.com.fabioaraujo.calcula.produto.dto.Item;

@Service
public class ItemService {
	@Autowired 
	private  ItemRepository itemRepository;

	public Iterable<Item> listItens(){
		return itemRepository.findAll();
	}

	public Item getItem(Long id) {

		return itemRepository.findById(id).orElse(null);
	}

	public Long createItem(Item item) {
		itemRepository.save(item);
		return item.getId();
	}
}