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
		
		jQuery('#jsDept').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxDept_jsonList.xhtml',
			columns:[[
				{field:'code',title:'部门编码',width:80},
				{field:'name',title:'部门名称',width:100}
			]]
		});	
		
		jQuery('#jsUser').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxEmployee_jsonList.xhtml',
			columns:[[
				{field:'code',title:'员工编号',width:90},
				{field:'name',title:'员工名称',width:150}
			]]
		});	
		
		jQuery('#jsCustomer').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxCustomer_jsonList.xhtml',
			columns:[[
				{field:'code',title:'客户编码',width:80},
				{field:'name',title:'客户名称',width:100}
			]]
		});		
		
		jQuery('#jsSettlement').combogrid({
			panelWidth:200,
			idField:'code',
			textField:'name',
			url:'jxSettlementType_ajax.xhtml',
			columns:[[
				{field:'code',title:'编码',width:80},
				{field:'name',title:'名称',width:100}
			]]
		});			

		jQuery('#jsWarehouse').combogrid({
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
				{field:'jsdBarcode',title:'商品条码',width:120},
				{field:'jsdCode',title:'编码',width:80},
				{field:'jsdName',title:'商品名称',width:200},
				{field:'jsdUnit_juName',title:'单位',width:60,align:'center'},
				{field:'jsdQuantity',title:'数量',width:60,align:'center'},
				{field:'jsdCost',title:'含税进价',width:80,align:'right'},
				{field:'jsdAmount',title:'含税金额',width:80,align:'right'},
				{field:'jsdWAmount',title:'未税金额',width:80,align:'right'},
				{field:'jsdNum',title:'件数',width:60,align:'center'},
				{field:'jsdOverflow',title:'短溢',width:60,align:'center'},
				{field:'jsdRate',title:'税率',width:60,align:'center'}
			]]
		});
			
		jQuery("#addBtn").click(function(){
			if(jQuery("#goodsModel_jgCode").val() == "" || jQuery("#goodsModel_id").val() == "")
				jQuery("#goodsModel_jgCode").focus();
			else if(jQuery("#jsdNum").val() == "")
				jQuery("#jsdNum").focus();	
			else if(jQuery("#jsdQuantity").val() == "")
				jQuery("#jsdQuantity").focus();					
			else if(jQuery("#jsdCost").val() == "")
				jQuery("#jsdCost").focus();
			else{								
				jQuery('#detailGrid').datagrid('appendRow',{
					'goods_id' : jQuery("#goodsModel_id").val(),
					'jsdBarcode' : jQuery("#goodsModel_jgCode").val(),
					'jsdCode' : jQuery("#goodsModel_jgIncode").val(),
					'jsdName' : jQuery("#goodsModel_jgName").val(),
					'jsdUnit_id' : jQuery("#jsdBUnit_id").val(),
					'jsdUnit_juName' : jQuery("#jsdBUnit_juName").val(),
					'jsdQuantity' : jQuery("#jsdQuantity").val(),
					'jsdCost' : jQuery("#jsdCost").val(),
					'jsdAmount' : jQuery("#jsdAmount").val(),
					'jsdWAmount' : jQuery("#jsdWAmount").val(),
					'jsdNum' : jQuery("#jsdNum").val(),
					'jsdOverflow' : jQuery("#jsdOverflow").val(),
					'jsdRate' : jQuery("#jsdRate").val()
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
			window.location = "jxMoveInventory_insert.xhtml";
		});
			
		jQuery("#goodsModel_jgCode").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
				var warehouse = jQuery('#jsWarehouse').combogrid('getValue');
				if(warehouse == ""){
					alert("提货仓库不能为空！")
					return;
				}
				jQuery.getJSON("jxGoods_getGoods.xhtml", {"jxGoodsModel.jgCode": jQuery(this).val(),"warehouseModel.jwCode": warehouse},
				function(data){
					if(data.error == undefined){
						jQuery("#goodsModel_id").val(data.id);
						jQuery("#goodsModel_jgIncode").val(data.incode);
						jQuery("#goodsModel_jgCode").val(data.code);
						jQuery("#goodsModel_jgName").val(data.name);
						jQuery("#jsdRate").numberbox('setValue',data.rate);
						jQuery("#jsdBUnit_id").val(data.bUnit.id);
						jQuery("#jsdBUnit_juName").val(data.bUnit.juName);
						jQuery("#jsdSpec").numberbox('setValue',data.spec);
						jQuery("#jsdUnit_id").val(data.sUnit.id);
						jQuery("#jsdUnit_juName").val(data.sUnit.juName);		
						jQuery("#inventory_curSum").val(data.inventory.curSum);
						jQuery("#inventory_totalSum").val(data.inventory.totalSum);												
						jQuery("#inventory_spareSum").val(data.inventory.spareSum);												
						jQuery("#inventory_wasteSum").val(data.inventory.wasteSum);												
					}else{
						alert(data.error);
						jQuery("#goodsModel_jgCode").val("");
						jQuery("#goodsModel_jgCode").focus();
					}
				});		    
			}  
		})  			
		
		jQuery("#jsdNum").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
					
				var spec = jQuery("#jsdSpec").val();
				if(spec != ""){
					jQuery("#jsdQuantity").numberbox('setValue',jQuery(this).val()*spec);
				}
			}
		})  		
		
		jQuery('#saveBtn').click(function(){
			if(jQuery('#jxSalesForm').form('validate')){
				var jsonArr = [];
				
				var rows = jQuery('#detailGrid').datagrid('getRows');
				if(rows.length == 0){
					alert("请填写移库的商品详细信息!");
					return;
				}
				if(window.confirm("请检查供应商，进价等项目是否正确。是否保存？")){
					var jo = null;
					for(var i=0;i<rows.length;i++){
						jo = '{';
						jo += '"goodsModel.id" : "' + rows[i].goods_id + '",';
						jo += '"goodsModel.jgCode" : "' + rows[i].jsdBarcode + '",';
						jo += '"goodsModel.jgIncode" : "' + rows[i].jsdCode + '",';
						jo += '"goodsModel.jgName" : "' + rows[i].jsdName + '",';
						jo += '"jsdUnit.id" : "' + rows[i].jsdUnit_id + '",';
						jo += '"jsdUnit.juName" : "' + rows[i].jsdUnit_juName + '",';
						jo += '"jsdQuantity" : "' + rows[i].jsdQuantity + '",';
						jo += '"jsdCost" : "' + rows[i].jsdCost + '",';
						jo += '"jsdAmount" : "' + rows[i].jsdAmount + '",';
						jo += '"jsdWAmount" : "' + rows[i].jsdWAmount + '",';
						jo += '"jsdNum" : "' + rows[i].jsdNum + '",';
						jo += '"jsdOverflow" : "' + rows[i].jsdOverflow + '",';
						jo += '"jsdRate" : "' + rows[i].jsdRate + '"}';
						jsonArr.push(jo);
					}
					jQuery("#jsonData").val('[' + jsonArr.join(',') + ']');				
					jQuery('#jxSalesForm').ajaxSubmit(function(obj) { 
						if(obj != undefined){
							if(obj.msg != undefined){
								alert(obj.msg);
								window.location.reload();
							}else{
								alert(obj.error);
							}
						}
					}); 			
				}
			}
		});	
		
		
});
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：批发销售 </div></td>
  </tr>
