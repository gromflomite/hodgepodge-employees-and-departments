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
    private final String QUERY_GETALL = " SELECT e.id, e.nombre, e.apellido_1, e.apellido_2, e.id_departamento, d.id AS 'departmentId', d.nombre AS 'departmentName', d.presupuesto, d.gasto FROM empleados as e LEFT JOIN departamentos as d ON e.id_departamento = d.id ORDER BY e.id ASC LIMIT 100; ";
    // --------------------------------------------------------------------------------------------
    
    public ArrayList<Employee> getAll() {

	ArrayList<Employee> dbRegisters = new ArrayList<Employee>();

	try (		
		Connection dBconnection = ConnectionManager.getConnection(); 
		PreparedStatement preparedStatement = dBconnection.prepareStatement(QUERY_GETALL);) {

	    try (ResultSet dbResultSet = preparedStatement.executeQuery()) {

		Employee employee;
		Department department;

		while (dbResultSet.next()) {

		    employee = new Employee();

		    employee.setIdEmployee(dbResultSet.getInt("id"));
		    employee.setNameEmployee(dbResultSet.getString("nombre"));
		    employee.setFirstSurnameEmployee(dbResultSet.getString("apellido_1"));
		    employee.setSecondSurnameEmployee(dbResultSet.getString("apellido_2"));
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

}
