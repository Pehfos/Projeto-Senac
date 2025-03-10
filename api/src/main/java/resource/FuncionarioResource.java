package resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Funcionario;
import service.FuncionarioService;

@Path("/funcionarios")
public class FuncionarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getFuncionarios() {
		FuncionarioService service = new FuncionarioService();
		List<Funcionario> lista = service.listarFuncionario();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Response getFuncionarioId(@PathParam("id") Integer id) {
		FuncionarioService service = new FuncionarioService();
		Funcionario funcionario = service.consultarIdFuncionario(id);
		
		Response response = null;
		
		if(funcionario != null) {
			response = Response.status(Response.Status.OK).entity(funcionario).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não encontrado.").build();
		}
		
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postFuncionario(Funcionario funcionario) {
		FuncionarioService service = new FuncionarioService();
		Boolean retorno = service.incluirFuncionario(funcionario);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(funcionario).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar esta ação.").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response putFuncionarios(@PathParam("id") Integer id, Funcionario funcionario) {
		FuncionarioService service = new FuncionarioService();
		Boolean retorno = service.alterarFuncionario(funcionario);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(funcionario).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar esta ação.").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deleteFuncionarios(@PathParam("id") Integer id) {
		FuncionarioService service = new FuncionarioService();
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		Boolean retorno = service.excluirFuncionario(funcionario);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity("Funcionário excluído com sucesso.").build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar esta ação.").build();
		}
		
		return response;
	}
}
