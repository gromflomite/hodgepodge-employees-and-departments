package models;

public class Department {

    private int departmentId;
    private String departmentName;
    private float departmentBudget;
    private float departmentExpenses;

    public Department() {
	super();
	this.departmentId = 0;
	this.departmentName = "";
	this.departmentBudget = 0f;
	this.departmentExpenses = 0f;
    }

    public int getDepartmentId() {
	return departmentId;
    }

    public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
    }

    public String getDepartmentName() {
	return departmentName;
    }

    public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
    }

    public float getDepartmentBudget() {
	return departmentBudget;
    }

    public void setDepartmentBudget(float departmentBudget) {
	this.departmentBudget = departmentBudget;
    }

    public float getDepartmentExpenses() {
	return departmentExpenses;
    }

    public void setDepartmentExpenses(float departmentExpenses) {
	this.departmentExpenses = departmentExpenses;
    }

    @Override
    public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentBudget=" + departmentBudget + ", departmentExpenses=" + departmentExpenses + "]";
    }

}
