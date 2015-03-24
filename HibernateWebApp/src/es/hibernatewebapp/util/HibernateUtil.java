package es.hibernatewebapp.util;

import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
    
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure();
			Properties properties = configuration.getProperties();
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(properties);
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			return factory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("\n\n>>>>>Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session openSession() {
		return sessionFactory.openSession();
	}
    
    public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}
    
    public static void closeSession() {
		sessionFactory.getCurrentSession().close();
	}
    
    public static Transaction beginTransaction(){
    	return getSession().beginTransaction();
    }
    
    public static void commitTransaction() {
    	getSession().getTransaction().commit();
	}
    
    public static void rollbackTransaction() {
    	Transaction tx = getSession().getTransaction();
    	if(tx != null){
    		tx.rollback();
    	}
	}
    
//    public static Session getCriteria() {
//		return sessionFactory.getC;
//	}
  
    public static void shutdown() {
        // Close caches and connection pools
    	sessionFactory.close();
    }
    
    @SuppressWarnings({"unchecked","rawtypes"})
	public static <T> List<T> listAndCast(Query q){
		List list = q.list();
        return list;
    }
    
    public static void addParametersToCriteria(List<ParameterFilter> parameters, Criteria criteria){
    	if(parameters != null){
	    	for(ParameterFilter sp : parameters){
				String colname = sp.getColumn();
				Operator operator = sp.getOperator();
				Object [] values = sp.getValues();
				HibernateUtil.addParameterToCriteria(colname, operator, values, criteria);
			}
    	}
    }
    
    public static void addParameterToCriteria(String colName, Operator operator, Object[] values, Criteria criteria){
    	
		switch (operator){
		case EQ:
			criteria.add(Restrictions.eq(colName, values[0]));
			break;
		case BETWEEN:
			Object from = values[0];
			Object to = values[1];
			if(from != null && to != null){
				criteria.add(Restrictions.between(colName, from, to));
			}else if(from == null && to != null){
				criteria.add(Restrictions.le(colName, to));
			}else if(from != null && to == null){
				criteria.add(Restrictions.ge(colName, from));
			}
			//We won't add a criteria if both values are null
			
			break;
		case GE:
			criteria.add(Restrictions.ge(colName, values[0]));
			break;
		case GT:
			criteria.add(Restrictions.gt(colName, values[0]));
			break;
		case IN:
			criteria.add(Restrictions.in(colName, values));
			break;
		case LE:
			criteria.add(Restrictions.le(colName, values[0]));
			break;
		case LIKE:
			criteria.add(Restrictions.ilike(colName, values[0].toString(), MatchMode.ANYWHERE));
			break;
		case LT:
			criteria.add(Restrictions.lt(colName, values[0]));
			break;
		default:
			break;
		}
	}
    
}
