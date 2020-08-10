package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Email;
import utils.DtbUtil;

public class EmailDao {

	private static Connection conexaoDtb = new DtbUtil().getConexao();
	private PreparedStatement queryDtb;
	
	private Long idEmail;
	
	public void addEmail(Email email) {
		insertEmail(email);
	}
	
	private void insertEmail(Email email) {
		
		try {
			queryDtb = conexaoDtb.prepareStatement("INSERT INTO email (endereco, ativo) VALUES (?,?)", queryDtb.RETURN_GENERATED_KEYS);
			
			queryDtb.setString(1, email.getEndereco());
			queryDtb.setBoolean(2, email.isAtivo());
			
			queryDtb.executeUpdate();
			
			try (ResultSet generatedKeys = queryDtb.getGeneratedKeys()) {
				
				if (generatedKeys.next()) {
					idEmail = generatedKeys.getLong(1);
	            }else {
	                throw new SQLException("Erro ao recuperar código de novo usuário");
	            }
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Long getIdEmail() {
		return idEmail;
	}

	
	
}
