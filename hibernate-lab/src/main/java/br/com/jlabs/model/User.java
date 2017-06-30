package br.com.jlabs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLockType;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "tb_user")
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.VERSION)
public class User implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3179035320352509958L;

	@Id
	@Column(name = "cd_user")
	private String id;

	@Column(name = "no_user")
	private String name;

	@Version
	@Column(name = "nu_vers")
	private Integer version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sq_mngr", nullable = true)
	private User manager;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",
	    joinColumns=@JoinColumn(name = "cd_user", referencedColumnName = "cd_user"),
	    inverseJoinColumns=@JoinColumn(name = "cd_role", referencedColumnName = "cd_role"))
	private Set<Role> roles;
	
	public User() {
		super();
		this.version = 1;
	}
	
	/**
	 * @param id
	 */
	public User(String id) {
		super();
		this.id = id;
	}

	public User(String id, String name) {
		this();
		this.id = id;
		this.name = name;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the manager
	 */
	public User getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
	 * 
	 * @param role
	 */
	public void addRole(Role role) {
		if (roles == null) {
			roles = new HashSet<Role>();
		}
		
		roles.add(role);
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
		User other = (User) obj;
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
		return "User [id=" + id + ", name=" + name + ", version=" + version + ", manager=" + manager + ", roles="
				+ roles + "]";
	}

}
