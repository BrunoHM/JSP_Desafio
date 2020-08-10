package model;

public class Contato {

	private Long idContato;
	
	private Long usuario_idUsuario;
	private Long telefone_idTelefone;
	private Long email_idEmail;
	
	
	public Long getIdContato() {
		return idContato;
	}
	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}
	public Long getUsuario_idUsuario() {
		return usuario_idUsuario;
	}
	public void setUsuario_idUsuario(Long usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}
	public Long getTelefone_idTelefone() {
		return telefone_idTelefone;
	}
	public void setTelefone_idTelefone(Long telefone_idTelefone) {
		this.telefone_idTelefone = telefone_idTelefone;
	}
	public Long getEmail_idEmail() {
		return email_idEmail;
	}
	public void setEmail_idEmail(Long email_idEmail) {
		this.email_idEmail = email_idEmail;
	}
	
}
