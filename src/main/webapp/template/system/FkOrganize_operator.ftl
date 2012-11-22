<@fkMacros.pageHeader />
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
<#list fkUserModels?if_exists as item><#assign index=(item_index + 1) % 4>
	<#if index == 1><tr></#if>
		<td width="25%">&nbsp;&nbsp;<input type="checkbox" checked name="selectId" title="${item.truename}" value="${item.id}">&nbsp;${item.truename}</td>
</#list></tr></table>
<@fkMacros.pageFooter />