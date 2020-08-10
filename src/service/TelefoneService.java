package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.TelefoneDao;
import model.Telefone;

public class TelefoneService {

	
	private List<Long> idTelefones;
	
	public void insereTelefone(HttpServletRequest request) {
		TelefoneDao telefoneDao = new TelefoneDao();
		Telefone telefone;
		
		if(request.getParameterValues("telefone") != null) {
			idTelefones = new ArrayList<Long>();
			
			String[] telefones = request.getParameterValues("telefone");
			String[] ddd       = request.getParameterValues("ddd");

			for(int index=0; index < telefones.length;index++) {
				telefone = new Telefone();
				
				telefone.setNumero(telefones[index]);
				telefone.setDdd(ddd[index]);
				telefone.setPrincipal(false);
				telefone.setAtivo(true);
				
				telefoneDao.addTelefone(telefone);
				idTelefones.add(telefoneDao.getIdTelefone());
			}
			
		}
		
	}

	public List<Long> getIdTelefones() {
		return idTelefones;
	}

}
