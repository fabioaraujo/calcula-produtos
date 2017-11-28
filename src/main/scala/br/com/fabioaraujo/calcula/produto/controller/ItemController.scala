package br.com.fabioaraujo.calcula.produto.controller

import br.com.fabioaraujo.calcula.produto.dto.{Item, Status}
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("item"))
class ItemController {
    @GetMapping(path = Array("/online"))
    @ResponseBody
    def online(): Status = {
      new Status
    }

    @PostMapping(path = Array("criar"))
    @ResponseBody
    def criaItem(@RequestBody item : Item) : Item = {
      item
    }
}