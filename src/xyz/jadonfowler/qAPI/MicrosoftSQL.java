package xyz.jadonfowler.qAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Microsoft JDBC Driver for SQL Server (https://msdn.microsoft.com/en-us/sqlserver/aa937724.aspx)
 * @author Owner
 */
public class MicrosoftSQL extends SQLDatabase {

	private final String serverName;
	private final String portNumber;
	
	public MicrosoftSQL(String serverName, String portNumber) {
		super();
		this.serverName = serverName;
		this.portNumber = portNumber;
	}

	@Override
	public Connection openConnection() throws SQLException,
			ClassNotFoundException {
		if(checkConnection())
			return connection;
		System.setProperty("java.net.preferIPv6Addresses", "true");
		connection = DriverManager.getConnection("jdbc:sqlserver://"+serverName+":"+portNumber);
		return connection;
	}

}
