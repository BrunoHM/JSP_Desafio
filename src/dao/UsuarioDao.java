package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DtbUtil;

public class UsuarioDao {

	private Connection conexaoDtb = new DtbUtil().getConexao();
	private PreparedStatement queryDtb;
	private ResultSet resultadoDtb;
	
	private void insertUsuario() {
		try {
			queryDtb = conexaoDtb.prepareStatement("INSERT INTO cliente (nome, sobrenome, cpf, ativo) VALUES (?,?,?,?)");
			//Implementar Insert Usuario ...		
		}catch(Exception e) {
			
		}
	}
	
	public ResultSet getAllusuario() {
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
	
	
}
