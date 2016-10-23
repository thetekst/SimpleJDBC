import java.io.IOException;

public class Main {
	public static void main(String args[]) {
		JDBCConnect jdbcConnect = new JDBCConnect();
		try {
			jdbcConnect.doQuery();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
