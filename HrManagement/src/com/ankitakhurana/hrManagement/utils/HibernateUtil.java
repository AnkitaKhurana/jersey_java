package com.ankitakhurana.hrManagement.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ankitakhurana.hrManagement.models.User;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
