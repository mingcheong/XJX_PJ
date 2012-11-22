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
<@fkMacros.formValidator 'companyComplaintsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if companyComplaintsModel.id?if_exists gt 0 >编辑<#else>添加</#if> 举报投诉 </div></td>
  </tr>
</table>
<@s.form id="companyComplaintsForm" action="companyComplaints_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyComplaintsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyComplaintsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>来电日期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="callsDate" name="companyComplaintsModel.callsDate" cssStyle="width:75%" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
			<ui:v for="callsDate" rule="require" warn="不允许以空格为开始" empty="来电日期不允许为空" pass="&nbsp;"/>
		</td>
 
		<th width="15%"><font color="#FF0000">*</font>文号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="paperNumber" name="companyComplaintsModel.paperNumber" cssStyle="width:75%"/>
			<ui:v for="paperNumber" rule="require" warn="不允许以空格为开始" empty="文号不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"> 摘要:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="digest" name="companyComplaintsModel.digest" cssStyle="width:75%"/>
		</td>
 
		<th width="15%"><font color="#FF0000">*</font>领导姓名:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="leaderName" name="companyComplaintsModel.leaderName" cssStyle="width:75%"/>
			<ui:v for="leaderName" rule="require" warn="不允许以空格为开始" empty="领导姓名不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>举报人姓名:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="complaintsName" name="companyComplaintsModel.complaintsName" cssStyle="width:75%"/>
			<ui:v for="complaintsName" rule="require" warn="不允许以空格为开始" empty="举报人改名不允许为空" pass="&nbsp;"/>
		</td>
	 
		<th width="15%"><font color="#FF0000">*</font>督办情况:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="supervisory" name="companyComplaintsModel.supervisory" cssStyle="width:75%"/>
			<ui:v for="supervisory" rule="require" warn="不允许以空格为开始" empty="督办情况不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">是否办妥:&nbsp;</th>
		<td width="35%">
			<select id="isAppropriate" name="companyComplaintsModel.isAppropriate"/>
			<!--<@s.textfield id="isAppropriate" name="companyComplaintsModel.isAppropriate"/>
			<ui:v for="isAppropriate" rule="require" warn="不允许以空格为开始" empty="是否办妥不允许为空" pass="&nbsp;"/>-->
		</td>
		<th width="15%"><font color="#FF0000">*</font>受理人:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="callsName" name="companyComplaintsModel.callsName" cssStyle="width:75%"/>
			<ui:v for="callsName" rule="require" warn="不允许以空格为开始" empty="受理人不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="remark" name="companyComplaintsModel.remark" cssStyle="width:90%;" rows="15"/>
		</td>
		
		<!--
		<th width="15%"><font color="#FF0000">*</font>领导批示:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="leaderCheck" name="companyComplaintsModel.leaderCheck" cssStyle="width:75%"/>
			<ui:v for="remark" rule="require" warn="不允许以空格为开始" empty="领导不允许为空" pass="&nbsp;"/>
		</td>
		-->
	</tr>
</table>
</@s.form>
<script>
	

	if(get("isAppropriate")){
		var opt = '<option value="false">否</option><option value="true">是</option>';
		jQuery("#isAppropriate").append(opt);
	}
	<#if companyComplaintsModel.isAppropriate?if_exists ==true>
		jQuery("#isAppropriate").val("true");
	<#else>
		jQuery("#isAppropriate").val("false");
	</#if>
	
</script>
<@fkMacros.pageFooter />
