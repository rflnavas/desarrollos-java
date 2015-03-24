package es.hibernatewebapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.hibernatewebapp.entities.User;
import es.hibernatewebapp.util.HibernateUtil;

public class UserDAO{
	
	public UserDAO() {

	}
	
	public boolean insert(User u) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(u);
			
			tx.commit();
			return true;
		} catch (Exception e) {

			if(tx != null){
				tx.rollback();
			}
			System.err.println(e.getMessage());
			return false;
		}finally{
			session.close();
		}
		
	}

	public boolean update(User u) {
		
		return false;
	}

	public List<User> select(Criteria c) {

		List<User> users = new ArrayList<User>();
		
		return users;
	}

	public boolean delete(long id) throws SQLException {
		return false;
	}
	
}