</table>
<@s.form id="jxSalesForm" action="jxSales_save.xhtml"  method="post">
<s:token /><@s.hidden name="jxSalesModel.id" />
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>原始单号:&nbsp;</th>
		<td width="20%">
			<input class="easyui-validatebox" type="text" id="jsOcode" name="jxSalesModel.jsOcode" data-options="required:true" style="width:200px;" missingMessage="原始单号不允许为空"/>
		</td>
		<th width="15%">单据号:&nbsp;</th>
		<td width="20%">
			<input class="easyui-validatebox" type="text" id="jsNum" name="jxSalesModel.jsNum" data-options="required:true" style="width:200px;" missingMessage="单据号不允许为空"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>上一单号:&nbsp;</th>
		<td width="20%">
			<input class="easyui-validatebox" type="text" id="jsLastCode" name="jxSalesModel.jsLastCode" data-options="required:true" style="width:200px;" missingMessage="上一单号不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>销售部门:&nbsp;</th>
		<td width="20%" colspan="3">
			<select id="jsDept" name="jxSalesModel.jsDept.jdCode" data-options="required:true" style="width:250px;" missingMessage="销售部门不允许为空"></select>
		</td>		
		<th width="15%"><font color="#FF0000">*</font>提货仓库:&nbsp;</th>
		<td width="20%">
			<select id="jsWarehouse" name="jxSalesModel.jsWarehouse.jwCode" data-options="required:true" style="width:250px;" missingMessage="提货仓库不允许为空"></select>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>所属客户:&nbsp;</th>
		<td width="20%">
			<select id="jsCustomer" name="jxSalesModel.jsCustomer.jcCode" data-options="required:true" style="width:250px;" missingMessage="所属客户不允许为空"></select>
		</td>		
		<th width="15%"><font color="#FF0000">*</font>出库日期:&nbsp;</th>
		<td width="20%">
			<input class="easyui-validatebox Wdate" type="text" id="jsDate" name="jxSalesModel.jsDate" value="${jxSalesModel.jsDate?date}" data-options="required:true" style="width:200px;" missingMessage="出库日期不允许为空" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd',errDealMode:1})"/>
		</td>	
		<th width="15%"><font color="#FF0000">*</font>销售员:&nbsp;</th>
		<td width="20%">
			<select id="jsUser" name="jxSalesModel.jsUser.jeCode" data-options="required:true" style="width:250px;" missingMessage="销售员不允许为空"></select>
		</td>				
	</tr>		
	<tr>
		<th width="15%">结算类型:&nbsp;</th>
		<td width="20%">
			<select id="jsSettlement" name="jxSalesModel.jsSettlement.jsCode" style="width:200px;"></select>
		</td>	
		<th width="15%">本单税率:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jsRate" name="jxSalesModel.jsRate" style="width:100px;"/>
		</td>
		<th width="15%">已提货:&nbsp;</th>
		<td width="20%">
			<input type="text" id="jsDelivery" name="jxSalesModel.jsDelivery" style="width:200px;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textarea id="jsRemark" name="jxSalesModel.jsRemark" cssStyle="width:90%;height:65px;"/>	
		</td>
	</tr>			
