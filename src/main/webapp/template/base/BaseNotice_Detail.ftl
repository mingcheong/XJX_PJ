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
    <td align="center" ><div class="dqwz">您现在的位置：通知公告 </div></td>
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
		<th width="15%">&nbsp;标题:</th>
		<td width="35%" colspan="3">&nbsp;${baseNoticeModel.name?default('')}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;制定单位:</th>
		<td width="35%">&nbsp;${baseNoticeModel.ruleUnit?default('')}</td>
		<th width="15%">&nbsp;实施单位:</th>
		<td width="35%">&nbsp;${baseNoticeModel.implUnit?default('')}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;类型:</th>
		<td width="35%">&nbsp;<@enum.getSelectEnum code="${baseNoticeModel.type}"/></td>
		<th width="15%">&nbsp;发布时间:</th>
		<td width="35%">&nbsp;${baseNoticeModel.releaseDate?default('')}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;内容:</th>
		<td width="35%" colspan="3">&nbsp;${baseNoticeModel.content?default('')}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;备注:</th>
		<td width="35%" colspan="3">&nbsp;${baseNoticeModel.remark?default('')}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;部门:</th>
		<td width="35%">&nbsp;${baseNoticeModel.fkOrganizeModel.orgName}</td>
		<th width="15%">&nbsp;填报人:</th>
		<td width="35%">&nbsp;${baseNoticeModel.fkUserModel.truename}</td>
	</tr>
	<tr>
		<th width="15%">附件:&nbsp;</th>
		<td width="35%" colspan="3">
		<#list fkAnnexModels?if_exists as o>
		<div><a href="${contextPath}/fkAnnex_download.xhtml?id=${o.id}" target="_blank" title="点击下载">${o.annexName}</a></div>
		</#list>
		</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;反馈信息:</th>
		<td width="35%" colspan="3">
		<table width="100%">
		<tr><td width="100px">姓名</td><td width="40px">阅读</td><td >反馈信息</td></tr>
		<#list baseNoticeModel?if_exists.baseNoticeUsersModels?if_exists as o>
		<tr><td width="100px">${o.fkUserModel.truename}</td><td width="40px"><#if o.state?if_exists == true>已阅<#else><font color="#FF0000">未阅</font></#if></td><td >${o.content?default('无')}</td></tr>
		</#list>
		</table>
		</td>
	</tr>
</table>
<@fkMacros.pageFooter />
