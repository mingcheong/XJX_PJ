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
<@fkMacros.formValidator 'fkResourceForm'/>
<#-- 验证参考 for 对应着你要验证的属性的ID,rule指的是验证规则，require表示是否必填。
	必填验证方式
	<ui:v for="邮编" rule="zip" require="true" warn="邮编格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="邮件" rule="email" require="true" warn="邮件格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="电话号码" rule="phone" require="true" warn="电话号码格式不正确！" empty="电话号码不允许为空！" pass="&nbsp;"/>
	<ui:v for="手机" rule="mobile" require="true" warn="手机格式不正确！" empty="手机不允许为空！" pass="&nbsp;"/>
	<ui:v for="URL" rule="url" require="true" warn="地址格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="IP" rule="ip" require="true" warn="IP格式不正确！" empty="IP不允许为空！" pass="&nbsp;"/>
	<ui:v for="帐号" rule="username" require="true" warn="帐号格式不正确！" empty="帐号不允许为空！" pass="&nbsp;"/>
	<ui:v for="数字" rule="integer" require="true" warn="数字格式不正确！" empty="数字不允许为空！" pass="&nbsp;"/>
	选填的验证方式
	<ui:v for="邮编" rule="zip" require="false" warn="邮编格式不正确！" empty="&nbsp;" pass="&nbsp;"/>
-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：添加菜单资源 </div></td>
  </tr>
</table>
<@s.form id="fkResourceForm" action="fkResource_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="fkResourceModel.id" /><@s.hidden name="fkResourceModel.hasChildren" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="fkResourceForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>菜单名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="resourceName" name="fkResourceModel.resourceName" cssStyle="width:65%"/>
			<ui:v for="resourceName" rule="require" warn="不允许以空格为开始" empty="菜单名称不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">访问地址:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="resourceUrl" name="fkResourceModel.resourceUrl" cssStyle="width:65%"/>
		</td>
	</tr>
	
	<tr>
		<th width="15%"><font color="#FF0000">*</font>上级菜单:&nbsp;</th>
		<td width="35%">
			<@s.hidden id="fatherId" name="fkResourceModel.fatherId" value="${fkResourceModel.fatherId?default('0')}"/>
			<@s.textfield id="fatherName" readonly="true" value="${fatherName?default('顶级资源')}" cssStyle="width:65%"/>&nbsp;
			<@fkMacros.radioTree 'fatherId','fatherName','fkResource_ajax.xhtml','${treeNodes}'/>
			<ui:v for="fatherId" rule="require" warn="不允许以空格为开始" empty="上级菜单不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>是否显示:&nbsp;</th>
		<td width="35%">
			<select name="fkResourceModel.isMenu">
				<option value="true" <#if fkResourceModel.isMenu>selected="selected"</#if> >显示</option>
				<option value="false" <#if !fkResourceModel.isMenu>selected="selected"</#if> >不显示</option>
			</select>
		</td>
	</tr>
	<tr>
		<th width="15%">菜单图标:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="resourceImg" name="fkResourceModel.resourceImg" cssStyle="width:65%"/>
		</td>
		<th width="15%">排&nbsp;&nbsp;	序:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="sortNum" name="fkResourceModel.sortNum" cssStyle="width:25%"/>
			<ui:v for="sortNum" rule="integer" require="false" warn="只能输入数字！" empty="&nbsp;" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">创建时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="createDate" name="fkResourceModel.createDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:45%"/>
			<ui:v for="createDate" rule="require" warn="不允许以空格为开始" empty="创建时间不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">修改时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="modifyDate" name="fkResourceModel.modifyDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:45%"/>
			<ui:v for="modifyDate" rule="require" warn="不允许以空格为开始" empty="修改时间不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
