import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnect {
	private final String url = "jdbc:mariadb://localhost:3306/user_page";
	private final String username = "root";
	private final String password = "good35";
	private final String query = "SELECT * FROM profile";
	
	public void doQuery() throws IOException {
		Profile profile;
		
		try(Connection connection = getConnection()) {
			Statement statement = connection.createStatement();
			
			try(ResultSet result = statement.executeQuery(query)) {
				while(result.next()) {
					int id = Integer.parseInt(result.getString(1));
					String login = result.getString(2);
					String fio = result.getString(3);
					String phone = result.getString(4);
					profile = new Profile(id, login, fio, phone);
					System.out.println(profile.toString());
				}
			}
		} catch (SQLException e) {
			for(Throwable t: e) {
				t.printStackTrace();
			}
		}
	}
	
	public Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		try(InputStream in = 
				Files.newInputStream(Paths.get("src/main/resources/db.properties"))) {
			props.load(in);
		}
		
		String drivers = props.getProperty("jdbc.drivers");
		if(null != drivers) System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}
}
