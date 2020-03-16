package com.ankitakhurana.hrManagement.services;

import javax.persistence.Query;

import org.hibernate.Session;

import com.ankitakhurana.hrManagement.models.User;
import com.ankitakhurana.hrManagement.utils.HibernateUtil;

public class DatabaseService {
	public static User GetUser(String username, String password) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String hql = "select U.id, U.username, U.password from User U where U.username = :username and U.password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		Object[] result = (Object[]) query.getSingleResult();
		User u = new User();
		u.setId((int) result[0]);
		u.setUsername((String) result[1]);
		u.setPassword((String) result[2]);
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
