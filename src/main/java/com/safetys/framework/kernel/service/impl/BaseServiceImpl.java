package com.safetys.framework.kernel.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.kernel.dao.IBaseDao;
import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.utils.OperateResult;

/**
 * 基础服务层实现方法
 * 
 * @author Stone
 * @param <Entity>
 * @param <pk>
 */
@Transactional(propagation = Propagation.REQUIRED)
public class BaseServiceImpl<Entity extends BaseModel, pk extends Serializable> implements IBaseService<Entity, pk> {

	protected static final String NODES = "nodes";
	protected static final String NODE = "node";
	protected static final String ID = "id";
	protected static final String NAME = "name";
	Logger logger = Logger.getLogger(this.getClass());

	protected final IBaseDao<Entity, pk> baseDao;

	public BaseServiceImpl(IBaseDao<Entity, pk> baseDao) {
		this.baseDao = baseDao;
	}

	public Entity findById(pk id) throws ServicesException {
		Entity entity = null;
		try {
			entity = baseDao.findById(id);
		} catch (DaoException e) {
			throw new ServicesException("查询失败：", e);
		}
		return entity;
	}

	public OperateResult remove(Entity entity) throws ServicesException {
		OperateResult or = new OperateResult();
		try {
			baseDao.remove(entity);
			or.setMessage("删除成功！");
			or.setState(true);
		} catch (DaoException e) {
			or.setMessage("删除失败！");
			or.setState(false);
			throw new ServicesException("删除失败：", e);
		}
		return or;
	}

	public OperateResult remove(pk id) throws ServicesException {
		OperateResult or = new OperateResult();
		try {
			baseDao.remove(id);
			or.setMessage("删除成功！");
			or.setState(true);
		} catch (DaoException e) {
			or.setMessage("删除失败！");
			or.setState(false);
			throw new ServicesException("删除失败：", e);
		}
		return or;
	}

	public OperateResult remove(List<Entity> entitys) throws ServicesException {
		OperateResult or = new OperateResult();
		try {
			baseDao.remove(entitys);
			or.setMessage("批量删除成功！");
			or.setState(true);
		} catch (DaoException e) {
			or.setMessage("批量删除失败！");
			or.setState(false);
			throw new ServicesException("批量删除出错：", e);
		}
		return or;
	}

	public OperateResult remove(String ids) throws ServicesException {
		OperateResult or = new OperateResult();
		try {
			baseDao.remove(ids);
			or.setMessage("批量删除成功！");
			or.setState(true);
		} catch (DaoException e) {
			or.setMessage("批量删除失败！");
			or.setState(false);
			throw new ServicesException("批量删除出错：", e);
		}
		return or;
	}

	public OperateResult save(Entity entity) throws ServicesException {
		OperateResult or = new OperateResult();
		try {
			entity = baseDao.save(entity);
			or.setResult(entity);
			or.setMessage("保存成功！");
			or.setState(true);
		} catch (DaoException e) {
			or.setMessage("保存失败！");
			or.setState(false);
			throw new ServicesException("保存失败：", e);
		}
		return or;
	}

	public OperateResult save(List<Entity> entitys) throws ServicesException {
		OperateResult or = new OperateResult();
		try {
			baseDao.save(entitys);
			or.setMessage("批量添加或修改成功！");
			or.setState(true);
		} catch (DaoException e) {
			or.setMessage("批量添加或修改失败！");
			or.setState(false);
			throw new ServicesException("批量添加或修改失败：", e);
		}
		return or;
	}

	public List<?> getCollectionByNativeSql(String SQL) throws ServicesException {
		return getCollectionByNativeSql(SQL, null);
	}

	public List<?> getCollectionByNativeSql(String SQL, Object[] params) throws ServicesException {
		return getCollectionByNativeSql(SQL, params, null);
	}

	public List<?> getCollectionByNativeSql(String SQL, Object[] params, String[] attributes) throws ServicesException {
		try {
			return baseDao.getCollectionByNativeSql(SQL, params, attributes);
		} catch (DaoException e) {
			throw new ServicesException("查询记录出错：", e);
		}
	}

	public java.util.List<Entity> getCollection(Entity model) throws ServicesException {
		return getCollection(model, true);
	}

	public List<Entity> getCollection(String JPQL) throws ServicesException {
		return getCollection(JPQL, new String[] {}, true);
	}

	public List<Entity> getCollection(Entity model, boolean pageFlag) throws ServicesException {
		return getCollection(null, model, pageFlag);
	}

	public List<Entity> getCollection(String JPQL, boolean pageFlag) throws ServicesException {
		return getCollection(JPQL, new String[] {}, pageFlag);
	}

	public List<Entity> getCollection(Entity model, String[] attributes) throws ServicesException {
		return getCollection(null, model, attributes);
	}

	public List<Entity> getCollection(String JPQL, String[] attributes, boolean pageFlag) throws ServicesException {
		return getCollection(JPQL, null, attributes, pageFlag);
	}

	public List<Entity> getCollection(String JPQL, Entity model) throws ServicesException {
		return getCollection(JPQL, model, true);
	}

	public List<Entity> getCollection(String JPQL, Entity model, boolean pageFlag) throws ServicesException {
		return getCollection(JPQL, model, null, pageFlag);
	}

	public List<Entity> getCollection(String JPQL, Entity model, String[] attributes) throws ServicesException {
		return getCollection(JPQL, model, attributes, true);
	}

	public List<Entity> getCollection(Entity entity, String[] attributes, boolean pageFlag) throws ServicesException {
		return getCollection(null, entity, attributes, pageFlag);
	}

	public List<Entity> getCollection(String JPQL, Entity entity, String[] attributes, boolean pageFlag) throws ServicesException {
		try {
			return baseDao.getCollection(JPQL, entity, attributes, pageFlag);
		} catch (DaoException e) {
			throw new ServicesException("查询记录出错：", e);
		}
	}
}
