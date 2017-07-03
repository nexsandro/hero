/**
 * 
 */
package br.com.jlabs.business.uc_0101;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jlabs.RootConfig;
import br.com.jlabs.business.uc_0102.KeywordBusiness;
import br.com.jlabs.model.Keyword;
import br.com.jlabs.model.Term;

/**
 * @author sandro
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class KeywordBusinessTest {

	@Autowired
	KeywordBusiness keywordBusiness;
	
	@Autowired
	private DataSource orDataSource;
	
	@Test
	public void testSaveKeyword() throws Exception {

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
		
		assertData(3);
	
	}

	private void assertData(int expected) throws Exception {
		Connection connection = orDataSource.getConnection();
		PreparedStatement pst = connection.prepareStatement("select count(*) from TB_MDIC_TERM");
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			Assert.assertEquals(expected, rs.getInt(1));
		}
		rs.close();
		pst.close();
		connection.close();
	}
}
