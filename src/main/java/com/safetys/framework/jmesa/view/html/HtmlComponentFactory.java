/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.safetys.framework.jmesa.view.html;

import com.safetys.framework.jmesa.core.CoreContext;
import com.safetys.framework.jmesa.view.AbstractComponentFactory;
import com.safetys.framework.jmesa.view.editor.CellEditor;
import com.safetys.framework.jmesa.view.html.component.HtmlColumn;
import com.safetys.framework.jmesa.view.html.component.HtmlRow;
import com.safetys.framework.jmesa.view.html.component.HtmlTable;
import com.safetys.framework.jmesa.view.html.editor.HtmlCellEditor;
import com.safetys.framework.jmesa.view.html.editor.HtmlFilterEditor;
import com.safetys.framework.jmesa.view.html.editor.HtmlHeaderEditor;
import com.safetys.framework.jmesa.view.html.renderer.HtmlCellRendererImpl;
import com.safetys.framework.jmesa.view.html.renderer.HtmlFilterRendererImpl;
import com.safetys.framework.jmesa.view.html.renderer.HtmlHeaderRendererImpl;
import com.safetys.framework.jmesa.view.html.renderer.HtmlRowRendererImpl;
import com.safetys.framework.jmesa.view.html.renderer.HtmlTableRendererImpl;
import com.safetys.framework.jmesa.web.WebContext;

/**
 * @since 2.0
 * @author Jeff Johnston
 *
 * @deprecated Should build components directly now instead of using factory.
 */
@Deprecated
public class HtmlComponentFactory extends AbstractComponentFactory {
    public HtmlComponentFactory(WebContext webContext, CoreContext coreContext) {}

    /**
     * @deprecated Should build components directly now instead of using factory.
     */
    @Deprecated
    @Override
    public HtmlTable createTable() {
        HtmlTable table = new HtmlTable();

        HtmlTableRendererImpl tableRenderer = new HtmlTableRendererImpl(table);
        table.setTableRenderer(tableRenderer);

        return table;
    }

    /**
     * @deprecated Should build components directly now instead of using factory.
     */
    @Deprecated
    @Override
    public HtmlRow createRow() {
        HtmlRow row = new HtmlRow();

        HtmlRowRendererImpl rowRenderer = new HtmlRowRendererImpl(row);
        row.setRowRenderer(rowRenderer);

        return row;
    }

    /**
     * @deprecated Should build components directly now instead of using factory.
     */
    @Deprecated
    @Override
    public CellEditor createBasicCellEditor() {
        HtmlCellEditor editor = new HtmlCellEditor();
        return editor;
    }

    /**
     * Create a column using the BasicCellEditor.
     * 
     * @param property The column property.
     * @return The HtmlColumn instance.
     * @deprecated Should build components directly now instead of using factory.
     */
    @Deprecated
    @Override
    public HtmlColumn createColumn(String property) {
        return createColumn(property, createBasicCellEditor());
    }

    /**
     * Create a column that does not require cell editor.
     * 
     * @return The HtmlColumn instance.
     * @deprecated Should build components directly now instead of using factory.
     */
    @Deprecated
    @Override
    public HtmlColumn createColumn(CellEditor editor) {
        return createColumn(null, editor);
    }

    /**
     * @deprecated Should build components directly now instead of using factory.
     */
    @Deprecated
    public HtmlColumn createColumn(String property, CellEditor editor) {
        HtmlColumn column = new HtmlColumn(property);
        
        // cell

        HtmlCellRendererImpl cellRenderer = new HtmlCellRendererImpl(column, editor);
        column.setCellRenderer(cellRenderer);

        // filter
        
        HtmlFilterRendererImpl filterRenderer = new HtmlFilterRendererImpl(column);
        column.setFilterRenderer(filterRenderer);

        HtmlFilterEditor filterEditor = new HtmlFilterEditor();
        filterEditor.setColumn(column);
        filterRenderer.setFilterEditor(filterEditor);
        
        // header

        HtmlHeaderRendererImpl headerRenderer = new HtmlHeaderRendererImpl(column);
        column.setHeaderRenderer(headerRenderer);

        HtmlHeaderEditor headerEditor = new HtmlHeaderEditor();
        headerEditor.setColumn(column);
        headerRenderer.setHeaderEditor(headerEditor);

        return column;
    }
}
