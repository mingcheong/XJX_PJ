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
<@fkMacros.formValidator 'fkOrganizeForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加组织机构 </div></td>
  </tr>
</table>
<@s.form id="fkOrganizeForm" action="fkOrganize_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="fkOrganizeModel.id" /><@s.hidden name="fkOrganizeModel.resources" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="fkOrganizeForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>机构代码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="orgCode" name="fkOrganizeModel.orgCode" cssStyle="width:75%"/>
			<ui:v for="orgCode" rule="require" warn="不允许以空格为开始" empty="机构代码不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>机构名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="orgName" name="fkOrganizeModel.orgName" cssStyle="width:75%"/>
			<ui:v for="orgName" rule="require" warn="不允许以空格为开始" empty="机构名称不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>上级机构:&nbsp;</th>
		<td width="35%">
			<@s.hidden id="fatherId" name="fkOrganizeModel.fatherId" value="${fkOrganizeModel.fatherId?default('0')}"/>
			<@s.textfield id="fatherName" readonly="true" value="顶级机构"  cssStyle="width:75%"/>
			<@fkMacros.radioTree 'fatherId','fatherName','fkOrganize_ajax.xhtml','${treeNodes}'/>
			<ui:v for="fatherId" rule="require" warn="不允许以空格为开始" empty="上级机构不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">排&nbsp;&nbsp;序:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="sortNum" name="fkOrganizeModel.sortNum" cssStyle="width:75%"/>
			<ui:v for="sortNum" rule="integer" require="false" warn="只许输入数字！" empty="&nbsp;" pass="&nbsp;"/>
		</td>
		
	</tr>
	<tr>
		<th width="15%">机构类型:&nbsp;</th>
		<td colspan="3">
			<!--<@s.textarea id="orgType" name="fkOrganizeModel.orgDesc" cssStyle="width:90%;height:65px;"/>-->
			<select id="orgType" name="fkOrganizeModel.orgType">
				<option value="public">外部机构</option>
				<option value="inner">内部机构</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<th width="15%">详细描述:&nbsp;</th>
		<td colspan="3">
			<@s.textarea id="orgDesc" name="fkOrganizeModel.orgDesc" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>创建时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="createDate" name="fkOrganizeModel.createDate" cssStyle="width:75%" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
			<ui:v for="createDate" rule="require" warn="不允许以空格为开始" empty="createDate不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>修改时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="modifyDate" name="fkOrganizeModel.modifyDate" cssStyle="width:75%" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:45%"/>
			<ui:v for="modifyDate" rule="require" warn="不允许以空格为开始" empty="modifyDate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<script>
	<#if fkOrganizeModel.orgType?if_exists !="">
		jQuery("#orgType").val('${fkOrganizeModel.orgType}');
	</#if>
</script>
<@fkMacros.pageFooter />
