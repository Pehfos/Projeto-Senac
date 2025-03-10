package service;

import java.util.List;
import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {
	public List<Funcionario> listarFuncionario(){
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.listar();
	}
	
	public Funcionario consultarIdFuncionario(Integer id) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.consultarId(id);
	}
	
	public boolean incluirFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.incluir(funcionario);
	}
	
	public boolean alterarFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.alterar(funcionario);
	}
	
	public boolean excluirFuncionario(Funcionario funcionario, Integer id) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.excluir(funcionario, id);
	}
}