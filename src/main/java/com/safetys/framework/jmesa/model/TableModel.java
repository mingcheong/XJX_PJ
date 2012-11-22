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
package com.safetys.framework.jmesa.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.safetys.framework.jmesa.core.filter.FilterMatcher;
import com.safetys.framework.jmesa.core.filter.FilterMatcherMap;
import com.safetys.framework.jmesa.core.filter.MatcherKey;
import com.safetys.framework.jmesa.core.filter.RowFilter;
import com.safetys.framework.jmesa.core.message.Messages;
import com.safetys.framework.jmesa.core.preference.Preferences;
import com.safetys.framework.jmesa.core.sort.ColumnSort;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.jmesa.limit.LimitActionFactory;
import static com.safetys.framework.jmesa.model.TableModelUtils.getItems;
import com.safetys.framework.jmesa.limit.state.State;
import com.safetys.framework.jmesa.view.View;
import com.safetys.framework.jmesa.view.component.Table;
import com.safetys.framework.jmesa.view.html.toolbar.Toolbar;
import com.safetys.framework.jmesa.web.WebContext;
import com.safetys.framework.jmesa.worksheet.Worksheet;

/**
 * @since 3.0
 * @author Jeff Johnston
 */
public class TableModel {

    private String id;
    private HttpServletRequest request;
    private Collection<?> items;
    private PageItems pageItems;
    private AllItems allItems;
    private Preferences preferences;
    private Messages messages;
    private ExportType[] exportTypes;
    private State state;
    private String stateAttr;
    private Limit limit;
    private boolean autoFilterAndSort = true;
    private Map<MatcherKey, FilterMatcher> filterMatchers;
    private FilterMatcherMap filterMatcherMap;
    private ColumnSort columnSort;
    private RowFilter rowFilter;
    private int maxRows;
    private int[] maxRowsIncrements;
    private Toolbar toolbar;
    private View view;
    private Table table;
    private boolean editable;
    private WorksheetSaver worksheetSaver;
    private Object addedRowObject;

    private TableFacade tableFacade;

    // only used to subclass the model
    protected TableModel() {}

    public TableModel(String id, HttpServletRequest request) {
        this.id = id;
        this.request = request;
        this.tableFacade = new TableFacade(id, request);
    }

    public TableModel(String id, HttpServletRequest request, HttpServletResponse response) {
        this.id = id;
        this.request = request;
        this.tableFacade = new TableFacade(id, request, response);
    }

    public TableModel(String id, WebContext webContext) {
        this.tableFacade = new TableFacade(id, null);
        tableFacade.setWebContext(webContext);
        setHttpServletRequest(tableFacade);
    }

    public TableModel(String id, WebContext webContext, HttpServletResponse response) {
        this.tableFacade = new TableFacade(id, null, response);
        tableFacade.setWebContext(webContext);
        setHttpServletRequest(tableFacade);
    }

    protected void setTableFacade(TableFacade tableFacade) {
        this.tableFacade = tableFacade;
        this.id = tableFacade.getId();
        setHttpServletRequest(tableFacade);
    }

    private void setHttpServletRequest(TableFacade tableFacade) {
        Object backingObject = tableFacade.getWebContext().getBackingObject();
        if (backingObject instanceof HttpServletRequest) {
            request = (HttpServletRequest) backingObject;
        }
    }

    /**
     * The most common way to set the items. If you need
     * to delay setting the items then call the method
     * with the AllItems interface.
     */
    public void setItems(Collection<?> items) {
        this.items = items;
    }

    /**
     * Use to set one page of items.
     */
    public void setItems(PageItems pageItems) {
        this.pageItems = pageItems;
    }

