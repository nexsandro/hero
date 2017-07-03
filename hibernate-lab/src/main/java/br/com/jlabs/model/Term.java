/**
 * 
 */
package br.com.jlabs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author sandro
 *
 */
@Entity
@Table( name = "TB_MDIC_TERM" )
public class Term {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_MDIC_TERM")
	@SequenceGenerator(name = "SE_MDIC_TERM", sequenceName = "SE_MDIC_TERM", initialValue = 1, allocationSize = 1)
	@Column(name = "SQ_TERM", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "SQ_KEYW", referencedColumnName = "SQ_KEYW", nullable = false )
	private Keyword keyword;

	@Column( name = "TX_TEXT", nullable = true, length = 255 )
	private String text;
	
	@Version
	@Column(name = "NU_VERS", nullable = false)
	private Integer version;

	public Term() {
		
	}
	
	/**
	 * @param id
	 */
	public Term(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * @param keyword
	 * @param text
	 */
	public Term(Keyword keyword, String text) {
		super();
		this.keyword = keyword;
		this.text = text;
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
	 * @return the keyword
	 */
	public Keyword getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) return false;
//		if (!(obj instanceof Term)) return false;
//		
//		return getId() != null && getId().equals(((Term)obj).getId());
//	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nTerm [id=" + id + ", text=" + text + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (id == null || other.id == null)	return false;
		if (!id.equals(other.id))
			return false;
		return true;
	}

}
