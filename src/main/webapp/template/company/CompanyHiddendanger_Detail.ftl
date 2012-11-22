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
    <td align="center" ><div class="dqwz">您现在的位置：添加companyHiddendangerForm </div></td>
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
		<th width="15%">企业名称:&nbsp;</th>
		<td width="35%" colspan="2">${companyHiddendangerModel.companyInfoModel.companyName?default('')}</td>
		<th width="15%">隐患编号:&nbsp;</th>
		<td width="35%" colspan="2">${companyHiddendangerModel.code?default('')}</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>单位地址:&nbsp;</th>
		<td width="35%" colspan="2">${companyHiddendangerModel.companyInfoModel.address?default('')}</td>
		<th width="15%"><font color="#FF0000">*</font>市级以上重点工程:&nbsp;</th>
		<td width="35%" colspan="2"><#if companyHiddendangerModel.isAbove?if_exists == true>是<#else>否</#if></td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>隐患地址:&nbsp;</th>
		<td width="35%" colspan="5">${companyHiddendangerModel.dangerAddress?default('')}</td>
	</tr>
	<tr>
		<th width="15%">隐患区域:&nbsp;</th>
		<td width="35%" colspan="5">
		<@enum.getSelectArea code="${companyHiddendangerModel.firstArea?default('')}"/>
		<@enum.getSelectArea code="${companyHiddendangerModel.secondArea?default('')}"/>
		<@enum.getSelectArea code="${companyHiddendangerModel.thirdArea?default('')}"/>
		<@enum.getSelectArea code="${companyHiddendangerModel.fourthArea?default('')}"/>
		<@enum.getSelectArea code="${companyHiddendangerModel.fifthArea?default('')}"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>联系人:&nbsp;</th>
		<td width="15%">${companyHiddendangerModel.dangerContact?default('')}</td>
		<th width="15%"><font color="#FF0000">*</font>联系电话:&nbsp;</th>
		<td width="15%">${companyHiddendangerModel.dangerPhone?default('')}</td>
		<th width="15%">手机:&nbsp;</th>
		<td width="35%">${companyHiddendangerModel.dangerMobile?default('')}</td>
	</tr>
	<tr>
		<th width="15%">隐患基本情况:&nbsp;</th>
		<td width="35%" colspan="5">${companyHiddendangerModel.dangerContent?default('')}</td>
	</tr>
</table>
<@fkMacros.pageFooter />
