package com.safetys.framework.kernel.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.model.BaseModel;




public interface IBaseDao<Entity extends BaseModel, pk extends Serializable>
{

	/**
	 * 根据ID查找对象
	 * 
	 * @param id
	 * @return Entity
	 */
	public Entity findById(pk id) throws DaoException;


	/**
	 * 获取记录数
	 * 
	 * @param jpql
	 * @return {@link Integer}
	 */
	public int getCount(Entity model) throws DaoException;


	/**
	 * 获取记录数
	 * 
	 * @param jpql
	 * @param entity
	 * @return {@link Integer}
	 */
	public int getCount(String jpql, Entity entity) throws DaoException;


	/**
	 * 根据对象移出记录
	 * 
	 * @param Entity
	 */
	public void remove(Entity entity) throws DaoException;


	/**
	 * 根据id移出记录
	 * 
	 * @param id
	 */
	public void remove(pk id) throws DaoException;


	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @throws DaoException
	 */
	public void remove(String ids) throws DaoException;


	/**
	 * 批量删除
	 * 
	 * @param entitys
	 * @throws DaoException
	 */
	public void remove(List<Entity> entitys) throws DaoException;


	/**
	 * 保存对象
	 * 
	 * @param entity
	 * @return Entity
	 */
	public Entity save(Entity entity) throws DaoException;


	/**
	 * 批量添加或修改
	 * 
	 * @param entitys
	 * @throws DaoException
	 */
	public void save(List<Entity> entitys) throws DaoException;


	/**
	 * 根据原生态SQL语句和排序字段进行查询
	 * 
	 * @param SQL
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<?> getCollectionByNativeSql(String SQL) throws DaoException;


	/**
	 * 根据原生态SQL语句和排序字段进行查询
	 * 
	 * @param SQL
	 * @param attributes
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<?> getCollectionByNativeSql(String SQL, String[] attributes) throws DaoException;


	/**
	 * 根据原生态SQL语句和查询参数进行查询
	 * 
	 * @param SQL
	 * @param params
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<?> getCollectionByNativeSql(String SQL, Object[] params) throws DaoException;


	/**
	 * 根据原生态SQL语句、参数和排序字段进行查询
	 * 
	 * @param SQL
	 * @param params
	 * @param attributes
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<?> getCollectionByNativeSql(String SQL, Object[] params, String[] attributes) throws DaoException;


	/**
	 * 根据JPQL和分页标识进行查询
	 * 
	 * @param JPQL
	 * @param pageFlag
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<Entity> getCollection(String JPQL, boolean pageFlag) throws DaoException;


	/**
	 * 根据JPQL、实体对象和分页标识进行查询
	 * 
	 * @param JPQL
	 * @param entity
	 * @param pageFlag
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<Entity> getCollection(String JPQL, Entity entity) throws DaoException;


	/**
	 * 根据JPQL、实体对象和分页标识进行查询
	 * 
	 * @param JPQL
	 * @param entity
	 * @param pageFlag
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<Entity> getCollection(String JPQL, Entity entity, boolean pageFlag) throws DaoException;


	/**
	 * 根据JPQL、排序字段和分页标识进行查询
	 * 
	 * @param JPQL
	 * @param attributes
	 * @param pageFlag
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<Entity> getCollection(String JPQL, String[] attributes, boolean pageFlag) throws DaoException;


	/**
	 * 根据JPQL、实体对象、排序字段、分页标识进行查询
	 * 
	 * @param JPQL
	 * @param entity
	 * @param attributes
	 * @param pageFlag
	 * @return {@link List}
	 * @throws DaoException
	 */
	public List<Entity> getCollection(String JPQL, Entity entity, String[] attributes, boolean pageFlag) throws DaoException;


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
	public List<Entity> find(String jpql, Map<String, ?> parameters) throws DaoException;


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
	public List<Entity> find(String jpql, Object... values) throws DaoException;


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
	public Entity findUnique(String jpql, Object... values) throws DaoException;


	/**
	 * 获取所有实体集合
	 * 
	 * @return 集合
	 * @throws DaoException
	 */
	public List<Entity> findAll() throws DaoException;


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
	public List<Entity> find(String propertyName, Object value) throws DaoException;


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
	public Entity findUniqueProperty(String propertyName, Object value) throws DaoException;

}
