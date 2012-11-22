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
<@enum.initEnumXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：健康防治详情 </div></td>
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
		<th width="10%">&nbsp;企业名称:</th>
		<td width="40%">&nbsp;${baseHealthModel.companyInfo.companyName}</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;地址:</th>
		<td width="40%">&nbsp;${baseHealthModel.companyInfo.address}</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;工种:</th>
		<td width="40%">&nbsp;<@enum.getSelectEnum '${baseHealthModel.workType}'/></td>
	</tr>
	<tr>
		<th width="10%">&nbsp;工作场所:</th>
		<td width="40%">&nbsp;${baseHealthModel.workPlace}</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;职工人数:</th>
		<td width="40%">&nbsp;${baseHealthModel.staffNum}</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;健康情况:</th>
		<td width="40%">&nbsp;<@s.textarea id="scription" name="baseHealthModel.scription" cssStyle="width:600;height:200" readOnly="true"/></td>
	</tr>
</table>
<@fkMacros.pageFooter />
