/*
 * Copyright 2004 original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.safetys.framework.jmesa.view.csv;

import java.util.Collection;
import java.util.List;

import com.safetys.framework.jmesa.view.AbstractExportView;
import com.safetys.framework.jmesa.view.component.Column;
import com.safetys.framework.jmesa.view.csv.renderer.CsvCellRenderer;
import com.safetys.framework.jmesa.view.renderer.CellRenderer;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
@SuppressWarnings("deprecation")
public class CsvView extends AbstractExportView {
	private String delimiter;

	public CsvView() {
	}

	public CsvView(String delimiter) {
		this.delimiter = delimiter;
	}

	protected String getDelimiter() {
		return delimiter;
	}

	public Object render() {
		StringBuilder data = new StringBuilder();
		List<Column> columns = getTable().getRow().getColumns();
		int rowcount = 0;
		Collection<?> items = getCoreContext().getPageItems();
		for (Object item : items) {
			rowcount++;
			for (Column column : columns) {
				CellRenderer cellRenderer = column.getCellRenderer();
				if (cellRenderer instanceof CsvCellRenderer) {
					data.append(column.getCellRenderer().render(item, rowcount));
				} else {
					Object value = cellRenderer.render(item, rowcount);
					data.append("\"").append(value).append("\"");
					data.append(getDelimiter());
				}
			}

			data.append("\r\n");
		}

		return data.toString();
	}
}
