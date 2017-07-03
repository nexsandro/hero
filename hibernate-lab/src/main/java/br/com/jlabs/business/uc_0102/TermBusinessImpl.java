/**
 * 
 */
package br.com.jlabs.business.uc_0102;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jlabs.business.uc_0101.CrudBusiness;
import br.com.jlabs.model.Term;

/**
 * @author sandro
 *
 */
@Service
public class TermBusinessImpl implements TermBusiness {

	@Autowired
	public CrudBusiness crud;
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0102.TermBusiness#save(br.com.jlabs.model.Term)
	 */
	public void save(Term term) {
		crud.save(term);
	}

	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0102.TermBusiness#update(br.com.jlabs.model.Term)
	 */
	public void update(Term term) {
		crud.save(term);
	}

}
