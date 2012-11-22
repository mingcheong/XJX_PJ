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
<@fkMacros.formValidator 'companyTrainForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if companyTrainModel.id?if_exists gt 0 >编辑<#else>添加</#if>培训信息 </div></td>
  </tr>
</table>
<@s.form id="companyTrainForm" action="companyTrain_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyTrainModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyTrainForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>培训类型:&nbsp;</th>
		<td width="35%" colspan="3">
			<select  id="trainType" name="companyTrainModel.trainType" ></select>
			<ui:v for="trainType" rule="require" warn="不允许以空格为开始" empty="请选择培训类型" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>企业名称:&nbsp;</th>
		<td width="35%" colspan="3">
			<input type="hidden" id="companyId" name="companyTrainModel.companyInfo.id"/>
			<span id="companyName"></span>
		</td>
	</tr>
	<tr>
		<th width="15%">地址:&nbsp;</th>
		<td width="35%" id="address" colspan="3">
		</td>
	</tr>
	<tr>
		<th width="15%">所在区域:&nbsp;</th>
		<td width="32%" colspan="3">
			<div id="div-area"></div>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>姓名:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="personName" name="companyTrainModel.personName" cssStyle="width:75%"/>
			<ui:v for="personName" rule="require" warn="不允许以空格为开始" empty="培训人员姓名不允许为空" pass="&nbsp;"/>
		</td>
	
		<th width="15%"><font color="#FF0000">*</font>身份证:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="personIdcard" name="companyTrainModel.personIdcard" cssStyle="width:75%"/>
			<ui:v for="personIdcard" rule="id_card"  require="true" warn="请输入正确的身份证号" empty="身份证不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">得分:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="score" name="companyTrainModel.score" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);if(this.value=='')this.value='0';"/>
			<ui:v for="score" rule="double" require="false" warn="请输入数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
	
		<th width="15%"> 联系电话:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="personPhone" name="companyTrainModel.personPhone" />
			&nbsp&nbsp&nbsp&nbsp
			<span>格式:区号-0000000</span>
			<ui:v for="personPhone" rule="phone" require="false" warn="请输入正确的电话号码" empty="电话不允许为空！" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>证书号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="certificateCode" name="companyTrainModel.certificateCode" cssStyle="width:30%"/>
			<ui:v for="certificateCode" rule="require" warn="不允许以空格为开始" empty="证书号不允许为空" pass="&nbsp;"/>
		</td>
	
		<th width="15%">培训状态:&nbsp;</th>
		<td width="35%">
			<select id="state" name="companyTrainModel.state"></select>
			<ui:v for="state" rule="require" warn="不允许以空格为开始" empty="培训状态不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/>
<@enum.selectAreas "companyTrainModel","div-area","${companyTrainModel.firstArea?if_exists}","${companyTrainModel.secondArea?if_exists}","${companyTrainModel.thirdArea?if_exists}","${companyTrainModel.fouthArea?if_exists}","${companyTrainModel.fifthArea?if_exists}" />

<script>
	if(get("trainType")){enumObj.initSelect("trainType","trainType");}		//培训类型
	if(get("state")){
		var opt = '<option value="1">已培训</option><option value="0">未培训</option>';
		jQuery("#state").append(opt);
	}
	
	<#if companyTrainModel.id?if_exists lt 0 >
		jQuery("#state").val("1");
	<#else>
			jQuery("#state").val("${companyTrainModel.state}");

	</#if>
	
	<#if companyTrainModel?if_exists !="" & companyTrainModel.id?if_exists lt 0 >
		jQuery("#companyId").val("${companyInfoModel.id}");
		jQuery("#companyName").text("${companyInfoModel.companyName}");
		jQuery("#address").text("${companyInfoModel.address}");
	<#else>
		jQuery("#companyId").val("${companyTrainModel.companyInfo.id}");
		jQuery("#address").text("${companyTrainModel.companyInfo.address}");
		jQuery("#companyName").text("${companyTrainModel.companyInfo.companyName}");
	</#if>
	
	<#if companyTrainModel.trainType?if_exists != "">
		jQuery("#trainType").val("${companyTrainModel.trainType}");
	</#if> 
</script>
<@fkMacros.pageFooter />
