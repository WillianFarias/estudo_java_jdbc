import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

//		Connection connection;
//		connection = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "will17");
		
		try(Connection connection = ConnectionFactory.recuperaConexao()) {
			
			try(PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO")) {
				
				stm.execute();
				
				ResultSet rst = stm.getResultSet();
				
				while(rst.next()) {
					Integer id = rst.getInt("ID");
					String nome = rst.getString("NOME");
					String descricao = rst.getString("DESCRICAO");
					
					System.out.println("Id: " + id + " Nome:" + nome + " Descricao: " + descricao);
				}
			}
		}
//		connection.close();
	}
}