</table>
<input type="hidden" id="jsonData" name="jsonData"/>
<div style="padding-top:2px;padding-bottom:2px;"><table id="detailGrid"></table></div>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%" style="border-top:0px;" nowrap>商品:&nbsp;</th>
		<td width="85%" colspan="5">
			<input type="hidden" id="goodsModel_id" name="jxSalesModel.goodsModel.id"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgCode" name="jxSalesModel.goodsModel.jgCode" style="width:200px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgIncode" name="jxSalesModel.goodsModel.jgIncode" disabled style="width:100px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgName" name="jxSalesModel.goodsModel.jgName" disabled style="width:250px;"/>
		</td>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jsdTotalNum" name="jxSalesDetailsModel.jsdTotalNum" style="width:100px;" disabled>			
		</td>		
	</tr>	
	<tr>
		<th width="15%" style="border-top:0px;" nowrap>库存:&nbsp;</th>
		<td width="85%" colspan="5">
			可用<input  type="text" id="inventory_curSum" style="width:60px;" disabled/>
			总<input  type="text" id="inventory_totalSum" style="width:60px;" disabled/>
			废品<input  type="text" id="inventory_wasteSum" style="width:60px;" disabled/>
			备用<input  type="text" id="inventory_spareSum" style="width:60px;" disabled/>
		</td>
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jsdTotalQuantity" name="jxSalesDetailsModel.jsdTotalQuantity" style="width:100px;" disabled/>			
		</td>		
	</tr>		
	<tr>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jsdNum" name="jxSalesDetailsModel.jsdNum" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jsdBUnit_id" name="jxSalesDetailsModel.jsdBUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jsdBUnit_juName" name="jxSalesDetailsModel.jsdBUnit.juName" style="width:50px;"/>×
			<input class="easyui-numberbox" type="text" id="jsdSpec" name="jxSalesDetailsModel.jsdSpec" style="width:50px;"/>	
		</td>
		<th width="15%" nowrap>税率:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jsdRate" name="jxSalesDetailsModel.jsdRate" style="width:100px;"/>
		</td>
		<th width="15%" nowrap>末次含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jsdWCost" name="jxSalesDetailsModel.jsdWCost" style="width:100px;" disabled/>
		</td>	
		<th width="15%" nowrap>含税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jsdTotalAmount" name="jxSalesDetailsModel.jsdTotalAmount" style="width:100px;" disabled/>			
		</td>			
	</tr>	
	<tr>
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jsdQuantity" name="jxSalesDetailsModel.jsdQuantity" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jsdUnit_id" name="jxSalesDetailsModel.jsdUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jsdUnit_juName" name="jxSalesDetailsModel.jsdUnit.juName" style="width:50px;"/>
		</td>
		<th width="15%" nowrap>含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jsdCost" name="jxSalesDetailsModel.jsdCost" style="width:100px;" data-options="precision:2"/>
		</td>
		<th width="15%" nowrap>含税金额:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jsdAmount" name="jxSalesDetailsModel.jsdAmount" style="width:100px;" disabled/>			
		</td>	
		<th width="15%" nowrap>未税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jsdTotalWAmount" name="jxSalesDetailsModel.jsdTotalWAmount" style="width:100px;" disabled/>
		</td>			
	</tr>	
	<tr>
		<th width="15%" nowrap>短溢:&nbsp;</th>
		<td width="30%">
			<input class="easyui-validatebox" type="text" id="jsdOverflow" name="jxSalesDetailsModel.jsdOverflow" style="width:200px;" validType="length[0,25]" invalidMessage="短溢不能超过25个汉字"/>			
		</td>
		<th width="15%" nowrap>未税金额:&nbsp;</th>
		<td width="20%" colspan="5">
			<input class="easyui-numberbox" type="text" id="jsdWAmount" name="jxSalesDetailsModel.jsdWAmount" style="width:100px;" disabled/>
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