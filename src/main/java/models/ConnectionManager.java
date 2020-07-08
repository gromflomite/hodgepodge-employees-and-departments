package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final static String URL = "jdbc:mysql://localhost/uf2176_ejercicio2_raul";
    private final static String USUARIO = "root";
    private final static String PASS = "secret";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

	Connection dbConnection = null;
	Class.forName("com.mysql.jdbc.Driver");
	dbConnection = DriverManager.getConnection(URL, USUARIO, PASS);
	return dbConnection;
    }
}
