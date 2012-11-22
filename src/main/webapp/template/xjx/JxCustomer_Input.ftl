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
<@fkMacros.formValidator 'jxCustomerForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxCustomerForm </div></td>
  </tr>
</table>
<@s.form id="jxCustomerForm" action="jxCustomer_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxCustomerModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxCustomerForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcCode" name="jxCustomerModel.jcCode" cssStyle="width:75%"/>
			<ui:v for="jcCode" rule="require" warn="不允许以空格为开始" empty="jcCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcClazz:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcClazz" name="jxCustomerModel.jcClazz" cssStyle="width:75%"/>
			<ui:v for="jcClazz" rule="require" warn="不允许以空格为开始" empty="jcClazz不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcName" name="jxCustomerModel.jcName" cssStyle="width:75%"/>
			<ui:v for="jcName" rule="require" warn="不允许以空格为开始" empty="jcName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcAddress:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcAddress" name="jxCustomerModel.jcAddress" cssStyle="width:75%"/>
			<ui:v for="jcAddress" rule="require" warn="不允许以空格为开始" empty="jcAddress不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcPost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcPost" name="jxCustomerModel.jcPost" cssStyle="width:75%"/>
			<ui:v for="jcPost" rule="require" warn="不允许以空格为开始" empty="jcPost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcPhone:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcPhone" name="jxCustomerModel.jcPhone" cssStyle="width:75%"/>
			<ui:v for="jcPhone" rule="require" warn="不允许以空格为开始" empty="jcPhone不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcFullname:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcFullname" name="jxCustomerModel.jcFullname" cssStyle="width:75%"/>
			<ui:v for="jcFullname" rule="require" warn="不允许以空格为开始" empty="jcFullname不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcBank:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcBank" name="jxCustomerModel.jcBank" cssStyle="width:75%"/>
			<ui:v for="jcBank" rule="require" warn="不允许以空格为开始" empty="jcBank不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcAccount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcAccount" name="jxCustomerModel.jcAccount" cssStyle="width:75%"/>
			<ui:v for="jcAccount" rule="require" warn="不允许以空格为开始" empty="jcAccount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcDuty:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcDuty" name="jxCustomerModel.jcDuty" cssStyle="width:75%"/>
			<ui:v for="jcDuty" rule="require" warn="不允许以空格为开始" empty="jcDuty不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcUser:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcUser" name="jxCustomerModel.jcUser" cssStyle="width:75%"/>
			<ui:v for="jcUser" rule="require" warn="不允许以空格为开始" empty="jcUser不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcCanuse:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcCanuse" name="jxCustomerModel.jcCanuse" cssStyle="width:75%"/>
			<ui:v for="jcCanuse" rule="require" warn="不允许以空格为开始" empty="jcCanuse不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jcRemark:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcRemark" name="jxCustomerModel.jcRemark" cssStyle="width:75%"/>
			<ui:v for="jcRemark" rule="require" warn="不允许以空格为开始" empty="jcRemark不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
