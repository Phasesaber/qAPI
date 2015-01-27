package xyz.jadonfowler.qAPI;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite extends SQLDatabase{
	
	private final String folder;
	private final String dbLocation;
	
	public SQLite(String folder, String dbLocation){
		this.folder = folder;
		this.dbLocation = dbLocation;
	}
	
	@Override
	public Connection openConnection() throws SQLException, ClassNotFoundException{
		if(checkConnection())
			return connection;
		File file = new File(folder, dbLocation);
		if(!(file.exists())){
			try{
				file.createNewFile();
			}catch(IOException e){
				System.out.println("ERROR: Unable to create SQLite Databse");
			}
		}
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:"+folder+"/"+dbLocation);
		return connection;
	}
	
}
