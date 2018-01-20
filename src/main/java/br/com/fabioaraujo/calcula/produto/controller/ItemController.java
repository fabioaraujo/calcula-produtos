package br.com.fabioaraujo.calcula.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioaraujo.calcula.produto.dto.Item;
import br.com.fabioaraujo.calcula.produto.service.ItemService;

@RestController
@RequestMapping("item")
class ItemController {
	
	@Autowired 
	private ItemService itemService;

  @PostMapping("criar")
  @ResponseBody
  public Item criar(@RequestBody Item item) {
    Long id = itemService.createItem(item);
    item.setId(id);
    return item;
  }

  @GetMapping("getById")
  @ResponseBody
  public Item getItem(@RequestParam Long id) {
    return itemService.getItem(id);
  }

  @GetMapping("listar")
  @ResponseBody
  public Iterable<Item> listar(){
    return itemService.listItens();
  }
}