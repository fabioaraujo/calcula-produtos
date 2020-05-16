package br.com.fabioaraujo.calcula.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabioaraujo.calcula.produto.dao.HoraTrabalhadaRepository;
import br.com.fabioaraujo.calcula.produto.dto.HoraTrabalhada;

@Service
public class HoraTrabalhadaService {

	@Autowired 
	private HoraTrabalhadaRepository horaTrabalhadaRepository;

	public HoraTrabalhada getHora() {
		return horaTrabalhadaRepository.findById(1L).orElse(null);
	}

	public Long criar(HoraTrabalhada horaTrabalhada) {
		horaTrabalhada.setId(1L);
		horaTrabalhadaRepository.save(horaTrabalhada);
		return horaTrabalhada.getId();
	}

}