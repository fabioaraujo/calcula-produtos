package br.com.fabioaraujo.calcula.produto.controller

import br.com.fabioaraujo.calcula.produto.dto.{HoraTrabalhada, Item}
import br.com.fabioaraujo.calcula.produto.service.{HoraTrabalhadaService, ItemService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("hora"))
class HoraTrabalhadaController(@Autowired val horaTrabalhadaService: HoraTrabalhadaService) {

  @PostMapping(path = Array("atualizar"))
  @ResponseBody
  def criar(@RequestBody horaTrabalhada : HoraTrabalhada): HoraTrabalhada = {
    val id = horaTrabalhadaService.criar(horaTrabalhada)
    horaTrabalhada
  }

  @GetMapping(path = Array("get"))
  @ResponseBody
  def getItem(): HoraTrabalhada = {
    horaTrabalhadaService.getHora()
  }

}