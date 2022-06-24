package com.prime.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.prime.dto.PacienteReduzidoDto;
import com.prime.repository.PacienteRepository;

@ApplicationScoped
public class PacienteService {
	
	@Inject
	PacienteRepository pacienteRepository;

	public List<PacienteReduzidoDto> findPacientePorNome(String nome) {
		return PacienteReduzidoDto.mapperAgendamentoDto(pacienteRepository.find("nome LIKE ?1", "%"+nome+"%").list());
	}
}
