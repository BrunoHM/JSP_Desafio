package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioService {
	
	ResultSet retornoSelect;
	
	UsuarioDao usuarioDao = new UsuarioDao();
	Usuario usuario = new Usuario();
	
	public void getTodosUsuarios(HttpServletRequest request) {
		try {
			retornoSelect = usuarioDao.getAllusuarios();
			List<Usuario> listUsuario = new ArrayList<Usuario>();
			
			while(retornoSelect.next()) {
				usuario = new Usuario();
				
				usuario.setId(retornoSelect.getInt(1));
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
	
}
