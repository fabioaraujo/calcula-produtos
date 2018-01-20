package br.com.fabioaraujo.calcula.produto.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fabioaraujo.calcula.produto.dto.HoraTrabalhada;

@Repository
public interface HoraTrabalhadaRepository extends CrudRepository<HoraTrabalhada, Long> {

}