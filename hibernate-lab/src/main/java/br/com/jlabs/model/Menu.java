/**
 * 
 */
package br.com.jlabs.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sandro
 *
 */
@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@Column(name = "cd_menu", nullable = false)
	private Integer id;
	
	@Column(name = "no_menu", nullable = false)
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "cd_prnt", referencedColumnName = "cd_menu")
	private Menu parent;
	
	@OneToMany(mappedBy = "parent")
	private Set<Menu> children;

	@ManyToMany(targetEntity = Role.class)
	@JoinTable(
			name = "menu_role",
			joinColumns = @JoinColumn(name = "cx_menu", referencedColumnName = "cd_menu"),
			inverseJoinColumns = @JoinColumn(name = "cx_role", referencedColumnName = "cd_role"))
	private Set<Role> roles;
	
	/**
	 * 
	 */
	public Menu() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the parent
	 */
	public Menu getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Menu parent) {
		this.parent = parent;
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}
	
	
}
