package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

		// create a properties object
		Properties properties = null;
		try {
			properties = loadPropertiesFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String driverString = properties.getProperty("driver");
		String urlString = properties.getProperty("url");
		String userNameString = properties.getProperty("username");
		String passwordString = properties.getProperty("password");

		// load the connection driver file
		Class.forName(driverString);

		// create a connection object
		Connection connection = null;
		connection = DriverManager.getConnection(urlString, userNameString, passwordString);
		return connection;
	}

	// create a properties method

	public static Properties loadPropertiesFile() throws IOException {
		Properties properties = new Properties();
		InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(input);
		input.close();
		return properties;
	}

}
