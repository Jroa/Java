package pe.com.jroa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pe.com.jroa.model.Employee;

public class EmployeeDaoJpa {
	protected EntityManager em;
	
	public EmployeeDaoJpa (EntityManager em){
		this.em = em;
	}
	
	public Employee createEmployee(Employee employee){
		em.persist(employee);
		return employee;
	}
	
	public void removeEmployee(int id){
		Employee employee = findEmployee(id);
		if(employee !=null){
			em.remove(employee);
		}
	}
	
	public Employee raiseEmployeeSalary(int id, long raise){
		Employee employee = em.find(Employee.class, id);
		if(employee !=null){
			employee.setSalary(employee.getSalary() + raise);
		}
		return employee;
	}
	
	public Employee findEmployee(int id){
		return em.find(Employee.class, id);
	}
	
	public List<Employee> findAllEmployees(){
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}
}
