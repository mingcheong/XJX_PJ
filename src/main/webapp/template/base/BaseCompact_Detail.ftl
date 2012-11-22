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
    <td align="center" ><div class="dqwz">您现在的位置：添加baseCompactForm </div></td>
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
		<th width="15%">&nbsp;compactType:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="baseCompactModel.compactType" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;industryTypes:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="baseCompactModel.industryTypes" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;unitChief:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="baseCompactModel.unitChief" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;preparer:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="baseCompactModel.preparer" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;phone:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="baseCompactModel.phone" cssStyle="width:75%"/></td>
	</tr>
</table>
<@fkMacros.pageFooter />
