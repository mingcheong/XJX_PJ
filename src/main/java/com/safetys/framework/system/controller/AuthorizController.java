package com.safetys.framework.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.safetys.framework.exception.ActionException;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.system.model.FkRoleModel;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkOrganizeService;
import com.safetys.framework.system.service.IFkResourceService;
import com.safetys.framework.system.service.IFkRoleService;
import com.safetys.framework.system.service.IFkUserService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;

/**
 * 权限分配控制器
 * @author Stone
 *
 */
@Scope("prototype")
@Controller("authorizController")
public class AuthorizController extends BaseController {

	private static final long serialVersionUID = 2436195628530148881L;
	private static final String path_forward_authorization_authoriz = "/template/system/Authorization.ftl";
	@Resource(name = "fkUserService")
	private IFkUserService fkUserService;
	@Resource(name = "fkRoleService")
	private IFkRoleService fkRoleService;
	@Resource(name = "fkOrganizeService")
	private IFkOrganizeService fkOrganizeService;
	@Resource(name = "fkResourceService")
	private IFkResourceService fkResourceService;
	private String typeCode;
	private List<FkRoleModel> fkRoleModels;

	/**
	 * 默认导航
	 */
	@Override
	public String execute() throws Exception {
		List<FkResourceModel> fkResourceModels = fkResourceService.getChildrenResources(0l);
		if (fkResourceModels != null && fkResourceModels.size() > 0) {
			treeModels = fkResourceService.getJson(fkResourceModels, treeModels);
		}
		fkRoleModels = fkRoleService.getCollection(new FkRoleModel(), false);
		request.setAttribute("resourceIds", gson.toJson(treeModels));
		this.setParameters(path_forward_authorization_authoriz);
		return SUCCESS;
	}

	/**
	 * 取人员，角度，组织机构的数据
	 * 
	 * @throws Exception
	 */
	public String ajax() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getTypeCode())) { throw new ActionException("对象编号不可为空！"); }
		String XML = "";
		if ("role".equals(this.getTypeCode())) {
			fkRoleModels = fkRoleService.getCollection(new FkRoleModel(),new String[]{"id"}, false);
			XML = fkRoleService.datasToXml(fkRoleModels);
		} else if ("user".equals(this.getTypeCode())) {
			List<FkUserModel> fkUserModels = fkUserService.getCollection(new FkUserModel(),new String[]{"id"}, false);
			XML = fkUserService.datasToXml(fkUserModels);
		} else {
			List<FkOrganizeModel> fkOrganizeModels = fkOrganizeService.getCollection(new FkOrganizeModel(),new String[]{"id"}, false);
			XML = fkOrganizeService.datasToXml(fkOrganizeModels);
		}
		this.response.getWriter().print(XML);
		this.response.getWriter().close();
		return NONE;
	}

	/**
	 * 取已有的菜单资源
	 * 
	 * @throws Exception
	 */
	public String getModelsToJson() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getTypeCode()) || AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("对象编号不可为空!"); }
		String ids = "";
		if ("role".equals(this.getTypeCode())) {
			FkRoleModel roleModel = fkRoleService.findById(this.getId());
			ids = roleModel.getResources();
		} else if ("user".equals(this.getTypeCode())) {
			FkUserModel userModel = fkUserService.findById(this.getId());
			ids = userModel.getResources();
		} else {
			FkOrganizeModel organizeModel = fkOrganizeService.findById(this.getId());
			ids = organizeModel.getResources();
		}
		this.response.getWriter().print(ids);
		this.response.getWriter().close();
		return NONE;
	}

	/**
	 * 保存数据
	 * 
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getTypeCode()) || AppUtils.isNullOrEmptyString(this.getId())
				|| AppUtils.isNullOrEmptyString(this.getSelectedIds())) { 
			this.response.getWriter().print("对象编号不可为空!"); 
			this.response.getWriter().close();
			return NONE;
		}
		OperateResult or = null;
		if ("role".equals(this.getTypeCode())) {
			FkRoleModel roleModel = fkRoleService.findById(this.getId());
			roleModel.setResources(this.getSelectedIds());
			or = fkRoleService.save(roleModel);
		} else if ("user".equals(this.getTypeCode())) {
			FkUserModel userModel = fkUserService.findById(this.getId());
			userModel.setResources(this.getSelectedIds());
			or = fkUserService.save(userModel);
		} else {
			FkOrganizeModel organizeModel = fkOrganizeService.findById(this.getId());
			organizeModel.setResources(this.getSelectedIds());
			or = fkOrganizeService.save(organizeModel);
		}
		this.response.getWriter().print(or.getMessage());
		this.response.getWriter().close();
		return NONE;
	}

	/**
	 * @return the fkRoleModels
	 */
	public List<FkRoleModel> getFkRoleModels() {
		return fkRoleModels;
	}

	/**
	 * @param fkRoleModels
	 *            the fkRoleModels to set
	 */
	public void setFkRoleModels(List<FkRoleModel> fkRoleModels) {
		this.fkRoleModels = fkRoleModels;
	}

	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode
	 *            the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}
