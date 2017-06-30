package br.com.jlabs.business.uc_0102;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.model.Tag;

@Service
public class CadastrarTagBusinessImpl implements CadastrarTagBusiness {

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0102.CadastrarTagBusiness#create(br.com.jlabs.model.Tag)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public void create(Tag tag) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(tag);
		
	}
}
