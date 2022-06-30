package com.prime.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.prime.dao.AgendaDao;
import com.prime.dto.AgendaDentistaDto;
import com.prime.dto.AgendamentoDto;
import com.prime.enuns.HorarioEnum;
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
			AgendaDentistaDto agendamentoDentista = new AgendaDentistaDto(f);
			agendamentoDentista.setAgenda(montarTabelaAgenda(localDate, f.getMatricula()));
			return agendamentoDentista;
		}).collect(Collectors.toList());
		
	}
	
	private AgendamentoDto[] montarTabelaAgenda(LocalDate data, Integer matricula) {
		
		AgendamentoDto[] AgendamentoObj = new  AgendamentoDto[19];
		
		agendaRepository.findPordataEDentista(data, matricula).forEach(h -> {
			int posicao = HorarioEnum.fromValue(h.getHora()).getPosicao();
			if(posicao != 99) {
				AgendamentoObj[posicao] = h;
			}
		});
		
		return AgendamentoObj;
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
	
	public List<String> getHorarios(){
		List<String> horarios = new ArrayList<>();
		for(HorarioEnum horario: HorarioEnum.values()) {
			if(horario != HorarioEnum.DEFAULT) {
				horarios.add(horario.getHora());				
			}
		}
		return horarios;
	}
	
	private LocalDate getDataPorString(String data) throws NegocioException {
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return LocalDate.parse(data, formatter);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e.getMessage());
		}
	}
}
