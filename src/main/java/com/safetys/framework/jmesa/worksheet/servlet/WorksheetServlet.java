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
package com.safetys.framework.jmesa.worksheet.servlet;

import static com.safetys.framework.jmesa.core.message.MessagesFactory.getMessages;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safetys.framework.jmesa.core.message.Messages;
import com.safetys.framework.jmesa.web.HttpServletRequestWebContext;
import com.safetys.framework.jmesa.web.WebContext;
import com.safetys.framework.jmesa.worksheet.WorksheetUpdater;

/**
 * The default invoker of the worksheet updater.
 *
 * @since 2.3
 * @author Jeff Johnston
 */
public class WorksheetServlet extends HttpServlet {
    private static final long serialVersionUID = -1828287062540295043L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        WebContext webContext = new HttpServletRequestWebContext(request);
        Messages messages = getMessages(webContext);
        WorksheetUpdater worksheetUpdater = new WorksheetUpdater();
        String columnStatus = worksheetUpdater.update(messages, webContext);
        
        try {
            response.getWriter().print(columnStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
