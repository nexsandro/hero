package br.com.jlabs;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.jlabs.business.uc_0101.CadastrarUserBusiness;
import br.com.jlabs.model.User;

public class HibernateTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("registry.xml");

		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		
		// Save an existent user 
		User user = new User();
		user.setId("1414");
		user.setName("João do Caminhão");
		
		CadastrarUserBusiness userBusiness = context.getBean(CadastrarUserBusiness.class);
		userBusiness.save(user);
		
		user = new User();
		user.setId("1414");
		user.setName("Other name");
		
		userBusiness.save(user);
		
	}
}
