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
<@fkMacros.formValidator 'companyAccidentForm'/>
<style>
	.tabNone{
		border-top-style: none;
		border-right-style: none;
		border-bottom-style: none;
		border-left-style: none;
	}
</style>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if companyAccidentModel.id?if_exists gt 0 >编辑<#else>添加</#if>事故信息 </div></td>
  </tr>
</table>
<@s.form id="companyAccidentForm" action="companyAccident_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyAccidentModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyAccidentForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="10%"><font color="#FF0000">*</font>事故大类:&nbsp;</th>
		<td width="35%">
			<select id="bigtype" name="companyAccidentModel.bigtype"></select>
			<ui:v for="bigtype" rule="require" warn="不允许以空格为开始" empty="请选标事故大类" pass="&nbsp;"/>
			
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>事故报告单位:&nbsp;</th>
		<td width="35%">
			<!--<@s.textfield id="accidentReportUnit" name="companyAccidentModel.accidentReportUnit" cssStyle="width:25%"/>
			<a>选择<a>
			<ui:v for="accidentReportUnit" rule="require" warn="不允许以空格为开始" empty="事故报告单位不允许为空" pass="&nbsp;"/>-->
			
			<@s.hidden id="organId" name="companyAccidentModel.accidentReportOrgan.id" value="0"/>
			<@s.textfield id="organName" readonly="true" value=""  cssStyle="width:25%"/>
			<@fkMacros.radioTree 'organId','organName','companyAccident_ajaxOrgan.xhtml','${treeNodes}'/>
			<ui:v for="organName" rule="require" warn="不允许以空格为开始" empty="事故报告单位不允许为空" pass="&nbsp;"/>
			
		</td>
	</tr>
	
	<tr>
		<th width="10%"><font color="#FF0000">*</font>事故单位:&nbsp;</th>
		<td width="35%">
			<input type="hidden" id="companyId" name="companyAccidentModel.accidentUnit.id"/>
			<span id="companyName"></span>
		</td>
	</tr>
	
	<tr>
		<th width="10%"><font color="#FF0000">*</font>事故所在区域:&nbsp;</th>
		<td width="35%" colspan="3">
			<div id="div-area"></div>
		</td>
	</tr>
	
	<tr>
		<th width="10%"><font color="#FF0000">*</font>事故时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="accidentDate" name="companyAccidentModel.accidentDate" cssStyle="width:25%" readOnly="true"  onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"/>
			<ui:v for="accidentDate" rule="require" warn="不允许以空格为开始" empty="事故时间不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%">直接经济损失:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="accidentLoss" name="companyAccidentModel.accidentLoss" cssStyle="width:25%" onBlur="this.value=jQuery.trim(this.value);if(this.value=='')this.value='0';"/>万元
			<ui:v for="accidentLoss" rule="double" require="false" warn="请输入正确的数值" empty="直接经济不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%">伤亡情况:&nbsp;</th>
		<td width="35%">
						现场共有 <@s.textfield id="totalNumber" name="companyAccidentModel.totalNumber" cssStyle="width:30px"  readOnly="true" onBlur="checkNum(this)" />人
						其中死亡 <@s.textfield id="deathNumber" name="companyAccidentModel.deathNumber" cssStyle="width:30px"   onBlur="checkNum(this)"/>人
						失踪  <@s.textfield id="missedNumber" name="companyAccidentModel.missedNumber" cssStyle="width:30px"   onBlur="checkNum(this)"/>人
						重伤  <@s.textfield id="seriovsWoundNumber" name="companyAccidentModel.seriovsWoundNumber" cssStyle="width:30px"  onBlur="checkNum(this)"/>人
						轻伤  <@s.textfield id="minorWoundNumber" name="companyAccidentModel.minorWoundNumber" cssStyle="width:30px"   onBlur="checkNum(this)"/>人
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>事故简要情况:&nbsp;</th>
		<td width="35%">
			<@s.textarea id="accidentContent" name="companyAccidentModel.accidentContent" cssStyle="width:65%;height:100"/>
			<ui:v for="accidentContent" rule="require" warn="不允许以空格为开始" empty="事故简要情况不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="10%"><font color="#FF0000">*</font>是否上报:&nbsp;</th>
		<td width="35%">
			<select id="isReport" name="companyAccidentModel.isReport" />
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/>

