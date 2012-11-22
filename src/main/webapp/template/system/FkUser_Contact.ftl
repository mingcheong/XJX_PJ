<@fkMacros.pageHeader />
<style>

</style>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：通迅录列表</div></td>
    </tr>
</table>

<TABLE  border=0 cellSpacing=0 cellPadding=0 width="100%" align=center class="table_list_my">
<tr>
	<th>机构名称</th>
	<th>真实姓名</th>
	<th>性别</th>
	<th>出生年月</th>
	<th>固定电话</th>
	<th>身份证</th>
<tr>

<#assign columnName=0>
<#assign columnCount=0>
<#list fkUserModels as item>
<tr>
	<#if columnName != item.fkOrganize.id>
		<#assign columnName=item.fkOrganize.id>
		<@getColumCount userList=fkUserModels organId=item.fkOrganize.id/>
		<td rowSpan="${columnCount}" style="background:#f0f0f0;border-right:solid 1px ">${item.fkOrganize.orgName}</td>
		<#assign columnCount=0>
	</#if>

	<td>${item.truename}</td>
	<td>${item.sex}</td>
	<td>${item.bornDate}</td>
	<td>${item.userPhone}</td>
	<td>${item.idCard}</td>
	
</tr>
</#list>
</table>

<#macro getColumCount userList,organId>
 	<#list userList as utemp>
 		<#if utemp.fkOrganize.id == organId>
 			<#assign columnCount=columnCount+1>
 		</#if>
 	</#list>
</#macro> 


<@fkMacros.pageFooter />

