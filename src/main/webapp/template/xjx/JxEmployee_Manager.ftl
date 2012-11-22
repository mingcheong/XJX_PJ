<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 -->
<@fkMacros.pageHeader />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：员工档案维护</div></td>
    </tr>
</table>
<@s.form id="jxEmployeeForm" action="jxEmployee_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">员工编号:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jeCode" name="jxEmployeeModel.jeCode" cssStyle="width:75%"/>
				</td>
				<th width="15%">员工姓名:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jeName" name="jxEmployeeModel.jeName" cssStyle="width:75%"/>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('jxEmployeeModel','filter');"/>
		        </td>
	     	</tr>
	    </table>		    
    </td>
  </tr>
  <tr>
    <td class="tool-toggle-td"><a id="J_SearchBoxToggle" state="show" hidefocus="true" href="javascript:;" title="收起/展开" onClick="toggleQueryPanel()" class="tool-toggle"></a></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_add '添 加'> obj="jxEmployee" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="jxEmployee" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="jxEmployee" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=jxEmployeeModels  limit=jxEmployeeModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="jxEmployee" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="jxEmployeeModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${jxEmployee.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="jeCode" title="员工编号" width="80px;"/>
				<@jmesa.htmlColumn property="jePlace" title="籍贯" width="60px;"/>
				<@jmesa.htmlColumn property="jeClazz" title="员工分类" width="60px;"/>
				<@jmesa.htmlColumn property="jeName" title="员工姓名" width="80px;"/>
				<@jmesa.htmlColumn property="jeDept.jdName" title="所属部门" width="80px;"/>
				<@jmesa.htmlColumn property="jeSex" title="性别" width="60px;" style="text-align: center;" >
					<#if jxEmployee.jeSex?if_exists == true>男<#else>女</#if>
				</@jmesa.htmlColumn>				
				<@jmesa.htmlColumn property="jeIdcard" title="身份证号" width="120px;"/>
				<@jmesa.htmlColumn property="jeDegree" title="学历" width="60px;">
					<#if jxEmployee.jeDegree == 1>小学
					<#elseif jxEmployee.jeDegree == 2>初中
					<#elseif jxEmployee.jeDegree == 3>高中
					<#elseif jxEmployee.jeDegree == 4>职高
					<#elseif jxEmployee.jeDegree == 5>中专
					<#elseif jxEmployee.jeDegree == 6>大专
					<#elseif jxEmployee.jeDegree == 7>本科
					<#elseif jxEmployee.jeDegree == 8>硕士
					<#elseif jxEmployee.jeDegree == 9>博士
					</#if>
				</@jmesa.htmlColumn>						
				<@jmesa.htmlColumn property="jeBirthday" title="生日" width="100px;"/>
				<@jmesa.htmlColumn property="jePhone" title="电话" width="100px;"/>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<script type="text/javascript">
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('jxEmployee_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