<@enum.selectAreas "companyAccidentModel","div-area","${companyAccidentModel.firstArea?if_exists}","${companyAccidentModel.secondArea?if_exists}","${companyAccidentModel.thirdArea?if_exists}","${companyAccidentModel.fouthArea?if_exists}","${companyAccidentModel.fifthArea?if_exists}" />

<script>
	if(get("bigtype")){enumObj.initSelect("accidentBigType","bigtype");}
	<#if companyAccidentModel.bigtype?if_exists != "">
		jQuery("#bigtype").val("${companyAccidentModel.bigtype}");
	</#if> 
	if(get("isReport")){
		var opt = '<option value="false">否</option><option value="true">是</option>';
		jQuery("#isReport").append(opt);
	}
	<#if companyAccidentModel.isReport?if_exists ==true>
		jQuery("#isReport").val("true");
	<#else>
		jQuery("#isReport").val("false");
	</#if>
	
	<#if companyAccidentModel?if_exists !="" & companyAccidentModel.id?if_exists lt 0 >
		jQuery("#companyId").val("${companyInfoModel.id}");
		jQuery("#companyName").text("${companyInfoModel.companyName}");
		jQuery("#organName").val("");
		jQuery("#organId").val("0");
	<#else>
		jQuery("#companyId").val("${companyAccidentModel.accidentUnit.id}");
		jQuery("#companyName").text("${companyAccidentModel.accidentUnit.companyName}");
		
		jQuery("#organName").val("${companyAccidentModel.accidentReportOrgan.orgName}");
		jQuery("#organId").val("${companyAccidentModel.accidentReportOrgan.id}");
	</#if>
	
	<#if companyAccidentModel.bigtype?if_exists != "">
		jQuery("#bigtype").val("${companyAccidentModel.bigtype}");
	</#if>
	<#if companyAccidentModel.totalNumber?if_exists =="">
		jQuery("#totalNumber").val("0");
	</#if>
	<#if companyAccidentModel.missedNumber?if_exists =="">
		jQuery("#missedNumber").val("0");
	</#if>
	<#if companyAccidentModel.seriovsWoundNumber?if_exists =="">
		jQuery("#seriovsWoundNumber").val("0");
	</#if>
	<#if companyAccidentModel.minorWoundNumber?if_exists =="">
		jQuery("#minorWoundNumber").val("0");
	</#if>
	<#if companyAccidentModel.deathNumber?if_exists =="">
		jQuery("#deathNumber").val("0");
	</#if>
	
	<#if companyAccidentModel.accidentLoss?if_exists =="">
		jQuery("#accidentLoss").val("0");
	</#if>
	
	
	function checkNum(txtNum)//判断整数
	{
	    var reg=/^\d*$/gi;
	    var isNum=reg.exec(trimAll(txtNum.value)); 
	    if(!isNum || isNum == "" || isNum == "null")
	    {
	    	txtNum.value="0";
	    }
		txtNum.value = jQuery.trim(txtNum.value);
		var deathNumber = parseInt(jQuery("#deathNumber").val());
		var missedNumber = parseInt(jQuery("#missedNumber").val());
		var seriovsWoundNumber = parseInt(jQuery("#seriovsWoundNumber").val());
		var minorWoundNumber = parseInt(jQuery("#minorWoundNumber").val());
		
		var total =0;
		
		if(deathNumber !="NaN")
			total = total+deathNumber;
		
		if(String(missedNumber) !="NaN")
			total  = total+ missedNumber;
		if(String(seriovsWoundNumber) !="NaN")
			total  = total+ seriovsWoundNumber;
		if(String(minorWoundNumber) !="NaN")
			total  = total+ minorWoundNumber;
		if(total >0)
			jQuery("#totalNumber").val(total+"");
	}
	function trimAll(data)
	{
	  var reg=/^ +| +$/g;
	  var str=data.replace(reg,"");
	  return str;
	}
</script>

<@fkMacros.pageFooter />
