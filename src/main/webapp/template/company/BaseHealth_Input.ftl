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
<@fkMacros.formValidator 'baseHealthForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if baseHealthModel.id?if_exists gt 0 >编辑<#else>添加</#if>健康防治信息  </div></td>
  </tr>
</table>
<@s.form id="baseHealthForm" action="baseHealth_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="baseHealthModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="baseHealthForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="10%">企业名称:&nbsp;</th>
		<td width="40%" colspan="3">
			<input type="hidden" id="companyId" name="baseHealthModel.companyInfo.id"/>
			<span id="companyName"></span>
		</td>
	</tr>
	<tr>
		<th width="10%">地址:&nbsp;</th>
		<td width="40%" id="address" colspan="3">
		</td>
	</tr>
		<th width="10%"><font color="#FF0000">*</font>工种:&nbsp;</th>
		<td width="40%">
			<select id="workType" name="baseHealthModel.workType" ></select>
			<ui:v for="workType" rule="require" warn="不允许以空格为开始" empty="请选择工程" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>职工人数:&nbsp;</th>
		<td width="40%">
			<@s.textfield id="staffNum" name="baseHealthModel.staffNum" />
			<ui:v for="staffNum" rule="integer" warn="请输入正确的数字" require="true" empty="职工人数不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>工作场所:&nbsp;</th>
		<td width="40%">
			<@s.textfield id="workPlace" name="baseHealthModel.workPlace"  />
			<ui:v for="workPlace" rule="require" warn="不允许以空格为开始" empty="工作场所不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>健康情况:&nbsp;</th>
		<td width="40%">
			<@s.textarea id="scription" name="baseHealthModel.scription" cssStyle="width:500;height:200"/>
			<ui:v for="scription" rule="require" warn="不允许以空格为开始" empty="健康情况不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/>
<script>
	if(get("workType")){enumObj.initSelect("workType","workType");}
	
	<#if baseHealthModel.workType?if_exists != "">
		jQuery("#workType").val("${baseHealthModel.workType}");
	</#if> 
	
	<#if baseHealthModel?if_exists !="" & baseHealthModel.id?if_exists lt 0 >
		jQuery("#companyId").val("${companyInfoModel.id}");
		jQuery("#companyName").text("${companyInfoModel.companyName}");
		jQuery("#address").text("${companyInfoModel.address}");
	<#else>
		jQuery("#companyId").val("${baseHealthModel.companyInfo.id}");
		jQuery("#companyName").text("${baseHealthModel.companyInfo.companyName}");
		jQuery("#address").text("${baseHealthModel.companyInfo.address}");
		
	</#if>
	
	
</script>
<@fkMacros.pageFooter />
