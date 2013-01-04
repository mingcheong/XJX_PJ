 <@fkMacros.pageHeader />
 <script type="text/javascript">
jQuery(function(){
		
	     jQuery("body").live("keydown",function (){
	     	if(window.event.keyCode == 13){
	          var id = jQuery(event.srcElement).attr('id');
	          if(id == "addBtn"){
				jQuery("#addBtn").click();
	          }else{
	          	window.event.keyCode = 9;
	          }
			}
	     })
		
		jQuery('#jbDept').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxDept_jsonList.xhtml',
			columns:[[
				{field:'code',title:'部门编码',width:80},
				{field:'name',title:'部门名称',width:100}
			]]
		});	
		
		jQuery('#jbSupplier').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxSupplier_jsonList.xhtml',
			columns:[[
				{field:'code',title:'供应商编码',width:90},
				{field:'name',title:'供应商名称',width:150}
			]]
		});	
		
		jQuery('#jbUser').add('#jbCheckuser').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxEmployee_jsonList.xhtml',
			columns:[[
				{field:'code',title:'员工编号',width:90},
				{field:'name',title:'员工名称',width:150}
			]]
		});	

		jQuery('#jbWarehouse').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxWarehouse_jsonList.xhtml',
			columns:[[
				{field:'code',title:'仓库编码',width:90},
				{field:'name',title:'仓库名称',width:150}
			]]
		});						
		
		jQuery('#detailGrid').datagrid({
			fitColumns: true,
			rownumbers:true,
			width: 'auto',
			height: '200',
			columns:[[
				{field:'jbdBarcode',title:'商品条码',width:120},
				{field:'jbdCode',title:'编码',width:80},
				{field:'jbdName',title:'商品名称',width:200},
				{field:'jbdUnit_juName',title:'单位',width:60,align:'center'},
				{field:'jbdQuantity',title:'数量',width:60,align:'center'},
				{field:'jbdCost',title:'含税进价',width:80,align:'right'},
				{field:'jbdAmount',title:'含税金额',width:80,align:'right'},
				{field:'jbdWAmount',title:'未税金额',width:80,align:'right'},
				{field:'jbdNum',title:'件数',width:60,align:'center'},
				{field:'jbdOverflow',title:'短溢',width:60,align:'center'},
				{field:'jbdRate',title:'税率',width:60,align:'center'}
			]]
		});
			
		jQuery("#addBtn").click(function(){
			if(jQuery("#goodsModel_jgCode").val() == "" || jQuery("#goodsModel_id").val() == "")
				jQuery("#goodsModel_jgCode").focus();
			else if(jQuery("#jbdNum").val() == "")
				jQuery("#jbdNum").focus();	
			else if(jQuery("#jbdQuantity").val() == "")
				jQuery("#jbdQuantity").focus();					
			else if(jQuery("#jbdCost").val() == "")
				jQuery("#jbdCost").focus();
			else{								
				jQuery('#detailGrid').datagrid('appendRow',{
					'goods_id' : jQuery("#goodsModel_id").val(),
					'jbdBarcode' : jQuery("#goodsModel_jgCode").val(),
					'jbdCode' : jQuery("#goodsModel_jgIncode").val(),
					'jbdName' : jQuery("#goodsModel_jgName").val(),
					'jbdUnit_id' : jQuery("#jbdBUnit_id").val(),
					'jbdUnit_juName' : jQuery("#jbdBUnit_juName").val(),
					'jbdQuantity' : jQuery("#jbdQuantity").val(),
					'jbdCost' : jQuery("#jbdCost").val(),
					'jbdAmount' : jQuery("#jbdAmount").val(),
					'jbdWAmount' : jQuery("#jbdWAmount").val(),
					'jbdNum' : jQuery("#jbdNum").val(),
					'jbdOverflow' : jQuery("#jbdOverflow").val(),
					'jbdRate' : jQuery("#jbdRate").val()
				});
				jQuery("#goodsModel_id").val("");
				jQuery("#goodsModel_jgCode").val("");
				jQuery("#goodsModel_jgIncode").val("");
				jQuery("#goodsModel_jgName").val("");
				jQuery("#goodsModel_jgCode").focus();
			}
		});
		
		jQuery("#delBtn").click(function(){
			var row = jQuery('#detailGrid').datagrid('getSelected');
			if (row){
				var index = jQuery('#detailGrid').datagrid('getRowIndex', row);
				jQuery('#detailGrid').datagrid('deleteRow', index);
			}	
		});
		
		jQuery("#addNewBtn").click(function(){
			window.location = "jxBackInventory_insert.xhtml";
		});
			
		jQuery("#goodsModel_jgCode").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
				jQuery.getJSON("jxGoods_getGoods.xhtml", {"jxGoodsModel.jgCode": jQuery(this).val()},
				function(data){
					if(data.error == undefined){
						jQuery("#goodsModel_id").val(data.id);
						jQuery("#goodsModel_jgIncode").val(data.incode);
						jQuery("#goodsModel_jgCode").val(data.code);
						jQuery("#goodsModel_jgName").val(data.name);
						jQuery("#jbdRate").numberbox('setValue',data.rate);
						jQuery("#jbdBUnit_id").val(data.bUnit.id);
						jQuery("#jbdBUnit_juName").val(data.bUnit.juName);
						jQuery("#jbdSpec").numberbox('setValue',data.spec);
						jQuery("#jbdUnit_id").val(data.sUnit.id);
						jQuery("#jbdUnit_juName").val(data.sUnit.juName);							
					}else{
						alert(data.error);
						jQuery("#goodsModel_jgCode").val("");
						jQuery("#goodsModel_jgCode").focus();
					}
				});		    
			}  
		})  			
		
		jQuery("#jbdNum").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
					
				var spec = jQuery("#jbdSpec").val();
				if(spec != ""){
					jQuery("#jbdQuantity").numberbox('setValue',jQuery(this).val()*spec);
				}
			}
		})  		
		
		jQuery('#saveBtn').click(function(){
			if(jQuery('#jxBackInventoryForm').form('validate')){
				var jsonArr = [];
				var rows = jQuery('#detailGrid').datagrid('getRows');
				if(rows.length == 0){
					alert("请填写入库的商品详细信息!");
					return;
				}
				if(window.confirm("请检查供应商，进价等项目是否正确。是否保存？")){
					var jo = null;
					for(var i=0;i<rows.length;i++){
						jo = '{';
						jo += '"goodsModel.id" : "' + rows[i].goods_id + '",';
						jo += '"goodsModel.jgCode" : "' + rows[i].jbdBarcode + '",';
						jo += '"goodsModel.jgIncode" : "' + rows[i].jbdCode + '",';
						jo += '"goodsModel.jgName" : "' + rows[i].jbdName + '",';
						jo += '"jbdUnit.id" : "' + rows[i].jbdUnit_id + '",';
						jo += '"jbdUnit.juName" : "' + rows[i].jbdUnit_juName + '",';
						jo += '"jbdQuantity" : "' + rows[i].jbdQuantity + '",';
						jo += '"jbdCost" : "' + rows[i].jbdCost + '",';
						jo += '"jbdAmount" : "' + rows[i].jbdAmount + '",';
						jo += '"jbdWAmount" : "' + rows[i].jbdWAmount + '",';
						jo += '"jbdNum" : "' + rows[i].jbdNum + '",';
						jo += '"jbdOverflow" : "' + rows[i].jbdOverflow + '",';
						jo += '"jbdRate" : "' + rows[i].jbdRate + '"}';
						jsonArr.push(jo);
					}
					jQuery("#jsonData").val('[' + jsonArr.join(',') + ']');				
					jQuery('#jxBackInventoryForm').submit();
				}
			}
		});	
		
		
});
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：退货出库单录入 </div></td>
  </tr>
