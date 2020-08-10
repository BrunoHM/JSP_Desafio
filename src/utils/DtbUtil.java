package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DtbUtil {

	public static Connection conexaoDtb;
	
	public static Connection getConexao() {
		if(conexaoDtb == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexaoDtb = DriverManager.getConnection("jdbc:mysql://localhost:3306/desafio_Jsp?serverTimezone=UTC","root","@Grilo1324");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conexaoDtb; 
	}
	
}
