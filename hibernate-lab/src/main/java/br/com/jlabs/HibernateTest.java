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
		KeywordBusiness keywordBusiness = context.getBean(KeywordBusiness.class);
		
		try {
			
			Keyword keyw = new Keyword("terms.term1", "Description 1", 1, null);
			
			String[] translations = new String[] {"Tradução", "Translation", "Traducción"};
			for(String translation : translations) {
				keyw.addTerm(new Term(keyw, translation));
			}

			System.out.println("--------------------------------------- saving ---------------------------------------");
			keywordBusiness.save(keyw);
			
			Term itemToRemove = keyw.getTerms().iterator().next();
			keyw.getTerms().remove(itemToRemove);
			keyw.getTerms().add(new Term(keyw, "Tracductcion Errada"));
			System.out.println("--------------------------------------- updating ---------------------------------------");
			keyw.setDescription("Description 2");
			keywordBusiness.update(keyw);
			
			System.out.println("Keyword at end: " + keyw.getTerms());
			
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
