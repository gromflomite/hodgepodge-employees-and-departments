package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.EmployeeDAO;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final EmployeeDAO employeeDAO = new EmployeeDAO();   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
	String searchFilter = request.getParameter("searchFilter"); // Get value from form
	
	
	
	ArrayList<Employee> dbRegisters = employeeDAO.getAllOrFiltered(searchFilter); // Sending null to DAO at first round (first page load, no user filter search entered yet)
	
	request.setAttribute("dbRegisters", dbRegisters);
	request.setAttribute("filterCriteria", searchFilter);
	
	request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// Using only doGet()
	doGet(request, response);
    }

}
