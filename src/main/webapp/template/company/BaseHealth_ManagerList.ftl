<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 ManagerList
 -->
<@fkMacros.pageHeader />
<@enum.initEnumXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz"><#if companyInfoModel?if_exists != "">${companyInfoModel.companyName}的</#if>健康防治列表</div></td>
    </tr>
</table>
<@s.form id="baseHealthForm" action="baseHealth_managerList.xhtml?id=${companyInfoModel.id}"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="left">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
		        <th width="10%" align="right">工种 &nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <input type="hidden" id="companyId" name="baseHealth.companyInfo.id" value="${companyInfoModel.id}"/>
		           <select id="workType" name="baseHealthModel.workType" />
		        </td>
				<th width="10%" align="right">工作场所&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="workPlace" name="baseHealthModel.workPlace"  />
		        </td>
		        <th width="10%" align="right">职工人数&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="staffNum" name="baseHealthModel.staffNum" />
		        </td>
		        <td width="10%">
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('baseHealthModel','filter');"/>
		        </td>
	     	</tr>

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
			<@util.company_addStand '添加'> obj="baseHealth_insert.xhtml"</@util.company_addStand>
			<@util.menu_edit '编 辑'> obj="baseHealth" </@util.menu_edit>
			<@util.company_delAll '删 除'> obj="baseHealth_remove.xhtml" </@util.company_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=baseHealthModels  limit=baseHealthModels.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="baseHealth" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="baseHealthModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${baseHealth.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyName" title="企业名称" >
					${baseHealth.companyInfo.companyName}
				</@jmesa.htmlColumn >
				<@jmesa.htmlColumn property="addre" title="企业地址" >
					${baseHealth.companyInfo.address}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="staffNum" title="职工人数" />
				<@jmesa.htmlColumn property="workPlace" title="工作场所" />
				<@jmesa.htmlColumn property="workType" title="工种" >
					<@enum.getSelectEnum '${baseHealth.workType}'/>
				</@jmesa.htmlColumn>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>

</@s.form>


<script type="text/javascript">
	if(get("workType")){enumObj.initSelect("workType","workType");}
	<#if baseHealthModel.workType?if_exists != "">jQuery("#workType").val("${baseHealthModel.workType}");</#if>
	
	function checkNum(txtNum)//判断整数
	{
	    var reg=/^\d*$/gi;
	    var isNum=reg.exec(trimAll(txtNum.value)); 
	    if(!isNum)
	    {
	        txtNum.value="";
	    }
	}
	
	function trimAll(data)
	{
	  var reg=/^ +| +$/g;
	  var str=data.replace(reg,"");
	  return str;
	}
	
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyAccident_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

