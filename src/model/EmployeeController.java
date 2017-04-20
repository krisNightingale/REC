package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "employee_controller")
@RequestScoped
public class EmployeeController {

	@EJB
	private EmployeeEJB employeeEJB;
	private Employee employee = new Employee();
	private List<Employee> list = new ArrayList<>();

	public List<Employee> getEmployeeList() {
		list = employeeEJB.findEmployees();
		return list;
	}

	public String viewEmployee() {
		return "employee_list.xhtml";
	}

	public String addNewEmployee() {
		employee = employeeEJB.addNewEmployee(employee);
		list = employeeEJB.findEmployees();
		return "employee_list.xhtml";
	}

	public EmployeeEJB getEmployeeEJB() {
		return employeeEJB;
	}

	public void setEmployeeEJB(EmployeeEJB employeeEJB) {
		this.employeeEJB = employeeEJB;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getList() {
		return getEmployeeList();
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
}
