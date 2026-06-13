package com.example.restservice;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestServiceApplicationTests {

	private EmployeeManager employeeManager;

	// Helper function to get the number of current employees
	int getEmployeeCount(EmployeeManager manager)
	{
		return manager.getAllEmployees().getEmployeeList().size();
	}

	@Test
	// Ensure that employee list is populated on initialization
	void createEmployeeManager() {
		EmployeeManager newEmployeeManager = new EmployeeManager();
		assert(getEmployeeCount(newEmployeeManager) != 0);
	}

	@Test
	// Ensure that adding an employee increases the employee count by 1
	void addEmployee() {
		EmployeeManager employeeManager = new EmployeeManager();
		int employeeCount = getEmployeeCount(employeeManager);
		Employee employee = new Employee("djones3", "Daria", "Jones", "dariajones@gmail.com", "Software developer");
		employeeManager.addEmployee(employee);
		assert(employeeCount + 1 == getEmployeeCount(employeeManager));
	}

	@BeforeEach
	void setUp()
	{
		this.employeeManager = new EmployeeManager();
		Employee newEmployee = new Employee("djones3", "Daria", "Jones", "dariajones@gmail.com", "Software developer");
		this.employeeManager.addEmployee(newEmployee);
	}

	@Test
	// Check whether added employee ID is found in ID field
	void employeeIdInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getId().equals("djones3"))
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee first name is found in first name field
	void employeeFirstNameInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getFirstName().equals("Daria"))
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee last name is found in last name field
	void employeeLastNameInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getLastName().equals("Jones"))
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee email is found in email field
	void employeeEmailInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getEmail().equals("dariajones@gmail.com"))
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee title is found in title field
	void employeeTitleInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i = 0; i < employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getTitle().equals("Software developer"))
			{
				return;
			}
		}
		assert(false);
	}
}
