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
<@fkMacros.formValidator 'jxSalesDetailsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxSalesDetailsForm </div></td>
  </tr>
</table>
<@s.form id="jxSalesDetailsForm" action="jxSalesDetails_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxSalesDetailsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxSalesDetailsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdSales:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdSales" name="jxSalesDetailsModel.jsdSales" cssStyle="width:75%"/>
			<ui:v for="jsdSales" rule="require" warn="不允许以空格为开始" empty="jsdSales不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdBarcode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdBarcode" name="jxSalesDetailsModel.jsdBarcode" cssStyle="width:75%"/>
			<ui:v for="jsdBarcode" rule="require" warn="不允许以空格为开始" empty="jsdBarcode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdCode" name="jxSalesDetailsModel.jsdCode" cssStyle="width:75%"/>
			<ui:v for="jsdCode" rule="require" warn="不允许以空格为开始" empty="jsdCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdName" name="jxSalesDetailsModel.jsdName" cssStyle="width:75%"/>
			<ui:v for="jsdName" rule="require" warn="不允许以空格为开始" empty="jsdName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdUnit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdUnit" name="jxSalesDetailsModel.jsdUnit" cssStyle="width:75%"/>
			<ui:v for="jsdUnit" rule="require" warn="不允许以空格为开始" empty="jsdUnit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdQuantity:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdQuantity" name="jxSalesDetailsModel.jsdQuantity" cssStyle="width:75%"/>
			<ui:v for="jsdQuantity" rule="require" warn="不允许以空格为开始" empty="jsdQuantity不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdCost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdCost" name="jxSalesDetailsModel.jsdCost" cssStyle="width:75%"/>
			<ui:v for="jsdCost" rule="require" warn="不允许以空格为开始" empty="jsdCost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdAmount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdAmount" name="jxSalesDetailsModel.jsdAmount" cssStyle="width:75%"/>
			<ui:v for="jsdAmount" rule="require" warn="不允许以空格为开始" empty="jsdAmount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdNum:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdNum" name="jxSalesDetailsModel.jsdNum" cssStyle="width:75%"/>
			<ui:v for="jsdNum" rule="require" warn="不允许以空格为开始" empty="jsdNum不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdOverflow:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdOverflow" name="jxSalesDetailsModel.jsdOverflow" cssStyle="width:75%"/>
			<ui:v for="jsdOverflow" rule="require" warn="不允许以空格为开始" empty="jsdOverflow不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdRate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdRate" name="jxSalesDetailsModel.jsdRate" cssStyle="width:75%"/>
			<ui:v for="jsdRate" rule="require" warn="不允许以空格为开始" empty="jsdRate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdPag:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdPag" name="jxSalesDetailsModel.jsdPag" cssStyle="width:75%"/>
			<ui:v for="jsdPag" rule="require" warn="不允许以空格为开始" empty="jsdPag不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdWcost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdWcost" name="jxSalesDetailsModel.jsdWcost" cssStyle="width:75%"/>
			<ui:v for="jsdWcost" rule="require" warn="不允许以空格为开始" empty="jsdWcost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdWamount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdWamount" name="jxSalesDetailsModel.jsdWamount" cssStyle="width:75%"/>
			<ui:v for="jsdWamount" rule="require" warn="不允许以空格为开始" empty="jsdWamount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdPre:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdPre" name="jxSalesDetailsModel.jsdPre" cssStyle="width:75%"/>
			<ui:v for="jsdPre" rule="require" warn="不允许以空格为开始" empty="jsdPre不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdSamount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdSamount" name="jxSalesDetailsModel.jsdSamount" cssStyle="width:75%"/>
			<ui:v for="jsdSamount" rule="require" warn="不允许以空格为开始" empty="jsdSamount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsdCustitem:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsdCustitem" name="jxSalesDetailsModel.jsdCustitem" cssStyle="width:75%"/>
			<ui:v for="jsdCustitem" rule="require" warn="不允许以空格为开始" empty="jsdCustitem不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
