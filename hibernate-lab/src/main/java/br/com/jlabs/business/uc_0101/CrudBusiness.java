package br.com.jlabs.business.uc_0101;

import java.io.Serializable;

public interface CrudBusiness {

	void save(Object entity);

	<T> T read(Class<T> clazz, Serializable id);

	void update(Object entity);

	void delete(Object entity);

	void evict(Object entity);

	void merge(Object entity);

}