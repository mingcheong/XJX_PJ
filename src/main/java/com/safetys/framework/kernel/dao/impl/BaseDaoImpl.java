package com.safetys.framework.kernel.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
@SuppressWarnings("unchecked")
public class BaseDaoImpl<Entity extends BaseModel, PK extends Serializable> implements IBaseDao<Entity, PK>
{

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
	public BaseDaoImpl()
	{

	}


	/**
	 * 构造器（将实体类和类名注入进来）
	 * 
	 * @param prototype
	 * @param entityName
	 */
	public BaseDaoImpl(Class<Entity> prototype, String entityName)
	{
		this.prototype = prototype;
		this.entityName = entityName;
	}


	public Entity findById(PK id) throws DaoException
	{
		Entity entity = null;
		entity = entityManager.find(this.prototype, id);
		closeSession(entityManager);
		return entity;
	}


	@SuppressWarnings("rawtypes")
	public int getCount(String jpql, Entity entity) throws DaoException
	{
		if (jpql == null || jpql.length() <= 0)
		{
			jpql = "select count(o) from " + this.entityName + " o";
		}
		else
		{
			if (jpql.indexOf("count") < 0)
			{
				jpql = "select count(o) " + jpql.substring(jpql.indexOf("o") + 1, jpql.length());
			}
		}
		final Map map = JPAHelper.buildReflectJpql(jpql, entity);
		final Object[] params = JPAHelper.getParams(map);
		String JPQL = JPAHelper.getJpql(map);
		JPQL = JPQL.substring(0, JPQL.lastIndexOf("order"));
		final Query query = entityManager.createQuery(JPQL);
		if ((null != params) && (params.length > 0))
		{
			for (int i = 0; i < params.length; i++)
			{
				query.setParameter(i + 1, params[i]);
			}
		}
		int count = Integer.parseInt(query.getSingleResult().toString());
		closeSession(entityManager);
		return count;
	}


	@SuppressWarnings("rawtypes")
	public int getCount(Entity entity) throws DaoException
	{
		String jpql = "select count(o) from " + this.entityName + " o";
		if (!JPAHelper.validJpql(jpql)) { throw new DaoException("JPQL语句不合法,请核实!"); }
		int count = 0;
		if (entity != null && !entity.equals(null))
		{
			final Map map = JPAHelper.buildReflectJpql(jpql, entity);
			final Object[] params = JPAHelper.getParams(map);
			String JPQL = JPAHelper.getJpql(map);
			JPQL = JPQL.substring(0, JPQL.lastIndexOf("order"));
			final Query query = entityManager.createQuery(JPQL);
			if ((null != params) && (params.length > 0))
			{
				for (int i = 0; i < params.length; i++)
				{
					query.setParameter(i + 1, params[i]);
				}
			}
			count = Integer.parseInt(query.getSingleResult().toString());
		}
		else
		{
			count = Integer.parseInt(entityManager.createQuery(jpql).getSingleResult().toString());
		}
		closeSession(entityManager);
		return count;
	}


	public void remove(Entity entity) throws DaoException
	{
		entityManager.remove(entity);
		entityManager.flush();
		entityManager.clear();
		closeSession(entityManager);
	}


	public void remove(PK id) throws DaoException
	{
		Entity entity = entityManager.find(this.prototype, id);
		entityManager.remove(entity);
		entityManager.flush();
		entityManager.clear();
		closeSession(entityManager);
	}


	public void remove(List<Entity> entitys) throws DaoException
	{
		for (Entity entity : entitys)
		{
			if (entity != null)
				entity.setDeleted(true);
			entityManager.merge(entity);
			entityManager.flush();
			entityManager.clear();
		}
		closeSession(entityManager);
	}


	public void remove(String ids) throws DaoException
	{
		String hql = "select o from " + this.entityName + " o where o.id in(" + ids + ")";
		List<Entity> entitys = entityManager.createQuery(hql).getResultList();
		remove(entitys);
	}


	public Entity save(Entity entity) throws DaoException
	{
		if (entity.getId() > 0)
		{
			entityManager.merge(entity);
		}
		else
		{
			entityManager.persist(entity);
		}
		entityManager.flush();
		entityManager.clear();
		closeSession(entityManager);
		return entity;
	}


	public void save(List<Entity> entitys) throws DaoException
	{
		for (Entity entity : entitys)
		{
			if (entity.getId() > 0)
			{
				entityManager.merge(entity);
			}
			else
			{
				entityManager.persist(entity);
			}
			entityManager.flush();
			entityManager.clear();
		}
		closeSession(entityManager);
	}


	public List<Entity> getCollection(String JPQL, boolean pageFlag) throws DaoException
	{
		return getCollection(JPQL, null, null, pageFlag);
	}


	public List<Entity> getCollection(String JPQL, Entity entity) throws DaoException
	{
		return getCollection(JPQL, entity, true);
	}


	public List<Entity> getCollection(String JPQL, Entity entity, boolean pageFlag) throws DaoException
	{
		return getCollection(JPQL, entity, null, pageFlag);
	}


	public List<Entity> getCollection(String JPQL, String[] attributes, boolean pageFlag) throws DaoException
	{
		return getCollection(JPQL, null, attributes, pageFlag);
	}


