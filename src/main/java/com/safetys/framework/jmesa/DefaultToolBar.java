package com.safetys.framework.jmesa;

import com.safetys.framework.jmesa.view.ViewUtils;
import com.safetys.framework.jmesa.view.html.toolbar.AbstractToolbar;
import com.safetys.framework.jmesa.view.html.toolbar.MaxRowsItem;
import com.safetys.framework.jmesa.view.html.toolbar.ToolbarItemType;

public class DefaultToolBar extends AbstractToolbar {

	@Override
	public String render() {
		addToolbarItem(ToolbarItemType.FIRST_PAGE_ITEM);
		addToolbarItem(ToolbarItemType.PREV_PAGE_ITEM);
		addToolbarItem(ToolbarItemType.PAGE_NUMBER_ITEMS);
		addToolbarItem(ToolbarItemType.NEXT_PAGE_ITEM);
		addToolbarItem(ToolbarItemType.LAST_PAGE_ITEM);
		if (enableSeparators) {
			addToolbarItem(ToolbarItemType.SEPARATOR);
		}
		MaxRowsItem maxRowsItem = (MaxRowsItem) addToolbarItem(ToolbarItemType.MAX_ROWS_ITEM);
		if (getMaxRowsIncrements() != null) {
			maxRowsItem.setIncrements(getMaxRowsIncrements());
		}
		boolean exportable = ViewUtils.isExportable(getExportTypes());
		if (exportable && enableSeparators) {
			addToolbarItem(ToolbarItemType.SEPARATOR);
		}
		if (exportable) {
			addExportToolbarItems(getExportTypes());
		}

		return super.render();
	}
}
