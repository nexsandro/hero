package br.com.jlabs.business.uc_0101;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jlabs.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:registry.xml")
public class CadastrarUserBusinessTest {

	@Autowired
	private CadastrarUserBusiness cadastrarUserBusiness;

	@Test
	public void testConcurrency3() {
		User user1 = new User("first3", "First Name3");
		User user2 = new User("first3", "First Name3");
		
		cadastrarUserBusiness.lockVersioned(user1);
		Assert.assertFalse(cadastrarUserBusiness.lockVersioned(user2));
	}
	
}
