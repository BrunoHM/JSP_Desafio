package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioService {
	
	UsuarioDao usuarioDao = new UsuarioDao();
	
	public void checkAction(HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		requestUri = requestUri.substring(requestUri.lastIndexOf("/")+1);
		
		if(requestUri.equals("usuarios")) {
			getTodosUsuarios(request);
		}else if(requestUri.equals("deletaUsuario")) {
			deletaUsuario(request);
		}else if(requestUri.equals("insereUsuario")) {
			addUsuario(request);
			getTodosUsuarios(request);
		}
		
	}
	
	private void deletaUsuario(HttpServletRequest request) {
		if(request.getParameter("idUserDel") != null) {
			int idUsuario = Integer.valueOf(request.getParameter("idUserDel"));
			
			if(idUsuario > 0) {
				usuarioDao.deletaUsuario(idUsuario);
			}
		}
		
	}

	private void getTodosUsuarios(HttpServletRequest request) {
		ResultSet retornoSelect;
		Usuario usuario;
		try {
			retornoSelect = usuarioDao.getAllusuarios();
			List<Usuario> listUsuario = new ArrayList<Usuario>();
			
			while(retornoSelect.next()) {
				usuario = new Usuario();
				
				usuario.setId(retornoSelect.getLong(1));
				usuario.setNome(retornoSelect.getString(2));
				usuario.setSobrenome(retornoSelect.getString(3));
				usuario.setCpf(retornoSelect.getString(4));
				usuario.setAtivo(retornoSelect.getBoolean(5));
				
				listUsuario.add(usuario);
			}
			request.setAttribute("queryResults",listUsuario);
			
		}catch(Exception e) {
			System.err.println("Não foi possível retornar os usuários cadastrados na base de dados!");
		}
	}
	
	
	private void addUsuario(HttpServletRequest request) {
		List<Long> idTelefones;
		Long idUsuario;
		Long idEmail;
		
		TelefoneService telefoneService = new TelefoneService();
		telefoneService.insereTelefone(request);
		idTelefones = telefoneService.getIdTelefones();
		
		EmailService emailService = new EmailService();
		emailService.insereEmail(request);
		idEmail = emailService.getIdEmail();
		
		insereUsuario(request);
		idUsuario = usuarioDao.getIdUsuario();
		
		ContatoService contatoService = new ContatoService();
		contatoService.insereContato(idTelefones, idUsuario, idEmail);
		
	}
	
	public void insereUsuario(HttpServletRequest request) {
		Usuario usuario;
		if(request.getParameter("nome") != null &&
		   request.getParameter("sobrenome") != null &&
		   request.getParameter("cpf") != null) {
			
			usuario = new Usuario();
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setSobrenome(request.getParameter("sobrenome"));
			usuario.setCpf(request.getParameter("cpf"));
			usuario.setAtivo(true);
			
			usuarioDao.addUsuario(usuario);
		}
		
	}
	
}
