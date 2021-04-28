package MainPacakge;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionManager {
  Connection connection = null;
    public Connection getConnection() {
     try {
		//Class.forName("com.mysql.cj.jdbc.driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library?useTimeZone=true&serverTimezone=UTC","prashant","Prashant");
	} catch (Exception e) {
		e.printStackTrace();
	}
     return connection;
    }
    public void closeConnection() {
    	try {
			connection.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
}
