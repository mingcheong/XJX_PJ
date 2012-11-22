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
<@enum.initAreaXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：事故详情</div></td>
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
		<th width="10%">&nbsp;事故大类:</th>
		<td width="35%">&nbsp;<@enum.getSelectEnum '${companyAccidentModel.bigtype}'/></td>
	</tr>
	<tr>
		<th width="10%">&nbsp;事故单位:</th>
		<td width="35%">&nbsp;${companyAccidentModel.accidentUnit.companyName}
	</tr>
	
	<tr>
		<th width="10%">&nbsp;事故报告单位:</th>
		<td width="35%">&nbsp;${companyAccidentModel.accidentReportOrgan.orgName}</td>
	</tr>

	<tr>
		<th width="10%">&nbsp;所在区域</th>
		<td width="35%">&nbsp;
			<@enum.getSelectArea '${companyAccidentModel.firstArea}'/>
			&nbsp;
			<@enum.getSelectArea '${companyAccidentModel.secondArea}'/>
			&nbsp;
			<@enum.getSelectArea '${companyAccidentModel.thirdArea}'/>
		</td>
	</tr>
	
	<tr>
		<th width="10%">&nbsp;事故时间:</th>
		<td width="35%">&nbsp;${companyAccidentModel.accidentDate}</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;直接经济损失:</th>
		<td width="35%">&nbsp;<#if companyAccidentModel.accidentLoss?if_exists> ${companyAccidentModel.accidentLoss}</#if></td>
	</tr>
	<tr>
		<th width="10%">&nbsp;伤亡情况:</th>
		<td width="35%">&nbsp;
			现场共有<#if companyAccidentModel.totalNumber?if_exists> ${companyAccidentModel.totalNumber}</#if>人&nbsp;&nbsp;
			其中死亡 <#if companyAccidentModel.deathNumber?if_exists>  ${companyAccidentModel.deathNumber}</#if>人&nbsp;&nbsp;
			失踪   <#if companyAccidentModel.missedNumber?if_exists>  ${companyAccidentModel.missedNumber}</#if>人&nbsp;&nbsp;
			重伤   <#if companyAccidentModel.seriovsWoundNumber?if_exists>${companyAccidentModel.seriovsWoundNumber}</#if>人&nbsp;&nbsp;
			轻伤<#if companyAccidentModel.minorWoundNumber?if_exists> ${companyAccidentModel.minorWoundNumber}</#if>人
		</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;事故简要概况:</th>
		<td width="35%">&nbsp;${companyAccidentModel.accidentContent}</td>
	</tr>
	<tr>
		<th width="10%">&nbsp;是否上报:</th>
		<td width="35%">&nbsp;
			<#if companyAccidentModel.isReport?if_exists == true>
				是
			<#else>
				否
			</#if>
		</td>
	</tr>
</table>
<@fkMacros.pageFooter />
