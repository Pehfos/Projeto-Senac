package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO {
	public List<Cliente> listar(){
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente cliente = null;
		Connection cnx = Dao.getConexao();
		
		String SQL = "SELECT * FROM clientes";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCelular(rs.getString("celular"));
				
				lista.add(cliente);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Cliente t: lista) {
			System.out.println(t);
		}
		
		return lista;
	}
	
	public Cliente consultarId(Integer id){
		Connection cnx = Dao.getConexao();
		Cliente cliente = null;
		
		String SQL = "SELECT * FROM clientes WHERE id = ?";
		
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCelular(rs.getString("celular"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
		
	}
	
	public boolean incluir(Cliente cliente) {
		boolean status = false;
		Connection cnx = Dao.getConexao();
		 
		StringBuilder QUERY = new StringBuilder();
		QUERY.append("INSERT INTO clientes(nome, celular) ");
		QUERY.append("VALUES (?, ?)");
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCelular());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean alterar(Cliente cliente) {
		boolean status = false;
		Connection cnx = Dao.getConexao();
		StringBuilder QUERY = new StringBuilder();
		
		QUERY.append("UPDATE clientes SET nome = ?, ");
		QUERY.append("celular = ? WHERE id = ?");
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCelular());
			ps.setInt(3, cliente.getId());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean excluir(Cliente cliente, Integer id) {
		boolean status = false;
		Connection cnx = Dao.getConexao();
		 
		String SQL = "DELETE FROM clientes WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
