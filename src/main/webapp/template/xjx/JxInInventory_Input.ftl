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
		
		jQuery('#jiUser').add('#jiCheckuser').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxEmployee_jsonList.xhtml',
			columns:[[
				{field:'code',title:'员工编号',width:90},
				{field:'name',title:'员工名称',width:150}
			]]
		});	

		jQuery('#jiWarehouse').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxWarehouse_jsonList.xhtml',
			columns:[[
				{field:'code',title:'仓库编码',width:90},
				{field:'name',title:'仓库名称',width:150}
			]]
		});						
		
			jQuery('#tt').datagrid({
				fitColumns: false,
				rownumbers:true,
				nowrap:false,
				width: '950',
				height: '200',
				columns:[[
					{field:'itemid',title:'商品条码',width:80},
					{field:'productid',title:'编码',width:120},
					{field:'listprice',title:'商品名称',width:80,align:'right'},
					{field:'unitcost',title:'单位',width:80,align:'right'},
					{field:'attr1',title:'数量',width:150},
					{field:'attr1',title:'含税进价',width:80},
					{field:'attr1',title:'含税金额',width:80},
					{field:'attr1',title:'件数',width:80},
					{field:'attr1',title:'短溢',width:80},
					{field:'attr1',title:'税率',width:80},
					{field:'status',title:'Status',width:60,align:'center'}
				]],
				onHeaderContextMenu: function(e, field){
					e.preventDefault();
					if (!jQuery('#tmenu').length){
						createColumnMenu();
					}
					jQuery('#tmenu').menu('show', {
						left:e.pageX,
						top:e.pageY
					});
				}
			});
			
			jQuery('#goodsModel').combogrid({  
                panelWidth:500,  
                idField:'mallid', //ID字段  
                textField:'mallname', //显示的字段  
                url:"../global/datagrid.aspx?act=malllist",  
                fitColumns: true,  
                striped: true,  
                editable:true,  
                pagination : true,//是否分页  
                rownumbers:true,//序号  
                collapsible:false,//是否可折叠的  
                fit: true,//自动大小  
                pageSize: 10,//每页显示的记录条数，默认为10  
                pageList: [10],//可以设置每页记录条数的列表  
                method:'post',  
                columns:[[  
                    {field:'mallname',title:'商城名称',width:150,sortable:true},
                    {field:'url',title:'网址',width:150} 
                ]],
                keyHandler: {
                    up: function() {},
                    down: function() {},
                    enter: function() {},
                    query: function(q) {
                        //动态搜索
                        jQuery('#goodsModel').combogrid("grid").datagrid("reload", { 'keyword': q });
                        jQuery('#goodsModel').combogrid("setValue", q);
                    }
                }
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
		<th width="15%"><font color="#FF0000">*</font>入库日期:&nbsp;</th>
		<td width="35%">
			<input class="easyui-datebox" type="text" id="jiDate" name="jxInInventoryModel.jiDate" data-options="required:true" style="width:200px;" missingMessage="入库日期不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%">验收员:&nbsp;</th>
		<td width="35%">
			<select id="jiCheckuser" name="jxInInventoryModel.jiCheckuser.jsCode" style="width:250px;"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>进货仓库:&nbsp;</th>
		<td width="35%">
			<select id="jiWarehouse" name="jxInInventoryModel.jiWarehouse.jwCode" data-options="required:true" style="width:250px;" missingMessage="进货仓库不允许为空"></select>
		</td>
	</tr>	
	<tr>
		<td colspan="4">
			<table id="tt"></table>
		</td>
	</tr>
	<tr>
		<th width="15%">商品:&nbsp;</th>
		<td width="85%" colspan="3">
			<select id="goodsModel" name="jxInInventoryDetailsModel.goodsModel.jgCode"  style="width:200px;"></select>
			<input class="easyui-validatebox" type="text" id="goodsModel.jgCode" name="jxInInventoryModel.goodsModel.jgCode" disabled style="width:100px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel.jgName" name="jxInInventoryModel.goodsModel.jgName" disabled style="width:250px;"/>
		</td>
	</tr>	
	<tr>
		<th width="15%">件数:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidNum" name="jxInInventoryDetailsModel.jidNum" style="width:100px;" data-options="min:1"/>			
			<input type="hidden" id="jidUnit.juCode" name="jxInInventoryDetailsModel.jidUnit.juCode"/>
			<input class="easyui-validatebox" type="text" id="jidUnit.juName" name="jxInInventoryDetailsModel.jidUnit.juName" style="width:60px;"/>×
			<input class="easyui-numberbox" type="text" id="jidSpec" name="jxInInventoryDetailsModel.jidSpec" style="width:60px;"/>	
		</td>
		<th width="15%">税率:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidRate" name="jxInInventoryDetailsModel.jidRate" style="width:100px;" data-options="min:0,max:100"/>
		</td>
	</tr>	
	<tr>
		<th width="15%">数量:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidQuantity" name="jxInInventoryDetailsModel.jidQuantity" style="width:100px;" data-options="min:1"/>			
			<input type="hidden" id="jidBUnit.juCode" name="jxInInventoryDetailsModel.jidBUnit.juCode"/>
			<input class="easyui-validatebox" type="text" id="jidBUnit.juName" name="jxInInventoryDetailsModel.jidBUnit.juName" style="width:60px;"/>
		</td>
		<th width="15%">含税进价:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidCost" name="jxInInventoryDetailsModel.jidCost" style="width:100px;" data-options="precision:2"/>
		</td>
	</tr>	
	<tr>
		<th width="15%">短溢:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jidOverflow" name="jxInInventoryDetailsModel.jidOverflow" style="width:200px;" validType="length[0,25]" invalidMessage="短溢不能超过25个汉字"/>			
		</td>
		<th width="15%">末次含税进价:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidWCost" name="jxInInventoryDetailsModel.jidWCost" style="width:100px;" disabled/>
		</td>
	</tr>	
	<tr>
		<th width="15%">含税金额:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidAmount" name="jxInInventoryDetailsModel.jidAmount" style="width:100px;" disabled/>			
		</td>
		<th width="15%">未税金额:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jidWAmount" name="jxInInventoryDetailsModel.jidWAmount" style="width:100px;" disabled/>
		</td>
	</tr>								
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jiRemark" name="jxInInventoryModel.jiRemark" cssStyle="width:90%;height:65px;"/>	
		</td>
	</tr>		
</table>
</@s.form>
<@fkMacros.pageFooter />
