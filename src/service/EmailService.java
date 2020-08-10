package service;

import javax.servlet.http.HttpServletRequest;

import dao.EmailDao;
import model.Email;

public class EmailService {

	private Long idEmail;
	
	public void insereEmail(HttpServletRequest request) {
				
		if(request.getParameter("email") != null) {
			EmailDao emailDao = new EmailDao();
			Email email = new Email();
			
			email.setEndereco(request.getParameter("email"));
			email.setAtivo(true);
			
			emailDao.addEmail(email);
			
			idEmail = emailDao.getIdEmail();
		}
		
	}

	public Long getIdEmail() {
		return idEmail;
	}
	
	
	
}
