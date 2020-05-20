package br.com.fabioaraujo.calcula.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioaraujo.calcula.produto.dto.Item;
import br.com.fabioaraujo.calcula.produto.service.ItemService;

@RestController
@RequestMapping("itens")
class ItemController {
	
	@Autowired 
	private ItemService itemService;

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
  @ResponseBody
  public Item save(@RequestBody Item item) {
    Long id = itemService.save(item);
    item.setId(id);
    return item;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public Item getItem(@PathVariable("id") Long id) {
    return itemService.getItem(id);
  }

  @GetMapping()
  @ResponseBody
  public Iterable<Item> listar(){
    return itemService.listItens();
  }
}