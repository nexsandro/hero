package br.com.jlabs.business.uc_0102;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.model.Tag;

public interface CadastrarTagBusiness {

	void create(Tag tag);

}