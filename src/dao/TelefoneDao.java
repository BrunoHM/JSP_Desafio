package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Telefone;
import utils.DtbUtil;

public class TelefoneDao {

	private static Connection conexaoDtb = new DtbUtil().getConexao();
	private PreparedStatement queryDtb;
	private Long idTelefone;
	
	public void addTelefone(Telefone tel) {
		insertTelefone(tel);
	}
	
	private void insertTelefone(Telefone tel) {
		try {
			queryDtb = conexaoDtb.prepareStatement("INSERT INTO telefone (numero, ddd, principal, ativo) VALUES (?,?,?,?)", queryDtb.RETURN_GENERATED_KEYS);
			
			queryDtb.setString(1, tel.getNumero());
			queryDtb.setString(2, tel.getDdd());
			queryDtb.setBoolean(3, tel.isPrincipal());
			queryDtb.setBoolean(4, tel.isAtivo());
			
			queryDtb.executeUpdate();

			try (
				ResultSet generatedKeys = queryDtb.getGeneratedKeys()) {
				
				while(generatedKeys.next()) {
					idTelefone = generatedKeys.getLong(1);
	            }
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	
	
}
