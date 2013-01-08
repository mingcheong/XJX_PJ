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
		
		jQuery('#jmDept').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxDept_jsonList.xhtml',
			columns:[[
				{field:'code',title:'部门编码',width:80},
				{field:'name',title:'部门名称',width:100}
			]]
		});	
		
		jQuery('#jmUser').add('#jbCheckuser').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxEmployee_jsonList.xhtml',
			columns:[[
				{field:'code',title:'员工编号',width:90},
				{field:'name',title:'员工名称',width:150}
			]]
		});	

		jQuery('#jmIwarehouse').add('#jmOwarehouse').combogrid({
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
				{field:'jmdBarcode',title:'商品条码',width:120},
				{field:'jmdCode',title:'编码',width:80},
				{field:'jmdName',title:'商品名称',width:200},
				{field:'jmdUnit_juName',title:'单位',width:60,align:'center'},
				{field:'jmdQuantity',title:'数量',width:60,align:'center'},
				{field:'jmdCost',title:'含税进价',width:80,align:'right'},
				{field:'jmdAmount',title:'含税金额',width:80,align:'right'},
				{field:'jmdWAmount',title:'未税金额',width:80,align:'right'},
				{field:'jmdNum',title:'件数',width:60,align:'center'},
				{field:'jmdOverflow',title:'短溢',width:60,align:'center'},
				{field:'jmdRate',title:'税率',width:60,align:'center'}
			]]
		});
			
		jQuery("#addBtn").click(function(){
			if(jQuery("#goodsModel_jgCode").val() == "" || jQuery("#goodsModel_id").val() == "")
				jQuery("#goodsModel_jgCode").focus();
			else if(jQuery("#jmdNum").val() == "")
				jQuery("#jmdNum").focus();	
			else if(jQuery("#jmdQuantity").val() == "")
				jQuery("#jmdQuantity").focus();					
			else if(jQuery("#jmdCost").val() == "")
				jQuery("#jmdCost").focus();
			else{								
				jQuery('#detailGrid').datagrid('appendRow',{
					'goods_id' : jQuery("#goodsModel_id").val(),
					'jmdBarcode' : jQuery("#goodsModel_jgCode").val(),
					'jmdCode' : jQuery("#goodsModel_jgIncode").val(),
					'jmdName' : jQuery("#goodsModel_jgName").val(),
					'jmdUnit_id' : jQuery("#jmdBUnit_id").val(),
					'jmdUnit_juName' : jQuery("#jmdBUnit_juName").val(),
					'jmdQuantity' : jQuery("#jmdQuantity").val(),
					'jmdCost' : jQuery("#jmdCost").val(),
					'jmdAmount' : jQuery("#jmdAmount").val(),
					'jmdWAmount' : jQuery("#jmdWAmount").val(),
					'jmdNum' : jQuery("#jmdNum").val(),
					'jmdOverflow' : jQuery("#jmdOverflow").val(),
					'jmdRate' : jQuery("#jmdRate").val()
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
				jQuery.getJSON("jxGoods_getGoods.xhtml", {"jxGoodsModel.jgCode": jQuery(this).val()},
				function(data){
					if(data.error == undefined){
						jQuery("#goodsModel_id").val(data.id);
						jQuery("#goodsModel_jgIncode").val(data.incode);
						jQuery("#goodsModel_jgCode").val(data.code);
						jQuery("#goodsModel_jgName").val(data.name);
						jQuery("#jmdRate").numberbox('setValue',data.rate);
						jQuery("#jmdBUnit_id").val(data.bUnit.id);
						jQuery("#jmdBUnit_juName").val(data.bUnit.juName);
						jQuery("#jmdSpec").numberbox('setValue',data.spec);
						jQuery("#jmdUnit_id").val(data.sUnit.id);
						jQuery("#jmdUnit_juName").val(data.sUnit.juName);							
					}else{
						alert(data.error);
						jQuery("#goodsModel_jgCode").val("");
						jQuery("#goodsModel_jgCode").focus();
					}
				});		    
			}  
		})  			
		
		jQuery("#jmdNum").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
					
				var spec = jQuery("#jmdSpec").val();
				if(spec != ""){
					jQuery("#jmdQuantity").numberbox('setValue',jQuery(this).val()*spec);
				}
			}
		})  		
		
		jQuery('#saveBtn').click(function(){
			if(jQuery('#jxMoveInventoryForm').form('validate')){
				var jsonArr = [];
				
				var iwarehouse = jQuery('#jmIwarehouse').combogrid('getValue');
				var owarehouse = jQuery('#jmOwarehouse').combogrid('getValue');
				if(iwarehouse == owarehouse){
					alert("调出仓库和调入仓库不能相同!");
					return;
				}
					
				
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
						jo += '"goodsModel.jgCode" : "' + rows[i].jmdBarcode + '",';
						jo += '"goodsModel.jgIncode" : "' + rows[i].jmdCode + '",';
						jo += '"goodsModel.jgName" : "' + rows[i].jmdName + '",';
						jo += '"jmdUnit.id" : "' + rows[i].jmdUnit_id + '",';
						jo += '"jmdUnit.juName" : "' + rows[i].jmdUnit_juName + '",';
						jo += '"jmdQuantity" : "' + rows[i].jmdQuantity + '",';
						jo += '"jmdCost" : "' + rows[i].jmdCost + '",';
						jo += '"jmdAmount" : "' + rows[i].jmdAmount + '",';
						jo += '"jmdWAmount" : "' + rows[i].jmdWAmount + '",';
						jo += '"jmdNum" : "' + rows[i].jmdNum + '",';
						jo += '"jmdOverflow" : "' + rows[i].jmdOverflow + '",';
						jo += '"jmdRate" : "' + rows[i].jmdRate + '"}';
						jsonArr.push(jo);
					}
					jQuery("#jsonData").val('[' + jsonArr.join(',') + ']');				
					jQuery('#jxMoveInventoryForm').ajaxSubmit(function(obj) { 
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
    <td align="center" ><div class="dqwz">您现在的位置：移库单录入 </div></td>
  </tr>
</table>
<@s.form id="jxMoveInventoryForm" action="jxMoveInventory_save.xhtml"  method="post">
<s:token /><@s.hidden name="jxMoveInventoryModel.id" />
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>原始单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jmOcode" name="jxMoveInventoryModel.jmOcode" data-options="required:true" style="width:200px;" missingMessage="原始单号不允许为空"/>
		</td>
		<th width="15%">单据号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jmNum" name="jxMoveInventoryModel.jmNum" data-options="required:true" style="width:200px;" missingMessage="单据号不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>上一单号:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jmLastCode" name="jxMoveInventoryModel.jmLastCode" data-options="required:true" style="width:200px;" missingMessage="上一单号不允许为空"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>所属部门:&nbsp;</th>
		<td width="35%">
			<select id="jmDept" name="jxMoveInventoryModel.jmDept.jdCode" data-options="required:true" style="width:250px;" missingMessage="所属部门不允许为空"></select>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>调出仓库:&nbsp;</th>
		<td width="35%">
			<select id="jmOwarehouse" name="jxMoveInventoryModel.jmOwarehouse.jwCode" data-options="required:true" style="width:250px;" missingMessage="调出仓库不允许为空"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>调入仓库:&nbsp;</th>
		<td width="35%">
			<select id="jmIwarehouse" name="jxMoveInventoryModel.jmIwarehouse.jwCode" data-options="required:true" style="width:250px;" missingMessage="调入仓库不允许为空"></select>
		</td>		
	</tr>		
	<tr>
		<th width="15%"><font color="#FF0000">*</font>调拨员:&nbsp;</th>
		<td width="35%">
			<select id="jmUser" name="jxMoveInventoryModel.jmUser.jeCode" data-options="required:true" style="width:250px;" missingMessage="调拨员不允许为空"></select>
		</td>	
		<th width="15%"><font color="#FF0000">*</font>调拨日期:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox Wdate" type="text" id="jmDate" name="jxMoveInventoryModel.jmDate" value="${jxMoveInventoryModel.jmDate?date}" data-options="required:true" style="width:200px;" missingMessage="调拨日期不允许为空" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd',errDealMode:1})"/>
		</td>			
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jmRemark" name="jxMoveInventoryModel.jmRemark" cssStyle="width:90%;height:65px;"/>	
		</td>
	</tr>			
</table>
<input type="hidden" id="jsonData" name="jsonData"/>
<div style="padding-top:2px;padding-bottom:2px;"><table id="detailGrid"></table></div>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%" style="border-top:0px;" nowrap>商品:&nbsp;</th>
		<td width="85%" colspan="5">
			<input type="hidden" id="goodsModel_id" name="jxMoveInventoryModel.goodsModel.id"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgCode" name="jxMoveInventoryModel.goodsModel.jgCode" style="width:200px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgIncode" name="jxMoveInventoryModel.goodsModel.jgIncode" disabled style="width:100px;"/>
			<input class="easyui-validatebox" type="text" id="goodsModel_jgName" name="jxMoveInventoryModel.goodsModel.jgName" disabled style="width:250px;"/>
		</td>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jmdTotalNum" name="jxMoveInventoryDetailsModel.jmdTotalNum" style="width:100px;" disabled>			
		</td>		
	</tr>	
	<tr>
		<th width="15%" nowrap>件数:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jmdNum" name="jxMoveInventoryDetailsModel.jmdNum" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jmdBUnit_id" name="jxMoveInventoryDetailsModel.jmdBUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jmdBUnit_juName" name="jxMoveInventoryDetailsModel.jmdBUnit.juName" style="width:50px;"/>×
			<input class="easyui-numberbox" type="text" id="jmdSpec" name="jxMoveInventoryDetailsModel.jmdSpec" style="width:50px;"/>	
		</td>
		<th width="15%" nowrap>税率:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jmdRate" name="jxMoveInventoryDetailsModel.jmdRate" style="width:100px;"/>
		</td>
		<th width="15%" nowrap>末次含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jmdWCost" name="jxMoveInventoryDetailsModel.jmdWCost" style="width:100px;" disabled/>
		</td>	
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jmdTotalQuantity" name="jxMoveInventoryDetailsModel.jmdTotalQuantity" style="width:100px;" disabled/>			
		</td>			
	</tr>	
	<tr>
		<th width="15%" nowrap>数量:&nbsp;</th>
		<td width="30%">
			<input class="easyui-numberbox" type="text" id="jmdQuantity" name="jxMoveInventoryDetailsModel.jmdQuantity" style="width:80px;" data-options="min:1"/>			
			<input type="hidden" id="jmdUnit_id" name="jxMoveInventoryDetailsModel.jmdUnit.id"/>
			<input class="easyui-validatebox" type="text" id="jmdUnit_juName" name="jxMoveInventoryDetailsModel.jmdUnit.juName" style="width:50px;"/>
		</td>
		<th width="15%" nowrap>含税进价:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jmdCost" name="jxMoveInventoryDetailsModel.jmdCost" style="width:100px;" data-options="precision:2"/>
		</td>
		<th width="15%" nowrap>含税金额:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jmdAmount" name="jxMoveInventoryDetailsModel.jmdAmount" style="width:100px;" disabled/>			
		</td>	
		<th width="15%" nowrap>含税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jmdTotalAmount" name="jxMoveInventoryDetailsModel.jmdTotalAmount" style="width:100px;" disabled/>			
		</td>				
	</tr>	
	<tr>
		<th width="15%" nowrap>短溢:&nbsp;</th>
		<td width="30%">
			<input class="easyui-validatebox" type="text" id="jmdOverflow" name="jxMoveInventoryDetailsModel.jmdOverflow" style="width:200px;" validType="length[0,25]" invalidMessage="短溢不能超过25个汉字"/>			
		</td>
		<th width="15%" nowrap>未税金额:&nbsp;</th>
		<td width="20%" colspan="3">
			<input class="easyui-numberbox" type="text" id="jmdWAmount" name="jxMoveInventoryDetailsModel.jmdWAmount" style="width:100px;" disabled/>
		</td>
		<th width="15%" nowrap>未税进额:&nbsp;</th>
		<td width="35%">
			<input type="text" id="jmdTotalWAmount" name="jxMoveInventoryDetailsModel.jmdTotalWAmount" style="width:100px;" disabled/>
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