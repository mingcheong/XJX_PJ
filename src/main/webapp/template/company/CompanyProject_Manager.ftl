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
<@enum.initAreaXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：建设项目查询列表</div></td>
    </tr>
</table>
<@s.form id="companyProjectForm" action="companyProject_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="10%" align="right">企业名称 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
					<@s.textfield id="companyName" name="companyProjectModel.companyInfo.companyName" cssStyle="width:90%"/>
		        </td>
				<th width="10%" align="right">项目名称 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
					<@s.textfield id="projectName" name="companyProjectModel.projectName" cssStyle="width:90%"/>
		        </td>
	     		<th width="10%" align="right">项目地址 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" >
		        	<@s.textfield id="projectAddress" name="companyProjectModel.projectAddress" />
		        </td>
		        <th width="10%" align="right">项目投资额 &nbsp;&nbsp;&nbsp;</th>
		        
		        <td width="15%">
		        	<@s.textfield id="projectInvestment" name="companyProjectModel.projectInvestment" cssStyle="width:100px" onChange="checkDecimal(this)"/>&nbsp;万元
		        </td>
	        </tr>
	        <tr>
	        	
		        <th width="10%" align="right">项目类型 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <select id="projectType" name="companyProjectModel.projectType" />
		        </td>
				<th width="10%" align="right">土地类型 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	 <select id="landType" name="companyProjectModel.landType" />
		        </td>
		        <th width="10%" align="right">设施类型 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%" colspan="2">
		        	 <select id="facilitiesType" name="companyProjectModel.facilitiesType" />
		        </td>
		       <td width="10%">
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyProjectModel','filter');"/>
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
			<!--<@util.menu_add '添 加'> obj="companyProject" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="companyProject" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="companyProject" </@util.menu_delAll>-->
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyProjectModels  limit=companyProjectModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyProject" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyProjectModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyProject.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="projectName" title="项目名称" >
					<a href="companyProject_detail.xhtml?id=${companyProject.id}" title="点击查看详细信息!">${companyProject.projectName}</a>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyName" title="企业名称" >
					${companyProject.companyInfo.companyName}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="area" title="企业所在区域" >
					<@enum.getSelectArea '${companyProject.companyInfo.firstArea}'/>
					&nbsp;
					<@enum.getSelectArea '${companyProject.companyInfo.secondArea}'/>
					&nbsp;
					<@enum.getSelectArea '${companyProject.companyInfo.thirdArea}'/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="projectAddress" title="项目地址" />
				<@jmesa.htmlColumn property="projectInvestment" title="项目投资额" />
				<@jmesa.htmlColumn property="projectType" title="项目类型" >
					<@enum.getSelectEnum companyProject.projectType/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="facilitiesType" title="设施类型" >
					<@enum.getSelectEnum companyProject.facilitiesType/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="landType" title="土地性质" >
					<@enum.getSelectEnum companyProject.landType/>
				</@jmesa.htmlColumn>
			
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>

</@s.form>


<script type="text/javascript">

	if(get("projectType")){enumObj.initSelect("projectType","projectType");}
	if(get("landType")){enumObj.initSelect("landType","landType");}
	if(get("facilitiesType")){enumObj.initSelect("facilitiesType","facilitiesType");}

	<#if companyProjectModel.projectType?if_exists != "">jQuery("#projectType").val("${companyProjectModel.projectType}");</#if>
	<#if companyProjectModel.landType?if_exists != "">jQuery("#landType").val("${companyProjectModel.landType}");</#if>
	<#if companyProjectModel.facilitiesType?if_exists != "">jQuery("#facilitiesType").val("${companyProjectModel.facilitiesType}");</#if>
	
	function checkDecimal(txtNum)//判断是否是数值
	{
	    if(isNaN(txtNum.value))
	    {
	    	txtNum.value="";
	    }
	}

	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyProject_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

