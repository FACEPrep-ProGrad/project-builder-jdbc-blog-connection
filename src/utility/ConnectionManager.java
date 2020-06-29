package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	public static Connection getConnection() {
		Connection con =null;
		//get the details from the properties file
		Properties properties = ConnectionManager.loadPropertiesFile();
		String driver , url , username , password;
		//load the driver
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//get the connection in connection object
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static Properties loadPropertiesFile() {
		Properties properties = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
}

