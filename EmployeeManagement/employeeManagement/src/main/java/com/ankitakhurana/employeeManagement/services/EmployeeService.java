package com.ankitakhurana.employeeManagement.services;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import com.ankitakhurana.employeeManagement.models.Employee;
import com.ankitakhurana.employeeManagement.utils.HibernateUtil;

public class EmployeeService {

	public static Employee getEmployee(int id) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "select E from Employee E where E.emp_code = :code";
			Query query = session.createQuery(hql);
			query.setParameter("code", id);
			Employee res = (Employee) query.getResultList().get(0);
			session.getTransaction().commit();
			session.close();
			return res;
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Employee> getEmployees() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String hql = "SELECT E FROM Employee E ";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Employee> res = query.getResultList();
		session.close();
		return res;
	}

	public static int editEmployee(Employee emp) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String hql;
		Query query;
		hql = "Update Employee E set E.emp_name = :name,E.location = :location,E.email =:email  where E.emp_code = :code ";
		query = session.createQuery(hql);
		query.setParameter("code", emp.getEmp_code());
		query.setParameter("name", emp.getEmp_name());
		query.setParameter("email", emp.getEmail());
		query.setParameter("location", emp.getLocation());
		int res = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return res;
	}
}
