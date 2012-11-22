<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 -->
<@fkMacros.pageHeader /><@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：添加baseRulesForm </div></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%">标题:&nbsp;</th>
		<td width="35%" colspan="3">${baseRulesModel.title?default('')}</td>
	</tr>
	<tr>
		<th width="15%">制定单位:&nbsp;</th>
		<td width="35%">${baseRulesModel.formUnit?default('')}</td>
		<th width="15%">实施单位:&nbsp;</th>
		<td width="35%">${baseRulesModel.implUnit?default('')}</td>
	</tr>
	<tr>
		<th width="15%">类型:&nbsp;</th>
		<td width="35%"><@enum.getSelectEnum code="${baseRulesModel.rulesType?default('')}"/></td>
		<th width="15%">发布时间:&nbsp;</th>
		<td width="35%">${baseRulesModel.releaseDate?default('')}</td>
	</tr>
	<tr>
		<th width="15%">内容:&nbsp;</th>
		<td colspan="3">${baseRulesModel.content?default('')}</td>
	</tr>
	<tr>
		<th width="15%">附件:&nbsp;</th>
		<td width="35%" colspan="3">
			<div>
				<#list fkAnnexModels?if_exists as o>
					<div><img id="img${o.id}" src="${resourcePath}/default/img/sc.gif" title="删除此附件" border="0" style="cursor: hand;" onclick="removeAnnex('${o.id}')">&nbsp;&nbsp;&nbsp;<a href="${contextPath}/fkAnnex_download.xhtml?id=${o.id}" target="_blank" title="点击下载">${o.annexName}</a></div>
				</#list>
			</div>
		</td>
	</tr>
</table>
<@fkMacros.pageFooter />
