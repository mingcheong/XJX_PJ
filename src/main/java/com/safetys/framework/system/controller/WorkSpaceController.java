package com.safetys.framework.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.system.service.IFkResourceService;

/**
 * 布局控制器
 * 
 * @author Stone
 */
@Scope("prototype")
@Controller("workspaceController")
public class WorkSpaceController extends BaseController {

	private static final long serialVersionUID = -3151434857350573687L;

	private static final String page_top_workspace = "/template/workspace/top.ftl";
	private static final String page_leftmenu_workspace = "/template/workspace/left-menu.ftl";
	private static final String page_leftinfo_workspace = "/template/workspace/left-info.ftl";
	private static final String page_control_workspace = "/template/workspace/control.ftl";
//	private static final String page_content_workspace = "/template/workspace/welcome.ftl";
	private static final String page_content_workspace = "/template/statistic/company_highcharts_statistic.ftl";
	private List<FkResourceModel> fkResourceModels;
	@Resource(name = "fkResourceService")
	private IFkResourceService fkResourceService;
	private String htmlMenus;

	public String top() throws Exception {
		fkResourceModels = fkResourceService.getCollection("select o from fkResourceModel o where o.id in(" + this.getUserResourceIds() + ") and o.fatherId=0 and o.isMenu = true",new String[]{"id","sortNum"}, false);
		this.setParameters(page_top_workspace);
		return SUCCESS;
	}

	public String left() throws Exception {
		if (this.getId() < 0) {
			this.setParameters(page_leftinfo_workspace);
		} else {
			fkResourceModels = fkResourceService.getChildrenResources(this.getUserResourceIds(), this.getId());
			if (fkResourceModels != null && fkResourceModels.size() > 0) {
				StringBuffer buffer = new StringBuffer();
				String imgPath = "/default/images/all_001.png";
				for (FkResourceModel element : fkResourceModels) {
					if (element.getResourceImg() != null && element.getResourceImg().length() > 0) {
						imgPath = element.getResourceImg();
					}
					if (element.getChildren() != null && element.getChildren().size() > 0) {
						buffer.append("<h1 onClick=\"javascript:ShowMenu(this,'first" + element.getId() + "')\"><img src='" + this.getResourcePath() + imgPath + "'/>&nbsp;&nbsp;"
						        + element.getResourceName() + "</h1>");
						buffer.append("<span id='first" + element.getId() + "' class='no'>");
						for (FkResourceModel element2 : element.getChildren()) {
							if (element2.getResourceImg() != null && element2.getResourceImg().length() > 0) {
								imgPath = element2.getResourceImg();
							}
							if (element2.getChildren() != null && element2.getChildren().size() > 0) {
								buffer.append("<h2 onClick=\"javascript:ShowMenu(this,'seconds" + element2.getId() + "')\"><img src='" + this.getResourcePath() + imgPath
								        + "'/>&nbsp;&nbsp;" + element2.getResourceName() + "</h2>");
								buffer.append("<ul id='seconds" + element2.getId() + "' class='no'>");
								for (FkResourceModel element3 : element2.getChildren()) {
									imgPath = "/default/images/all_002.png";
									if (element3.getResourceImg() != null && element3.getResourceImg().length() > 0) {
										imgPath = element3.getResourceImg();
									}
									buffer.append("<li><a href='" + element3.getResourceUrl() + "' target='mainFrame'><img src='" + this.getResourcePath() + imgPath
									        + "'/>&nbsp;&nbsp;" + element3.getResourceName() + "</a></li>");
								}
								buffer.append("</ul>");
							} else {
								buffer.append("<h2><a href='" + element2.getResourceUrl() + "' target='mainFrame'> <img src='" + this.getResourcePath() + imgPath
								        + "'/>&nbsp;&nbsp;" + element2.getResourceName() + "</a></h2>");
							}
						}
						buffer.append("</span>");
					} else {
						buffer.append("<h1><a href='" + element.getResourceUrl() + "' target='mainFrame'><img src='" + this.getResourcePath() + imgPath + "'/>&nbsp;&nbsp;"
						        + element.getResourceName() + "</a></h1>");
					}
				}
				this.setHtmlMenus(buffer.toString());
			}
			this.setParameters(page_leftmenu_workspace);
		}
		return SUCCESS;
	}

	public String content() throws Exception {

		this.setParameters(page_content_workspace);
		return SUCCESS;
	}

	public String control() throws Exception {

		this.setParameters(page_control_workspace);
		return SUCCESS;
	}

	/**
	 * @return the htmlMenus
	 */
	public String getHtmlMenus() {
		return htmlMenus;
	}

	/**
	 * @param htmlMenus
	 *            the htmlMenus to set
	 */
	public void setHtmlMenus(String htmlMenus) {
		this.htmlMenus = htmlMenus;
	}

	/**
	 * @return the fkResourceModels
	 */
	public List<FkResourceModel> getFkResourceModels() {
		return fkResourceModels;
	}

	/**
	 * @param fkResourceModels
	 *            the fkResourceModels to set
	 */
	public void setFkResourceModels(List<FkResourceModel> fkResourceModels) {
		this.fkResourceModels = fkResourceModels;
	}

}
