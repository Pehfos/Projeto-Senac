package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Funcionario;

public class FuncionarioDAO {	
	public List<Funcionario> listar(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Funcionario funcionario = null;
		Connection cnx = Dao.getConexao();
		
		String SQL = "SELECT * FROM funcionarios";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				funcionario = new Funcionario();
				
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCEP(rs.getString("CEP"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setCelular(rs.getString("celular"));
				
				lista.add(funcionario);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Funcionario t: lista) {
			System.out.println(t);
		}
		
		return lista;
	}
	
	public Funcionario consultarId(Integer id){
		Connection cnx = Dao.getConexao();
		Funcionario funcionario = null;
		
		String SQL = "SELECT * FROM funcionarios WHERE id = ?";
		
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				funcionario = new Funcionario();
				
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCEP(rs.getString("CEP"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setCelular(rs.getString("celular"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;
		
	}
	
	public boolean incluir(Funcionario funcionario) {
		boolean status = false;
		Connection cnx = Dao.getConexao();
		 
		StringBuilder QUERY = new StringBuilder();
		QUERY.append("INSERT INTO funcionarios(nome, email, CEP, cargo, celular) ");
		QUERY.append("VALUES (?, ?, ?, ?, ?)");
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());
			
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getEmail());
			ps.setString(3, funcionario.getCEP());
			ps.setString(4, funcionario.getCargo());
			ps.setString(5, funcionario.getCelular());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean alterar(Funcionario funcionario) {
		boolean status = false;
		Connection cnx = Dao.getConexao();
		StringBuilder QUERY = new StringBuilder();
		
		QUERY.append("UPDATE funcionarios SET nome = ?, email = ?, ");
		QUERY.append("CEP = ?, cargo = ?, celular = ? WHERE id = ?");
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());

			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getEmail());
			ps.setString(3, funcionario.getCEP());
			ps.setString(4, funcionario.getCargo());
			ps.setString(5, funcionario.getCelular());
			ps.setInt(6, funcionario.getId());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean excluir(Funcionario funcionario) {
		boolean status = false;
		Connection cnx = Dao.getConexao();
		 
		String SQL = "DELETE FROM funcionarios WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, funcionario.getId());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
