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
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxCustomerModel.id == -1>添加<#else>修改</#if>客户档案 </div></td>
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
		<th width="15%"><font color="#FF0000">*</font>顾客编号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcCode" name="jxCustomerModel.jcCode" cssStyle="width:75%"/>
			<ui:v for="jcCode" rule="require" warn="不允许以空格为开始" empty="顾客编号不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">会员分类:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcClazz" name="jxCustomerModel.jcClazz" cssStyle="width:25%" maxlength="1"/>&nbsp;ABC分类
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>顾客简称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcName" name="jxCustomerModel.jcName" cssStyle="width:75%"/>
			<ui:v for="jcName" rule="require" warn="不允许以空格为开始" empty="顾客简称不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>可使用:&nbsp;</th>
		<td width="35%">
			<select name="jxCustomerModel.jcCanuse">
				<option value="true" <#if jxCustomerModel.jcCanuse>selected="selected"</#if> >是</option>
				<option value="false" <#if !jxCustomerModel.jcCanuse>selected="selected"</#if> >否</option>
			</select>	
		</td>		
	</tr>
	<tr>
		<th width="15%">地址:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jcAddress" name="jxCustomerModel.jcAddress" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">邮编:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcPost" name="jxCustomerModel.jcPost" cssStyle="width:75%"/>
			<ui:v for="jcPost" rule="zip" require="false" warn="邮编格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
		</td>
		<th width="15%">电话:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcPhone" name="jxCustomerModel.jcPhone" cssStyle="width:75%"/>
			<ui:v for="jcPhone" rule="phone" require="false" warn="电话号码格式不正确！" empty="电话号码不允许为空！" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">顾客全称:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jcFullname" name="jxCustomerModel.jcFullname" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">开户银行:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcBank" name="jxCustomerModel.jcBank" cssStyle="width:75%"/>
		</td>
		<th width="15%">账号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcAccount" name="jxCustomerModel.jcAccount" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">税号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jcDuty" name="jxCustomerModel.jcDuty" cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>业务员:&nbsp;</th>
		<td width="35%">
			<@s.hidden id="userId" name="jxCustomerModel.jcUser.id" />
			<@s.textfield id="userName" name="jxCustomerModel.jcUser.jeName" readonly="true" cssStyle="width:75%"/>&nbsp;
			<@fkMacros.radioTree 'userId','userName','jxEmployee_ajax.xhtml','${employeeNodes}'/>
			<ui:v for="userName" rule="require" warn="不允许以空格为开始" empty="业务员不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">其他备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jcRemark" name="jxCustomerModel.jcRemark" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>	
</table>
</@s.form>
<@fkMacros.pageFooter />
