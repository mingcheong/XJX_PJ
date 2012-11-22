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
    <td align="center" ><div class="dqwz">您现在的位置：培训详情 </div></td>
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
		<th width="15%">&nbsp;培训类型:</th>
		<td width="35%" colspan="3">&nbsp;<@enum.getSelectEnum companyTrainModel.trainType/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;企业名称:</th>
		<td width="35%" colspan="3">&nbsp;${companyTrainModel.companyInfo.companyName}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;所在区域:</th>
		<td width="35%" colspan="3">&nbsp;
			<@enum.getSelectArea '${companyTrainModel.firstArea}'/>
			&nbsp;
			<@enum.getSelectArea '${companyTrainModel.secondArea}'/>
			&nbsp;
			<@enum.getSelectArea '${companyTrainModel.thirdArea}'/>
		</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;地址:</th>
		<td width="35%" colspan="3">&nbsp;${companyTrainModel.companyInfo.address}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;培训人员名称:</th>
		<td width="35%">&nbsp;${companyTrainModel.personName}</td>
 
		<th width="15%">&nbsp;身份证:</th>
		<td width="35%">&nbsp;${companyTrainModel.personIdcard}</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;得分:</th>
		<td width="35%">&nbsp;
			<#if companyTrainModel.score?if_exists!="">	
				${companyTrainModel.score}
			</#if>
		</td>
 
		<th width="15%">&nbsp;联系电话:</th>
		<td width="35%">&nbsp;
			<#if companyTrainModel.score?if_exists!="">	
				${companyTrainModel.personPhone}
			</#if>
		</td>
	</tr>
	<tr>
		<th width="15%">&nbsp;证书号:</th>
		<td width="35%">&nbsp;${companyTrainModel.certificateCode}</td>

		<th width="15%">&nbsp;培训状态:</th>
		<td width="35%" >&nbsp;
			<#if companyTrainModel.state?if_exists==1>
				已培训
			<#else>
				未培训
			</#if>
		</td>
	</tr>
	
</table>
<@fkMacros.pageFooter />
