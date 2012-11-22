package com.safetys.framework.fckeditor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.safetys.framework.fckeditor.tool.Utils;

public class FCKeditorConfig extends HashMap<String, String> {

	private static final long serialVersionUID = -4831190504944866644L;
	private static final Logger logger = LoggerFactory.getLogger(FCKeditorConfig.class);

	public String getUrlParams() {
		final StringBuffer osParams = new StringBuffer();
		try {
			for (final Map.Entry<String, String> entry : this.entrySet()) {
				if (Utils.isNotEmpty(entry.getValue())) {
					osParams.append("&amp;");
					osParams.append(entry.getKey());
					osParams.append("=");
					osParams.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				}
			}

		} catch (final UnsupportedEncodingException e) {
			FCKeditorConfig.logger.error("Configuration parameters could not be encoded", e);
		}

		if (osParams.length() > 0) {
			osParams.delete(0, 5);
		}
		return osParams.toString();
	}
}