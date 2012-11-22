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
<@fkMacros.formValidator 'companyProjectForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if companyProjectModel.id?if_exists gt 0 >编辑<#else>添加</#if>建设项目基本情况</div>
    </td>
  </tr>
</table>
<@s.form id="companyProjectForm" action="companyProject_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyProjectModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyProjectForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<td width="15%" align="right"><font color="#FF0000">*</font>项目名称&nbsp;</td>
		<td width="35%">
			<input type="hidden" id="companyId" name="companyProjectModel.companyInfo.id"/>
			<@s.textfield id="projectName" name="companyProjectModel.projectName" cssStyle="width:75%"/>
			<ui:v for="projectName" rule="require" warn="不允许以空格为开始" empty="项目名称不允许为空" pass="&nbsp;"/>
		</td>

		<td width="15%"  align="right"><font color="#FF0000">*</font>投资金额&nbsp;</td>
		<td width="35%">
			<@s.textfield id="projectInvestment" name="companyProjectModel.projectInvestment" cssStyle="width:38%" onBlur="this.value=jQuery.trim(this.value);if(this.value=='')this.value='0';"/>
			<span>&nbsp;&nbsp;万元</span>
			<ui:v for="projectInvestment" rule="double" warn="请输入正确的数值" require="true" empty="投资金额不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right"><font color="#FF0000">*</font>项目地址&nbsp;</td>
		<td width="35%">
			<@s.textfield id="projectAddress" name="companyProjectModel.projectAddress" cssStyle="width:75%"  />
			<ui:v for="projectAddress" rule="require" warn="不允许以空格为开始" empty="项目地址不允许为空" pass="&nbsp;"/>
		</td>
		<td width="15%" align="right"><font color="#FF0000">*</font>土地性质&nbsp;</td>
		<td width="35%" colspan="3">
			<select id="landType" name="companyProjectModel.landType" cssStyle="width:75%"></select>
			<ui:v for="landType" rule="require" warn="不允许以空格为开始" empty="请选择土地性质" pass="&nbsp;"/>
		</td>
	</tr>
	</tr>
	
	<tr>
		<td width="15%" align="right"><font color="#FF0000">*</font>项目类型&nbsp;</td>
		<td width="35%">
			<select id="projectType" name="companyProjectModel.projectType" onChange="checkSelect(this,'hdprojectType')"></select>
			<ui:v for="projectType" rule="require" warn="不允许以空格为开始" empty="请选择项目类型" pass="&nbsp;"/>
		</td>

		<td width="15%" align="right">设施类型&nbsp;</td>
		<td width="35%">
			<select id="facilitiesType" name="companyProjectModel.facilitiesType" ></select>
		</td>
	</tr>
	<tr>
	
	<tr>
		<td width="15%" align="right"><font color="#FF0000">*</font>规划许可情况&nbsp;</td>
		<td width="35%" colspan="3">
			<@s.textarea id="content1" name="companyProjectModel.content1" cssStyle="width:75%;height:120" />
			<span style="color:red;font-size:12px">限3000个汉字</span>
			<ui:v for="content1" rule="require" warn="不允许以空格为开始" empty="不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right" style="line-height:18px">
			<font color="#FF0000">*</font>
			投资主管部门对</br>建设项目是否进</br>行审批（核准、备案）？</br>若无，无需对项目</br>审批（核准、备案</br>）原因的说明。
			
		</td>
		<td width="35%" colspan="3">
			<@s.textarea id="content2" name="companyProjectModel.content2" cssStyle="width:75%;height:120"/>
			<span style="color:red;font-size:12px">限3000个汉字</span>
			<ui:v for="content2" rule="require" warn="不允许以空格为开始" empty="不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right" style="line-height:18px"><font color="#FF0000">*</font>建设项目主要内容</br>，工艺及技术来源</td>
		<td width="35%" colspan="3">
			<@s.textarea id="content3" name="companyProjectModel.content3" cssStyle="width:75%;height:120" />
			<span style="color:red;font-size:12px">限3000个汉字</span>
			<ui:v for="content3" rule="require" warn="不允许以空格为开始" empty="不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right" style="line-height:18px"><font color="#FF0000">*</font>项目实施后，危险化学产品（包括副产、中间产品）品种、能力的前后变化。</td>
		<td width="35%" colspan="3">
			<@s.textarea id="content4" name="companyProjectModel.content4" cssStyle="width:75%;height:120" />
			<span style="color:red;font-size:12px">限3000个汉字</span>
			<ui:v for="content4" rule="require" warn="不允许以空格为开始" empty="不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
<@enum.initEnumXML/>
</@s.form>

<script>
	if(get("projectType")){enumObj.initSelect("projectType","projectType");}
	if(get("landType")){enumObj.initSelect("landType","landType");}
	if(get("facilitiesType")){enumObj.initSelect("facilitiesType","facilitiesType");}
	<#if companyProjectModel.projectType?if_exists != "">
		jQuery("#projectType").val("${companyProjectModel.projectType}");
	</#if>
	<#if companyProjectModel.facilitiesType?if_exists != "">
		jQuery("#facilitiesType").val("${companyProjectModel.facilitiesType}");
	</#if>
	<#if companyProjectModel.landType?if_exists != "">
		jQuery("#landType").val("${companyProjectModel.landType}");
	</#if>
	
	<#if companyProjectModel?if_exists !="" & companyProjectModel.id?if_exists lt 0 >
		jQuery("#companyId").val("${companyInfoModel.id}");
	<#else>
		jQuery("#companyId").val("${companyProjectModel.companyInfo.id}");
	</#if>

</script>
<@fkMacros.pageFooter />
