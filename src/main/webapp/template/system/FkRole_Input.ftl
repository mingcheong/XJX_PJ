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
<@fkMacros.formValidator 'fkRoleForm'/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：添加角色 </div></td>
  </tr>
</table>
<@s.form id="fkRoleForm" action="fkRole_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="fkRoleModel.id" /><@s.hidden name="fkRole.resources" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="fkRoleForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="8%"><font color="#FF0000">*</font>角色编码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="roleCode" name="fkRoleModel.roleCode" cssStyle="width:20%"/>
			<ui:v for="roleCode" rule="require" warn="不允许以空格为开始" empty="roleCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="8%"><font color="#FF0000">*</font>角色名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="roleName" name="fkRoleModel.roleName" cssStyle="width:20%"/>
			<ui:v for="roleName" rule="require" warn="不允许以空格为开始" empty="roleName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="8%">排&nbsp;&nbsp;序:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="sortNum" name="fkRoleModel.sortNum" cssStyle="width:20%"/>
			<ui:v for="sortNum" rule="integer" require="false" warn="只许输入数字！" empty="&nbsp;" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="8%"><font color="#FF0000">*</font>创建时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="createDate" name="fkRoleModel.createDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"  cssStyle="width:20%"/>
			<ui:v for="createDate" rule="require" warn="不允许以空格为开始" empty="createDate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="8%"><font color="#FF0000">*</font>修改时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="modifyDate" name="fkRoleModel.modifyDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"  cssStyle="width:20%"/>
			<ui:v for="modifyDate" rule="require" warn="不允许以空格为开始" empty="modifyDate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