	public List<Entity> getCollection(String JPQL, Entity entity, String[] attributes, boolean pageFlag) throws DaoException
	{
		if (JPQL == null || JPQL.length() <= 0)
		{
			JPQL = "select o from " + this.entityName + " o";
		}
		if (!JPAHelper.validJpql(JPQL)) { throw new DaoException("JPQL语句不合法,请核实!"); }
		Object[] params = null;
		if (entity != null)
		{
			if (pageFlag && entity.getTotalRows() < 0)
			{
				int totalRows = this.getCount(JPQL, entity);
				entity.setTotalRows(totalRows);
			}
			final Map<String, Object> map = JPAHelper.buildReflectJpql(JPQL, entity);
			JPQL = JPAHelper.getJpql(map);
			params = JPAHelper.getParams(map);
		}
		if (attributes != null && attributes.length > 0)
		{
			StringBuilder builder = new StringBuilder();
			builder.append(" order by");
			for (String attribute : attributes)
			{
				builder.append(" o.").append(attribute).append(" ,");
			}
			String orderString = builder.substring(0, builder.lastIndexOf(",")) + " asc";
			if (JPQL.lastIndexOf("order") <= 0)
			{
				JPQL += orderString;
			}
			else
			{
				JPQL = JPQL.substring(0, JPQL.lastIndexOf("order")) + orderString;
			}
		}
		final Query query = entityManager.createQuery(JPQL);
		if (null != params && params.length > 0)
		{
			for (int i = 0; i < params.length; i++)
			{
				query.setParameter(i + 1, params[i]);
			}
		}
		List<Entity> entities = new ArrayList<Entity>();
		if (pageFlag)
		{
			entities = query.setFirstResult(entity.getEndSize()).setMaxResults(entity.getPageSize()).getResultList();
		}
		else
		{
			entities = query.getResultList();
		}
		closeSession(entityManager);
		return entities;
	}


	public List<?> getCollectionByNativeSql(String SQL) throws DaoException
	{
		return getCollectionByNativeSql(SQL, null);
	}


	public List<?> getCollectionByNativeSql(String SQL, String[] attributes) throws DaoException
	{
		return getCollectionByNativeSql(SQL, null, attributes);
	}


	public List<?> getCollectionByNativeSql(String SQL, Object[] params) throws DaoException
	{
		return getCollectionByNativeSql(SQL, params, null);
	}


	public List<?> getCollectionByNativeSql(String SQL, Object[] params, String[] attributes) throws DaoException
	{
		if (attributes != null && attributes.length > 0)
		{
			StringBuilder builder = new StringBuilder();
			builder.append(" order by");
			for (String attribute : attributes)
			{
				builder.append(attribute).append(" ,");
			}
			String orderString = builder.substring(0, builder.lastIndexOf(",")) + " asc";
			SQL = SQL.substring(0, SQL.lastIndexOf("order")) + orderString;
		}
		final Query query = entityManager.createNativeQuery(SQL);
		if (null != params && params.length > 0)
		{
			for (int i = 0; i < params.length; i++)
			{
				query.setParameter(i + 1, params[i]);
			}
		}
		List<?> datas = query.getResultList();
		closeSession(entityManager);
		return datas;
	}


	public static void closeSession(EntityManager entityManager)
	{
		if (entityManager != null)
		{
			entityManager.close();
		}
	}


	public EntityManager getEntityManager()
	{
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}


	/**
	 * 查询指定jpql，并返回集合
	 * 
	 * @param jpql
	 *            jpql语句
	 * @param parameters
	 *            参数集合
	 * @return 集合
	 * @throws DaoException
	 */
	public List<Entity> find(String jpql, Map<String, ?> parameters) throws DaoException
	{
		TypedQuery<Entity> query = entityManager.createQuery(jpql, this.prototype);
		for (Parameter<?> sqlParam : query.getParameters())
		{
			query.setParameter(sqlParam.getName(), parameters.get(sqlParam.getName()));
		}
		return query.getResultList();
	}


	/**
	 * 查询指定jpql，并返回集合
	 * 
	 * @param jpql
	 *            jpql语句
	 * @param values
	 *            可变的参数列表
	 * @return 集合
	 * @throws DaoException
	 */
	public List<Entity> find(String jpql, Object... values) throws DaoException
	{
		Query query = entityManager.createQuery(jpql);
		setQueryParams(query, values);
		return query.getResultList();
	}


	/**
	 * 按照jpql语句查询唯一对象.
	 * 
	 * @param jpql
	 *            jpql语句
	 * @param values
	 *            可变参数集合
	 * @return OBJECT对象
	 * @throws DaoException
	 */
	public Entity findUnique(String jpql, Object... values) throws DaoException
	{
		Query query = entityManager.createQuery(jpql, this.prototype);
		setQueryParams(query, values);
		query.setMaxResults(1);
		return (Entity) query.getSingleResult();
	}


	/**
	 * 获取所有实体集合
	 * 
	 * @return 集合
	 * @throws DaoException
	 */
	public List<Entity> findAll() throws DaoException
	{
		String jpql = "SELECT o FROM " + this.entityName + " AS o";
		TypedQuery<Entity> query = entityManager.createQuery(jpql, this.prototype);
		return query.getResultList();
	}


	/**
	 * 查找指定属性的实体集合
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体集合
	 * @throws DaoException
	 */
	public List<Entity> find(String propertyName, Object value) throws DaoException
	{
		String jpql = "from " + this.entityName + " as a where a." + propertyName + "=?";
		return find(jpql, value);
	}


	/**
	 * 查找指定属性的实体集合
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体
	 * @throws DaoException
	 */
	public Entity findUniqueProperty(String propertyName, Object value) throws DaoException
	{
		String jpql = "from " + this.entityName + " as a where a." + propertyName + "=?";
		return findUnique(jpql, value);
	}


	protected void setQueryParams(Query query, Object... values)
	{
		if (values != null && values.length > 0)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i + 1, values[i]);
			}
		}
	}
}
