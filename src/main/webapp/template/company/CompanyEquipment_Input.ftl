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
<@fkMacros.formValidator 'companyEquipmentForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置: <#if companyEquipmentModel.id?if_exists gt 0 >编辑<#else>添加</#if>特种设备</div></td>
  </tr>
</table>
<@s.form id="companyEquipmentForm" action="companyEquipment_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyEquipmentModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyEquipmentForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>设备名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="name" name="companyEquipmentModel.name" cssStyle="width:75%"/>
			<ui:v for="name" rule="require" warn="不允许以空格为开始" empty="name不允许为空" pass="&nbsp;"/>
		</td>

		<th width="15%"> 安全管理人员:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="safetyPerson" name="companyEquipmentModel.safetyPerson" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"> 设备使用地点:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="usedAddress" name="companyEquipmentModel.usedAddress" cssStyle="width:75%"/>
		</td>

		<th width="15%"> 设备注册代码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="regCode" name="companyEquipmentModel.regCode" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"> 设备状态:&nbsp;</th>
		<td width="35%">
			<select id="state" name="companyEquipmentModel.state" cssStyle="width:75%"/>
		</td>

		<th width="15%"> 注册登记机构:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="regUnit" name="companyEquipmentModel.regUnit" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"> 注册登记日期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="regDate" name="companyEquipmentModel.regDate" cssStyle="width:75%" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" />
			 
		</td>

		<th width="15%"> 维保单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="preserveUnit" name="companyEquipmentModel.preserveUnit" cssStyle="width:75%"/>
			
		</td>
	</tr>
	<tr>
		<th width="15%"> 制造单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="produceUnit" name="companyEquipmentModel.produceUnit" cssStyle="width:75%"/>
			
		</td>

		<th width="15%"> 检验单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="inspectionUnit" name="companyEquipmentModel.inspectionUnit" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">检验日期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="inspectionDate" name="companyEquipmentModel.inspectionDate" cssStyle="width:75%" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
		</td>

		<th width="15%">维保电话:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="preserverPhone" name="companyEquipmentModel.preserverPhone" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"> 设备类型:&nbsp;</th>
		<td width="35%">
			<select id="equipentType" name="companyEquipmentModel.equipentType" cssStyle="width:75%"/>
		</td>

		<th width="15%"> 使用单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="usedUnit" name="companyEquipmentModel.usedUnit" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">使用地址:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="usingAddress" name="companyEquipmentModel.usingAddress" cssStyle="width:75%"/>
		</td>

		<th width="15%">设备型号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="model" name="companyEquipmentModel.model" cssStyle="width:75%"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/>
<@enum.initAllEnum />
<script type="text/javascript">
	<#if companyEquipmentModel.state?if_exists != "">
		jQuery("#state").val("${companyEquipmentModel.state}");
	</#if> 
	<#if companyEquipmentModel.equipentType?if_exists != "">
		jQuery("#equipentType").val("${companyEquipmentModel.equipentType}");
	</#if> 
	//alert(${companyEquipmentModel.id});
</script>

<@fkMacros.pageFooter />
