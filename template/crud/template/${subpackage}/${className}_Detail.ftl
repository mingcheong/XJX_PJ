<#include "/macro.include"/>
<#include "/page_copyright.include">
<#assign className = table.className>   
<#assign contentPath = table.contentName> 
<#assign classNameLower = className?uncap_first>
${"<@fkMacros.pageHeader />"}
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：添加${classNameLower}Form </div></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			${"<@util.menu_back '返 回'/>"}
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<@generateColumnProperties />
</table>
${"<@fkMacros.pageFooter />"}
<#macro generateColumnProperties>
<#list table.columns as column>
	<#if !column.pk && column.columnNameLower != "isDeleted"  && column.columnNameLower != "firstarea" && column.columnNameLower != "secondarea" && column.columnNameLower != "thirdarea" && column.columnNameLower != "fourtharea" && column.columnNameLower != "fiftharea">
	<tr>
		<th width="15%">&nbsp;${column.columnNameLower }:</th>
		<td width="35%">&nbsp;${"<@s.textfield "} readonly="true" name="${classNameLower}Model.${column.columnNameLower }" cssStyle="width:75%"/></td>
	</tr>
	</#if>
</#list>
</#macro>