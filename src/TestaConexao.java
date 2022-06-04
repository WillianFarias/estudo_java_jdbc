import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Connection connection;
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "will17");

		Statement stm = connection.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			
			System.out.println("Id: " + id + " Nome:" + nome + " Descricao: " + descricao);
		}
		
		connection.close();
	}
}
