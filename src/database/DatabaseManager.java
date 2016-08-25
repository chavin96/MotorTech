package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Customer;

public class DatabaseManager {

	public void insertCustomer(Customer customer) throws Exception {

		try {
			Connection connection = getConnection();

			// the mysql insert statement
			String query = " insert into customer (code, name, address, telephone, fax, email, contactPerson, vehicleNumber, vehicleModel, vehicleMake, engineNumber, chassisNo, vehicleColour)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, customer.getCode());
			preparedStmt.setString(2, customer.getName());
			preparedStmt.setString(3, customer.getAddress());
			preparedStmt.setString(4, customer.getTelephone());
			preparedStmt.setString(5, customer.getFax());
			preparedStmt.setString(6, customer.getEmail());
			preparedStmt.setString(7, customer.getContactPerson());
			preparedStmt.setString(8, customer.getVehicleNumber());
			preparedStmt.setString(9, customer.getVehicleModel());
			preparedStmt.setString(10, customer.getVehicleMake());
			preparedStmt.setString(11, customer.getEngineNumber());
			preparedStmt.setString(12, customer.getChassisNumber());
			preparedStmt.setString(13, customer.getVehicleColour());
			// execute the preparedstatement
			preparedStmt.execute();

			connection.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	private static class DatabaseManagerLoader {
		private static final DatabaseManager INSTANCE = new DatabaseManager();
	}

	private DatabaseManager() {
		if (DatabaseManagerLoader.INSTANCE != null) {
			throw new IllegalStateException("Already instantiated");
		}
	}

	public static DatabaseManager getInstance() {
		return DatabaseManagerLoader.INSTANCE;
	}

	public Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/motortechdatabase", "root", "1234");
		} catch (SQLException e) {
			throw new Exception("Connection Failed!", e);
		}
		return connection;
	}
}
