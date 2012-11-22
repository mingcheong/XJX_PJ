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
package com.safetys.framework.jmesa.view.excel;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.safetys.framework.jmesa.core.CoreContext;
import com.safetys.framework.jmesa.view.AbstractViewExporter;
import com.safetys.framework.jmesa.view.View;

/**
 * @since 2.1
 * @author jeff jie
 */
public class ExcelViewExporter extends AbstractViewExporter {
	public ExcelViewExporter(View view, CoreContext coreContext, HttpServletResponse response) {
        super(view, coreContext, response);
    }

    public ExcelViewExporter(View view, CoreContext coreContext, HttpServletResponse response, String fileName) {
        super(view, coreContext, response, fileName);
    }

    public void export()
            throws Exception {
        HttpServletResponse response = super.getResponse();
        HSSFWorkbook workbook = (HSSFWorkbook) this.getView().render();
        responseHeaders(response);
        workbook.write(response.getOutputStream());
    }

    public String getContextType() {
        return "application/vnd.ms-excel;charset=UTF-8";
    }

    public String getExtensionName() {
        return "xls";
    }
}
