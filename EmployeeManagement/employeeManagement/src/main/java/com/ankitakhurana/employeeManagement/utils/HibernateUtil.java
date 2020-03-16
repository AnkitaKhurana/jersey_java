package com.ankitakhurana.employeeManagement.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ankitakhurana.employeeManagement.models.Employee;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

		} catch (Throwable ex) {
			
			System.out.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
