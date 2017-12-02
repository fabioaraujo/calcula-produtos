package br.com.fabioaraujo.calcula.produto.service

import br.com.fabioaraujo.calcula.produto.dao.{HoraTrabalhadaRepository, ProdutoRepository}
import br.com.fabioaraujo.calcula.produto.dto.{HoraTrabalhada, Produto}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HoraTrabalhadaService(@Autowired val horaTrabalhadaRepository: HoraTrabalhadaRepository) {

  def getHora(): HoraTrabalhada = {
    horaTrabalhadaRepository.findOne(1L)
  }

  def criar(horaTrabalhada: HoraTrabalhada): Long = {
    horaTrabalhada.id = 1L
    horaTrabalhadaRepository.save(horaTrabalhada)
    horaTrabalhada.id
  }
}