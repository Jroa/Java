package pe.com.jroa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pe.com.jroa.model.Employee;

public class EmployeeDaoJpaTest {

	EntityManagerFactory emf;
	EntityManager em;
	EmployeeDaoJpa dao;
	
	@Before
	public void setUp(){
		emf = Persistence.createEntityManagerFactory("EmployeeUnit");
		em = emf.createEntityManager();
		dao = new EmployeeDaoJpa(em);
	}
	
	@After
	public void tearDown(){
		em.close();
		emf.close();
	}
	
	private Employee getNewEmployee(){
		Employee employee = new Employee();
		employee.setId(158);
		employee.setName("John Doe");
		employee.setSalary(45000);
		
		return employee;
	}
	
	@Test
	public void testCRUDEmployee(){

		//Create
		em.getTransaction().begin();
		Employee newEmployee = getNewEmployee();
		Employee employee = dao.createEmployee(newEmployee);
		em.getTransaction().commit();
		System.out.println("Persisted " + employee);

		//Find
		employee = dao.findEmployee(getNewEmployee().getId());
		System.out.println("Found " + employee);
		assertNotNull(employee);
		
		//Find All
		List<Employee> listEmployees = dao.findAllEmployees();
		for(Employee emp : listEmployees){
			System.out.println("Found employee: " + emp);
		}
		assertNotNull(listEmployees);
		
		//Update
		em.getTransaction().begin();
		employee = dao.raiseEmployeeSalary(getNewEmployee().getId(), 1000);
		em.getTransaction().commit();
		System.out.println("Updated " + employee);
		Employee employeeUpdated = dao.findEmployee(getNewEmployee().getId());
		assertEquals(getNewEmployee().getSalary() + 1000, employeeUpdated.getSalary());
		
		
		//Remove
		em.getTransaction().begin();
		dao.removeEmployee(getNewEmployee().getId());
		em.getTransaction().commit();
		System.out.println("Remove Employee 158");
		Employee employeeRemoved = dao.findEmployee(getNewEmployee().getId());
		assertNull(employeeRemoved);
	}	
}
