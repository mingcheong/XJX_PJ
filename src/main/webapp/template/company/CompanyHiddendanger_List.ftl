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
<@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：重大隐患挂牌管理列表</div></td>
    </tr>
</table>
<@s.form id="companyHiddendangerForm" action="companyHiddendanger_list.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="10%" align="right">单位名称&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" align="right">
		        	<@s.textfield id="companyName" name="companyHiddendangerModel.companyInfoModel.companyName" cssStyle="width:150PX"/>	
		        </td>
				<th width="10%" align="right">隐患地址&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="dangerAddress" name="companyHiddendangerModel.dangerAddress" cssStyle="width:150PX"/>
		        </td>
				<th width="10%" align="right">单位区域&nbsp;&nbsp;&nbsp;</th>
		        <td>
		        	<div id="div-area"></div>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyHiddendangerModel','filter');"/>
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
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyHiddendangerModels limit=companyHiddendangerModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyHiddendanger" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyHiddendangerModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="序号" filterable=false sortable=false>
					${rowcount+((companyHiddendangerModel.pageNo-1)*companyHiddendangerModel.pageSize)}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyInfoModel.companyName" title="单位名称" ><a href="${contextPath}/companyHiddendanger_detail.xhtml?id=${companyHiddendanger.id}">${companyHiddendanger.companyInfoModel.companyName}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="code" title="隐患编号" />
				<@jmesa.htmlColumn property="dangerAddress" title="隐患地址" />
				<@jmesa.htmlColumn property="level" title="是否挂牌" >
					<#if companyHiddendanger.level?if_exists != "">
						<@enum.getSelectEnum code="${companyHiddendanger.level}"/>
					<#else>
						无
					</#if>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="dangerContact" title="联系人" />
				<@jmesa.htmlColumn property="dangerPhone" title="联系电话" />
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<@enum.selectAreas "companyHiddendangerModel.companyInfoModel","div-area","${companyHiddendangerModel?if_exists.companyInfoModel?if_exists.firstArea?if_exists}","${companyHiddendangerModel?if_exists.companyInfoModel?if_exists.secondArea?if_exists}","${companyHiddendangerModel?if_exists.companyInfoModel?if_exists.thirdArea?if_exists}","${companyHiddendangerModel?if_exists.companyInfoModel?if_exists.fouthArea?if_exists}","${companyHiddendangerModel?if_exists.companyInfoModel?if_exists.fifthArea?if_exists}" />
<@enum.initAllEnum /><script type="text/javascript"> <#if companyHiddendangerModel.level?if_exists != "">jQuery("#ReportType").val("${companyHiddendangerModel.level}");</#if></script>
<script type="text/javascript">
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyHiddendanger_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

