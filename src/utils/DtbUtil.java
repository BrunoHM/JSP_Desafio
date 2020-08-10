package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DtbUtil {

	public static Connection conexaoDtb;
	private static final String conexao = "jdbc:mysql://localhost:3306/desafio_Jsp?serverTimezone=UTC";
	private static final String usuario = "root";
	private static final String senha = "@Grilo1324";

	
	public static Connection getConexao() {
		if(conexaoDtb == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexaoDtb = DriverManager.getConnection(conexao, usuario, senha);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conexaoDtb; 
	}
	
}
