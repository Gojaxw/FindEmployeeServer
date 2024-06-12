package com.serveronspring.SpringServer;

import com.serveronspring.SpringServer.model.employee.Employee;
import com.serveronspring.SpringServer.model.employee.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;
	@PersistenceContext
	EntityManager entityManager;
	@Test
	void addEmployeeTest() {
		Employee employee =new Employee();
		employee.setName("Bryce Afler");
		employee.setLocation("Building-2");
		employee.setBranch("Security");
		employee.setId((employeeDao.getCount()+1));
		employeeDao.save(employee);

	}
//@Test
	void getAllEmployee() {
		List<Employee> employees= employeeDao.getAllEmployees();
		System.out.println(employees);
	}
	//@Test
	void  deleteAll(){
		employeeDao.deleteAll();
	}
	//@Test
	void getAllEmployeeAndDeleteThem() {
		List<Employee> employees= employeeDao.getAllEmployees();
		for (Employee employee:employees){
			employeeDao.delete(employee);
		}
	}
	//@Test
	void  deleteById(){
		employeeDao.deleteById(2);

	}
}
