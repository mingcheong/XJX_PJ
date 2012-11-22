package com.safetys.framework.fckeditor;

import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.fckeditor.handlers.PropertiesLoader;
import com.safetys.framework.fckeditor.tool.Compatibility;
import com.safetys.framework.fckeditor.tool.Utils;
import com.safetys.framework.fckeditor.tool.XHtmlTagTool;

public class FCKeditor {

	private final FCKeditorConfig fckConfig = new FCKeditorConfig();
	private String instanceName;
	private String inputName;
	private final HttpServletRequest request;

	// defaults
	private String value = Utils.EMPTY_STRING;
	private String toolbarSet = PropertiesLoader.getEditorToolbarSet();
	private String width = PropertiesLoader.getEditorWidth();
	private String height = PropertiesLoader.getEditorHeight();
	private String basePath = PropertiesLoader.getEditorBasePath();

	public FCKeditor(HttpServletRequest request, String instanceName, String inputName, String width, String height, String toolbarSet, String value, String basePath) {

		this(request, instanceName, inputName);
		this.width = width;
		this.height = height;
		this.toolbarSet = toolbarSet;
		this.value = value;
		this.basePath = basePath;

	}

	public FCKeditor(final HttpServletRequest request, final String instanceName, final String width, final String height, final String toolbarSet, final String value, final String basePath) {

		this(request, instanceName, null, width, height, toolbarSet, value, basePath);

	}

	public FCKeditor(final HttpServletRequest request, final String instanceName) {

		if (request == null) { throw new NullPointerException("the request cannot be null"); }
		this.request = request;

		this.setInstanceName(instanceName);

	}

	public FCKeditor(HttpServletRequest request, String instanceName, String inputName) {
		this(request, instanceName);
		this.setInputName(inputName);
	}

	public void setInstanceName(final String instanceName) {
		if (Utils.isEmpty(instanceName)) { throw new IllegalArgumentException("instanceName cannot be empty"); }
		if (!instanceName.matches("\\p{Alpha}[\\p{Alnum}:_.-]*")) { throw new IllegalArgumentException("instanceName must be a valid XHTML id containing only \"\\p{Alpha}[\\p{Alnum}:_.-]*\""); }
		this.instanceName = instanceName;
	}

	public void setInputName(final String inputName) {
		if (Utils.isEmpty(inputName)) {
			this.inputName = this.instanceName;
		} else {
			this.inputName = inputName;
		}
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public void setBasePath(final String basePath) {
		this.basePath = basePath;
	}

	public void setToolbarSet(final String toolbarSet) {
		this.toolbarSet = toolbarSet;
	}

	public void setWidth(final String width) {
		this.width = width;
	}

	public void setHeight(final String height) {
		this.height = height;
	}

	public String getConfig(String name) {
		return this.fckConfig.get(name);
	}

	public void setConfig(String name, String value) {
		if (value != null) {
			this.fckConfig.put(name, value);
		}
	}

	private String escapeXml(String str) {

		if (Utils.isEmpty(str)) { return str; }

		final StringBuffer sb = new StringBuffer();

		final int len = str.length();
		char c;

		for (int i = 0; i < len; i++) {

			c = str.charAt(i);
			switch (c) {
				case '&':
					sb.append("&amp;");
					break;
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '"':
					sb.append("&quot;");
					break;
				case '\'':
					sb.append("&#39;");
					break;
				default:
					sb.append(c);
					break;
			}
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		final StringBuffer strEditor = new StringBuffer();

		strEditor.append("<div>");
		final String encodedValue = this.escapeXml(this.value);
		this.setInputName(this.inputName);

		if (Compatibility.isCompatibleBrowser(this.request)) {
			strEditor.append(this.createInputForVariable(this.instanceName, this.inputName, encodedValue));
			final String configStr = this.fckConfig.getUrlParams();
			if (Utils.isNotEmpty(configStr)) {
				strEditor.append(this.createInputForVariable(this.instanceName.concat("___Config"), null, configStr));
			}
			final StringBuffer editorLink = new StringBuffer(this.request.getContextPath());
			editorLink.append(this.basePath);
			editorLink.append("/editor/fckeditor.html?InstanceName=").append(this.instanceName);
			if (Utils.isNotEmpty(this.toolbarSet)) {
				editorLink.append("&amp;Toolbar=").append(this.toolbarSet);
			}
			final XHtmlTagTool iframeTag = new XHtmlTagTool("iframe", XHtmlTagTool.SPACE);
			iframeTag.addAttribute("id", this.instanceName.concat("___Frame"));
			iframeTag.addAttribute("src", editorLink.toString());
			iframeTag.addAttribute("width", this.width);
			iframeTag.addAttribute("height", this.height);
			iframeTag.addAttribute("frameborder", "0");
			iframeTag.addAttribute("scrolling", "no");
			strEditor.append(iframeTag);

		} else {
			final XHtmlTagTool textareaTag = new XHtmlTagTool("textarea", encodedValue);
			textareaTag.addAttribute("name", this.inputName);
			textareaTag.addAttribute("rows", "4");
			textareaTag.addAttribute("cols", "40");
			textareaTag.addAttribute("wrap", "virtual");
			textareaTag.addAttribute("style", "width: ".concat(this.width).concat("; height: ").concat(this.height));
		}
		strEditor.append("</div>");
		return strEditor.toString();
	}

	public String createHtml() {
		return this.toString();
	}

	private String createInputForVariable(final String id, final String name, final String value) {
		final XHtmlTagTool tag = new XHtmlTagTool("input");
		tag.addAttribute("id", id);
		tag.addAttribute("name", name);
		tag.addAttribute("value", value);
		tag.addAttribute("type", "hidden");
		return tag.toString();
	}
}