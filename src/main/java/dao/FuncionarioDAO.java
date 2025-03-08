package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDAO {
	public List<Funcionario> listar() {
		List<Funcionario> lista = new ArrayList<>();
		Funcionario funcionario  = null;
		Connection connection = Dao.getConexao();
		
		String SQL = "SELECT * FROM funcionarios";
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCEP(resultSet.getString("CEP"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setCelular(resultSet.getString("celular"));
				
				lista.add(funcionario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Funcionario listaFuncionario: lista) {
			System.out.println(listaFuncionario);
		}
		
		return lista;
	}
	
	public Funcionario listarId(Integer id) {
		Connection connection = Dao.getConexao();
		Funcionario funcionario  = null;
		
		String SQL = "SELECT * FROM funcionarios WHERE id = ?";
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCEP(resultSet.getString("CEP"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setCelular(resultSet.getString("celular"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	public Boolean incluir(Funcionario funcionario) {
		Boolean status = false;
		Connection connection = Dao.getConexao();
		
		String SQL = "INSERT INTO funcionarios (nome, email, CEP, cargo, celular)"
				 	+ " VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCEP());
			preparedStatement.setString(4, funcionario.getCargo());
			preparedStatement.setString(5, funcionario.getCelular());
			
			Integer execute = preparedStatement.executeUpdate();
			
			status = execute > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public Boolean alterar(Funcionario funcionario) {
		Boolean status = false;
		Connection connection = Dao.getConexao();
		
		String SQL = "UPDATE funcionarios SET nome = ?, email = ?, CEP = ?, "
					+ "cargo = ?, celular = ? WHERE id = ?";
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCEP());
			preparedStatement.setString(4, funcionario.getCargo());
			preparedStatement.setString(5, funcionario.getCelular());
			
			Integer execute = preparedStatement.executeUpdate();
			
			status = execute > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public Boolean excluir(Funcionario funcionario) {
		Boolean status = false;
		Connection connection = Dao.getConexao();
		
		String SQL = "DELETE FROM funcionarios WHERE id = ?";
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setInt(1, funcionario.getId());
			
			Integer execute = preparedStatement.executeUpdate();
			
			status = execute > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
