<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.controller;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ${basepackage}.${subpackage}.model.${className}Model;
import ${basepackage}.${subpackage}.service.I${className}Service;
<#include "/java_comment.include">
@Scope("prototype")
@Controller("${classNameLower}Controller")
public class ${className}Controller extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_${classNameLower} = "/template/${subpackage}/${className}_Input.ftl";
	private static final String page_forward_showupdate_${classNameLower} = "/template/${subpackage}/${className}_Input.ftl";
	private static final String page_forward_showdetail_${classNameLower} = "/template/${subpackage}/${className}_Detail.ftl";
	private static final String page_forward_tomanagers_${classNameLower} = "/template/${subpackage}/${className}_Manager.ftl";
	private static final String action_forward_managers_${classNameLower} = "${classNameLower}_manager.xhtml";
	@Resource(name = "${classNameLower}Service")
	private I${className}Service ${classNameLower}Service;
	private ${className}Model ${classNameLower}Model;
	private List<${className}Model> ${classNameLower}Models;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_${classNameLower});
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要修改的对象编号不可为空！");
        }
		${classNameLower}Model = ${classNameLower}Service.findById(this.getId());
		this.setParameters(page_forward_showupdate_${classNameLower});
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要查看的对象编号不可为空！");
        }
		${classNameLower}Model = ${classNameLower}Service.findById(this.getId());
		this.setParameters(page_forward_showdetail_${classNameLower});
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = ${classNameLower}Service.save(${classNameLower}Model);
		this.set${className}Model(null);
		this.setParameters(or.getMessage(),action_forward_managers_${classNameLower});
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * @throws ActionException
	 */
	public String remove() throws Exception {
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) { 
			throw new ActionException("将要删除的对象编号不可为空！");
		}
		or = ${classNameLower}Service.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_${classNameLower});
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		${classNameLower}Model.setFirstArea(this.getCurrentUser().getFirstArea());
		${classNameLower}Model.setSecondArea(this.getCurrentUser().getSecondArea());
		${classNameLower}Model.setThirdArea(this.getCurrentUser().getThirdArea());
		${classNameLower}Model.setFourthArea(this.getCurrentUser().getFourthArea());
		${classNameLower}Model.setFifthArea(this.getCurrentUser().getFifthArea());
		${classNameLower}Models = ${classNameLower}Service.getCollection(${classNameLower}Model);
		this.setParameters(page_forward_tomanagers_${classNameLower});
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		${classNameLower}Models = ${classNameLower}Service.getCollection(${classNameLower}Model);
		TableFacade tableFacade = new TableFacade("${classNameLower}Model", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {<@generateFields />
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(${classNameLower}Models);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (${classNameLower}Model == null) {
			${classNameLower}Model = new ${className}Model(request, "${classNameLower}Model");
		}
	}
	
	/**
	 * @return the ${classNameLower}Model
	 */
	public ${className}Model get${className}Model() {
		return ${classNameLower}Model;
	}

	/**
	 * @param ${classNameLower}Model the ${classNameLower}Model to set
	 */
	public void set${className}Model(${className}Model ${classNameLower}Model) {
		this.${classNameLower}Model = ${classNameLower}Model;
	}

	/**
	 * @return the ${classNameLower}Models
	 */
	public List<${className}Model> get${className}Models() {
		return ${classNameLower}Models;
	}

	/**
	 * @param ${classNameLower}Models the ${classNameLower}Models to set
	 */
	public void set${className}Models(List<${className}Model> ${classNameLower}Models) {
		this.${classNameLower}Models = ${classNameLower}Models;
	}
<#macro generateFields><#list table.columns as column><#if !column.pk && column.columnNameLower != "deleted"  && column.columnNameLower != "sortnum">"${column.columnNameLower}",</#if></#list>};</#macro>
}
