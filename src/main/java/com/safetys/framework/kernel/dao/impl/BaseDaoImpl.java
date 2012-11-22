package com.safetys.framework.kernel.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.dao.IBaseDao;
import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.utils.JPAHelper;

/**
 * 持久层基础实现器
 * 
 * @author Stone
 * @param <Entity>
 *            实体对象
 * @param <PK>
 *            主键
 */
public class BaseDaoImpl<Entity extends BaseModel, PK extends Serializable> implements IBaseDao<Entity, PK> {

	/**
	 * 实体管理
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	/**
	 * 实体对象
	 */
	private Class<Entity> prototype;
	/**
	 * 实体名称
	 */
	private String entityName;

	/**
	 * 默认构造器
	 */
	public BaseDaoImpl() {

	}

	/**
	 * 构造器（将实体类和类名注入进来）
	 * 
	 * @param prototype
	 * @param entityName
	 */
	public BaseDaoImpl(Class<Entity> prototype, String entityName) {
		this.prototype = prototype;
		this.entityName = entityName;
	}

	public Entity findById(PK id) throws DaoException {
		Entity entity = null;
		entity = entityManager.find(this.prototype, id);
		closeSession(entityManager);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public int getCount(String jpql, Entity entity) throws DaoException {
		if (jpql == null || jpql.length() <= 0) {
			jpql = "select count(o) from " + this.entityName + " o";
		} else {
			if (jpql.indexOf("count") < 0) {
				jpql = "select count(o) " + jpql.substring(jpql.indexOf("o") + 1, jpql.length());
			}
		}
		final Map map = JPAHelper.buildReflectJpql(jpql, entity);
		final Object[] params = JPAHelper.getParams(map);
		String JPQL = JPAHelper.getJpql(map);
		JPQL = JPQL.substring(0, JPQL.lastIndexOf("order"));
		final Query query = entityManager.createQuery(JPQL);
		if ((null != params) && (params.length > 0)) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		int count = Integer.parseInt(query.getSingleResult().toString());
		closeSession(entityManager);
		return count;
	}

	@SuppressWarnings("rawtypes")
	public int getCount(Entity entity) throws DaoException {
		String jpql = "select count(o) from " + this.entityName + " o";
		if (!JPAHelper.validJpql(jpql)) { throw new DaoException("JPQL语句不合法,请核实!"); }
		int count = 0;
		if (entity != null && !entity.equals(null)) {
			final Map map = JPAHelper.buildReflectJpql(jpql, entity);
			final Object[] params = JPAHelper.getParams(map);
			String JPQL = JPAHelper.getJpql(map);
			JPQL = JPQL.substring(0, JPQL.lastIndexOf("order"));
			final Query query = entityManager.createQuery(JPQL);
			if ((null != params) && (params.length > 0)) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i + 1, params[i]);
				}
			}
			count = Integer.parseInt(query.getSingleResult().toString());
		} else {
			count = Integer.parseInt(entityManager.createQuery(jpql).getSingleResult().toString());
		}
		closeSession(entityManager);
		return count;
	}

	public void remove(Entity entity) throws DaoException {
		entityManager.remove(entity);
		entityManager.flush();
		entityManager.clear();
		closeSession(entityManager);
	}

	public void remove(PK id) throws DaoException {
		Entity entity = entityManager.find(this.prototype, id);
		entityManager.remove(entity);
		entityManager.flush();
		entityManager.clear();
		closeSession(entityManager);
	}

	public void remove(List<Entity> entitys) throws DaoException {
		for (Entity entity : entitys) {
			if (entity != null) entity.setDeleted(true);
			entityManager.merge(entity);
			entityManager.flush();
			entityManager.clear();
		}
		closeSession(entityManager);
	}

	@SuppressWarnings("unchecked")
	public void remove(String ids) throws DaoException {
		String hql = "select o from " + this.entityName + " o where o.id in(" + ids + ")";
		List<Entity> entitys = entityManager.createQuery(hql).getResultList();
		remove(entitys);
	}

	public Entity save(Entity entity) throws DaoException {
		if (entity.getId() > 0) {
			entityManager.merge(entity);
		} else {
			entityManager.persist(entity);
		}
		entityManager.flush();
		entityManager.clear();
		closeSession(entityManager);
		return entity;
	}

	public void save(List<Entity> entitys) throws DaoException {
		for (Entity entity : entitys) {
			if (entity.getId() > 0) {
				entityManager.merge(entity);
			} else {
				entityManager.persist(entity);
			}
			entityManager.flush();
			entityManager.clear();
		}
		closeSession(entityManager);
	}

	public List<Entity> getCollection(String JPQL, boolean pageFlag) throws DaoException {
		return getCollection(JPQL, null, null, pageFlag);
	}

	public List<Entity> getCollection(String JPQL, Entity entity) throws DaoException {
		return getCollection(JPQL, entity,true);
	}
	
	public List<Entity> getCollection(String JPQL, Entity entity, boolean pageFlag) throws DaoException {
		return getCollection(JPQL, entity, null, pageFlag);
	}

	public List<Entity> getCollection(String JPQL, String[] attributes, boolean pageFlag) throws DaoException {
		return getCollection(JPQL, null, attributes, pageFlag);
	}

	@SuppressWarnings("unchecked")
	public List<Entity> getCollection(String JPQL, Entity entity, String[] attributes, boolean pageFlag) throws DaoException {
		if (JPQL == null || JPQL.length() <= 0) {
			JPQL = "select o from " + this.entityName + " o";
		}
		if (!JPAHelper.validJpql(JPQL)) { throw new DaoException("JPQL语句不合法,请核实!"); }
		Object[] params = null;
		if (entity != null) {
			if (pageFlag && entity.getTotalRows() < 0) {
				int totalRows = this.getCount(JPQL, entity);
				entity.setTotalRows(totalRows);
			}
			final Map<String, Object> map = JPAHelper.buildReflectJpql(JPQL, entity);
			JPQL = JPAHelper.getJpql(map);
			params = JPAHelper.getParams(map);
		}
		if (attributes != null && attributes.length > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append(" order by");
			for (String attribute : attributes) {
				builder.append(" o.").append(attribute).append(" ,");
			}
			String orderString = builder.substring(0, builder.lastIndexOf(",")) + " asc";
			if (JPQL.lastIndexOf("order") <= 0) {
				JPQL += orderString;
			} else {
				JPQL = JPQL.substring(0, JPQL.lastIndexOf("order")) + orderString;
			}
		}
		final Query query = entityManager.createQuery(JPQL);
		if (null != params && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		List<Entity> entities = new ArrayList<Entity>();
		if (pageFlag) {
			entities = query.setFirstResult(entity.getEndSize()).setMaxResults(entity.getPageSize()).getResultList();
		} else {
			entities = query.getResultList();
		}
		closeSession(entityManager);
		return entities;
	}

	public List<?> getCollectionByNativeSql(String SQL) throws DaoException {
		return getCollectionByNativeSql(SQL, null);
	}
	
	public List<?> getCollectionByNativeSql(String SQL, String[] attributes) throws DaoException {
		return getCollectionByNativeSql(SQL, null, attributes);
	}

	public List<?> getCollectionByNativeSql(String SQL, Object[] params) throws DaoException {
		return getCollectionByNativeSql(SQL, params, null);
	}

	public List<?> getCollectionByNativeSql(String SQL, Object[] params, String[] attributes) throws DaoException {
		if (attributes != null && attributes.length > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append(" order by");
			for (String attribute : attributes) {
				builder.append(attribute).append(" ,");
			}
			String orderString = builder.substring(0, builder.lastIndexOf(",")) + " asc";
			SQL = SQL.substring(0, SQL.lastIndexOf("order")) + orderString;
		}
		final Query query = entityManager.createNativeQuery(SQL);
		if (null != params && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		List<?> datas = query.getResultList();
		closeSession(entityManager);
		return datas;
	}

	public static void closeSession(EntityManager entityManager) {
		if (entityManager != null) {
			entityManager.close();
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
