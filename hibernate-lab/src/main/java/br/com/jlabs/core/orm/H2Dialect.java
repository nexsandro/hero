package br.com.jlabs.core.orm;

public class H2Dialect extends org.hibernate.dialect.H2Dialect {

	/**
	 * Force use of sequences over identity (default).
	 */
	@Override
	public boolean supportsIdentityColumns() {
		
		return false;
		
	}
}
