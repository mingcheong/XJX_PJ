<@fkMacros.pageHeader />
<@enum.initEnumXML />
<@fkMacros.formValidator 'baseNoticeForm'/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：通知公告 </div></td>
  </tr>
</table>
<@s.form id="baseNoticeForm" action="baseNotice_feedback.xhtml"  method="post" enctype="multipart/form-data">
<s:token />
	<@s.hidden name="baseNoticeModel.id" />
	<@s.hidden id="orgsId" name="baseNoticeModel.fkOrganizeModel.id"/>
	<@s.hidden id="userId" name="baseNoticeModel.fkUserModel.id"/>
	<@s.hidden name="baseNoticeModel.deleted"/>
	<@s.hidden name="baseNoticeModel.firstArea"/>
	<@s.hidden name="baseNoticeModel.secondArea"/>
	<@s.hidden name="baseNoticeModel.thirdArea"/>
	<@s.hidden name="baseNoticeModel.fourthArea"/>
	<@s.hidden name="baseNoticeModel.fifthArea"/>
	
	<@s.hidden name="baseNoticeUsersModel.id"/>
	<@s.hidden name="baseNoticeUsersModel.fkUserModel.id"/>
	<@s.hidden name="baseNoticeUsersModel.baseNoticeModel.id"/>
	<@s.hidden name="baseNoticeUsersModel.state"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="baseNoticeForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>通知标题:&nbsp;</th>
		<td width="35%" colspan="3">
			${baseNoticeModel.name}
		</td>
	</tr>
	<tr>
		<th width="15%">制定单位:&nbsp;</th>
		<td width="35%">
			${baseNoticeModel.ruleUnit}
		</td>
		<th width="15%">实施单位:&nbsp;</th>
		<td width="35%">
			${baseNoticeModel.implUnit}
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>通知类型:&nbsp;</th>
		<td width="35%">
			<@enum.getSelectEnum code="${baseNoticeModel.type}"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>发布时间:&nbsp;</th>
		<td width="35%">
			${baseNoticeModel.releaseDate}
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>内容:&nbsp;</th>
		<td colspan="3"> 
			${baseNoticeModel.content}
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			${baseNoticeModel.remark?default('')}
		</td>
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
		<th width="15%">反馈意见:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="remark" name="baseNoticeUsersModel.content" cssStyle="width:90%" rows="5"></@s.textarea>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
