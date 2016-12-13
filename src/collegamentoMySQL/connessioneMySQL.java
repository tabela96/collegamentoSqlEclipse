package collegamentoMySQL;
import java.sql.*;

public class connessioneMySQL {
	public static void main(String[] args) throws SQLException {
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch
		/*															  ho modificato qui-> /nomeDatabase?....*/
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova?user=root&password=");
		//jdbc:mysql://localhost:3306/Contatti?user=root&password=secret
		sql = "SELECT * FROM amici;"; //qui seleziono la tabella
		// ________________________________query
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() == true)
				System.out.println(rs.getString("id") + "\t" + rs.getString("cognome")+"\t"+rs.getString("nome")+"\t"+rs.getString("dataNascita"));
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
	}// fine main
}// fine classe
