package utility;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
1.Create a class called as `ConnectionManager` inside the utility package.
2.Create a method public static Connection getConnection() which returns a connection object. 
3.Use the method public static Properties loadPropertiesFile() to load the jdbc properties from the jdbc.properties file.
*/

public class ConnectionManager{
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties properties=loadPropertiesFile();
		Class.forName(properties.getProperty("driver"));
		Connection connection=null;
		connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
		if(connection!=null)
			return connection;
		else
			return null;
	}
	
	public static Properties loadPropertiesFile() throws IOException {
		Properties properties=new Properties();
		InputStream inputStream=ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);
		inputStream.close();
		return properties;
	}
	
}