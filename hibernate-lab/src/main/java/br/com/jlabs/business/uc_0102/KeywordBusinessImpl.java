/**
 * 
 */
package br.com.jlabs.business.uc_0102;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.business.uc_0101.CrudBusiness;
import br.com.jlabs.model.Keyword;
import br.com.jlabs.model.Term;

/**
 * @author sandro
 *
 */
@Service
public class KeywordBusinessImpl implements KeywordBusiness {

	@Autowired
	public CrudBusiness crud;
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.business.uc_0102.KeywordBusiness#save(br.com.jlabs.model.Keyword)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(Keyword keyword) {
		
		crud.save(keyword);
		
		for(Term term : keyword.getTerms()) {
			crud.save(term);
		}
		
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update(Keyword keyword) {

		Keyword entity = crud.read(Keyword.class, keyword.getId());
		
		for (Term term : keyword.getTerms()) {
			if (term.getId() != null)
				crud.update(term);
			else
				crud.save(term);
		}
		
		entity.setTerms(keyword.getTerms());

	}

}
