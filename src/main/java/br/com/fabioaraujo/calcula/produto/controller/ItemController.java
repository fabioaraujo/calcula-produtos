package br.com.fabioaraujo.calcula.produto.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.fabioaraujo.calcula.produto.dto.Item;
import br.com.fabioaraujo.calcula.produto.service.ItemService;

@RestController
@RequestMapping("itens")
class ItemController {

	@Autowired 
	private ItemService itemService;

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Item> criar(@RequestBody Item item) {
		item.setId(null);
		Long id = itemService.save(item);
		item.setId(id);
		UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(
				ItemController.class, "getItem", id).build();
		URI uri = uriComponents.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping()
	@ResponseBody
	public ResponseEntity<Item> atualizar(@RequestBody Item item) {
		if(item.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		Long id = itemService.save(item);
		item.setId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
		return ResponseEntity.ok(itemService.getItem(id));
	}

	@GetMapping()
	@ResponseBody
	public ResponseEntity<Iterable<Item>> listar(){
		return ResponseEntity.ok(itemService.listItens());
	}
}