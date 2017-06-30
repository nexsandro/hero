/**
 * 
 */
package br.com.jlabs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author sandro
 *
 */
@Entity
@Table( name = "TB_MDIC_KEYW" )
public class Keyword {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_MDIC_KEYW")
	@SequenceGenerator(name = "SE_MDIC_KEYW", sequenceName = "SE_MDIC_KEYW", initialValue = 1, allocationSize = 1)
	@Column( name = "SQ_KEYW", nullable = false )
	private Integer id;
	
	@Column(name = "CD_KEY", nullable = false, length = 255)
	private String key;
	
	@Column(name = "TX_DESC", length = 255)
	private String description;
	
	@Version
	@Column(name = "NU_VERS", nullable = false)
	private Integer version;

	@OneToMany(mappedBy = "keyword")
	private Set<Term> terms;
	
	public Keyword() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param key
	 * @param description
	 * @param version
	 * @param terms
	 */
	public Keyword(String key, String description, Integer version, Set<Term> terms) {
		super();
		this.key = key;
		this.description = description;
		this.version = version;
		this.terms = terms;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the terms
	 */
	public Set<Term> getTerms() {
		if (terms == null) {
			terms = new HashSet<Term>();
		}
		return terms;
	}

	/**
	 * @param terms the terms to set
	 */
	public void setTerms(Set<Term> terms) {
		this.terms = terms;
	}

	public void addTerm(Term term) {
		getTerms().add(term);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Keyword [id=" + id + ", key=" + key + ", description=" + description + ", version=" + version + "]";
	}
	
}
