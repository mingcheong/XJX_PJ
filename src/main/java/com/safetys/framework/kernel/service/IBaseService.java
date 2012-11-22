package com.safetys.framework.kernel.service;

import java.io.Serializable;
import java.util.List;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.utils.OperateResult;

/**
 * 基础数据层接口
 * 
 * @author Stone
 * @param <Entity>
 * @param <PK>
 */
public interface IBaseService<Entity extends BaseModel, PK extends Serializable> {

	/**
	 * 根据ID查找对象
	 * 
	 * @param id
	 * @return Entity
	 */
	public Entity findById(PK id) throws ServicesException;

	/**
	 * 根据对象移出记录
	 * 
	 * @param Entity
	 */
	public OperateResult remove(Entity entity) throws ServicesException;

	/**
	 * 根据id移出记录
	 * 
	 * @param id
	 */
	public OperateResult remove(PK id) throws ServicesException;

	/**
	 * 批量删除（避免内存溢出异常(OutOfMemoryException))
	 * 
	 * @param ids
	 * @return {@link OperateResult}
	 * @throws ServicesException
	 */
	public OperateResult remove(String ids) throws ServicesException;

	/**
	 * 批量删除（避免内存溢出异常(OutOfMemoryException))
	 * 
	 * @param entitys
	 * @return {@link OperateResult}
	 * @throws ServicesException
	 */
	public OperateResult remove(List<Entity> entitys) throws ServicesException;

	/**
	 * 保存对象
	 * 
	 * @param entity 实体对象
	 * @return Entity 实体对象
	 */
	public OperateResult save(Entity entity) throws ServicesException;

	/**
	 * 批量添加或修改（避免内存溢出异常(OutOfMemoryException))
	 * 
	 * @param entitys 实体对象
	 * @return OperateResult 操作结果
	 * @throws DaoException
	 */
	public OperateResult save(List<Entity> entitys) throws ServicesException;

	/**
	 * 根据原生态SQL取数据
	 * 
	 * @param SQL
	 *            native sql query
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCollectionByNativeSql(String SQL) throws ServicesException;

	/**
	 * 根据原生态SQL取数据
	 * 
	 * @param SQL
	 *            native sql query
	 * @param params
	 *            查询参数
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCollectionByNativeSql(String SQL, Object[] params) throws ServicesException;

	/**
	 * 根据原生态SQL取数据
	 * 
	 * @param SQL native sql query
	 * @param params 查询参数
	 * @param attributes 排序关键字
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCollectionByNativeSql(String SQL, Object[] params, String[] attributes) throws ServicesException;

	/**
	 * 根据实体取数据结果集
	 * 
	 * @param model
	 *            实体对象
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(Entity model) throws ServicesException;

	/**
	 * 根据JPQL语句查询数据结果集
	 * 
	 * @param JPQL
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL) throws ServicesException;

	/**
	 * 根据实体取数据结果集
	 * 
	 * @param model
	 *            实体对象
	 * @param pageFlag
	 *            分页
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(Entity model, boolean pageFlag) throws ServicesException;

	/**
	 * 根据JPQL语句查询数据结果集
	 * 
	 * @param JPQL
	 * @param pageFlag
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL, boolean pageFlag) throws ServicesException;

	/**
	 * 根据实体取数据结果集并按指定的属性排序
	 * 
	 * @param model
	 *            实体对象
	 * @param attributes
	 *            排序属性
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(Entity model, String[] attributes) throws ServicesException;

	/**
	 * 根据JPQL语句查询数据结果集
	 * 
	 * @param JPQL
	 * @param attributes
	 * @param pageFlag
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL, String[] attributes, boolean pageFlag) throws ServicesException;

	/**
	 * 根据实体取数据结果集并按指定的属性排序
	 * 
	 * @param model
	 *            实体对象
	 * @param attributes
	 *            排序属性
	 * @param pageFlag
	 *            分页标识
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(Entity model, String[] attributes, boolean pageFlag) throws ServicesException;

	/**
	 * 根据JPQL取数据结果集
	 * 
	 * @param JPQL
	 *            JPA查询语句
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL, Entity model) throws ServicesException;

	/**
	 * 根据JPQL取数据结果集
	 * 
	 * @param JPQL
	 *            JPA查询语句
	 * @param pageFlag
	 *            （分页标识）
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL, Entity model, boolean pageFlag) throws ServicesException;

	/**
	 * 根据JPQL取数据结果集并以相关排序字段排序
	 * 
	 * @param JPQL
	 *            JPA查询语句
	 * @param attributes
	 *            排序字段
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL, Entity model, String[] attributes) throws ServicesException;

	/**
	 * 根据JPQL、查询参数取数据结果集并以相关排序字段排序
	 * 
	 * @param JPQL
	 *            JPA查询语句
	 * @param params
	 *            查询参数
	 * @param attributes
	 *            排序字段
	 * @param pageFlag
	 *            （分页标识）
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<Entity> getCollection(String JPQL, Entity model, String[] attributes, boolean pageFlag) throws ServicesException;

}
