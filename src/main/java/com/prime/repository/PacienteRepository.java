package com.prime.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.prime.model.PacienteModel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PacienteRepository implements PanacheRepository<PacienteModel>{

}
