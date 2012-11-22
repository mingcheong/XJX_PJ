package com.safetys.framework.filter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.safetys.framework.jmesa.core.filter.DateFilterMatcher;
import com.safetys.framework.jmesa.core.filter.FilterMatcher;
import com.safetys.framework.jmesa.core.filter.FilterMatcherMap;
import com.safetys.framework.jmesa.core.filter.MatcherKey;

public class TagFilterMatcherMap implements FilterMatcherMap {

	public Map<MatcherKey, FilterMatcher> getFilterMatchers() {
		Map<MatcherKey, FilterMatcher> filterMatcherMap = new HashMap<MatcherKey, FilterMatcher>();
		filterMatcherMap.put(new MatcherKey(Date.class), new DateFilterMatcher("yyyy年MM月dd日 HH时mm分ss秒"));
		return filterMatcherMap;
	}

}
