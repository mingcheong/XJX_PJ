/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.framework.utils.Struts2Utils;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxProductCateModel;
import com.safetys.zhjg.xjx.model.JxPuchaseTypeModel;
import com.safetys.zhjg.xjx.model.JxSettlementTypeModel;
import com.safetys.zhjg.xjx.model.JxUnitModel;
import com.safetys.zhjg.xjx.service.IJxDeptService;
import com.safetys.zhjg.xjx.service.IJxGoodsService;
import com.safetys.zhjg.xjx.service.IJxProductCateService;
import com.safetys.zhjg.xjx.service.IJxPuchaseTypeService;
import com.safetys.zhjg.xjx.service.IJxSettlementTypeService;
import com.safetys.zhjg.xjx.service.IJxUnitService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxGoodsController")
public class JxGoodsController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxGoods = "/template/xjx/JxGoods_Input.ftl";
	private static final String page_forward_showupdate_jxGoods = "/template/xjx/JxGoods_Input.ftl";
	private static final String page_forward_showdetail_jxGoods = "/template/xjx/JxGoods_Detail.ftl";
	private static final String page_forward_tomanagers_jxGoods = "/template/xjx/JxGoods_Manager.ftl";
	private static final String action_forward_managers_jxGoods = "jxGoods_manager.xhtml";

	/**
	 * 商品代码业务操作类
	 */
	@Resource(name = "jxGoodsService")
	private IJxGoodsService jxGoodsService;

	/**
	 * 部门业务操作类
	 */
	@Resource(name = "jxDeptService")
	private IJxDeptService jxDeptService;

	/**
	 * 计量单位业务操作类
	 */
	@Resource(name = "jxUnitService")
	private IJxUnitService jxUnitService;

	/**
	 * 进货类型业务操作类
	 */
	@Resource(name = "jxPuchaseTypeService")
	private IJxPuchaseTypeService jxPuchaseTypeService;

	/**
	 * 付款类型业务操作类
	 */
	@Resource(name = "jxSettlementTypeService")
	private IJxSettlementTypeService jxSettlementTypeService;

	/**
	 * 商品分类业务操作类
	 */
	@Resource(name = "jxProductCateService")
	private IJxProductCateService jxProductCateService;

	private JxGoodsModel jxGoodsModel;
	private List<JxGoodsModel> jxGoodsModels;
	



	/**
	 * 以JSON方式返回供应商列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String jsonList() throws Exception
	{
		jxGoodsModels = jxGoodsService.getCollection(jxGoodsModel);
		JSONArray jr = new JSONArray();
		if (jxGoodsModels != null && !jxGoodsModels.isEmpty())
		{
			JSONObject json = null;
			for (JxGoodsModel goods : jxGoodsModels)
			{
				json = new JSONObject();
				json.put("id", goods.getId());
				json.put("code", goods.getJgCode());
				json.put("name", goods.getJgName());
				jr.put(json);
			}
		}
		JSONObject jo = new JSONObject();
		jo.put("total", jxGoodsModels.size());
		jo.put("rows", jr);
		return Struts2Utils.renderJson(jo.toString());
	}


	public String getGoods() throws Exception
	{

		if (jxGoodsModel == null || StringUtils.isEmpty(jxGoodsModel.getJgCode()))
			return null;
		jxGoodsModel = jxGoodsService.findByCode(jxGoodsModel.getJgCode().trim());
		JSONObject json = new JSONObject();
		if (jxGoodsModel != null)
		{
			json.put("id", jxGoodsModel.getId());
			json.put("incode", jxGoodsModel.getJgIncode());
			json.put("code", jxGoodsModel.getJgCode());
			json.put("name", jxGoodsModel.getJgName());
			json.put("rate", jxGoodsModel.getJgRate());
			json.put("spec", jxGoodsModel.getJgSpec());
			
			JSONObject bUnit= new JSONObject();
			bUnit.put("id", jxGoodsModel.getJgBunit().getId());
			bUnit.put("juCode", jxGoodsModel.getJgBunit().getJuCode());
			bUnit.put("juName", jxGoodsModel.getJgBunit().getJuName());
			json.put("bUnit", bUnit);
			
			JSONObject sUnit= new JSONObject();
			sUnit.put("id", jxGoodsModel.getJgSunit().getId());
			sUnit.put("juCode", jxGoodsModel.getJgSunit().getJuCode());
			sUnit.put("juName", jxGoodsModel.getJgSunit().getJuName());
			json.put("sUnit", sUnit);
			
		}
		else
		{
			json.put("error", "无此商品,请先设置!");
		}
		return Struts2Utils.renderJson(json.toString());
	}


	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		jxGoodsModel.setJgCansell(true);
		jxGoodsModel.setJgSpare(true);
		jxGoodsModel.setJgIntsell(false);
		this.setParameters(page_forward_showinsert_jxGoods);
		return SUCCESS;
	}


	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception
	{
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		jxGoodsModel = jxGoodsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxGoods);
		return SUCCESS;
	}


	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception
	{
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要查看的对象编号不可为空！"); }
		jxGoodsModel = jxGoodsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxGoods);
		return SUCCESS;
	}


	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception
	{
		OperateResult or = null;

		JxDeptModel jgDept = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgDept().getJdCode()))
		{
			jgDept = jxDeptService.findUnique("jdCode", jxGoodsModel.getJgDept().getJdCode());
		}

		JxUnitModel jgSunit = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgSunit().getJuCode()))
		{
			jgSunit = jxUnitService.findUnique("juCode", jxGoodsModel.getJgSunit().getJuCode());
		}

		JxUnitModel jgBunit = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgBunit().getJuCode()))
		{
			jgBunit = jxUnitService.findUnique("juCode", jxGoodsModel.getJgBunit().getJuCode());
		}

		JxProductCateModel jgCate = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgCate().getJpcCode()))
		{
			jgCate = jxProductCateService.findUnique("jpcCode", jxGoodsModel.getJgCate().getJpcCode());
		}

		JxPuchaseTypeModel jgPtype = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgPtype().getJpCode()))
		{
			jgPtype = jxPuchaseTypeService.findUnique("jpCode", jxGoodsModel.getJgPtype().getJpCode());
		}

		JxSettlementTypeModel jgStype = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgStype().getJsCode()))
		{
			jgStype = jxSettlementTypeService.findUnique("jsCode", jxGoodsModel.getJgStype().getJsCode());
		}

		JxSettlementTypeModel jgSeway = null;
		if (StringUtils.isNotEmpty(jxGoodsModel.getJgSeway().getJsCode()))
		{
			jgSeway = jxSettlementTypeService.findUnique("jsCode", jxGoodsModel.getJgSeway().getJsCode());
		}
		jxGoodsModel.setJgDept(jgDept);
		jxGoodsModel.setJgSunit(jgSunit);
		jxGoodsModel.setJgBunit(jgBunit);
		jxGoodsModel.setJgCate(jgCate);
		jxGoodsModel.setJgPtype(jgPtype);
		jxGoodsModel.setJgStype(jgStype);
		jxGoodsModel.setJgSeway(jgSeway);

		or = jxGoodsService.save(jxGoodsModel);
		this.setJxGoodsModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxGoods);
		return SUCCESS;
	}


	/**
	 * 删除数据
	 * 
	 * @throws ActionException
	 */
	public String remove() throws Exception
	{
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) { throw new ActionException("将要删除的对象编号不可为空！"); }
		or = jxGoodsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxGoods);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxGoodsModels = jxGoodsService.getCollection(jxGoodsModel);
		this.setParameters(page_forward_tomanagers_jxGoods);
		return SUCCESS;
	}


	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception
	{
		jxGoodsModels = jxGoodsService.getCollection(jxGoodsModel);
		TableFacade tableFacade = new TableFacade("jxGoodsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jgIncode", "jgCode", "jgName", "jgDept", "jgSunit", "jgBunit", "jgSpec", "jgCate", "jgOrigin", "jgFactory", "jgRate", "jgGuided", "jgShelf", "jgPtype", "jgPcycle",
				"jgStype", "jgSeway", "jgCansell", "jgSpare", "jgIntsell", "jgRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxGoodsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxGoodsModel == null)
		{
			jxGoodsModel = new JxGoodsModel(request, "jxGoodsModel");
		}
	}


	/**
	 * @return the jxGoodsModel
	 */
	public JxGoodsModel getJxGoodsModel()
	{
		return jxGoodsModel;
	}


	/**
	 * @param jxGoodsModel
	 *            the jxGoodsModel to set
	 */
	public void setJxGoodsModel(JxGoodsModel jxGoodsModel)
	{
		this.jxGoodsModel = jxGoodsModel;
	}


	/**
	 * @return the jxGoodsModels
	 */
	public List<JxGoodsModel> getJxGoodsModels()
	{
		return jxGoodsModels;
	}


	/**
	 * @param jxGoodsModels
	 *            the jxGoodsModels to set
	 */
	public void setJxGoodsModels(List<JxGoodsModel> jxGoodsModels)
	{
		this.jxGoodsModels = jxGoodsModels;
	}
}
