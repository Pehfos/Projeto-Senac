package service;

import java.util.List;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteService {
	public List<Cliente> listarCliente(){
		ClienteDAO dao = new ClienteDAO();
		return dao.listar();
	}
	
	public Cliente consultarIdCliente(Integer id) {
		ClienteDAO dao = new ClienteDAO();
		return dao.consultarId(id);
	}
	
	public boolean incluirCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.incluir(cliente);
	}
	
	public boolean alterarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.alterar(cliente);
	}
	
	public boolean excluirCliente(Cliente cliente, Integer id) {
		ClienteDAO dao = new ClienteDAO();
		return dao.excluir(cliente, id);
	}
}
