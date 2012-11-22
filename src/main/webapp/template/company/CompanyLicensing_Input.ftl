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
<link rel="stylesheet" type="text/css" href="${resourcePath}/wbox/wbox/wbox.css" />
<link rel="stylesheet" type="text/css" href="${resourcePath}/wbox/wbox/wbox-min.css" />
<script src="${resourcePath}/wbox/wbox.js" type="text/javascript"></script>
	
<@fkMacros.formValidator 'companyLicensingForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if companyLicensingModel.id?if_exists gt 0 >编辑<#else>添加</#if>行政许可 </div></td>
  </tr>
</table>
<@s.form id="companyLicensingForm" action="companyLicensing_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyLicensingModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyLicensingForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="10%"><font color="#FF0000">*</font>许可证类型:&nbsp;</th>
		<td width="40%">
			<select id="standardType" name="companyLicensingModel.standardType" />
			<@s.hidden id="" name=""/>
			<ui:v for="standardType" rule="require" warn="不允许以空格为开始" empty="请选择许可证类型" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>单位名称:&nbsp;</th>
		<td width="40%">
			<input type="hidden" id="companyId" name="companyLicensingModel.companyInfo.id"/>
			<span id="companyName"></span>
		</td>
	</tr>
	<tr>
		<th width="10%">单位地址:&nbsp;</th>
		<td width="40%" id="address"></td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>主要负责人:&nbsp;</th>
		<td width="40%">
			<@s.textfield id="companyChief" name="companyLicensingModel.companyChief" cssStyle="width:35%"/>
			<ui:v for="companyChief" rule="require" warn="不允许以空格为开始" empty="主要负责人不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"> 经济类型:&nbsp;</th>
		<td width="40%">
			<select id="economicType" name="companyLicensingModel.economicType" />
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>许可范围:&nbsp;</th>
		<td width="40%">
			<@s.textarea id="companyLeavel" name="companyLicensingModel.companyLeavel" cssStyle="width:35%"/>
			<ui:v for="companyLeavel" rule="require" warn="不允许以空格为开始" empty="许可范围不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>证书编号:&nbsp;</th>
		<td width="40%">
			<@s.textfield id="certificateNumber" name="companyLicensingModel.certificateNumber" cssStyle="width:35%"/>
			<ui:v for="certificateNumber" rule="require" warn="不允许以空格为开始" empty="证书编号不允许为空" pass="&nbsp;"/>
		</td>
	</tr>

	<tr>
		<th width="10%">有效日期:&nbsp;</th>
		<td width="40%">
			<@s.textfield id="validityBegin" name="companyLicensingModel.validityBegin" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
			至
			<@s.textfield id="validityEnd" name="companyLicensingModel.validityEnd" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',errDealMode:1})"/>
		</td>
	</tr>
	<tr>
		<th width="10%">发证日期:&nbsp;</th>
		<td width="40%">
			<@s.textfield id="issueDate" name="companyLicensingModel.issueDate" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
		</td>
	</tr>
	<tr>
		<th width="10%">发证机关:&nbsp;</th>
		
		<td width="40%">
			<@s.textfield id="issueUnit" name="companyLicensingModel.issueUnit" />
			
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/>
<@enum.initAllEnum />
<script>
	if(get("standardType")){enumObj.initSelect("licensingType","standardType");}
	<#if companyLicensingModel.standardType?if_exists != "">
		jQuery("#standardType").val("${companyLicensingModel.standardType}");
	</#if> 
	<#if companyLicensingModel.economicType?if_exists != "">
		jQuery("#economicType").val("${companyLicensingModel.economicType}");
	</#if> 

	<#if companyLicensingModel?if_exists !="" & companyLicensingModel.id?if_exists < 0 >
		jQuery("#companyId").val("${companyInfoModel.id}");
		jQuery("#companyName").text("${companyInfoModel.companyName}");
		jQuery("#address").text("${companyInfoModel.address}");
	<#else>
		jQuery("#companyId").val("${companyLicensingModel.companyInfo.id}");
		jQuery("#address").text("${companyLicensingModel.companyInfo.address}");
		jQuery("#companyName").text("${companyLicensingModel.companyInfo.companyName}");
	</#if> 
</script>
<@fkMacros.pageFooter />
