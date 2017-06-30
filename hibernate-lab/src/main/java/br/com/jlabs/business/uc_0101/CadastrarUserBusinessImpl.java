package br.com.jlabs.business.uc_0101;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.model.User;

@Service
public class CadastrarUserBusinessImpl implements CadastrarUserBusiness {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0101.CadastrarUserBusiness#save(br.com.jlabs.model.User)
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public User save(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		if (user.getManager() != null) {
			user.setManager((User) session.load(User.class, user.getManager().getId()));
		}
		
		session.saveOrUpdate(user);
		session.flush();
		
		return user;
		
	}	
	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0101.CadastrarUserBusiness#save(br.com.jlabs.model.User)
	 */
	@Transactional
	public boolean lockVersioned(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.save(user);
			session.flush();
		} catch (ConstraintViolationException e) {
			return false;
		}
		
		return true;
		
	}
	
	@Transactional
	public List<User> list() {
		Session session = sessionFactory.getCurrentSession();
		
		return (List<User>) session
				.createCriteria(User.class)
				.setFetchMode("roles", FetchMode.JOIN)
				.setFetchMode("manager", FetchMode.JOIN)
				.list();
		
	}

	@Transactional
	public User read(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		
		return (User) session.get(User.class, id);

	}

	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