</table>
<@s.form id="jxBackInventoryForm" action="jxBackInventory_save.xhtml"  method="post">
<s:token /><@s.hidden name="jxBackInventoryModel.id" />
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>退货单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jbCode" name="jxBackInventoryModel.jbCode" data-options="required:true" style="width:200px;" missingMessage="退货单号不允许为空"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>上一单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jbLastCode" name="jxBackInventoryModel.jbLastCode" data-options="required:true" style="width:200px;" missingMessage="上一单号不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>原始单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jbOcode" name="jxBackInventoryModel.jbOcode" data-options="required:true" style="width:200px;" missingMessage="原始单号不允许为空"/>
		</td>
		<th width="15%">备用:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jbCodemark" name="jxBackInventoryModel.jbCodemark" style="width:200px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>退货部门:&nbsp;</th>
		<td width="35%">
			<select id="jbDept" name="jxBackInventoryModel.jbDept.jdCode" data-options="required:true" style="width:250px;" missingMessage="退货部门不允许为空"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>退货员:&nbsp;</th>
		<td width="35%">
			<select id="jbUser" name="jxBackInventoryModel.jbUser.jeCode" data-options="required:true" style="width:250px;" missingMessage="退货员不允许为空"></select>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>供应商:&nbsp;</th>
		<td width="35%">
			<select id="jbSupplier" name="jxBackInventoryModel.jbSupplier.jsCode" data-options="required:true" style="width:250px;" missingMessage="供应商不允许为空"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>退库日期:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox Wdate" type="text" id="jbDate" name="jxBackInventoryModel.jbDate" value="${jxBackInventoryModel.jbDate?date}" data-options="required:true" style="width:200px;" missingMessage="退库日期不允许为空" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd',errDealMode:1})"/>
		</td>
	</tr>
	<tr>
		<th width="15%">验收员:&nbsp;</th>
		<td width="35%">
			<select id="jbCheckuser" name="jxBackInventoryModel.jbCheckuser.jeCode" style="width:250px;"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>退货仓库:&nbsp;</th>
		<td width="35%">
			<select id="jbWarehouse" name="jxBackInventoryModel.jbWarehouse.jwCode" data-options="required:true" style="width:250px;" missingMessage="退货仓库不允许为空"></select>
		</td>
	</tr>	
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jbRemark" name="jxBackInventoryModel.jbRemark" cssStyle="width:90%;height:65px;"/>	
		</td>
	</tr>			
