package es.hibernatewebapp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.Operator;
import es.hibernatewebapp.util.ParameterFilter;

public abstract class GenericDAOImpl <T, ID extends Serializable> implements GenericDAO<T, ID>{
	
	public GenericDAOImpl() {
	}

	protected Session getSession() {
        return HibernateUtil.getSession();
    }
 
    public void save(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.saveOrUpdate(entity);
    }
 
    public void merge(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.merge(entity);
    }
 
    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
        List<T> t;
        t = query.list();
        return t;
    }
    
    @SuppressWarnings("unchecked")
	public List<T> findMany(Criteria criteria) {
        List<T> t;
        t = criteria.list();
        return t;
    }
    
    @SuppressWarnings("unchecked")
	public T findOne(Criteria criteria) {
        T t;
        t = (T) criteria.uniqueResult();//Lanza NonUniqueResult si se encuentra mas de un elemento o instancia.
        return t;
    }
 
    @SuppressWarnings("unchecked")
	public T findOne(Query query) {
        T t;
        t = (T) query.uniqueResult();//Lanza NonUniqueResult si se encuentra mas de un elemento o instancia.
        return t;
    }
 
    @SuppressWarnings("unchecked")
	public T findById(Class<?> clazz, Long id) {
        Session hibernateSession = this.getSession();
        T t = null;
        t = (T) hibernateSession.get(clazz, id);
        return t;
    }
 
    @SuppressWarnings("unchecked")
	public List<T> findAll(Class<?> clazz) {
        Session hibernateSession = this.getSession();
        List<T> T = null;
        Query query = hibernateSession.createQuery("from " + clazz.getSimpleName());
        T = query.list();
        return T;
    }
    
    public List<T> findBy(Class<?> clazz, List<ParameterFilter> parameters){
    	List<T> lt = new ArrayList<T>();
    	if(parameters != null && !parameters.isEmpty()){
			Criteria criteria = HibernateUtil.getSession().createCriteria(clazz);
			HibernateUtil.addParametersToCriteria(parameters, criteria);
			lt = findMany(criteria);
    	}else{
    		lt = findAll(clazz);
    	}
		return lt;
	}
    
    public List<T> findBy(Class<?> clazz, String colName, Operator operator, Object[] values){
		List<T> lt = new ArrayList<T>();
		Criteria criteria = HibernateUtil.getSession().createCriteria(clazz);
		HibernateUtil.addParameterToCriteria(colName, operator, values, criteria);
		lt = findMany(criteria);
		return lt;
	}
    
}
