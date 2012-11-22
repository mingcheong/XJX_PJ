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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxInventoryForm </div></td>
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
		<th width="15%">&nbsp;jiWarehouse:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="jxInventoryModel.jiWarehouse" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;jiGoods:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="jxInventoryModel.jiGoods" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;jiCursum:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="jxInventoryModel.jiCursum" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;jiTotalsum:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="jxInventoryModel.jiTotalsum" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;jiWastesum:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="jxInventoryModel.jiWastesum" cssStyle="width:75%"/></td>
	</tr>
	<tr>
		<th width="15%">&nbsp;jiSparesum:</th>
		<td width="35%">&nbsp;<@s.textfield  readonly="true" name="jxInventoryModel.jiSparesum" cssStyle="width:75%"/></td>
	</tr>
</table>
<@fkMacros.pageFooter />
