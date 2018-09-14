/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars.data;

/**
 *
 * @author SPANDANA
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;

	public synchronized static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;

	}

	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/cars");
		} catch (NamingException e) {
			System.err.println(e);
		}
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");    
		String dbName = "cars";        
		String userName = "spandana";        
		String password = "12345678";      
		String hostname = "rentacardb.c3uw78z0w4om.us-east-2.rds.amazonaws.com";      
		String port = "3306";
		String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;        
		return DriverManager.getConnection(jdbcUrl);
	}
	public void freeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}
}