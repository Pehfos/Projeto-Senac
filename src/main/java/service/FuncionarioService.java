package service;

import java.util.List;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {
	public List<Funcionario> listarFuncionario(){
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.listar();
	}
	
	public Boolean incluirFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.incluir(funcionario);
	}
	
	public Boolean alterarFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.alterar(funcionario);
	}
	
	public Boolean excluirFuncionario(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.excluir(funcionario);
	}
}
