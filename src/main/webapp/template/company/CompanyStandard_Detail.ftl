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

</style>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：行政许可详情 </div></td>
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
		<th width="10%">&nbsp;证书类型:</th>
		<td width="35%">&nbsp;
		<@enum.getSelectEnum companyStandardModel.standardType/>
		</td>
	</tr>
	<tr>
		<th>&nbsp;单位名称:</th>
		<td>&nbsp; ${companyStandardModel.companyInfo.companyName} </td>
	</tr>
	<tr>
		<th>&nbsp;地址:</th>
		<td> ${companyStandardModel.companyInfo.address} </td>
	</tr>
	>

	<tr>
		<th >&nbsp;标准化达标级别:</th>
		<td >&nbsp;
			<@enum.getSelectEnum companyStandardModel.companyLeavel/>
		</td>
	</tr>
	<tr>
		<th >&nbsp;许可证编号:</th>
		<td >&nbsp;${companyStandardModel.certificateNumber}</td>
	</tr>
	
	<tr>
		<th  >&nbsp;有效日期:</th>
		<td >&nbsp;${companyStandardModel.validityBegin} &nbsp;&nbsp; 至 &nbsp;&nbsp; ${companyStandardModel.validityEnd}</td>
	</tr>
	<tr>
		<th >&nbsp;发证日期:</th>
		<td >&nbsp;${companyStandardModel.issueDate}</td>
	</tr>
	<tr>
		<th >&nbsp;发证机关:</th>
		<td >&nbsp;${companyStandardModel.issueUnit}
	</tr>
</table>
<@fkMacros.pageFooter />
