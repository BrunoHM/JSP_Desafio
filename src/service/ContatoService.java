package service;

import java.util.List;

import dao.ContatoDao;
import model.Contato;


public class ContatoService {
	
	
	public void insereContato(List<Long> idTelefones, Long idUsuario, Long idEmail) {
		
		if(idTelefones != null && idUsuario != null && idEmail != null) {
			ContatoDao contatoDao = new ContatoDao();
			Contato contato;
		
			for(Long idTelefone : idTelefones) {
				contato = new Contato();
				
				contato.setUsuario_idUsuario(idUsuario);
				contato.setTelefone_idTelefone(idTelefone);
				contato.setEmail_idEmail(idEmail);
				idEmail = null;
				
				contatoDao.addContato(contato);
			}
		}
	}
	
	

}