    /**
     * Use if you need to delay calculating the items until
     * some other action, such as saving to a worksheet.
     */
    public void setItems(AllItems allItems) {
        this.allItems = allItems;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public void setExportTypes(ExportType... exportTypes) {
        this.exportTypes = exportTypes;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setStateAttr(String stateAttr) {
        this.stateAttr = stateAttr;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public void autoFilterAndSort(boolean autoFilterAndSort) {
        this.autoFilterAndSort = autoFilterAndSort;
    }

    public void addFilterMatcher(MatcherKey key, FilterMatcher matcher) {
        if (filterMatchers == null) {
            filterMatchers = new HashMap<MatcherKey, FilterMatcher>();
        }
        filterMatchers.put(key, matcher);
    }

    public void addFilterMatcherMap(FilterMatcherMap filterMatcherMap) {
        this.filterMatcherMap = filterMatcherMap;
    }

    public void setColumnSort(ColumnSort columnSort) {
        this.columnSort = columnSort;
    }

    public void setRowFilter(RowFilter rowFilter) {
        this.rowFilter = rowFilter;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }

    public void setMaxRowsIncrements(int... maxRowsIncrements) {
        this.maxRowsIncrements = maxRowsIncrements;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void addRowObject(Object addedRowObject) {
        this.addedRowObject = addedRowObject;
    }

    public void saveWorksheet(WorksheetSaver worksheetSaver) {
        this.worksheetSaver = worksheetSaver;
    }

    public boolean isExporting() {
        return getExportType() != null;
    }

    public ExportType getExportType() {
        LimitActionFactory actionFactory = new LimitActionFactory(id, request.getParameterMap());
        return actionFactory.getExportType();
    }

    /**
     * Generate the view.
     *
     * @return An html generated table will return the String markup. An export will be written out
     *         to the response and this method will return null.
     */
    public String render() {
        tableFacade.setEditable(editable);

        if (worksheetSaver != null) {
            TableModelUtils.saveWorksheet(tableFacade, worksheetSaver);
        }

        if (preferences != null) {
            tableFacade.setPreferences(preferences);
        }

        if (messages != null) {
            tableFacade.setMessages(messages);
        }

        if (exportTypes != null) {
            tableFacade.setExportTypes(exportTypes);
        }

        if (stateAttr != null) {
            tableFacade.setStateAttr(stateAttr);
        }

        if (state != null) {
            tableFacade.setState(state);
        }

        if (filterMatchers != null) {
            for (Entry<MatcherKey, FilterMatcher> entry : filterMatchers.entrySet()) {
                tableFacade.addFilterMatcher(entry.getKey(), entry.getValue());
            }
        }

        if (filterMatcherMap != null) {
            tableFacade.addFilterMatcherMap(filterMatcherMap);
        }

        if (columnSort != null) {
            tableFacade.setColumnSort(columnSort);
        }

        if (rowFilter != null) {
            tableFacade.setRowFilter(rowFilter);
        }

        if (maxRows != 0) {
            tableFacade.setMaxRows(maxRows);
        }

        if (maxRowsIncrements != null) {
            tableFacade.setMaxRowsIncrements(maxRowsIncrements);
        }

        if (limit != null) {
            tableFacade.setLimit(limit);
        }

        if (pageItems != null) {
            items = getItems(tableFacade, pageItems);
        } else if (allItems != null) {
            items = allItems.getItems();
        }
        
        tableFacade.setItems(items);
        tableFacade.autoFilterAndSort(autoFilterAndSort);

        if (table != null) {
            tableFacade.setTable(table);
        }
        
        if (toolbar != null) {
            tableFacade.setToolbar(toolbar);
        }

        if (view != null) {
            tableFacade.setView(view);
        }

        Worksheet worksheet = tableFacade.getWorksheet();
        if (editable && worksheet.isAddingRow()) {
        	if (addedRowObject != null) {
        		tableFacade.addWorksheetRow(addedRowObject);
        	} else {
        		tableFacade.addWorksheetRow();
        	}
        }

        if (editable && worksheet.isRemovingRow()) {
            tableFacade.removeWorksheetRow();
        }

        return tableFacade.render();
    }
}
