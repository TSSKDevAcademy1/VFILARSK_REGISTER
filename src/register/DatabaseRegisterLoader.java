package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseRegisterLoader implements RegisterLoader {

	public static final String URL = "jdbc:mysql://localhost/register";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static final String QUERYINSERT = "INSERT INTO rregister (id, name, number) VALUES (?, ?, ?)";
	public static final String QUERYSELECT = "SELECT id, name, number FROM rregister";
	public static final String QUERYDELETE = "DELETE FROM rregister";

	@Override
	public void save(Register register) {
		try {
			try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
				try (Statement stmt = con.createStatement()) {
					stmt.executeUpdate(QUERYDELETE);
				}

				try (PreparedStatement stmt = con.prepareStatement(QUERYINSERT)) {
					for (int j = 0; j < register.getCount(); j++) {
						stmt.setInt(1, j + 1);
						stmt.setString(2, register.getPerson(j).getName());
						stmt.setString(3, register.getPerson(j).getPhoneNumber());
						stmt.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Register load() {
		try {
			try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(QUERYSELECT);) {

				Register register = new ListRegister();

				while (rs.next()) {
					register.addPerson(new Person(rs.getString(2), rs.getString(3)));
				}

				return register;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}