/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net Copyright (C) 2004-2010 Frederico Caldeira Knabben == BEGIN LICENSE == Licensed under the terms of any of the following licenses
 * at your choice: - GNU General Public License Version 2 or later (the "GPL") http://www.gnu.org/licenses/gpl.html - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html - Mozilla Public License Version 1.1 or later (the "MPL") http://www.mozilla.org/MPL/MPL-1.1.html == END LICENSE ==
 */
package com.safetys.framework.fckeditor.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Java representation of an XHTML tag.
 * <p>
 * Usage:
 * 
 * <pre>
 * XHtmlTagTool tag = XHtmlTagTool(&quot;a&quot;, &quot;link&quot;);
 * tag.addAttribute(&quot;href&quot;, &quot;http://google.com&quot;);
 * tag.toString();: &lt;a href=&quot;http://google.com&quot;&gt;link&lt;/a&gt;
 * </pre>
 * 
 * </p>
 * <em>Note</em>:
 * <ul>
 * <li>Attributes are not ordered.</li>
 * <li>If you want to avoid self-closing tags without supplying a value, set {@link #SPACE} as the tag's value.</li>
 * </ul>
 * 
 * @version $Id: XHtmlTagTool.java 4785 2009-12-21 20:10:28Z mosipov $
 */
public class XHtmlTagTool {

	/** Name of the tag. */
	private final String name;

	/** Container for the attributes. */
	private final Map<String, String> attributes = new HashMap<String, String>();

	/** Value of the tag. */
	private String value;

	/** Indicator to uses non self-closing tag. */
	public static final String SPACE = " ";

	/**
	 * Class constructor with tag name.
	 * 
	 * @param name
	 *            the tag name of the new XHtmlTagTool
	 * @throws IllegalArgumentException
	 *             if <code>name</code> is empty
	 */
	public XHtmlTagTool(final String name) {
		if (Utils.isEmpty(name)) { throw new IllegalArgumentException("Parameter 'name' shouldn't be empty!"); }
		this.name = name;
	}

	/**
	 * Class constructor with name and value.
	 * 
	 * @param name
	 *            the tag name of the new XHtmlTagTool
	 * @param value
	 *            the tag value of the new XHtmlTagTool which is the tag body
	 * @throws IllegalArgumentException
	 *             if <code>name</code> is empty
	 */
	public XHtmlTagTool(final String name, final String value) {
		this(name);
		this.value = value;
	}

	/**
	 * Sets the tag value.
	 * 
	 * @param value
	 *            the tag value which is the tag body
	 */
	public void setValue(final String value) {
		this.value = value;
	}

	/**
	 * Adds an attribute to this tag.
	 * 
	 * @param name
	 *            attribute name
	 * @param value
	 *            attribute value
	 * @throws IllegalArgumentException
	 *             if <code>name</code> is empty
	 */
	public void addAttribute(final String name, final String value) {
		if (Utils.isEmpty(name)) { throw new IllegalArgumentException("Name is null or empty"); }
		this.attributes.put(name, value);
	}

	/**
	 * Creates the HTML representation of this tag. It follows the XHTML standard.
	 * 
	 * @return HTML representation of this tag
	 */
	@Override
	public String toString() {
		final StringBuffer tag = new StringBuffer();

		// open tag
		tag.append("<").append(this.name);

		// add attributes
		for (final String key : this.attributes.keySet()) {
			final String val = this.attributes.get(key);
			tag.append(' ').append(key).append('=').append('\"').append(val).append('\"');
		}

		// close the tag
		if (Utils.isNotEmpty(this.value)) {
			tag.append(">").append(this.value).append("</").append(this.name).append('>');
		} else {
			tag.append(" />");
		}

		return tag.toString();
	}

}