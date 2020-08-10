package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import utils.DtbUtil;

public class UsuarioDao {

	private Connection conexaoDtb = new DtbUtil().getConexao();
	private PreparedStatement queryDtb;
	private ResultSet resultadoDtb;
	
	private Long idUsuario;
	
	public ResultSet getAllusuarios() {
		selectAllUsuarios();
		return resultadoDtb;
	}
	
	private void selectAllUsuarios() {
		try {
			queryDtb = conexaoDtb.prepareStatement("select * from usuario");
			queryDtb.execute();
			resultadoDtb = queryDtb.getResultSet();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deletaUsuario(int idUsuario) {
		deleteUser(idUsuario);
	}
	
	private int deleteUser(int userId) {
		int statusOperation = 0;
		
		try {
			queryDtb = conexaoDtb.prepareStatement("DELETE usuario FROM usuario WHERE idUsuario = ?");
			queryDtb.setInt(1, userId);
			statusOperation = queryDtb.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return statusOperation;
	}
	
	public void addUsuario(Usuario usuario) {
		insertUsuario(usuario);
	}
	
	private void insertUsuario(Usuario usuario) {
		try {
			queryDtb = conexaoDtb.prepareStatement("INSERT INTO usuario (nome, sobrenome, cpf, ativo) VALUES (?,?,?,?)", queryDtb.RETURN_GENERATED_KEYS);
			
			queryDtb.setString(1, usuario.getNome());
			queryDtb.setString(2, usuario.getSobrenome());
			queryDtb.setString(3, usuario.getCpf());
			queryDtb.setBoolean(4, usuario.getAtivo());
			
			queryDtb.executeUpdate();

			try (ResultSet generatedKeys = queryDtb.getGeneratedKeys()) {
				
				if (generatedKeys.next()) {
					idUsuario = generatedKeys.getLong(1);
	            }else {
	                throw new SQLException("Erro ao recuperar código de novo usuário");
	            }
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	
	
}
