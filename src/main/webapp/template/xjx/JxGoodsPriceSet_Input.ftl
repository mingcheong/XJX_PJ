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
		
		jQuery('#jpCustomer').combogrid({
			panelWidth:200,
			idField:'code',
			textField:'name',
			url:'jxCustomer_jsonList.xhtml',
			columns:[[
				{field:'code',title:'客户编码',width:80},
				{field:'name',title:'客户名称',width:100}
			]]
		});			
		
			
		jQuery("#jpGoods_jgCode").keydown(function(event) {  
			if (event.keyCode == 13) {
				if(jQuery(this).val() == "")
					return;
				jQuery.getJSON("jxGoods_getGoods.xhtml", {"jxGoodsModel.jgCode": jQuery(this).val()},
				function(data){
					if(data.error == undefined){
						jQuery("#jpGoods_id").val(data.id);
						jQuery("#jpGoods_jgIncode").val(data.incode);
						jQuery("#jpGoods_jgCode").val(data.code);
						jQuery("#jpGoods_jgName").val(data.name);
						jQuery("#jpGoods_jgRate").numberbox('setValue',data.rate);
						jQuery("#jpGoods_jgBunit_id").val(data.bUnit.id);
						jQuery("#jpGoods_jgBunit_juName").val(data.bUnit.juName);
						jQuery("#jpGoods_jgSpec").numberbox('setValue',data.spec);					
					}
				});		    
			}  
		})  				
		
		jQuery('#saveBtn').click(function(){
			if(jQuery('#jxGoodsPriceSetForm').form('validate')){
				jQuery('#jxGoodsPriceSetForm').submit();
			}
		});
		
		<#if jxGoodsPriceSetModel.id != -1>
		jQuery('#jxGoodsPriceSetForm').form('load',{
			'jxGoodsPriceSetModel.jpGoods.jgCode':'${jxGoodsPriceSetModel.jpGoods.jgCode}',
			'jxGoodsPriceSetModel.jpGoods.id':'${jxGoodsPriceSetModel.jpGoods.id}',
			'jxGoodsPriceSetModel.jpGoods.jgIncode':'${jxGoodsPriceSetModel.jpGoods.jgIncode}',
			'jxGoodsPriceSetModel.jpGoods.jgName':'${jxGoodsPriceSetModel.jpGoods.jgName}',
			'jxGoodsPriceSetModel.jpGoods.jgBunit.id':'${jxGoodsPriceSetModel.jpGoods.jgBunit.id}',
			'jxGoodsPriceSetModel.jpGoods.jgBunit.juName':'${jxGoodsPriceSetModel.jpGoods.jgBunit.juName}',
			'jxGoodsPriceSetModel.jpGoods.jgSpec':'${jxGoodsPriceSetModel.jpGoods.jgSpec}',
			'jxGoodsPriceSetModel.jpGoods.jgRate':'${jxGoodsPriceSetModel.jpGoods.jgRate}',
			'jxGoodsPriceSetModel.jpCustomer.jcCode':'${jxGoodsPriceSetModel.jpCustomer.jcCode}',
			'jxGoodsPriceSetModel.jpPrice':'${jxGoodsPriceSetModel.jpPrice}',
			'jxGoodsPriceSetModel.jpCost':'${jxGoodsPriceSetModel.jpCost}',
			'jxGoodsPriceSetModel.jpPricelast':'${jxGoodsPriceSetModel.jpPricelast}'
		});		
		</#if>	
		
		
});
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxGoodsPriceSetModel.id == -1>添加<#else>修改</#if>商品售价设置 </div></td>
  </tr>
</table>
<@s.form id="jxGoodsPriceSetForm" action="jxGoodsPriceSet_save.xhtml"  method="post">
<s:token /><@s.hidden name="jxGoodsPriceSetModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<li><a href="javascript:void(0);" id="saveBtn" title="保 存"><span><img src="${resourcePath}/default/img/tool_save.png">保 存</span></a></li>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>商品代码:&nbsp;</th>
		<td width="35%" colspan="3">
			<input type="hidden" id="jpGoods_id" name="jxGoodsPriceSetModel.jpGoods.id"/>
			<input class="easyui-validatebox" type="text" id="jpGoods_jgCode" name="jxGoodsPriceSetModel.jpGoods.jgCode" style="width:200px;" data-options="required:true" missingMessage="商品代码不允许为空"/>
			<input class="easyui-validatebox" type="text" id="jpGoods_jgIncode" name="jxGoodsPriceSetModel.jpGoods.jgIncode" disabled style="width:100px;"/>
			<input class="easyui-validatebox" type="text" id="jpGoods_jgName" name="jxGoodsPriceSetModel.jpGoods.jgName" disabled style="width:250px;"/>			
		</td>
	</tr>
	<tr>
		<th width="15%">外包装:&nbsp;</th>
		<td width="35%">
			<input type="hidden" id="jpGoods_jgBunit_id" name="jxGoodsPriceSetModel.jpGoods.jgBunit.id"/>
			<input class="easyui-validatebox" type="text" id="jpGoods_jgBunit_juName" name="jxGoodsPriceSetModel.jpGoods.jgBunit.juName" disabled style="width:200px;"/>
		</td>
		<th width="15%">包装规格:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jpGoods_jgSpec" name="jxGoodsPriceSetModel.jpGoods.jgSpec" disabled style="width:200px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%" nowrap>税率:&nbsp;</th>
		<td width="20%">
			<input class="easyui-numberbox" type="text" id="jpGoods_jgRate" name="jxGoodsPriceSetModel.jpGoods.jgRate" disabled style="width:100px;"/>
		</td>	
		<th width="15%"><font color="#FF0000">*</font>所属客户:&nbsp;</th>
		<td width="35%">
			<select id="jpCustomer" name="jxGoodsPriceSetModel.jpCustomer.jcCode" data-options="required:true" style="width:200px;" missingMessage="所属客户不允许为空"></select>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>售价:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jpPrice" name="jxGoodsPriceSetModel.jpPrice" style="width:200px;" data-options="precision:2,required:true" missingMessage="售价不允许为空"/>
		</td>
		<th width="15%">成本:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jpCost" name="jxGoodsPriceSetModel.jpCost" style="width:200px;" data-options="precision:2"/>
		</td>		
	</tr>
	<tr>
		<th width="15%">售价末次:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jpPricelast" name="jxGoodsPriceSetModel.jpPricelast" style="width:200px;" data-options="precision:2"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>建档时间:&nbsp;</th>
		<td width="20%">
			<input class="easyui-validatebox Wdate" type="text" id="jpDate" name="jxGoodsPriceSetModel.jpDate" value="${jxGoodsPriceSetModel.jpDate?date}" data-options="required:true" style="width:200px;" missingMessage="建档日期不允许为空" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd',errDealMode:1})"/>
		</td>			
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
