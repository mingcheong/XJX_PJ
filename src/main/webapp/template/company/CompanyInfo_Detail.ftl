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
<@enum.initEnumXML /><@enum.initAreaXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：企业详细信息 </div></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
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
		<td width="32%" colspan="3">${companyInfoModel.companyName?default('')}</td>
	</tr>
	<tr>
		<th width="18%"><font color="#FF0000">*</font>企业地址:&nbsp;</th>
		<td width="32%" colspan="3">${companyInfoModel.address?default('')}</td>
	</tr>
	<tr>
		<th width="18%">区域:&nbsp;</th>
		<td width="32%">
		<@enum.getSelectArea code="${companyInfoModel.firstArea?default('')}"/>
		<@enum.getSelectArea code="${companyInfoModel.secondArea?default('')}"/>
		<@enum.getSelectArea code="${companyInfoModel.thirdArea?default('')}"/>
		<@enum.getSelectArea code="${companyInfoModel.fourthArea?default('')}"/>
		<@enum.getSelectArea code="${companyInfoModel.fifthArea?default('')}"/>
		</td>
		<th width="18%">工商登记机关:&nbsp;</th>
		<td width="32%">${companyInfoModel.registration?default('')}</td>
	</tr>
	<tr>
		<th width="18%">经济性质:&nbsp;</th>
		<td width="32%"><@enum.getSelectEnum code="${companyInfoModel.character?default('')}"/></td>
		<th width="18%"><font color="#FF0000">*</font>行业类型:&nbsp;</th>
		<td width="32%"><@enum.getSelectEnum code="${companyInfoModel.industrial?default('')}"/></td>
	</tr>
	<tr>
		<th width="18%"><font color="#FF0000">*</font>法人代表姓名:&nbsp;</th>
		<td width="32%">${companyInfoModel.legalPerson?default('')}</td>
		<th width="18%"><font color="#FF0000">*</font>法人代表联系方式:&nbsp;</th>
		<td width="32%">${companyInfoModel.legalContact?default('')}</td>
	</tr>
	<tr>
		<th width="18%">安全生产主要负责人姓名:&nbsp;</th>
		<td width="32%">${companyInfoModel.principalPerson?default('')}</td>
		<th width="18%">安全生产主要负责人手机:&nbsp;</th>
		<td width="32%">${companyInfoModel.principalMobile?default('')}</td>
	</tr>
	<tr>
		
		<th width="18%">安全管理人员姓名:&nbsp;</th>
		<td width="32%">${companyInfoModel.safetyName?default('')}</td>
		<th width="18%">安全管理人手机:&nbsp;</th>
		<td width="32%">${companyInfoModel.safetyMobile?default('')}</td>
	</tr>
	<tr>
		<th width="18%">职工人数:&nbsp;</th>
		<td width="32%">${companyInfoModel.staffNumber?default('')}</td>
		<th width="18%">技术管理人数:&nbsp;</th>
		<td width="32%">${companyInfoModel.outputNumber?default('')}</td>
	</tr>
	<tr>
	<th width="18%">外来务工人数:&nbsp;</th>
		<td width="32%">${companyInfoModel.migrantNumber?default('')}</td>
		<th width="18%">持证上岗人数:&nbsp;</th>
		<td width="32%">${companyInfoModel.postsNumber?default('')}</td>
		
	</tr>
	<tr>
	<th width="18%">工伤保险:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.insure?if_exists == true>有<#else>无</#if></td>
		<th width="18%">参保人数:&nbsp;</th>
		<td width="32%">${companyInfoModel.insureNumber?default('')}</td>
	</tr>
	<tr>
	<th width="18%">年产值或年销售额:&nbsp;</th>
		<td width="32%">${companyInfoModel.yearSales?default('')}</td>
		<th width="18%">与政府签订协议书:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isAgreement?if_exists == true>有<#else>无</#if></td>
	</tr>
	<tr>
	<th width="18%">安全管理机构设置:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isOrgs?if_exists == true>有<#else>无</#if></td>
		<th width="18%">安全生产管理人员人数 :&nbsp;</th>
		<td width="32%">${companyInfoModel.safetyNumber?default('')}</td>
	</tr>
	<tr>
	<th width="18%">人员密集场所:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isDense?if_exists == true>是<#else>否</#if></td>
		<th width="18%">消防重点单位:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isFirekey?if_exists == true>是<#else>否</#if></td>
	</tr>
	<tr>
	<th width="18%">特种设备:&nbsp;</th>
		<td width="32%" colspan="3">${companyInfoModel.equipmentIds?default('')}</td>
	</tr>
	<tr>
		<th width="18%">消防设施:&nbsp;</th>
		<td width="32%">${companyInfoModel.facilities?default('')}</td>
		<th width="18%">设施、设备管理台帐:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isAccount?if_exists == true>有<#else>无</#if></td>
	</tr>
	<tr>
		<th width="18%">使用危险化学品情况:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isDangerous?if_exists == true>有<#else>无</#if></td>
		<th width="18%">危险化学品仓库:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isChemicals?if_exists == true>有<#else>无</#if></td>
	</tr>
	<tr>
		<th width="18%">安全达标开展情况:&nbsp;</th>
		<td width="32%"><@enum.getSelectEnum code="${companyInfoModel.safetyStandards?default('')}"/>
		</td>
		<th width="18%">是否建立安全生产管理台帐:&nbsp;</th>
		<td width="32%"><#if companyInfoModel.isSafetyAccount?if_exists == true>有<#else>无</#if></td>
	</tr>
	<tr>
		<th width="18%">主要安全生产管理制度名称:&nbsp;</th>
		<td width="32%" colspan="3">${companyInfoModel.safetyRules?default('')}</td>
	</tr>
</table>
<@fkMacros.pageFooter />
