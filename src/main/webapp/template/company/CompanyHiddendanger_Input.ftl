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
<@enum.initAreaXML/>
<@fkMacros.formValidator 'companyHiddendangerForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：重大危险源 </div></td>
  </tr>
</table>
<@s.form id="companyHiddendangerForm" action="companyHiddendanger_addHidden.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyHiddendangerModel.id" /><@s.hidden name="companyHiddendangerModel.companyInfoModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center">
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyHiddendangerForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%">企业名称:&nbsp;</th>
		<td width="35%" colspan="2">
			<@s.textfield id="companyId" readonly="true" name="companyHiddendangerModel.companyInfoModel.companyName" cssStyle="width:75%"/>
		</td>
		<th width="15%">隐患编号:&nbsp;</th>
		<td width="35%" colspan="2">
			<@s.textfield id="code" readonly="true" value="11" name="companyHiddendangerModel.code" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>单位地址:&nbsp;</th>
		<td width="35%" colspan="2">
		<@s.textfield id="companyaddress" readonly="true" name="companyHiddendangerModel.companyInfoModel.address" cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>市级以上重点工程:&nbsp;</th>
		<td width="35%" colspan="2">
		<input type="radio" id="insure" name="companyHiddendangerModel.isAbove" value="true" <#if companyHiddendangerModel.isAbove?if_exists == true>checked="checked"</#if>>是
		<input type="radio" id="insure" name="companyHiddendangerModel.isAbove" value="false" <#if companyHiddendangerModel.isAbove?if_exists == false>checked="checked"</#if>>否
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>隐患地址:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textfield id="dangerAddress" name="companyHiddendangerModel.dangerAddress" cssStyle="width:75%"/>
			<ui:v for="dangerAddress" rule="require" warn="不允许以空格为开始" empty="隐患地址不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">隐患区域:&nbsp;</th>
		<td width="35%" colspan="5">
		<div id="div-area"></div>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>联系人:&nbsp;</th>
		<td width="15%">
			<@s.textfield id="dangerContact" name="companyHiddendangerModel.dangerContact" cssStyle="width:75%"/>
			<ui:v for="dangerContact" rule="require" warn="不允许以空格为开始" empty="联系人不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>联系电话:&nbsp;</th>
		<td width="15%">
			<@s.textfield id="dangerPhone" name="companyHiddendangerModel.dangerPhone" cssStyle="width:75%"/>
			<ui:v for="dangerPhone" rule="phone" require="true" warn="电话号码格式不正确！" empty="电话号码不允许为空！" pass="&nbsp;"/>
		</td>
		<th width="15%">手机:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="dangerMobile" name="companyHiddendangerModel.dangerMobile" cssStyle="width:75%"/>
			<ui:v for="dangerMobile" rule="mobile" require="false" warn="手机格式不正确！"  pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">隐患基本情况:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textarea id="dangerContent" name="companyHiddendangerModel.dangerContent"  cssStyle="width:90%;" rows="8"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.selectAreas "companyHiddendangerModel","div-area","${companyHiddendangerModel?if_exists.firstArea?if_exists}","${companyHiddendangerModel?if_exists.secondArea?if_exists}","${companyHiddendangerModel?if_exists.thirdArea?if_exists}","${companyHiddendangerModel?if_exists.fouthArea?if_exists}","${companyHiddendangerModel?if_exists.fifthArea?if_exists}" />
<@fkMacros.pageFooter />
