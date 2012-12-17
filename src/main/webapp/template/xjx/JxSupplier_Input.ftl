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
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxSupplierModel.id == -1>添加<#else>修改</#if>供应商档案 </div></td>
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
		<th width="15%"><font color="#FF0000">*</font>供应商编号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsCode" name="jxSupplierModel.jsCode" cssStyle="width:75%"/>
			<ui:v for="jsCode" rule="require" warn="不允许以空格为开始" empty="供应商编号不允许为空" pass="&nbsp;"/>
		</td>

		<th width="15%">可使用:&nbsp;</th>
		<td width="15%">
			<select name="jxSupplierModel.jsCanuse">
				<option value="true" <#if jxSupplierModel.jsCanuse>selected="selected"</#if> >是</option>
				<option value="false" <#if !jxSupplierModel.jsCanuse>selected="selected"</#if> >否</option>
			</select>		
		</td>		
		<th width="10%">分类:&nbsp;</th>
		<td width="10%">
			<@s.textfield id="jsCate" name="jxSupplierModel.jsCate" cssStyle="width:75%"  maxlength="1"/>
		</td>			
	</tr>
	<tr>
		<th width="15%">信用额度:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsLimit" name="jxSupplierModel.jsLimit" cssStyle="width:75%"/>
			<ui:v for="jsLimit" rule="integer" require="false" warn="信用额度格式不正确！" pass="&nbsp;"/>
		</td>
		<th width="15%">结存金额:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jsBalance" name="jxSupplierModel.jsBalance" cssStyle="width:75%"/>
			<ui:v for="jsBalance" rule="integer" require="false" warn="结存金额格式不正确！" pass="&nbsp;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>供应商简称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsName" name="jxSupplierModel.jsName" cssStyle="width:75%"/>
			<ui:v for="jsName" rule="require" warn="不允许以空格为开始" empty="供应商简称不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">法人:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jsPerson" name="jxSupplierModel.jsPerson" cssStyle="width:75%"/>
		</td>		
	</tr>
	<tr>
		<th width="15%">地址:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textfield id="jsAddr" name="jxSupplierModel.jsAddr" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">邮编:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsPost" name="jxSupplierModel.jsPost" cssStyle="width:75%"/>
		</td>
		<th width="15%">电话:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jsTele" name="jxSupplierModel.jsTele" cssStyle="width:75%"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>供应商全称:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textfield id="jsFullname" name="jxSupplierModel.jsFullname" cssStyle="width:75%"/>
			<ui:v for="jsFullname" rule="require" warn="不允许以空格为开始" empty="供应商全称不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">开户银行:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsBank" name="jxSupplierModel.jsBank" cssStyle="width:75%"/>
		</td>
		<th width="15%">账号:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jsAccount" name="jxSupplierModel.jsAccount" cssStyle="width:75%"/>
		</td>		
	</tr>

	<tr>
		<th width="15%">税号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jsDutyno" name="jxSupplierModel.jsDutyno" cssStyle="width:75%"/>
		</td>
		<th width="15%">联系人:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jsContact" name="jxSupplierModel.jsContact" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">其他备注:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textarea id="jsRemark" name="jxSupplierModel.jsRemark" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
