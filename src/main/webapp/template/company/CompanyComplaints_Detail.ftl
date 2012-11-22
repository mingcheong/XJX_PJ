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
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：举报详情 </div></td>
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
		<th width="15%">&nbsp;来电日期:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.callsDate}</td>
	 
		<th width="15%">&nbsp;文号:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.paperNumber}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;摘要:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.digest}</td>
 
		<th width="15%">&nbsp;领导姓名:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.leaderName}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;举报人姓名:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.complaintsName}</td>
	 
		<th width="15%">&nbsp;督办情况:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.supervisory}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;是否办妥:</th>
		<td width="35%">&nbsp;
			<#if companyComplaintsModel.isAppropriate?if_exists == true>
				是
			<#else>
				否
			</#if>
		</td>
	 
		<th width="15%">&nbsp;受理人:</th>
		<td width="35%">&nbsp;${companyComplaintsModel.callsName}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;备注:</th>
		<td width="35%" colspan="3">&nbsp;
		<@s.textarea id="remark" name="companyComplaintsModel.remark" cssStyle="width:90%;" rows="15" readOnly="true"/>
		</td>
	</tr>
</table>
<@fkMacros.pageFooter />
