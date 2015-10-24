package br.com.jlabs.business.uc_0101;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.model.User;

public interface CadastrarUserBusiness {

	User save(User user);

	List<User> list();

	User read(Serializable id);

	User create(User user);

	boolean lockVersioned(User user);

}