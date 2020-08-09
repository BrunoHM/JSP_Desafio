package model;

public class Usuario {
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private boolean ativo;
	
	public Usuario() {}
			
	public Usuario(String nome, String sobrenome, String cpf, boolean ativo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.ativo = ativo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
