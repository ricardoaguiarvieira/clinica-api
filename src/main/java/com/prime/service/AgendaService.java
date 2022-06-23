package com.prime.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.prime.dao.AgendaDao;
import com.prime.dto.AgendaDentistaDto;
import com.prime.dto.AgendamentoDto;
import com.prime.exception.NegocioException;
import com.prime.model.AgendaModel;
import com.prime.model.FuncionarioModel;
import com.prime.repository.AgendaRepository;

@ApplicationScoped
public class AgendaService {
	
	@Inject
	AgendaDao agendaDao;
	
	@Inject
	AgendaRepository agendaRepository;
	
	@Inject
	FuncionarioService funcionarioService;

	public List<AgendaDentistaDto> getAgendamentosPorData(String data) throws NegocioException {
		
		final LocalDate localDate = getDataPorString(data);
		
		List<FuncionarioModel> funcionarios = funcionarioService.getFuncionarios();
		
		return funcionarios.stream().map(f -> {
			AgendaDentistaDto agendamento = new AgendaDentistaDto(f);
			agendamento.setAgenda(agendaRepository.findPordataEDentista(localDate, f.getMatricula()));
			return agendamento;
		}).collect(Collectors.toList());
		
	}
	
	@Transactional
	public AgendamentoDto saveAgendamento(AgendamentoDto agendamento) {
		AgendaModel agenda = AgendamentoDto.mapperAgendaModel(agendamento);
		agendaRepository.persist(agenda);
		agendaRepository.flush();
		return new AgendamentoDto(agenda);
	}
	
	@Transactional
	public AgendamentoDto updateAgendamento(AgendamentoDto agendamento) {
		
		AgendaModel agenda = agendaRepository.findById(agendamento.getId());
		
		agenda.setData(agendamento.getData());
		agenda.setDentista(agendamento.getMatricula());
		agenda.setDescricao(agendamento.getDescricao());
		agenda.setObs(agendamento.getObservacao());
		agenda.setStatus(agendamento.getStatus());
		
		agendaRepository.persist(agenda);
		return agendamento;
	}
	
	@Transactional
	public AgendamentoDto deleteAgendamento(Long id) {
		
		AgendaModel agendamento = agendaRepository.findById(id);
		agendaRepository.deleteById(id);
		
		return new AgendamentoDto(agendamento);
	}
	
	private LocalDate getDataPorString(String data) throws NegocioException {
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return LocalDate.parse(data, formatter);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e.getMessage());
		}
	}
}
