package View;

import java.util.List;
import java.util.Scanner;

import model.Funcionario;
import service.FuncionarioService;

public class Screen {
	public void exibirMenu() {
		System.out.println("----- MENU PRINCIPAL -----");
		System.out.println("1 - Listar funcionarios");
		System.out.println("2 - Adicionar funcionario");
		System.out.println("3 - Alterar funcionario");
		System.out.println("4 - Remover funcionario");
		System.out.println("0 - F  I  M");
		System.out.println("Digite a opção desejada:");
	}
	
	public void listarScreen() {
		FuncionarioService service = new FuncionarioService();
		List<Funcionario> lista  = service.listarFuncionario();
	}
	
	public void incluirScreen() {
		Scanner scanner = new Scanner(System.in);
		Funcionario funcionario = new Funcionario();
		
		FuncionarioService service = new FuncionarioService();
		service.incluirFuncionario(funcionario);
		
		System.out.println("Digi"); //<-- Last change
	}
}
