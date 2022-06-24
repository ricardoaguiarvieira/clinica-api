package com.prime.repository;

import javax.enterprise.context.ApplicationScoped;

import com.prime.model.FuncionarioModel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<FuncionarioModel> {

}
