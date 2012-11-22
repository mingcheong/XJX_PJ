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
<@fkMacros.formValidator 'companyInfoForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：企业管理 </div></td>
  </tr>
</table>
<@s.form id="companyInfoForm" action="companyInfo_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyInfoModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="companyInfoForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="18%"><font color="#FF0000">*</font>企业名称:&nbsp;</th>
		<td width="32%" colspan="3">
			<@s.textfield id="companyName" name="companyInfoModel.companyName" cssStyle="width:75%"/>
			<ui:v for="companyName" rule="require" warn="不允许以空格为开始" empty="企业名称不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="18%"><font color="#FF0000">*</font>企业地址:&nbsp;</th>
		<td width="32%" colspan="3">
			<@s.textfield id="address" name="companyInfoModel.address" cssStyle="width:75%"/>
			<ui:v for="address" rule="require" warn="不允许以空格为开始" empty="企业地址不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="18%">区域:&nbsp;</th>
		<td width="32%">
			<div id="div-area"></div>
		</td>
		<th width="18%">工商登记机关:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="registration" name="companyInfoModel.registration" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="18%">经济性质:&nbsp;</th>
		<td width="32%">
			<select name="companyInfoModel.character" id="character"></select>
		</td>
		<th width="18%"><font color="#FF0000">*</font>行业类型:&nbsp;</th>
		<td width="32%">
		<select name="companyInfoModel.industrial" id="industrial"></select>
		<ui:v for="industrial" rule="require" warn="不允许以空格为开始" empty="请选择行业类型" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="18%"><font color="#FF0000">*</font>法人代表姓名:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="legalPerson" name="companyInfoModel.legalPerson" cssStyle="width:75%"/>
			<ui:v for="legalPerson" rule="require" warn="不允许以空格为开始" empty="法人代表姓名不允许为空" pass="&nbsp;"/>
		</td>
		<th width="18%"><font color="#FF0000">*</font>法人代表联系方式:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="legalContact" name="companyInfoModel.legalContact" cssStyle="width:75%"/>
			<ui:v for="legalContact" rule="mobile" require="false" warn="法人代表手机格式不正确"  pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="18%">安全生产主要负责人姓名:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="principalPerson" name="companyInfoModel.principalPerson" cssStyle="width:75%"/>
		</td>
		<th width="18%">安全生产主要负责人手机:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="principalMobile" name="companyInfoModel.principalMobile" cssStyle="width:75%"/>
			<ui:v for="principalMobile" rule="mobile" require="false" warn="安全生产主要负责人手机格式不正确！" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		
		<th width="18%">安全管理人员姓名:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="safetyName" name="companyInfoModel.safetyName" cssStyle="width:75%"/>
		</td>
		<th width="18%">安全管理人手机:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="safetyMobile" name="companyInfoModel.safetyMobile" cssStyle="width:75%"/>
			<ui:v for="safetyMobile" rule="mobile" require="false" warn="安全管理人手机格式不正确！"  pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="18%">职工人数:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="staffNumber" name="companyInfoModel.staffNumber" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
			<ui:v for="staffNumber" rule="integer" require="false" warn="请输入正确的数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
		<th width="18%">技术管理人数:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="outputNumber" name="companyInfoModel.outputNumber" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
			<ui:v for="outputNumber" rule="integer" require="false" warn="请输入正确的数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
	<th width="18%">外来务工人数:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="migrantNumber" name="companyInfoModel.migrantNumber" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
			<ui:v for="migrantNumber" rule="integer" require="false" warn="请输入正确的数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
		<th width="18%">持证上岗人数:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="postsNumber" name="companyInfoModel.postsNumber" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
			<ui:v for="postsNumber" rule="integer" require="false" warn="请输入正确的数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
		
	</tr>
	<tr>
	<th width="18%">工伤保险:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="insure" name="companyInfoModel.insure" value="true" <#if companyInfoModel.insure?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="insure" name="companyInfoModel.insure" value="false" <#if companyInfoModel.insure?if_exists == false>checked="checked"</#if>>无
		</td>
		<th width="18%">参保人数:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="insureNumber" name="companyInfoModel.insureNumber" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
			<ui:v for="insureNumber" rule="integer" require="false" warn="请输入正确的数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
	<th width="18%">年产值或年销售额:&nbsp;</th>
		<td width="32%">
		<@s.textfield id="yearSales" name="companyInfoModel.yearSales" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
		<ui:v for="yearSales" rule="integer" require="false" warn="数字格式不正确！"  pass="&nbsp;"/>
		</td>
		<th width="18%">与政府签订协议书:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="insure" name="companyInfoModel.isAgreement" value="true" <#if companyInfoModel.isAgreement?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="insure" name="companyInfoModel.isAgreement" value="false" <#if companyInfoModel.isAgreement?if_exists == false>checked="checked"</#if>>无
		</td>
	</tr>
	<tr>
	<th width="18%">安全管理机构设置:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="insure" name="companyInfoModel.isOrgs" value="true" <#if companyInfoModel.isOrgs?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="insure" name="companyInfoModel.isOrgs" value="false" <#if companyInfoModel.isOrgs?if_exists == false>checked="checked"</#if>>无
		</td>
		<th width="18%">安全生产管理人员人数 :&nbsp;</th>
		<td width="32%">
			<@s.textfield id="safetyNumber" name="companyInfoModel.safetyNumber" cssStyle="width:75%" onBlur="this.value=jQuery.trim(this.value);"/>
			<ui:v for="safetyNumber" rule="integer" require="false" warn="请输入正确的数值" empty="数字不允许为空！" pass="&nbsp;"/>
		</td>
		
	</tr>
	<tr>
	<th width="18%">人员密集场所:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="insure" name="companyInfoModel.isDense" value="true" <#if companyInfoModel.isDense?if_exists == true>checked="checked"</#if>>是
		<input type="radio" id="insure" name="companyInfoModel.isDense" value="false" <#if companyInfoModel.isDense?if_exists == false>checked="checked"</#if>>否
		</td>
		<th width="18%">消防重点单位:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="insure" name="companyInfoModel.isFirekey" value="true" <#if companyInfoModel.isFirekey?if_exists == true>checked="checked"</#if>>是
		<input type="radio" id="insure" name="companyInfoModel.isFirekey" value="false" <#if companyInfoModel.isFirekey?if_exists == false>checked="checked"</#if>>否
		</td>
		
	</tr>
	<tr>
	<th width="18%">特种设备:&nbsp;</th>
		<td width="32%" colspan="3">
			<@s.textfield id="equipmentIds" name="companyInfoModel.equipmentIds" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="18%">消防设施:&nbsp;</th>
		<td width="32%">
			<@s.textfield id="facilities" name="companyInfoModel.facilities" cssStyle="width:75%"/>
		</td>
		<th width="18%">设施、设备管理台帐:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="isAccount" name="companyInfoModel.isAccount" value="true" <#if companyInfoModel.isAccount?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="isAccount" name="companyInfoModel.isAccount" value="false" <#if companyInfoModel.isAccount?if_exists == false>checked="checked"</#if>>无
		</td>
	</tr>
	<tr>
		<th width="18%">使用危险化学品情况:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="isDangerous" name="companyInfoModel.isDangerous" value="true" <#if companyInfoModel.isDangerous?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="isDangerous" name="companyInfoModel.isDangerous" value="false" <#if companyInfoModel.isDangerous?if_exists == false>checked="checked"</#if>>无
		</td>
		<th width="18%">危险化学品仓库:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="isChemicals" name="companyInfoModel.isChemicals" value="true" <#if companyInfoModel.isChemicals?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="isChemicals" name="companyInfoModel.isChemicals" value="false" <#if companyInfoModel.isChemicals?if_exists == false>checked="checked"</#if>>无
		</td>
	</tr>
	<tr>
		<th width="18%">安全达标开展情况:&nbsp;</th>
		<td width="32%">
		<select name="companyInfoModel.safetyStandards" id="safetyStandards"></select>
		</td>
		<th width="18%">是否建立安全生产管理台帐:&nbsp;</th>
		<td width="32%">
		<input type="radio" id="isSafetyAccount" name="companyInfoModel.isSafetyAccount" value="true" <#if companyInfoModel.isSafetyAccount?if_exists == true>checked="checked"</#if>>有
		<input type="radio" id="isSafetyAccount" name="companyInfoModel.isSafetyAccount" value="false" <#if companyInfoModel.isSafetyAccount?if_exists == false>checked="checked"</#if>>无
		</td>
	</tr>
	<tr>
		<th width="18%">主要安全生产管理制度名称:&nbsp;</th>
		<td width="32%" colspan="3">
			<@s.textfield id="safetyRules" name="companyInfoModel.safetyRules" cssStyle="width:75%"/>
		</td>
	</tr>
</table>
<@enum.selectAreas "companyInfoModel","div-area","${companyInfoModel.firstArea?if_exists}","${companyInfoModel.secondArea?if_exists}","${companyInfoModel.thirdArea?if_exists}","${companyInfoModel.fouthArea?if_exists}","${companyInfoModel.fifthArea?if_exists}" />
<@enum.initEnumXML /><@enum.initAllEnum />
<script type="text/javascript"> 
<#if companyInfoModel.character?if_exists != "">jQuery("#character").val("${companyInfoModel.character}");</#if>
<#if companyInfoModel.safetyStandards?if_exists != "">jQuery("#safetyStandards").val("${companyInfoModel.safetyStandards}");</#if>
<#if companyInfoModel.industrial?if_exists != "">jQuery("#industrial").val("${companyInfoModel.industrial}");</#if> 
</script>
</@s.form>
<@fkMacros.pageFooter />
