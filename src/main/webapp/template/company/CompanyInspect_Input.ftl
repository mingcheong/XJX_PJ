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

<@fkMacros.formValidator 'companyInspectForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：行政执法 </div></td>
  </tr>
</table>
<@s.form id="companyInspectForm" action="companyInspect_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyInspectModel.id" /><@s.hidden name="companyInspectModel.companyInfoModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyInspectForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>检查类型:&nbsp;</th>
		<td width="35%" colspan="3">
			<select name="companyInspectModel.inspecttype" id="inspectType"></select>
			<ui:v for="inspectType" rule="require" warn="不允许以空格为开始" empty="检查类型不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>被检查企业:&nbsp;</th>
		<td width="35%" colspan="3">
		${companyInspectModel?if_exists.companyInfoModel?if_exists.companyName?default('')}
		<input type="hidden" name="param" value="${companyInspectModel?if_exists.companyInfoModel?if_exists.id}">
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>单位地址:&nbsp;</th>
		<td width="35%" colspan="3">
		${companyInspectModel?if_exists.companyInfoModel?if_exists.address?default('')}
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>检查场所:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="place" name="companyInspectModel.place" cssStyle="width:75%"/>
			<ui:v for="place" rule="require" warn="不允许以空格为开始" empty="检查场所不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>检查时间:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="startdate" name="companyInspectModel.startdate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:150px"/>
			止
			<@s.textfield id="enddate" name="companyInspectModel.enddate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:150px"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>检查人员:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="inspectors" name="companyInspectModel.inspectors" cssStyle="width:75%"/>
			<ui:v for="inspectors" rule="require" warn="不允许以空格为开始" empty="检查不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>记录人人员:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="recordors" name="companyInspectModel.recordors" cssStyle="width:75%"/>
			<ui:v for="recordors" rule="require" warn="不允许以空格为开始" empty="记录不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>执法单位:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="enforceunit" name="companyInspectModel.enforceunit" cssStyle="width:75%"/>
			<ui:v for="enforceunit" rule="require" warn="不允许以空格为开始" empty="执法单位不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="remark" name="companyInspectModel.remark" cssStyle="width:75%" rows="5"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML /><@enum.initAllEnum />
<script type="text/javascript"> 
<#if companyInspectModel.inspecttype?if_exists != "">jQuery("#inspectType").val("${companyInspectModel.inspecttype}");</#if>
</script>
<@fkMacros.pageFooter />
