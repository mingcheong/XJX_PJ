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
<@fkMacros.formValidator 'jxInInventoryDetailsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxInInventoryDetailsForm </div></td>
  </tr>
</table>
<@s.form id="jxInInventoryDetailsForm" action="jxInInventoryDetails_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxInInventoryDetailsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxInInventoryDetailsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidInInventory:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidInInventory" name="jxInInventoryDetailsModel.jidInInventory" cssStyle="width:75%"/>
			<ui:v for="jidInInventory" rule="require" warn="不允许以空格为开始" empty="jidInInventory不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidBarcode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidBarcode" name="jxInInventoryDetailsModel.jidBarcode" cssStyle="width:75%"/>
			<ui:v for="jidBarcode" rule="require" warn="不允许以空格为开始" empty="jidBarcode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidCode" name="jxInInventoryDetailsModel.jidCode" cssStyle="width:75%"/>
			<ui:v for="jidCode" rule="require" warn="不允许以空格为开始" empty="jidCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidName" name="jxInInventoryDetailsModel.jidName" cssStyle="width:75%"/>
			<ui:v for="jidName" rule="require" warn="不允许以空格为开始" empty="jidName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidUnit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidUnit" name="jxInInventoryDetailsModel.jidUnit" cssStyle="width:75%"/>
			<ui:v for="jidUnit" rule="require" warn="不允许以空格为开始" empty="jidUnit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidQuantity:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidQuantity" name="jxInInventoryDetailsModel.jidQuantity" cssStyle="width:75%"/>
			<ui:v for="jidQuantity" rule="require" warn="不允许以空格为开始" empty="jidQuantity不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidCost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidCost" name="jxInInventoryDetailsModel.jidCost" cssStyle="width:75%"/>
			<ui:v for="jidCost" rule="require" warn="不允许以空格为开始" empty="jidCost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidAmount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidAmount" name="jxInInventoryDetailsModel.jidAmount" cssStyle="width:75%"/>
			<ui:v for="jidAmount" rule="require" warn="不允许以空格为开始" empty="jidAmount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidNum:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidNum" name="jxInInventoryDetailsModel.jidNum" cssStyle="width:75%"/>
			<ui:v for="jidNum" rule="require" warn="不允许以空格为开始" empty="jidNum不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidOverflow:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidOverflow" name="jxInInventoryDetailsModel.jidOverflow" cssStyle="width:75%"/>
			<ui:v for="jidOverflow" rule="require" warn="不允许以空格为开始" empty="jidOverflow不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jidRate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jidRate" name="jxInInventoryDetailsModel.jidRate" cssStyle="width:75%"/>
			<ui:v for="jidRate" rule="require" warn="不允许以空格为开始" empty="jidRate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
