package br.com.fabioaraujo.calcula.produto.controller

import br.com.fabioaraujo.calcula.produto.dto.Item
import br.com.fabioaraujo.calcula.produto.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("item"))
class ItemController(@Autowired val itemService: ItemService) {

  @PostMapping(path = Array("criar"))
  @ResponseBody
  def criar(@RequestBody item: Item): Item = {
    val id = itemService.createItem(item)
    item.setId(id)
    item
  }

  @GetMapping(path = Array("getById"))
  @ResponseBody
  def getItem(@RequestParam id: Long): Item = {
    itemService.getItem(id)
  }

  @GetMapping(path = Array("listar"))
  @ResponseBody
  def listar(): java.lang.Iterable[Item] = {
    itemService.listItens()
  }
}