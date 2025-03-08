package resource;

import java.util.List;

import jakarta.ws.rs.GET;
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
}
