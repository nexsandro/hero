/**
 * 
 */
package br.com.jlabs;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

/**
 * @author sandro
 *
 */
public class EventInterceptor implements Interceptor {

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#afterTransactionBegin(org.hibernate.Transaction)
	 */
	public void afterTransactionBegin(Transaction arg0) {
		System.out.println("afterTransactionBegin");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#afterTransactionCompletion(org.hibernate.Transaction)
	 */
	public void afterTransactionCompletion(Transaction arg0) {
		System.out.println("afterTransactionCompletion");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#beforeTransactionCompletion(org.hibernate.Transaction)
	 */
	public void beforeTransactionCompletion(Transaction arg0) {
		System.out.println("beforeTransactionCompletion");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#findDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	public int[] findDirty(Object arg0, Serializable arg1, Object[] arg2, Object[] arg3, String[] arg4, Type[] arg5) {
		System.out.println("findDirty");
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#getEntity(java.lang.String, java.io.Serializable)
	 */
	public Object getEntity(String arg0, Serializable arg1) throws CallbackException {
		System.out.println("getEntity");
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#getEntityName(java.lang.Object)
	 */
	public String getEntityName(Object arg0) throws CallbackException {
		System.out.println("getEntityName");
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#instantiate(java.lang.String, org.hibernate.EntityMode, java.io.Serializable)
	 */
	public Object instantiate(String arg0, EntityMode arg1, Serializable arg2) throws CallbackException {
		System.out.println("instantiate");
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#isTransient(java.lang.Object)
	 */
	public Boolean isTransient(Object arg0) {
		System.out.println("isTransient");
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onCollectionRecreate(java.lang.Object, java.io.Serializable)
	 */
	public void onCollectionRecreate(Object arg0, Serializable arg1) throws CallbackException {
		System.out.println("onCollectionRecreate: " + arg0);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onCollectionRemove(java.lang.Object, java.io.Serializable)
	 */
	public void onCollectionRemove(Object arg0, Serializable arg1) throws CallbackException {
		System.out.println("onCollectionRemove");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onCollectionUpdate(java.lang.Object, java.io.Serializable)
	 */
	public void onCollectionUpdate(Object arg0, Serializable arg1) throws CallbackException {
		System.out.println("onCollectionUpdate");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onDelete(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	public void onDelete(Object arg0, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		System.out.println("onDelete");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onFlushDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	public boolean onFlushDirty(Object arg0, Serializable arg1, Object[] arg2, Object[] arg3, String[] arg4,
			Type[] arg5) throws CallbackException {
		System.out.println("onFlushDirty: " + arg0);
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onLoad(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	public boolean onLoad(Object arg0, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		System.out.println("onLoad");
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onPrepareStatement(java.lang.String)
	 */
	public String onPrepareStatement(String original) {
		System.out.println("onPrepareStatement");
		return original;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#onSave(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	public boolean onSave(Object arg0, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		System.out.println("onSave: " + arg0);
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#postFlush(java.util.Iterator)
	 */
	public void postFlush(Iterator arg0) throws CallbackException {
		System.out.println("postFlush");
	}

	/* (non-Javadoc)
	 * @see org.hibernate.Interceptor#preFlush(java.util.Iterator)
	 */
	public void preFlush(Iterator arg0) throws CallbackException {
		System.out.println("preFlush");
	}

}
