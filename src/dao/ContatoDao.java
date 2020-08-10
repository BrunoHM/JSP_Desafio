package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Contato;
import utils.DtbUtil;

public class ContatoDao {

	private static Connection conexaoDtb = new DtbUtil().getConexao();
	private PreparedStatement queryDtb;
	
	public void addContato(Contato contato) {
		insertContato(contato);
	}
	
	private void insertContato(Contato contato) {
		
		try {
			queryDtb = conexaoDtb.prepareStatement("INSERT INTO contato (usuario_idUsuario, telefone_idtelefone, email_idemail) VALUES (?,?,?)");
			
			queryDtb.setLong(1, contato.getUsuario_idUsuario());
			queryDtb.setLong(2, contato.getTelefone_idTelefone());
			
			queryDtb.setObject(3, contato.getEmail_idEmail(), java.sql.Types.INTEGER);
			
			queryDtb.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
