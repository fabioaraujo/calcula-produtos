package br.com.fabioaraujo.calcula.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioaraujo.calcula.produto.dto.HoraTrabalhada;
import br.com.fabioaraujo.calcula.produto.service.HoraTrabalhadaService;

@RestController
@RequestMapping("hora")
public class HoraTrabalhadaController{
	@Autowired 
	private HoraTrabalhadaService horaTrabalhadaService;

  @PostMapping("atualizar")
  @ResponseBody
  public HoraTrabalhada criar(@RequestBody HoraTrabalhada horaTrabalhada){
    Long id = horaTrabalhadaService.criar(horaTrabalhada);
    return horaTrabalhada;
  }

  @GetMapping("get")
  @ResponseBody
  private HoraTrabalhada getItem() {
    return horaTrabalhadaService.getHora();
  }

}