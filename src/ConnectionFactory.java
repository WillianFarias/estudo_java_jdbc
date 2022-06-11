import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	//DataSource
	public DataSource dataSource;
	
	//PoolDeConexao
	public ConnectionFactory () {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("will17");
		
		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperaConexao() throws SQLException {
//		Connection connection;
//		connection = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "will17");
//
//		return connection;
		return this.dataSource.getConnection();
	}
}
