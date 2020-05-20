package br.com.fabioaraujo.calcula.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioaraujo.calcula.produto.dto.HoraTrabalhada;
import br.com.fabioaraujo.calcula.produto.service.HoraTrabalhadaService;

@RestController
@RequestMapping("hora-trabalhada")
public class HoraTrabalhadaController{
	@Autowired 
	private HoraTrabalhadaService horaTrabalhadaService;

  @PutMapping()
  @ResponseBody
  public ResponseEntity<Void> criarOuAtualizar(@RequestBody HoraTrabalhada horaTrabalhada){
	horaTrabalhada.setId(1L);
	horaTrabalhadaService.criar(horaTrabalhada);
    return ResponseEntity.noContent().build();
  }

  @GetMapping()
  @ResponseBody
  private HoraTrabalhada getItem() {
    return horaTrabalhadaService.getHora();
  }

}