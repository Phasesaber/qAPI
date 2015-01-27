package xyz.jadonfowler.qAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL extends SQLDatabase{
	private final String user;
	private final String database;
	private final String password;
	private final String port;
	private final String hostname;
	
	public MySQL(String user, String database, String password, String port,
			String hostname) {
		super();
		this.user = user;
		this.database = database;
		this.password = password;
		this.port = port;
		this.hostname = hostname;
	}

	@Override
	public Connection openConnection() throws SQLException,
			ClassNotFoundException {
		if(checkConnection()){
			return connection;
		}
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://"+hostname+":"+port+"/"+database, user, password);
		return connection;
	}
	
}
