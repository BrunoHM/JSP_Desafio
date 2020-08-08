package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DtbUtil {

	public DtbUtil(){
		conectaDtb();
	}
	
	Connection conexaoDtb;
	
	public void conectaDtb() {
		try {
			connectDtb();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connectDtb() throws Exception {
		if(conexaoDtb == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexaoDtb = DriverManager.getConnection("jdbc:mysql://localhost:3306/desafio_Jsp?serverTimezone=UTC","root","@Grilo1324");
		}
	}
	
	public Connection getConexao() {
		return conexaoDtb;
	}
	
}
