package landlord.student.rental.daowork;

import java.sql.*;

public class ConnectionToSQL {

	public static Connection connectToDataBase() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalDataBase", "root", "|OSI3Y8W,?sw");
		} catch (ClassNotFoundException e) {
			// the driver is shipped with the application
			throw new IllegalStateException(e);
		}
		// This is the source of all of the errors.
	}

}
