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
 <style type="text/css">
  .input_text {
    width: 40px;
    }
  </style>
<@fkMacros.formValidator 'companyReportsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：安全生产执法行动情况统计表 </div></td>
  </tr>
</table>
<@s.form id="companyReportsForm" action="companyReports_show.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="companyReportsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td align="center" colspan="2"><font size="6"><b>安全生产执法行动情况统计表</b></font></td>
	</tr>
	<tr>
		<td align="left">填报单位：${companyReportsModel?if_exists.fkOrganizeModel?if_exists.orgName?default('')}<input type="hidden" name="companyReportsModel.fkOrganizeModel.id" value="${companyReportsModel?if_exists.fkOrganizeModel?if_exists.id?default('')}"></td>
		<td align="right">截止到
		<@s.textfield id="startdate" name="startdate" value="${startdate?default('')}" readonly="true" onFocus="WdatePicker({minDate:'1900-01',dateFmt:'yyyy-MM',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:100px"/>
		<input type="button" onclick="tod();" value="确定">
		</td>
	</tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<td style="background: #f4f7fa;" width="100px">行业(领域)</td>
		<td style="background: #f4f7fa;">字段01</td>
		<td style="background: #f4f7fa;">字段02</td>
		<td style="background: #f4f7fa;">字段03</td>
		<td style="background: #f4f7fa;">字段04</td>
		<td style="background: #f4f7fa;">字段05</td>
		<td style="background: #f4f7fa;">字段06</td>
		<td style="background: #f4f7fa;">字段07</td>
		<td style="background: #f4f7fa;">字段08</td>
		<td style="background: #f4f7fa;">字段09</td>
		<td style="background: #f4f7fa;">字段10</td>
		<td style="background: #f4f7fa;">字段11</td>
		<td style="background: #f4f7fa;">字段12</td>
		<td style="background: #f4f7fa;">字段13</td>
		<td style="background: #f4f7fa;">字段14</td>
		<td style="background: #f4f7fa;">字段15</td>
		<td style="background: #f4f7fa;">字段16</td>
		<td style="background: #f4f7fa;">字段17</td>
		<td style="background: #f4f7fa;">字段18</td>
		<td style="background: #f4f7fa;">字段19</td>
		<td style="background: #f4f7fa;">字段20</td>
	</tr>
	<#list companyReportsModels as o>
	<tr>
		<td style="background: #f4f7fa;">
			${o?if_exists.fkEnumModel?if_exists.enumName?default('')}
			<input type="hidden" name="ety" value="${o?if_exists.fkEnumModel?if_exists.enumCode?default('')}">
			<input type="hidden" name="eid" value="${o?if_exists.fkEnumModel?if_exists.id?default('')}">
			<input type="hidden" name="mid" value="${o?if_exists.id?default('')}">
			<#if o?if_exists.fkEnumModel?if_exists.hasChildren><input type="hidden" name="hsc" value="true"><#else><input type="hidden" name="hsc" value="false"></#if>
			<input type="hidden" name="efi" value="${o?if_exists.fkEnumModel?if_exists.fatherId?default('')}">
		</td>
		<td>${o?if_exists.n1?default('')}</td>
		<td>${o?if_exists.n2?default('')}</td>
		<td>${o?if_exists.n3?default('')}</td>
		<td>${o?if_exists.n4?default('')}</td>
		<td>${o?if_exists.n5?default('')}</td>
		<td>${o?if_exists.n6?default('')}</td>
		<td>${o?if_exists.n7?default('')}</td>
		<td>${o?if_exists.n8?default('')}</td>
		<td>${o?if_exists.n9?default('')}</td>
		<td>${o?if_exists.n10?default('')}</td>
		<td>${o?if_exists.n11?default('')}</td>
		<td>${o?if_exists.n12?default('')}</td>
		<td>${o?if_exists.n13?default('')}</td>
		<td>${o?if_exists.n14?default('')}</td>
		<td>${o?if_exists.n15?default('')}</td>
		<td>${o?if_exists.n16?default('')}</td>
		<td>${o?if_exists.n17?default('')}</td>
		<td>${o?if_exists.n18?default('')}</td>
		<td>${o?if_exists.n19?default('')}</td>
		<td>${o?if_exists.n20?default('')}</td>
	</tr>
	</#list>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
 	 <td>单位负责人</td>
 	 <td>${companyReportsModel?if_exists.unitResponsible?default('')}</td>
 	 <td>填表人</td>
 	 <td>${companyReportsModel?if_exists.fillPerson?default('')}</td>
 	 <td>联系电话</td>
 	 <td>${companyReportsModel?if_exists.contactPhone?default('')}</td>
 	 <td>填报日期</td>
 	 <td>${companyReportsModel?if_exists.fillDate?default('')}</td>
  </tr>
</table>
</@s.form>
<script type="text/javascript">
function tod(){
window.location.href = '${contextPath}/companyReports_show.xhtml?startdate='+jQuery("#startdate").val()+"&m="+Math.round(Math.random() * 10000);
}
</script>
<@fkMacros.pageFooter />
