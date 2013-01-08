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
<@fkMacros.formValidator 'jxSalesForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxSalesForm </div></td>
  </tr>
</table>
<@s.form id="jxSalesForm" action="jxSales_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxSalesModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxSalesForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsDept:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsDept" name="jxSalesModel.jsDept" cssStyle="width:75%"/>
			<ui:v for="jsDept" rule="require" warn="不允许以空格为开始" empty="jsDept不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsOcode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsOcode" name="jxSalesModel.jsOcode" cssStyle="width:75%"/>
			<ui:v for="jsOcode" rule="require" warn="不允许以空格为开始" empty="jsOcode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsNum:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsNum" name="jxSalesModel.jsNum" cssStyle="width:75%"/>
			<ui:v for="jsNum" rule="require" warn="不允许以空格为开始" empty="jsNum不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsLastCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsLastCode" name="jxSalesModel.jsLastCode" cssStyle="width:75%"/>
			<ui:v for="jsLastCode" rule="require" warn="不允许以空格为开始" empty="jsLastCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsWarehouse:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsWarehouse" name="jxSalesModel.jsWarehouse" cssStyle="width:75%"/>
			<ui:v for="jsWarehouse" rule="require" warn="不允许以空格为开始" empty="jsWarehouse不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsCustomer:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsCustomer" name="jxSalesModel.jsCustomer" cssStyle="width:75%"/>
			<ui:v for="jsCustomer" rule="require" warn="不允许以空格为开始" empty="jsCustomer不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsSettlement:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsSettlement" name="jxSalesModel.jsSettlement" cssStyle="width:75%"/>
			<ui:v for="jsSettlement" rule="require" warn="不允许以空格为开始" empty="jsSettlement不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsUser:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsUser" name="jxSalesModel.jsUser" cssStyle="width:75%"/>
			<ui:v for="jsUser" rule="require" warn="不允许以空格为开始" empty="jsUser不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsDate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsDate" name="jxSalesModel.jsDate" cssStyle="width:75%"/>
			<ui:v for="jsDate" rule="require" warn="不允许以空格为开始" empty="jsDate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsRate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsRate" name="jxSalesModel.jsRate" cssStyle="width:75%"/>
			<ui:v for="jsRate" rule="require" warn="不允许以空格为开始" empty="jsRate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsDelivery:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsDelivery" name="jxSalesModel.jsDelivery" cssStyle="width:75%"/>
			<ui:v for="jsDelivery" rule="require" warn="不允许以空格为开始" empty="jsDelivery不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsRemark:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsRemark" name="jxSalesModel.jsRemark" cssStyle="width:75%"/>
			<ui:v for="jsRemark" rule="require" warn="不允许以空格为开始" empty="jsRemark不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
