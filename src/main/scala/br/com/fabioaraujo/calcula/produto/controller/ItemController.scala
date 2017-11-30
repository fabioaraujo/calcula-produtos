package br.com.fabioaraujo.calcula.produto.controller

import br.com.fabioaraujo.calcula.produto.dto.{Item, Status}
import br.com.fabioaraujo.calcula.produto.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("scala/item"))
class ItemController(@Autowired val itemService : ItemService) {
    @GetMapping(path = Array("/online"))
    @ResponseBody
    def online(): Status = {
      new Status
    }

    @PostMapping(path = Array("criar"))
    @ResponseBody
    def criaItem(@RequestBody item : Item) : Item = {
      val id = itemService.createItem(item)
      item.setId(id)
      item
    }

  @GetMapping(path = Array("getById"))
  @ResponseBody
  def getItem(@RequestParam id : Long) : Item = {
    itemService.getItem(id)
  }
}