package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	// connection
	private static Connection conn = null;
	
	// create connections
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);				
			} catch(SQLException err) {
				throw new DbException(err.getMessage()); // nossa propria excecao
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();				
			} catch(SQLException err) {
				throw new DbException(err.getMessage()); // nossa propria excecao
			}
		}
	}
	
	// carregar as props do arq
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch(IOException err) {
			throw new DbException(err.getMessage()); // nossa propria excecao
		}
	}
	
	// fechar os statements
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();				
			} catch (SQLException err) {
				throw new DbException(err.getMessage());
			}
		}
	}
	
	// fechar os resultsets
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();				
			} catch (SQLException err) {
				throw new DbException(err.getMessage());
			}
		}
	}
	
}
