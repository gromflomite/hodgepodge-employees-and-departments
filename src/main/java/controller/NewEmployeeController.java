package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.EmployeeDAO;

@WebServlet("/newemployee")
public class NewEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// We are using only doPost()
	doGet(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	final EmployeeDAO employeeDAO = new EmployeeDAO();

	// POJO to set the values from form
	Employee newEmployee = new Employee();

	try {

	    // Get the parameters from the view form
	    String nameEmployee = request.getParameter("nameEmployee");
	    String firstSurnameEmployee = request.getParameter("firstSurnameEmployee");
	    String secondSurnameEmployee = request.getParameter("secondSurnameEmployee");
	    String nifEmployee = request.getParameter("nifEmployee");
	    String stringDepartmentEmployee = request.getParameter("departmentEmployee");

	    // Parse the int values
	    int departmentEmployee = Integer.parseInt(stringDepartmentEmployee);

	    // Set values to POJO
	    newEmployee.setNameEmployee(nameEmployee);
	    newEmployee.setFirstSurnameEmployee(firstSurnameEmployee);
	    newEmployee.setSecondSurnameEmployee(secondSurnameEmployee);
	    newEmployee.setNif(nifEmployee);
	    newEmployee.setIdDepartmentEmployee(departmentEmployee);

	    try {

		// Calling DAO' insert method
		employeeDAO.insert(newEmployee);

	    } catch (Exception e) {

		// TODO LOG and feedback
	    }

	} catch (Exception e) {

	    // TODO LOG and feedback

	} finally {

	    // Going back to index.jsp
	    request.getRequestDispatcher("home").forward(request, response);
	}

    }

}
