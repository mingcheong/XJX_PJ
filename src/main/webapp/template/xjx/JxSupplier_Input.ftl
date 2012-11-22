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
<@fkMacros.formValidator 'jxSupplierForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxSupplierForm </div></td>
  </tr>
</table>
<@s.form id="jxSupplierForm" action="jxSupplier_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxSupplierModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxSupplierForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsCode" name="jxSupplierModel.jsCode" cssStyle="width:75%"/>
			<ui:v for="jsCode" rule="require" warn="不允许以空格为开始" empty="jsCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsName" name="jxSupplierModel.jsName" cssStyle="width:75%"/>
			<ui:v for="jsName" rule="require" warn="不允许以空格为开始" empty="jsName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsAddr:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsAddr" name="jxSupplierModel.jsAddr" cssStyle="width:75%"/>
			<ui:v for="jsAddr" rule="require" warn="不允许以空格为开始" empty="jsAddr不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsPost:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsPost" name="jxSupplierModel.jsPost" cssStyle="width:75%"/>
			<ui:v for="jsPost" rule="require" warn="不允许以空格为开始" empty="jsPost不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsTele:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsTele" name="jxSupplierModel.jsTele" cssStyle="width:75%"/>
			<ui:v for="jsTele" rule="require" warn="不允许以空格为开始" empty="jsTele不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsFullname:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsFullname" name="jxSupplierModel.jsFullname" cssStyle="width:75%"/>
			<ui:v for="jsFullname" rule="require" warn="不允许以空格为开始" empty="jsFullname不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsBank:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsBank" name="jxSupplierModel.jsBank" cssStyle="width:75%"/>
			<ui:v for="jsBank" rule="require" warn="不允许以空格为开始" empty="jsBank不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsAccount:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsAccount" name="jxSupplierModel.jsAccount" cssStyle="width:75%"/>
			<ui:v for="jsAccount" rule="require" warn="不允许以空格为开始" empty="jsAccount不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsDutyno:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsDutyno" name="jxSupplierModel.jsDutyno" cssStyle="width:75%"/>
			<ui:v for="jsDutyno" rule="require" warn="不允许以空格为开始" empty="jsDutyno不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsContact:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsContact" name="jxSupplierModel.jsContact" cssStyle="width:75%"/>
			<ui:v for="jsContact" rule="require" warn="不允许以空格为开始" empty="jsContact不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsPerson:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsPerson" name="jxSupplierModel.jsPerson" cssStyle="width:75%"/>
			<ui:v for="jsPerson" rule="require" warn="不允许以空格为开始" empty="jsPerson不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsRemark:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsRemark" name="jxSupplierModel.jsRemark" cssStyle="width:75%"/>
			<ui:v for="jsRemark" rule="require" warn="不允许以空格为开始" empty="jsRemark不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsCanuse:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsCanuse" name="jxSupplierModel.jsCanuse" cssStyle="width:75%"/>
			<ui:v for="jsCanuse" rule="require" warn="不允许以空格为开始" empty="jsCanuse不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsCate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsCate" name="jxSupplierModel.jsCate" cssStyle="width:75%"/>
			<ui:v for="jsCate" rule="require" warn="不允许以空格为开始" empty="jsCate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsLimit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsLimit" name="jxSupplierModel.jsLimit" cssStyle="width:75%"/>
			<ui:v for="jsLimit" rule="require" warn="不允许以空格为开始" empty="jsLimit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsBalance:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsBalance" name="jxSupplierModel.jsBalance" cssStyle="width:75%"/>
			<ui:v for="jsBalance" rule="require" warn="不允许以空格为开始" empty="jsBalance不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jsCreatetime:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsCreatetime" name="jxSupplierModel.jsCreatetime" cssStyle="width:75%"/>
			<ui:v for="jsCreatetime" rule="require" warn="不允许以空格为开始" empty="jsCreatetime不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
