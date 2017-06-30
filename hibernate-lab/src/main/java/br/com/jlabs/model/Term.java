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
	public Integer id;
	
	@ManyToOne
	@JoinColumn( name = "SQ_KEYW", referencedColumnName = "SQ_KEYW" )
	public Keyword keyword;

	@Column( name = "tx_text", nullable = true, length = 255 )
	public String text;

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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Term)) return false;
		
		return getId() != null && getId().equals(((Term)obj).getId());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Term [id=" + id + ", keyword=" + keyword + ", text=" + text + "]";
	}

}
