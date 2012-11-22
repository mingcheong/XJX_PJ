package com.safetys.framework.system.controller;

import java.util.List;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.kernel.model.OnLineObject;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.system.model.FkRoleModel;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkResourceService;
import com.safetys.framework.system.service.IFkRoleService;
import com.safetys.framework.system.service.IFkUserService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.MD5;

/**
 * 登陆验证和控制分发
 * 
 * @author Stone
 */
@Scope("prototype")
@Controller("dispatchController")
public class DispatchController extends BaseController {

	private static final long serialVersionUID = -9117963402773404961L;
	private static final String FORWARD_CONTROLLER_PAGE = "/template/workspace/main.ftl";
	@Resource(name = "fkUserService")
	private IFkUserService fkUserService;
	@Resource(name = "fkRoleService")
	private IFkRoleService fkRoleService;
	@Resource(name = "fkResourceService")
	private IFkResourceService fkResourceService;
	private FkUserModel userModel;
	private List<FkResourceModel> resourceModels;
	private String username;
	private String password;
	private String randcode;

	/**
	 * 退出登陆并转到主页面
	 * 
	 * @throws Exception
	 */
	public String exits() throws Exception {
		if (session.get("onLineObject") != null) session.remove("onLineObject");
		return INPUT;
	}

	@Override
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		String result = "";
		if (getCurrentUser() != null) {
			this.setParameters(FORWARD_CONTROLLER_PAGE);
			result = SUCCESS;
		} else {
			if (AppUtils.isNullOrEmptyString(this.getUsername()) || AppUtils.isNullOrEmptyString(this.getPassword()) || AppUtils.isNullOrEmptyString(this.getRandcode())) {
				this.setMessage("faile");
				result = INPUT;
			} else {
				final String rand = (String) this.session.get("rand_code");
				if ((rand + "").equals(this.getRandcode())) {
					userModel = new FkUserModel();
					userModel.setUsername(username);
					userModel.setPassword(MD5.calcMD5(password));
					List<FkUserModel> datas = fkUserService.getCollection(userModel, false);
					if (datas != null && datas.size() > 0) {
						userModel = datas.get(0);
						OnLineObject onLineObject = new OnLineObject();
						onLineObject.setSelfResource(loadResources(userModel));
						onLineObject.setActionNames(fkResourceService.getActions(onLineObject.getSelfResource()));
						onLineObject.setCurrentUser(userModel);
						session.put("onLineObject", onLineObject);
						this.setParameters(FORWARD_CONTROLLER_PAGE);
						result = SUCCESS;
					} else {
						this.setMessage("faile");
						result = INPUT;
					}
				} else {
					this.setMessage("faile");
					result = INPUT;
				}
			}
		}
		return result;
	}

	/**
	 * 加载当前操作人员所拥有的资源菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadResources(FkUserModel fkUserModel) throws Exception {
		final TreeSet treeSet = new TreeSet();
		this.userModel = fkUserModel;
		String[] ids = null;
		if (!AppUtils.isNullOrEmptyString(userModel.getResources())) {
			ids = userModel.getResources().split(",");
			for (String id : ids) {
				treeSet.add(id);
			}
		}
		if (!AppUtils.isNullOrEmptyString(userModel.getFkOrganize().getId())) {
			FkOrganizeModel organize = userModel.getFkOrganize();
			if (!AppUtils.isNullOrEmptyString(organize.getResources())) {
				ids = organize.getResources().split(",");
				for (String id : ids) {
					treeSet.add(id);
				}
			}
		}
		if (!AppUtils.isNullOrEmptyString(userModel.getRoles())) {
			String JPQL = "select o from fkRoleModel o where 1=1 and o.id in(" + userModel.getRoles() + ")";
			List<FkRoleModel> datas = fkRoleService.getCollection(JPQL, false);
			for (FkRoleModel model : datas) {
				if (model.getResources() != null && model.getResources().length() > 0) ids = model.getResources().split(",");
				for (String id : ids) {
					treeSet.add(id);
				}
			}
		}
		final StringBuffer sb = new StringBuffer();
		for (Object o : treeSet) {
			if (o.toString().length() > 0) sb.append(o.toString() + ",");
		}
		String topIds = sb.toString();
		topIds = topIds.substring(0, topIds.lastIndexOf(","));
		return topIds;
	}

	public FkUserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(FkUserModel userModel) {
		this.userModel = userModel;
	}

	public List<FkResourceModel> getResourceModels() {
		return resourceModels;
	}

	public void setResourceModels(List<FkResourceModel> resourceModels) {
		this.resourceModels = resourceModels;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRandcode() {
		return randcode;
	}

	public void setRandcode(String randcode) {
		this.randcode = randcode;
	}

}
