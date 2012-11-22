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
	
<@fkMacros.formValidator 'companyStandardForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if companyStandardModel.id?if_exists gt 0 >编辑<#else>添加</#if>行政许可 </div></td>
  </tr>
</table>
<@s.form id="companyStandardForm" action="companyStandard_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyStandardModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyStandardForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>标准化类型:&nbsp;</th>
		<td width="35%">
			<select id="standardType" name="companyStandardModel.standardType"></select>
			<ui:v for="standardType" rule="require" warn="不允许以空格为开始" empty="请选标准化类型" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>单位名称:&nbsp;</th>
		<td width="35%">
			<input type="hidden" id="companyId" name="companyStandardModel.companyInfo.id"/>
			<span id="companyName"></span>
		</td>
	</tr>

	<tr>
		<th width="15%"><font color="#FF0000">*</font>标准化达标级别:&nbsp;</th>
		<td width="35%">
			<select id="companyLeavel" name="companyStandardModel.companyLeavel" onChange="checkSelect(this,'hdcompanyLeavel')"/>
			<@s.hidden id="" name=""/>
			<ui:v for="companyLeavel" rule="require" warn="不允许以空格为开始" empty="请选择达标级别" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>证书编号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="certificateNumber" name="companyStandardModel.certificateNumber" cssStyle="width:35%"/>
			<ui:v for="certificateNumber" rule="require" warn="不允许以空格为开始" empty="证书编号不允许为空" pass="&nbsp;"/>
		</td>
	</tr>

	<tr>
		<th width="15%">有效日期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="validityBegin" name="companyStandardModel.validityBegin" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
			至
			<@s.textfield id="validityEnd" name="companyStandardModel.validityEnd" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',errDealMode:1})"/>
		</td>
	</tr>
	<tr>
		<th width="10%">发证日期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="issueDate" name="companyStandardModel.issueDate" readOnly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
		</td>
	</tr>
	<tr>
		<th >发证机关:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="issueUnit" name="companyStandardModel.issueUnit" />
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/>
<@enum.initAllEnum />
<script>
	if(get("standardType")){enumObj.initSelect("standardType","standardType");}
	if(get("companyLeavel")){enumObj.initSelect("companyLeavel","companyLeavel");}
	<#if companyStandardModel.standardType?if_exists != "">
		jQuery("#standardType").val("${companyStandardModel.standardType}");
	</#if> 
	<#if companyStandardModel.companyLeavel?if_exists != "">
		jQuery("#companyLeavel").val("${companyStandardModel.companyLeavel}");
	</#if> 

	<#if companyStandardModel?if_exists !="" & companyStandardModel.id?if_exists < 0 >
		jQuery("#companyId").val("${companyInfoModel.id}");
		jQuery("#companyName").text("${companyInfoModel.companyName}");
	<#else>
		jQuery("#companyId").val("${companyStandardModel.companyInfo.id}");
		jQuery("#companyName").text("${companyStandardModel.companyInfo.companyName}");
	</#if>

</script>
<@fkMacros.pageFooter />
