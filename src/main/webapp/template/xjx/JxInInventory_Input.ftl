 <@fkMacros.pageHeader />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：进货入库单录入 </div></td>
  </tr>
</table>
<@s.form id="jxInInventoryForm" action="jxInInventory_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxInInventoryModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxInInventoryForm" </@util.menu_save>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>进货单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jiCode" name="jxInInventoryModel.jiCode" data-options="required:true" style="width:200px;" missingMessage="进货单号不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiLastCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiLastCode" name="jxInInventoryModel.jiLastCode" cssStyle="width:75%"/>
			<ui:v for="jiLastCode" rule="require" warn="不允许以空格为开始" empty="jiLastCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiOcode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiOcode" name="jxInInventoryModel.jiOcode" cssStyle="width:75%"/>
			<ui:v for="jiOcode" rule="require" warn="不允许以空格为开始" empty="jiOcode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiCodemark:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiCodemark" name="jxInInventoryModel.jiCodemark" cssStyle="width:75%"/>
			<ui:v for="jiCodemark" rule="require" warn="不允许以空格为开始" empty="jiCodemark不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiDept:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiDept" name="jxInInventoryModel.jiDept" cssStyle="width:75%"/>
			<ui:v for="jiDept" rule="require" warn="不允许以空格为开始" empty="jiDept不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiSupplier:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiSupplier" name="jxInInventoryModel.jiSupplier" cssStyle="width:75%"/>
			<ui:v for="jiSupplier" rule="require" warn="不允许以空格为开始" empty="jiSupplier不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiUser:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiUser" name="jxInInventoryModel.jiUser" cssStyle="width:75%"/>
			<ui:v for="jiUser" rule="require" warn="不允许以空格为开始" empty="jiUser不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiDate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiDate" name="jxInInventoryModel.jiDate" cssStyle="width:75%"/>
			<ui:v for="jiDate" rule="require" warn="不允许以空格为开始" empty="jiDate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiCheckuser:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiCheckuser" name="jxInInventoryModel.jiCheckuser" cssStyle="width:75%"/>
			<ui:v for="jiCheckuser" rule="require" warn="不允许以空格为开始" empty="jiCheckuser不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiWarehouse:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiWarehouse" name="jxInInventoryModel.jiWarehouse" cssStyle="width:75%"/>
			<ui:v for="jiWarehouse" rule="require" warn="不允许以空格为开始" empty="jiWarehouse不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jiRemark:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jiRemark" name="jxInInventoryModel.jiRemark" cssStyle="width:75%"/>
			<ui:v for="jiRemark" rule="require" warn="不允许以空格为开始" empty="jiRemark不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
