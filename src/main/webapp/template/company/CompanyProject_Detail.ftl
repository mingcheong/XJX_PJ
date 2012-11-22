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
    <td align="center" ><div class="dqwz">${companyProjectModel.companyInfo.companyName}：建设项目详情 </div></td>
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
	<td width="15%" align="right">项目名称&nbsp;</td>
		<td width="35%">
			${companyProjectModel.projectName}
		</td>

		<td width="15%" rowspan="2" align="right">投资金额&nbsp;</td>
		<td width="35%" rowspan="2">
			${companyProjectModel.projectInvestment}
			<span>&nbsp;&nbsp;万元</span>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right">项目地址&nbsp;</td>
		<td width="35%">
			${companyProjectModel.projectAddress}
		</td>
	</tr>
	
	<tr>
		<td width="15%" align="right">项目类型&nbsp;</td>
		<td width="35%">
			<@enum.getSelectEnum companyProjectModel.projectType/>
		</td>

		<td width="15%" align="right">设施类型&nbsp;</td>
		<td width="35%">
			<@enum.getSelectEnum companyProjectModel.facilitiesType/>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right">土地性质&nbsp;</td>
		<td width="35%" colspan="3">
			<@enum.getSelectEnum companyProjectModel.landType/>
		</td>
	</tr>
	<tr>
		<td width="15%" align="right">规划许可情况&nbsp;</td>
		<td width="35%" colspan="3">
			<@s.textarea id="content1" name="companyProjectModel.content1" cssStyle="width:75%;height:120" readOnly="true"/>

		</td>
	</tr>
	<tr>
		<td width="15%" align="right" style="line-height:18px">
			投资主管部门对</br>建设项目是否进</br>行审批（核准、备案）？</br>若无，无需对项目</br>审批（核准、备案</br>）原因的说明。
			
		</td>
		<td width="35%" colspan="3" style="line-height:18px">
			<@s.textarea id="content2" name="companyProjectModel.content2" cssStyle="width:75%;height:120" readOnly="true"/>

		</td>
	</tr>
	<tr>
		<td width="15%" align="right" style="line-height:18px">建设项目主要内容</br>，工艺及技术来源</td>
		<td width="35%" colspan="3" >
			<@s.textarea id="content3" name="companyProjectModel.content3" cssStyle="width:75%;height:120" readOnly="true"/>

		</td>
	</tr>
	<tr>
		<td width="15%" align="right" style="line-height:18px">项目实施后，危险化学产品（包括副产、中间产品）品种、能力的前后变化。</td>
		<td width="35%" colspan="3">
			<@s.textarea id="content4" name="companyProjectModel.content4" cssStyle="width:75%;height:120" readOnly="true"/>

		</td>
	</tr>
</table>
<@fkMacros.pageFooter />
