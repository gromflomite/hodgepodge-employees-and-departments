package models;

public class Employee {

    private int idEmployee;
    private String nameEmployee;
    private String firstSurnameEmployee;
    private String secondSurnameEmployee;
    private int idDepartmentEmployee;
    private Department department;

    public Employee() {
	super();
	this.idDepartmentEmployee = 0;
	this.nameEmployee = "";
	this.firstSurnameEmployee = "";
	this.secondSurnameEmployee = "";
	this.idDepartmentEmployee = 0;
	this.department = new Department();
    }

    public int getIdEmployee() {
	return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
	this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
	return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
	this.nameEmployee = nameEmployee;
    }

    public String getFirstSurnameEmployee() {
	return firstSurnameEmployee;
    }

    public void setFirstSurnameEmployee(String firstSurnameEmployee) {
	this.firstSurnameEmployee = firstSurnameEmployee;
    }

    public String getSecondSurnameEmployee() {
	return secondSurnameEmployee;
    }

    public void setSecondSurnameEmployee(String secondSurnameEmployee) {
	this.secondSurnameEmployee = secondSurnameEmployee;
    }

    public int getIdDepartmentEmployee() {
	return idDepartmentEmployee;
    }

    public void setIdDepartmentEmployee(int idDepartmentEmployee) {
	this.idDepartmentEmployee = idDepartmentEmployee;
    }

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    @Override
    public String toString() {
	return "Employee [idEmployee=" + idEmployee + ", nameEmployee=" + nameEmployee + ", firstSurnameEmployee=" + firstSurnameEmployee + ", secondSurnameEmployee=" + secondSurnameEmployee + ", idDepartmentEmployee="
		+ idDepartmentEmployee + ", department=" + department + "]";
    }

}
