package com.prime.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.prime.model.FuncionarioModel;
import com.prime.repository.FuncionarioRepository;


@ApplicationScoped
public class FuncionarioService {
	
	@Inject
	FuncionarioRepository repository;
	
	public List<FuncionarioModel> getFuncionarios() {
		return repository.findAll().list();
	}

}
