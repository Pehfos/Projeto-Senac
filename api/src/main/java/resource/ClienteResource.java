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
import model.Cliente;
import service.ClienteService;

@Path("/clientes")
public class ClienteResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public Response getClientes() {
		ClienteService service = new ClienteService();
		List<Cliente> lista = service.listarCliente();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Response getClienteId(@PathParam("id") Integer id) {
		ClienteService service = new ClienteService();
		Cliente cliente = service.consultarIdCliente(id);
		
		Response response = null;
		
		if(cliente != null) {
			response = Response.status(Response.Status.OK).entity(cliente).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não encontrado.").build();
		}
		
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCliente(Cliente cliente) {
		ClienteService service = new ClienteService();
		Boolean retorno = service.incluirCliente(cliente);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(cliente).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar esta ação.").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response putClientes(@PathParam("id") Integer id, Cliente cliente) {
		ClienteService service = new ClienteService();
		Boolean retorno = service.alterarCliente(cliente);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.ACCEPTED).entity(cliente).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar esta ação.").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deleteClientes(@PathParam("id") Integer id, Cliente cliente) {
		ClienteService service = new ClienteService();
		Boolean retorno = service.excluirCliente(cliente, id);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity("Funcionário excluído com sucesso.").build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar esta ação.").build();
		}
		
		return response;
	}
}
