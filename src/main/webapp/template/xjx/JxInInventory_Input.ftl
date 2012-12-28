 <@fkMacros.pageHeader />
 <script type="text/javascript">
	jQuery(function(){
		
		jQuery('#jiDept').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxDept_jsonList.xhtml',
			columns:[[
				{field:'code',title:'部门编码',width:80},
				{field:'name',title:'部门名称',width:100}
			]]
		});	
		
		jQuery('#jiSupplier').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxSupplier_jsonList.xhtml',
			columns:[[
				{field:'code',title:'供应商编码',width:90},
				{field:'name',title:'供应商名称',width:150}
			]]
		});	
		
		jQuery('#jiUser').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxEmployee_jsonList.xhtml',
			columns:[[
				{field:'code',title:'员工编号',width:90},
				{field:'name',title:'员工名称',width:150}
			]]
		});				
		
		
});
</script>
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
		<th width="15%"><font color="#FF0000">*</font>上一单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jiLastCode" name="jxInInventoryModel.jiLastCode" data-options="required:true" style="width:200px;" missingMessage="上一单号不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>原始单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jiOcode" name="jxInInventoryModel.jiOcode" data-options="required:true" style="width:200px;" missingMessage="原始单号不允许为空"/>
		</td>
		<th width="15%">备用:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jiCodemark" name="jxInInventoryModel.jiCodemark" style="width:200px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>进货部门:&nbsp;</th>
		<td width="35%">
			<select id="jiDept" name="jxInInventoryModel.jiDept.jdCode" data-options="required:true" style="width:250px;" missingMessage="进货部门不允许为空"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>进货员:&nbsp;</th>
		<td width="35%">
			<select id="jiUser" name="jxInInventoryModel.jiUser.jsCode" data-options="required:true" style="width:250px;" missingMessage="进货员不允许为空"></select>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>供应商:&nbsp;</th>
		<td width="35%">
			<select id="jiSupplier" name="jxInInventoryModel.jiSupplier.jsCode" data-options="required:true" style="width:250px;" missingMessage="供应商不允许为空"></select>
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
