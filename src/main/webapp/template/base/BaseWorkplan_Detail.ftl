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
<@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：添加baseWorkplanForm </div></td>
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
		<th width="15%"><font color="#FF0000">*</font>标题:&nbsp;</th>
		<td width="35%">${baseWorkplanModel.name?default('')}</td>
		<th width="15%"><font color="#FF0000">*</font>会议类别:&nbsp;</th>
		<td width="35%"><@enum.getSelectEnum code="${baseWorkplanModel.modelType?default('')}"/></td>
	</tr>
	<tr>
		<th width="15%">制定单位:&nbsp;</th>
		<td width="35%">${baseWorkplanModel.ruleUnit?default('')}</td>
		<th width="15%">实施单位:&nbsp;</th>
		<td width="35%">${baseWorkplanModel.implUnit?default('')}</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>类型:&nbsp;</th>
		<td width="35%"><@enum.getSelectEnum code="${baseWorkplanModel.type?default('')}"/></td>
		<th width="15%"><font color="#FF0000">*</font>发布时间:&nbsp;</th>
		<td width="35%">${baseWorkplanModel.releaseDate?default('')}</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>内容:&nbsp;</th>
		<td width="35%" colspan="3">${baseWorkplanModel.content?default('')}</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">${baseWorkplanModel.remark?default('')}</td>
	</tr>
</table>
<@fkMacros.pageFooter />
