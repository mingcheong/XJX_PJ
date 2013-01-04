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
		
		jQuery('#detailGrid').datagrid({
			fitColumns: true,
			rownumbers:true,
			width: 'auto',
			height: '200',
			columns:[[
				{field:'jidBarcode',title:'商品条码',width:120},
				{field:'jidCode',title:'编码',width:80},
				{field:'jidName',title:'商品名称',width:200},
				{field:'jidUnit_juName',title:'单位',width:60,align:'center'},
				{field:'jidQuantity',title:'数量',width:60,align:'center'},
				{field:'jidCost',title:'含税进价',width:80,align:'right'},
				{field:'jidAmount',title:'含税金额',width:80,align:'right'},
				{field:'jidWAmount',title:'未税金额',width:80,align:'right'},
				{field:'jidNum',title:'件数',width:60,align:'center'},
				{field:'jidOverflow',title:'短溢',width:60,align:'center'},
				{field:'jidRate',title:'税率',width:60,align:'center'}
			]]
		});
			
		jQuery("#addBtn").click(function(){
			if(jQuery("#goodsModel_jgCode").val() == "" || jQuery("#goodsModel_id").val() == "")
				jQuery("#goodsModel_jgCode").focus();
			else if(jQuery("#jidNum").val() == "")
				jQuery("#jidNum").focus();	
			else if(jQuery("#jidQuantity").val() == "")
				jQuery("#jidQuantity").focus();					
			else if(jQuery("#jidCost").val() == "")
				jQuery("#jidCost").focus();
			else{								
				jQuery('#detailGrid').datagrid('appendRow',{
					'goods_id' : jQuery("#goodsModel_id").val(),
					'jidBarcode' : jQuery("#goodsModel_jgCode").val(),
					'jidCode' : jQuery("#goodsModel_jgIncode").val(),
					'jidName' : jQuery("#goodsModel_jgName").val(),
					'jidUnit_id' : jQuery("#jidBUnit_id").val(),
					'jidUnit_juName' : jQuery("#jidBUnit_juName").val(),
					'jidQuantity' : jQuery("#jidQuantity").val(),
					'jidCost' : jQuery("#jidCost").val(),
					'jidAmount' : jQuery("#jidAmount").val(),
					'jidWAmount' : jQuery("#jidWAmount").val(),
					'jidNum' : jQuery("#jidNum").val(),
					'jidOverflow' : jQuery("#jidOverflow").val(),
					'jidRate' : jQuery("#jidRate").val()
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
			window.location = "jxInInventory_insert.xhtml";
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
						jQuery("#jidRate").numberbox('setValue',data.rate);
						jQuery("#jidBUnit_id").val(data.bUnit.id);
						jQuery("#jidBUnit_juName").val(data.bUnit.juName);
						jQuery("#jidSpec").numberbox('setValue',data.spec);
						jQuery("#jidUnit_id").val(data.sUnit.id);
						jQuery("#jidUnit_juName").val(data.sUnit.juName);							
					}else{
						alert(data.error);
						jQuery("#goodsModel_jgCode").val("");
						jQuery("#goodsModel_jgCode").focus();
					}
				});		    
			}  
		})  			
		
		jQuery("#jidNum").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
					
				var spec = jQuery("#jidSpec").val();
				if(spec != ""){
					jQuery("#jidQuantity").numberbox('setValue',jQuery(this).val()*spec);
				}
			}
		})  		
		
		jQuery('#saveBtn').click(function(){
			if(jQuery('#jxInInventoryForm').form('validate')){
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
						jo += '"goodsModel.jgCode" : "' + rows[i].jidBarcode + '",';
						jo += '"goodsModel.jgIncode" : "' + rows[i].jidCode + '",';
						jo += '"goodsModel.jgName" : "' + rows[i].jidName + '",';
						jo += '"jidUnit.id" : "' + rows[i].jidUnit_id + '",';
						jo += '"jidUnit.juName" : "' + rows[i].jidUnit_juName + '",';
						jo += '"jidQuantity" : "' + rows[i].jidQuantity + '",';
						jo += '"jidCost" : "' + rows[i].jidCost + '",';
						jo += '"jidAmount" : "' + rows[i].jidAmount + '",';
						jo += '"jidWAmount" : "' + rows[i].jidWAmount + '",';
						jo += '"jidNum" : "' + rows[i].jidNum + '",';
						jo += '"jidOverflow" : "' + rows[i].jidOverflow + '",';
						jo += '"jidRate" : "' + rows[i].jidRate + '"}';
						jsonArr.push(jo);
					}
					jQuery("#jsonData").val('[' + jsonArr.join(',') + ']');				
					jQuery('#jxInInventoryForm').submit();
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
			<select id="jiUser" name="jxInInventoryModel.jiUser.jeCode" data-options="required:true" style="width:250px;" missingMessage="进货员不允许为空"></select>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>供应商:&nbsp;</th>
		<td width="35%">
			<select id="jiSupplier" name="jxInInventoryModel.jiSupplier.jsCode" data-options="required:true" style="width:250px;" missingMessage="供应商不允许为空"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>入库日期:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox Wdate" type="text" id="jiDate" name="jxInInventoryModel.jiDate" value="${jxInInventoryModel.jiDate?date}" data-options="required:true" style="width:200px;" missingMessage="入库日期不允许为空" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd',errDealMode:1})"/>
		</td>
	</tr>
	<tr>
		<th width="15%">验收员:&nbsp;</th>
		<td width="35%">
			<select id="jiCheckuser" name="jxInInventoryModel.jiCheckuser.jeCode" style="width:250px;"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>进货仓库:&nbsp;</th>
		<td width="35%">
			<select id="jiWarehouse" name="jxInInventoryModel.jiWarehouse.jwCode" data-options="required:true" style="width:250px;" missingMessage="进货仓库不允许为空"></select>
		</td>
	</tr>	
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jiRemark" name="jxInInventoryModel.jiRemark" cssStyle="width:90%;height:65px;"/>	
		</td>
	</tr>			
</table>
<input type="hidden" id="jsonData" name="jsonData"/>
<div style="padding-top:2px;padding-bottom:2px;"><table id="detailGrid"></table></div>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%" style="border-top:0px;" nowrap>商品:&nbsp;</th>
		<td width="85%" colspan="5">
			<input type="hidden" id="goodsModel_id" name="jxInInventoryModel.goodsModel.id"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgCode" name="jxInInventoryModel.goodsModel.jgCode" style="width:200px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgIncode" name="jxInInventoryModel.goodsModel.jgIncode" disabled style="width:100px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgName" name="jxInInventoryModel.goodsModel.jgName" disabled style="width:250px;"/>
		</td>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jidTotalNum" name="jxInInventoryDetailsModel.jidTotalNum" style="width:100px;" disabled>			
		</td>		
	</tr>	
	<tr>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jidNum" name="jxInInventoryDetailsModel.jidNum" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jidBUnit_id" name="jxInInventoryDetailsModel.jidBUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jidBUnit_juName" name="jxInInventoryDetailsModel.jidBUnit.juName" style="width:50px;"/>×
			<input class="easyui-numberbox" type="text" id="jidSpec" name="jxInInventoryDetailsModel.jidSpec" style="width:50px;"/>	
		</td>
		<th width="15%" nowrap>税率:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jidRate" name="jxInInventoryDetailsModel.jidRate" style="width:100px;"/>
		</td>
		<th width="15%" nowrap>末次含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jidWCost" name="jxInInventoryDetailsModel.jidWCost" style="width:100px;" disabled/>
		</td>	
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jidTotalQuantity" name="jxInInventoryDetailsModel.jidTotalQuantity" style="width:100px;" disabled/>			
		</td>			
	</tr>	
	<tr>
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jidQuantity" name="jxInInventoryDetailsModel.jidQuantity" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jidUnit_id" name="jxInInventoryDetailsModel.jidUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jidUnit_juName" name="jxInInventoryDetailsModel.jidUnit.juName" style="width:50px;"/>
		</td>
		<th width="15%" nowrap>含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jidCost" name="jxInInventoryDetailsModel.jidCost" style="width:100px;" data-options="precision:2"/>
		</td>
		<th width="15%" nowrap>含税金额:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jidAmount" name="jxInInventoryDetailsModel.jidAmount" style="width:100px;" disabled/>			
		</td>	
		<th width="15%" nowrap>含税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jidTotalAmount" name="jxInInventoryDetailsModel.jidTotalAmount" style="width:100px;" disabled/>			
		</td>				
	</tr>	
	<tr>
		<th width="15%" nowrap>短溢:&nbsp;</th>
		<td width="30%">
			<input class="easyui-validatebox" type="text" id="jidOverflow" name="jxInInventoryDetailsModel.jidOverflow" style="width:200px;" validType="length[0,25]" invalidMessage="短溢不能超过25个汉字"/>			
		</td>
		<th width="15%" nowrap>未税金额:&nbsp;</th>
		<td width="20%" colspan="3">
			<input class="easyui-numberbox" type="text" id="jidWAmount" name="jxInInventoryDetailsModel.jidWAmount" style="width:100px;" disabled/>
		</td>
		<th width="15%" nowrap>未税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jidTotalWAmount" name="jxInInventoryDetailsModel.jidTotalWAmount" style="width:100px;" disabled/>
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
