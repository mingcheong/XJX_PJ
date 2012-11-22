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
<@enum.initEnumXML/>
<@enum.initAreaXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：健康防治列表</div></td>
    </tr>
</table>
<@s.form id="baseHealthForm" action="baseHealth_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="8%" align="right">企业名称&nbsp;&nbsp;&nbsp;</th>
				<td width="10%">
					<@s.textfield id="comapnyName" name="baseHealthModel.companyInfo.companyName" />
				</td>
				<th width="8%" align="right">工种&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <select id="workType" name="baseHealthModel.workType" />
		        </td>
				<th width="8%" align="right">工作场所&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="workPlace" name="baseHealthModel.workPlace"  />
		        </td>
		        <th width="8%" align="right">职工人数&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		        	<@s.textfield id="staffNum" name="baseHealthModel.staffNum" onChange="checkNum(this)"/>
		        </td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('baseHealthModel','filter');"/>
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
			<!--<@util.menu_add '添 加'> obj="baseHealth" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="baseHealth" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="baseHealth" </@util.menu_delAll>-->
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=baseHealthModels  limit=baseHealthModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="baseHealth" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="baseHealthModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${baseHealth.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyName" title="企业名称">
					<a href="baseHealth_detail.xhtml?id=${baseHealth.id}" title="点击查看详细信息!">${baseHealth.companyInfo.companyName}</a>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="addre" title="地址" >
					${baseHealth.companyInfo.address}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="accidentContact" title="企业所在区域">
					<@enum.getSelectArea '${baseHealth.companyInfo.firstArea}'/>
					&nbsp;
					<@enum.getSelectArea '${baseHealth.companyInfo.secondArea}'/>
					&nbsp;
					<@enum.getSelectArea '${baseHealth.companyInfo.thirdArea}'/>
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
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('baseHealth_report.xhtml?' + parameterString);
    }
    
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
</script>
<@fkMacros.pageFooter />

