package com.safetys.framework.kernel.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.safetys.framework.kernel.model.OnLineObject;
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.system.model.FkUserModel;

/**
 * 抽象控制器
 * 
 * @author Stone
 */
public class BaseController extends DefaultActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

	private static final long serialVersionUID = 3330662187932899882L;
	protected static final String FORWARD_ERROR = "message_to_back";
	protected static final String FORWARD_SUCCESS = "/template/common/success.ftl";
	protected static final String JSON = "json";
	public static final String DOWNLOAD = "download";
	
	// 批量上传用
	protected List<File> Filedata;
	protected List<String> FiledataFileName;
	protected List<String> FiledataContentType;
	// 文件下载用
	protected String fileName;// 文件名称
	protected String contentType; // 文件类型
	protected InputStream downloadFile; // 文件下载的流
	// 树型对象集
	protected List<TreeModel> treeModels = new ArrayList<TreeModel>();
	// json转换对象
	protected Gson gson = new Gson();
	// 树型对象
	protected TreeModel treeModel = null;
	private Date cuurentDate;
	/**
	 * 默认转向地址
	 */
	private String successPage = FORWARD_SUCCESS;
	/**
	 * 项目顶级URL
	 */
	private String contextPath;
	/**
	 * 顶上资源地址
	 */
	private String resourcePath;

	/**
	 * 枚举地址
	 */
	private String enumXmlUrl;
	/**
	 * 区域地址
	 */
	private String areaXmlUrl;
	/**
	 * 转向用到的地址
	 */
	private String url;
	/**
	 * 主键编号
	 */
	private Long id = -1l;
	/**
	 * 建立session对象
	 */
	@SuppressWarnings("rawtypes")
	protected Map session;
	/**
	 * 提示信息
	 */
	private String message;
	/**
	 * 输入页面的地址
	 */
	private String inputPage;
	/**
	 * 选择的编号
	 */
	private String selectedIds;
	/**
	 * 建立requset请求对象
	 */
	protected HttpServletRequest request;
	/**
	 * 建立response响应对象
	 */
	protected HttpServletResponse response;

	/**
	 * 设置转向的地址
	 * 
	 * @param successPage
	 */
	protected void setParameters(String successPage) {
		this.setSuccessPage(successPage);
	}

	/**
	 * 设置转向的地址
	 * 
	 * @param message
	 * @param url
	 */
	protected void setParameters(String message, String url) {
		this.setSuccessPage(this.successPage);
		this.setMessage(message);
		this.setUrl(url);
	}

	/**
	 * @param session
	 *            the session to set
	 */
	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	/**
	 * @param requeset
	 *            the requeset to set
	 */
	public void setServletRequest(HttpServletRequest requeset) {
		this.request = requeset;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getContentType() {
		return this.contentType;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getDownloadFile() {
		return this.downloadFile;
	}

	/**
	 * @return the cuurentDate
	 */
	public Date getCuurentDate() {
		if (cuurentDate == null) {
			cuurentDate = new Date();
		}
		return cuurentDate;
	}

	/**
	 * @param cuurentDate
	 *            the cuurentDate to set
	 */
	public void setCuurentDate(Date cuurentDate) {
		this.cuurentDate = cuurentDate;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

	public List<File> getFiledata() {
		return this.Filedata;
	}

	public void setFiledata(List<File> filedata) {
		this.Filedata = filedata;
	}

	public List<String> getFiledataFileName() {
		return this.FiledataFileName;
	}

	public void setFiledataFileName(List<String> filedataFileName) {
		this.FiledataFileName = filedataFileName;
	}

	public List<String> getFiledataContentType() {
		return this.FiledataContentType;
	}

	public void setFiledataContentType(List<String> filedataContentType) {
		this.FiledataContentType = filedataContentType;
	}

	/**
	 * @return the inputPage
	 */
	public String getInputPage() {
		return inputPage;
	}

	/**
	 * @param inputPage
	 *            the inputPage to set
	 */
	public void setInputPage(String inputPage) {
		this.inputPage = inputPage;
	}

	/**
	 * @return the enumXmlUrl
	 */
	public String getEnumXmlUrl() {
		if (enumXmlUrl == null) {
			enumXmlUrl = request.getContextPath() + "/resources/xml/enum.xml";
		}
		return enumXmlUrl;
	}

	/**
	 * @param enumXmlUrl
	 *            the enumXmlUrl to set
	 */
	public void setEnumXmlUrl(String enumXmlUrl) {
		this.enumXmlUrl = enumXmlUrl;
	}

	/**
	 * @return the areaXmlUrl
	 */
	public String getAreaXmlUrl() {
		if (areaXmlUrl == null) {
			areaXmlUrl = request.getContextPath() + "/resources/xml/area.xml";
		}
		return areaXmlUrl;
	}

	/**
	 * @param areaXmlUrl
	 *            the areaXmlUrl to set
	 */
	public void setAreaXmlUrl(String areaXmlUrl) {
		this.areaXmlUrl = areaXmlUrl;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the successPage
	 */
	public String getSuccessPage() {
		return successPage;
	}

	/**
	 * @param successPage
	 *            the successPage to set
	 */
	public void setSuccessPage(String successPage) {
		this.successPage = successPage;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 取当前操作人员的详细信息
	 * 
	 * @return {@link FkUserModel}
	 */
	public FkUserModel getCurrentUser() {
		OnLineObject onLineObject = (OnLineObject) this.session.get("onLineObject");
		if (onLineObject != null) {
			return onLineObject.getCurrentUser();
		} else {
			return null;
		}
	}

	/**
	 * 当前用户所拥有的资源信息
	 * 
	 * @return {@link List}
	 */
	public String getUserResourceIds() {
		OnLineObject onLineObject = (OnLineObject) this.session.get("onLineObject");
		if (onLineObject != null) {
			return onLineObject.getSelfResource();
		} else {
			return null;
		}
		
	}

	/**
	 * @return the selectedIds
	 */
	public String getSelectedIds() {
		return selectedIds;
	}

	/**
	 * @param selectedIds
	 *            the selectedIds to set
	 */
	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}

	public String getContextPath() {
		if (contextPath == null || contextPath.length() < 1) {
			contextPath = request.getContextPath();
		}
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getResourcePath() {
		if (resourcePath == null || resourcePath.length() < 1) {
			resourcePath = request.getContextPath() + "/resources";
		}
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

}
