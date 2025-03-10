package model;

public class Funcionario {
	private Integer id;
	private String nome;
	private String email;
	private String CEP;
	private String cargo;
	private String celular;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@Override
	public String toString() {
		return "Funcionario: id=" + id + ", nome=" + nome + ", email=" + email + ", CEP=" + CEP + 
				", cargo=" + cargo + ", celular=" + celular + ".";
	}
	
	
}