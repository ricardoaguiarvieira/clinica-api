package com.prime.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.prime.service.FuncionarioService;

@Path("/funcionario")
@Tag(name = "Funcionário")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioResource {
	
	@Inject
	FuncionarioService service;

	@GET
    public Response getfuncionarios() {
        return Response.status(Response.Status.OK).entity(
        		service.getFuncionarios()).build();
    }
}
