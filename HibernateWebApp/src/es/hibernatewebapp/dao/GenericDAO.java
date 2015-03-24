package es.hibernatewebapp.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

public interface GenericDAO <T, ID extends Serializable> {

	List<T> findMany(Query q);
	
	List<T> findAll(Class<?> clazz);
	
	T findById(Class<?> clazz, ID id);
	
	T findOne(Query q);
	
	void merge(T entity);
	
	void save(T entity);
	
	void delete(T entity);

}
