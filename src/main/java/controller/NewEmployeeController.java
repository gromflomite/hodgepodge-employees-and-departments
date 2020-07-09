package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.EmployeeDAO;

@WebServlet("/newemployee")
public class NewEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private static final EmployeeDAO employeeDAO = new EmployeeDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// We are using only doPost()
	doGet(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// Get the parameters from the view form
	String nameEmployee 		= request.getParameter("nameEmployee");
	String firstSurnameEmployee 	= request.getParameter("firstSurnameEmployee");
	String secondSurnameEmployee	= request.getParameter("secondSurnameEmployee");
	String nifEmployee		= request.getParameter("nifEmployee");
	String stringDepartmentEmployee	= request.getParameter("departmentEmployee");	
	
	try {
	    
	    // Parse the int values
	    int departmentEmployee = Integer.parseInt(stringDepartmentEmployee);	    
	    
	} catch (Exception e) {
	    
	    
	   
	} finally {
	    
	    
	}
	
	
    }

}