</table>
<input type="hidden" id="jsonData" name="jsonData"/>
<div style="padding-top:2px;padding-bottom:2px;"><table id="detailGrid"></table></div>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%" style="border-top:0px;" nowrap>商品:&nbsp;</th>
		<td width="85%" colspan="5">
			<input type="hidden" id="goodsModel_id" name="jxBackInventoryModel.goodsModel.id"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgCode" name="jxBackInventoryModel.goodsModel.jgCode" style="width:200px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgIncode" name="jxBackInventoryModel.goodsModel.jgIncode" disabled style="width:100px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgName" name="jxBackInventoryModel.goodsModel.jgName" disabled style="width:250px;"/>
		</td>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jbdTotalNum" name="jxBackInventoryDetailsModel.jbdTotalNum" style="width:100px;" disabled>			
		</td>		
	</tr>	
	<tr>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jbdNum" name="jxBackInventoryDetailsModel.jbdNum" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jbdBUnit_id" name="jxBackInventoryDetailsModel.jbdBUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jbdBUnit_juName" name="jxBackInventoryDetailsModel.jbdBUnit.juName" style="width:50px;"/>×
			<input class="easyui-numberbox" type="text" id="jbdSpec" name="jxBackInventoryDetailsModel.jbdSpec" style="width:50px;"/>	
		</td>
		<th width="15%" nowrap>税率:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jbdRate" name="jxBackInventoryDetailsModel.jbdRate" style="width:100px;"/>
		</td>
		<th width="15%" nowrap>末次含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jbdWCost" name="jxBackInventoryDetailsModel.jbdWCost" style="width:100px;" disabled/>
		</td>	
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jbdTotalQuantity" name="jxBackInventoryDetailsModel.jbdTotalQuantity" style="width:100px;" disabled/>			
		</td>			
	</tr>	
	<tr>
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jbdQuantity" name="jxBackInventoryDetailsModel.jbdQuantity" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jbdUnit_id" name="jxBackInventoryDetailsModel.jbdUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jbdUnit_juName" name="jxBackInventoryDetailsModel.jbdUnit.juName" style="width:50px;"/>
		</td>
		<th width="15%" nowrap>含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jbdCost" name="jxBackInventoryDetailsModel.jbdCost" style="width:100px;" data-options="precision:2"/>
		</td>
		<th width="15%" nowrap>含税金额:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jbdAmount" name="jxBackInventoryDetailsModel.jbdAmount" style="width:100px;" disabled/>			
		</td>	
		<th width="15%" nowrap>含税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jbdTotalAmount" name="jxBackInventoryDetailsModel.jbdTotalAmount" style="width:100px;" disabled/>			
		</td>				
	</tr>	
	<tr>
		<th width="15%" nowrap>短溢:&nbsp;</th>
		<td width="30%">
			<input class="easyui-validatebox" type="text" id="jbdOverflow" name="jxBackInventoryDetailsModel.jbdOverflow" style="width:200px;" validType="length[0,25]" invalidMessage="短溢不能超过25个汉字"/>			
		</td>
		<th width="15%" nowrap>未税金额:&nbsp;</th>
		<td width="20%" colspan="3">
			<input class="easyui-numberbox" type="text" id="jbdWAmount" name="jxBackInventoryDetailsModel.jbdWAmount" style="width:100px;" disabled/>
		</td>
		<th width="15%" nowrap>未税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jbdTotalWAmount" name="jxBackInventoryDetailsModel.jbdTotalWAmount" style="width:100px;" disabled/>
		</td>		
	</tr>
	<tr>
		<td colspan="8" style="text-align:center;">
			<a id="addBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加一条</a>
			<a id="delBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除一条</a>
			<a id="addNewBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加新单</a>
			<a id="saveBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
		</td>
	</tr>									
</table>
</@s.form>
<@fkMacros.pageFooter />
