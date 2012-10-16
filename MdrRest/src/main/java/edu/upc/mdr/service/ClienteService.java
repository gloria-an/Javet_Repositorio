package edu.upc.mdr.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.upc.mdr.model.Cliente;
import edu.upc.mdr.vo.ClienteCollection;

@Path("/cliente-service/")
@Produces("application/xml")
public interface ClienteService {
	@GET
	@Path("/clientes/{dni}")
	@Produces({ "application/xml", "application/json" })
	public ClienteCollection getUsers(@PathParam("dni") String dni);

	@GET
	@Path("/cliente2/{dni}")
	public Cliente getUserCli(@PathParam("dni") String dni);
	
	@POST
	@Path("/cliente")
	public Cliente getUser(@FormParam("dni") String dni);

	@GET
	@Path("/clientes/bad")
	public Response getBadRequest();

}