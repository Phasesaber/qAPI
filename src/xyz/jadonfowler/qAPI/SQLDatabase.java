package xyz.jadonfowler.qAPI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SQLDatabase {
	
	protected Connection connection;
	
	protected SQLDatabase(){}
	
	public abstract Connection openConnection() throws SQLException, ClassNotFoundException;
	
	public boolean checkConnection() throws SQLException{
		return connection != null && !connection.isClosed();
	}
	
	public boolean closeConnection() throws SQLException{
		if(connection == null) return false;
		connection.close();
		return true;
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	public ResultSet querySQL(String query) throws SQLException, ClassNotFoundException{   
		if(!checkConnection())
			openConnection();
		return connection.createStatement().executeQuery(query);
	}
	
	public int updateSQL(String query) throws SQLException, ClassNotFoundException{
		if(!checkConnection())
			openConnection();
		return connection.createStatement().executeUpdate(query);
	}
}
