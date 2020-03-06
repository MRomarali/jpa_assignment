package ECCutb.OmarAli.jpa_Assignment.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
  private static final String URL;
  private static final String USER;
  private static final String PASSWORD;

  static {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("src/main/resources/application.properties"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    URL = properties.getProperty("url");
    USER = properties.getProperty("user");
    PASSWORD = properties.getProperty("password");
  }
  public static Connection getConnection() throws SQLException{
    return DriverManager.getConnection(URL,USER,PASSWORD);
  }
}
