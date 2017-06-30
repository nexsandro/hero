package br.com.jlabs;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.jlabs.business.uc_0101.CadastrarUserBusiness;
import br.com.jlabs.business.uc_0102.KeywordBusiness;
import br.com.jlabs.model.Keyword;
import br.com.jlabs.model.Role;
import br.com.jlabs.model.Term;
import br.com.jlabs.model.User;

public class HibernateTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		test2(context);
		
	}

	private static void test1(AnnotationConfigApplicationContext context) {
		CadastrarUserBusiness userBusiness = context.getBean(CadastrarUserBusiness.class);

		System.out.println("---------------------- Entity 1 ----------------------");
		User user = new User();
		user.setId("1416");
		user.setName("Manager");
		user.addRole(new Role("Engineer"));
		userBusiness.save(user);
		
		System.out.println("---------------------- Entity 2 ----------------------");
		user.setName("Nome alterado");
		userBusiness.save(user);
	}

	
	private static void test2(AnnotationConfigApplicationContext context) {
		KeywordBusiness crud = context.getBean(KeywordBusiness.class);
		
		try {
			
			Keyword keyw = new Keyword("terms.term1", null, 1, null);
			
			String[] translations = new String[] {"Tradução", "Translation", "Traducción"};
			for(String translation : translations) {
				keyw.addTerm(new Term(keyw, translation));
			}

			crud.save(keyw);
			
			keyw.getTerms().remove(keyw.getTerms().iterator().next());
			keyw.getTerms().add(new Term(keyw, "New Term"));
			crud.update(keyw);
			
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
