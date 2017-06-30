package br.com.jlabs;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.jlabs.business.uc_0102.CadastrarTagBusiness;
import br.com.jlabs.model.Tag;

public class H2Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("registry-h2.xml");

		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		
		// Save an existent user 
		Tag tag = new Tag();
		tag.setName("wildfly");
		
		CadastrarTagBusiness userBusiness = context.getBean(CadastrarTagBusiness.class);
		userBusiness.create(tag);
		
	}
}
