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
    <td align="center" ><div class="dqwz">您现在的位置：查看用户详情 </div></td>
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
		<th width="15%"><font color="#FF0000">*</font>帐号名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="username" name="fkUserModel.username" readonly="true" cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>真实姓名:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="truename" name="fkUserModel.truename" readonly="true" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>身份证号码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="idCard" name="fkUserModel.idCard" readonly="true" cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>出生年月:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="bornDate" name="fkUserModel.bornDate" readonly="true"  cssStyle="width:75%" />
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>组织机构:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="fatherName" readonly="true" value="${orgsName?default('')}"  cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>固定电话:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="userPhone" name="fkUserModel.userPhone" readonly="true" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">电邮邮件:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="userEmail" name="fkUserModel.userEmail" readonly="true" cssStyle="width:75%"/>
		</td>
		<th width="15%">手机号码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="userMobile" name="fkUserModel.userMobile" readonly="true" cssStyle="width:75%"/>
		</td>
	</tr>
	
	<tr>
		<th width="15%"><font color="#FF0000">*</font>创建时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="createDate" name="fkUserModel.createDate" readonly="true" cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>修改时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="modifyDate" name="fkUserModel.modifyDate" readonly="true" cssStyle="width:75%"/>
		</td>
	</tr>
</table>
<@fkMacros.pageFooter />
