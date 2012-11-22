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
<@fkMacros.formValidator 'baseMeetingForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：会议记录 </div></td>
  </tr>
</table>
<@s.form id="baseMeetingForm" action="baseMeeting_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="baseMeetingModel.id" />
	<@s.hidden id="orgsId" name="baseMeetingModel.fkOrganizeModel.id" value="${currentUser.fkOrganize.id}"/>
			<@s.hidden id="userId" name="baseMeetingModel.fkUserModel.id" value="${currentUser.id}"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="baseMeetingForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>标题:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="name" name="baseMeetingModel.name" cssStyle="width:75%"/>
			<ui:v for="name" rule="require" warn="不允许以空格为开始" empty="标题不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>会议类别:&nbsp;</th>
		<td width="35%">
			<select name="baseMeetingModel.modelType" id="MeetingModelType"></select>
			<ui:v for="MeetingModelType" rule="require" warn="不允许以空格为开始" empty="会议类别不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">制定单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="ruleUnit" name="baseMeetingModel.ruleUnit" cssStyle="width:75%"/>
		</td>
		<th width="15%">实施单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="implUnit" name="baseMeetingModel.implUnit" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>类型:&nbsp;</th>
		<td width="35%">
		<select name="baseMeetingModel.type" id="ReportType"></select>
			<ui:v for="ReportType" rule="require" warn="不允许以空格为开始" empty="类型不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>发布时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="releaseDate" name="baseMeetingModel.releaseDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"  cssStyle="width:75%"/>
			<ui:v for="releaseDate" rule="require" warn="不允许以空格为开始" empty="发布时间不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>内容:&nbsp;</th>
		<td width="35%" colspan="3"> 
			<@util.fckEditPanl editorName="baseMeetingModel.content" editorValue="${baseMeetingModel.content?default('')}"/>
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="remark" name="baseMeetingModel.remark" cssStyle="width:90%;" rows="8"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML /><@enum.initAllEnum /><script type="text/javascript"> <#if baseMeetingModel.type?if_exists != "">jQuery("#ReportType").val("${baseMeetingModel.type}");</#if> <#if baseMeetingModel.modelType?if_exists != "">jQuery("#MeetingModelType").val("${baseMeetingModel.modelType}");</#if></script>
<@fkMacros.pageFooter />
