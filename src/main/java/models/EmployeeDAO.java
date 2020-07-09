package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

    // SQL queries
    // --------------------------------------------------------------------------------------------
    // executeQuery -> returns -> ResultSet
    private final String QUERY_GETALL = " SELECT e.id, e.nombre, e.apellido_1, e.apellido_2, e.nif,e.id_departamento, d.id AS 'departmentId', d.nombre AS 'departmentName', d.presupuesto, d.gasto FROM empleados as e LEFT JOIN departamentos as d ON e.id_departamento = d.id ORDER BY e.id ASC LIMIT 100; ";

    // executeUpdate -> returns -> integer with the number of affected rows
    private final String QUERY_INSERT = " INSERT INTO empleados (nif, nombre, apellido_1, apellido_2, id_departamento) VALUES (?,?,?,?,?); ";
    // --------------------------------------------------------------------------------------------

    
    
    // getAll()
    // -----------------------------------------------------------------------------------
    public ArrayList<Employee> getAll() {

	ArrayList<Employee> dbRegisters = new ArrayList<Employee>();

	try (Connection dBconnection = ConnectionManager.getConnection(); PreparedStatement preparedStatement = dBconnection.prepareStatement(QUERY_GETALL);) {

	    try (ResultSet dbResultSet = preparedStatement.executeQuery()) {

		Employee employee;
		Department department;

		while (dbResultSet.next()) {

		    employee = new Employee();

		    employee.setIdEmployee(dbResultSet.getInt("id"));
		    employee.setNameEmployee(dbResultSet.getString("nombre"));
		    employee.setFirstSurnameEmployee(dbResultSet.getString("apellido_1"));
		    employee.setSecondSurnameEmployee(dbResultSet.getString("apellido_2"));
		    employee.setNif(dbResultSet.getString("nif"));
		    employee.setIdDepartmentEmployee(dbResultSet.getInt("id_departamento"));

		    department = new Department();

		    department.setDepartmentId(dbResultSet.getInt("departmentId"));
		    department.setDepartmentName(dbResultSet.getString("departmentName"));
		    department.setDepartmentBudget(dbResultSet.getFloat("presupuesto"));
		    department.setDepartmentExpenses(dbResultSet.getFloat("gasto"));

		    employee.setDepartment(department);

		    dbRegisters.add(employee);
		}

	    }
	} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace(); // TODO
	}

	return dbRegisters;
    }
    // End getAll()
    // ---------------------------------------------------------------------------------------
    
    

    // insert()
    // ---------------------------------------------------------------------------------------
    public void insert(Employee newEmployee) {

	try (
		Connection dbConnection = ConnectionManager.getConnection(); 
		PreparedStatement preparedStatement = dbConnection.prepareStatement(QUERY_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

	    // Replace ? in the SQL query
	    preparedStatement.setString	(1, newEmployee.getNameEmployee());
	    preparedStatement.setString	(2, newEmployee.getFirstSurnameEmployee());
	    preparedStatement.setString	(3, newEmployee.getSecondSurnameEmployee());
	    preparedStatement.setString	(4, newEmployee.getNif());
	    preparedStatement.setInt	(5, newEmployee.getIdDepartmentEmployee());	    

	    // Executing the update against the DB and saving the number of affected rows
	    int affectedRows = preparedStatement.executeUpdate();
	    
	} catch (Exception e) {

	    // TODO LOG and feedback	    

	} 
	
    }

    // End insert()
    // -----------------------------------------------------------------------------------

}
