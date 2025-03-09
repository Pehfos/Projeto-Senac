package resource;

import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Funcionario;
import service.FuncionarioService;

@Path("funcionarios")
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
	@Path("buscar/{id}")
	public Response getFuncionarioId(@PathParam("id")Integer id) {
		 if (id == null) {
		        return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
		    }
		
		FuncionarioService service = new FuncionarioService();
		Funcionario funcionario = service.listarFuncionarioId(id);
		
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
		
		if(funcionario != null) {
			response = Response.status(Response.Status.OK).entity(funcionario).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar essa ação.").build();
		}
		
		return response;
	}
	
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/funcionarios/{id}")
	public Response patchFuncionario(@PathParam("id") Integer id, Funcionario funcionario) {
		FuncionarioService service = new FuncionarioService();
	    funcionario.setId(id);  // Ensure that the ID is set before calling service
	    Boolean sucesso = service.alterarFuncionario(funcionario);
	    
	    if (sucesso) {
	        return Response.status(Response.Status.OK).entity(funcionario).build();
	    } else {
	        return Response.status(Response.Status.NOT_FOUND).entity("Funcionario not found or update failed.").build();
	    }
	}
}
