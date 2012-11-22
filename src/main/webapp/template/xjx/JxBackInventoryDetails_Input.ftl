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
<@fkMacros.formValidator 'jxBackInventoryDetailsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxBackInventoryDetailsForm </div></td>
  </tr>
</table>
<@s.form id="jxBackInventoryDetailsForm" action="jxBackInventoryDetails_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxBackInventoryDetailsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxBackInventoryDetailsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdBackInventory:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdBackInventory" name="jxBackInventoryDetailsModel.jbdBackInventory" cssStyle="width:75%"/>
			<ui:v for="jbdBackInventory" rule="require" warn="不允许以空格为开始" empty="jbdBackInventory不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdBarcode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdBarcode" name="jxBackInventoryDetailsModel.jbdBarcode" cssStyle="width:75%"/>
			<ui:v for="jbdBarcode" rule="require" warn="不允许以空格为开始" empty="jbdBarcode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdCode" name="jxBackInventoryDetailsModel.jbdCode" cssStyle="width:75%"/>
			<ui:v for="jbdCode" rule="require" warn="不允许以空格为开始" empty="jbdCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdName" name="jxBackInventoryDetailsModel.jbdName" cssStyle="width:75%"/>
			<ui:v for="jbdName" rule="require" warn="不允许以空格为开始" empty="jbdName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdUnit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdUnit" name="jxBackInventoryDetailsModel.jbdUnit" cssStyle="width:75%"/>
			<ui:v for="jbdUnit" rule="require" warn="不允许以空格为开始" empty="jbdUnit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdQuantity:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdQuantity" name="jxBackInventoryDetailsModel.jbdQuantity" cssStyle="width:75%"/>
			<ui:v for="jbdQuantity" rule="require" warn="不允许以空格为开始" empty="jbdQuantity不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdCost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdCost" name="jxBackInventoryDetailsModel.jbdCost" cssStyle="width:75%"/>
			<ui:v for="jbdCost" rule="require" warn="不允许以空格为开始" empty="jbdCost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdAmount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdAmount" name="jxBackInventoryDetailsModel.jbdAmount" cssStyle="width:75%"/>
			<ui:v for="jbdAmount" rule="require" warn="不允许以空格为开始" empty="jbdAmount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdNum:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdNum" name="jxBackInventoryDetailsModel.jbdNum" cssStyle="width:75%"/>
			<ui:v for="jbdNum" rule="require" warn="不允许以空格为开始" empty="jbdNum不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdOverflow:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdOverflow" name="jxBackInventoryDetailsModel.jbdOverflow" cssStyle="width:75%"/>
			<ui:v for="jbdOverflow" rule="require" warn="不允许以空格为开始" empty="jbdOverflow不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jbdRate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jbdRate" name="jxBackInventoryDetailsModel.jbdRate" cssStyle="width:75%"/>
			<ui:v for="jbdRate" rule="require" warn="不允许以空格为开始" empty="jbdRate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
