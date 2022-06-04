import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection recuperaConexao() throws SQLException {
		Connection connection;
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "will17");

		return connection;
	}
}
