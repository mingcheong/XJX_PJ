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
<@fkMacros.formValidator 'jxMoveInventoryDetailsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxMoveInventoryDetailsForm </div></td>
  </tr>
</table>
<@s.form id="jxMoveInventoryDetailsForm" action="jxMoveInventoryDetails_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxMoveInventoryDetailsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxMoveInventoryDetailsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdMoveInventory:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdMoveInventory" name="jxMoveInventoryDetailsModel.jmdMoveInventory" cssStyle="width:75%"/>
			<ui:v for="jmdMoveInventory" rule="require" warn="不允许以空格为开始" empty="jmdMoveInventory不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdBarcode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdBarcode" name="jxMoveInventoryDetailsModel.jmdBarcode" cssStyle="width:75%"/>
			<ui:v for="jmdBarcode" rule="require" warn="不允许以空格为开始" empty="jmdBarcode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdCode" name="jxMoveInventoryDetailsModel.jmdCode" cssStyle="width:75%"/>
			<ui:v for="jmdCode" rule="require" warn="不允许以空格为开始" empty="jmdCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdName" name="jxMoveInventoryDetailsModel.jmdName" cssStyle="width:75%"/>
			<ui:v for="jmdName" rule="require" warn="不允许以空格为开始" empty="jmdName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdUnit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdUnit" name="jxMoveInventoryDetailsModel.jmdUnit" cssStyle="width:75%"/>
			<ui:v for="jmdUnit" rule="require" warn="不允许以空格为开始" empty="jmdUnit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdQuantity:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdQuantity" name="jxMoveInventoryDetailsModel.jmdQuantity" cssStyle="width:75%"/>
			<ui:v for="jmdQuantity" rule="require" warn="不允许以空格为开始" empty="jmdQuantity不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdCost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdCost" name="jxMoveInventoryDetailsModel.jmdCost" cssStyle="width:75%"/>
			<ui:v for="jmdCost" rule="require" warn="不允许以空格为开始" empty="jmdCost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdAmount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdAmount" name="jxMoveInventoryDetailsModel.jmdAmount" cssStyle="width:75%"/>
			<ui:v for="jmdAmount" rule="require" warn="不允许以空格为开始" empty="jmdAmount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdNum:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdNum" name="jxMoveInventoryDetailsModel.jmdNum" cssStyle="width:75%"/>
			<ui:v for="jmdNum" rule="require" warn="不允许以空格为开始" empty="jmdNum不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdOverflow:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdOverflow" name="jxMoveInventoryDetailsModel.jmdOverflow" cssStyle="width:75%"/>
			<ui:v for="jmdOverflow" rule="require" warn="不允许以空格为开始" empty="jmdOverflow不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdRate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdRate" name="jxMoveInventoryDetailsModel.jmdRate" cssStyle="width:75%"/>
			<ui:v for="jmdRate" rule="require" warn="不允许以空格为开始" empty="jmdRate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdPack:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdPack" name="jxMoveInventoryDetailsModel.jmdPack" cssStyle="width:75%"/>
			<ui:v for="jmdPack" rule="require" warn="不允许以空格为开始" empty="jmdPack不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdWcost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdWcost" name="jxMoveInventoryDetailsModel.jmdWcost" cssStyle="width:75%"/>
			<ui:v for="jmdWcost" rule="require" warn="不允许以空格为开始" empty="jmdWcost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jmdWamount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jmdWamount" name="jxMoveInventoryDetailsModel.jmdWamount" cssStyle="width:75%"/>
			<ui:v for="jmdWamount" rule="require" warn="不允许以空格为开始" empty="jmdWamount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
