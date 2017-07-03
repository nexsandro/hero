package br.com.jlabs.business.uc_0101;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudBusinessImpl implements CrudBusiness {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0101.CrudBusiness#save(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Object entity) {
		sessionFactory.getCurrentSession().save(entity);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public <T> T read(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void merge(Object entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void evict(Object entity) {
		sessionFactory.getCurrentSession().evict(entity);
	}
}
