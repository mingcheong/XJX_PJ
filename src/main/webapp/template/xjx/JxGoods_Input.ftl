 <@fkMacros.pageHeader />
<script type="text/javascript">
	jQuery(function(){
		jQuery('#cc').combogrid({
			panelWidth:250,
			value:'30',
			idField:'code',
			textField:'name',
			url:'jxSettlementType_ajax.xhtml',
			columns:[[
				{field:'code',title:'编码',width:80},
				{field:'name',title:'名称',width:100}
			]]
		});
		
		jQuery('#jgDept').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxDept_jsonList.xhtml',
			columns:[[
				{field:'code',title:'部门编码',width:80},
				{field:'name',title:'部门名称',width:100}
			]]
		});	
		
		jQuery('#jgSunit').add('#jgBunit').combogrid({
			panelWidth:250,
			idField:'code',
			textField:'name',
			url:'jxUnit_jsonList.xhtml',
			columns:[[
				{field:'code',title:'单位编码',width:80},
				{field:'name',title:'单位名称',width:100}
			]]
		});

		jQuery('#jgCate').combogrid({
			panelWidth:300,
			idField:'code',
			textField:'name',
			url:'jxProductCate_jsonList.xhtml',
			columns:[[
				{field:'code',title:'分类编码',width:80},
				{field:'name',title:'分类名称',width:120},
				{field:'canUse',title:'可使用',width:60}
			]]
		});			
		
						
		
			jQuery('#jxGoodsForm').form('load',{
				'jxGoodsModel.jgIncode':'name2'
			});		
		
		jQuery('#jxGoodsForm').submit(function(){
		jQuery(this).form('validate');
			//alert(jQuery('#cc').combogrid('getValue'));
			return false;
		});
		
	});
	function reload(){
		jQuery('#cc').combogrid('grid').datagrid('reload');
	}
	function setValue(){
		jQuery('#cc').combogrid('setValue', '002');
	}
	function getValue(){
		var val = jQuery('#cc').val();
		alert(val);
	}
	function disable(){
		jQuery('#cc').combogrid('disable');
	}
	function enable(){
		jQuery('#cc').combogrid('enable');
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxGoodsModel.id == -1>添加<#else>修改</#if>商品档案 </div></td>
  </tr>
</table>
<@s.form id="jxGoodsForm" action="jxGoods_save.xhtml"  method="post">
<s:token /><@s.hidden name="jxGoodsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul><input type="submit" name="aa" value="提交">
			<@util.menu_save '保 存'> obj="jxGoodsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>商品内部编码:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgIncode" name="jxGoodsModel.jgIncode" data-options="required:true" style="width:200px;" missingMessage="商品内部编码不允许为空"//>
		</td>
		<th width="15%"><font color="#FF0000">*</font>商品编码:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgCode" name="jxGoodsModel.jgCode" data-options="required:true" style="width:200px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>品名规格:&nbsp;</th>
		<td width="35%" colspan="3">
			<input class="easyui-validatebox" type="text" id="jgName" name="jxGoodsModel.jgName" data-options="required:true" style="width:500px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>所属部门:&nbsp;</th>
		<td width="35%">
			<select id="jgDept" name="jxGoodsModel.jgDept" data-options="required:true" style="width:250px;"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>数量单位:&nbsp;</th>
		<td width="35%">
			<select id="jgSunit" name="jxGoodsModel.jgSunit" data-options="required:true" style="width:250px;"></select>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>外包装:&nbsp;</th>
		<td width="35%">
			<select id="jgBunit" name="jxGoodsModel.jgBunit" data-options="required:true" style="width:250px;"></select>
		</td>
		<th width="15%">包装规格:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgSpec" name="jxGoodsModel.jgSpec" style="width:200px;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>商品分类:&nbsp;</th>
		<td width="35%">
			<select id="jgCate" name="jxGoodsModel.jgCate" data-options="required:true" style="width:300px;"></select>
		</td>
		<th width="15%">产地:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgOrigin" name="jxGoodsModel.jgOrigin" style="width:200px;" validType="length[0,50]" invalidMessage="产地不能超过25个汉字">
		</td>		
	</tr>
	<tr>
		<th width="15%">税率:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jgRate" name="jxGoodsModel.jgRate" style="width:100px;" data-options="min:0,max:100"/>
		</td>	
		<th width="15%">制造商:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgFactory" name="jxGoodsModel.jgFactory" style="width:300px;" validType="length[0,200]" invalidMessage="制造商不能超过100个汉字">
		</td>			
	</tr>
	<tr>
		<th width="15%">指导价:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jgGuided" name="jxGoodsModel.jgGuided" style="width:100px;" data-options="precision:2"/>
		</td>
		<th width="15%">保质（修）期:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jgShelf" name="jxGoodsModel.jgShelf" style="width:100px;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>进货类型:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgPtype" name="jxGoodsModel.jgPtype" cssStyle="width:75%"/>
			<ui:v for="jgPtype" rule="require" warn="不允许以空格为开始" empty="进货类型不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">进货周期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgPcycle" name="jxGoodsModel.jgPcycle" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">付款类型:&nbsp;</th>
		<td width="35%">
			<!--<@s.textfield id="jgStype" name="jxGoodsModel.jgStype" cssStyle="width:75%"/>->
			<select id="cc" name="dept" style="width:250px;" data-options="required:true"></select>
		</td>
		<th width="15%">结算方式:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSeway" name="jxGoodsModel.jgSeway" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<td colspan="4">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
			<tr>
				<th width="15%"><font color="#FF0000">*</font>可销售:&nbsp;</th>
				<td width="18%">
					<select name="jxGoodsModel.jgCansell">
						<option value="true" <#if jxGoodsModel.jgCansell>selected="selected"</#if> >是</option>
						<option value="false" <#if !jxGoodsModel.jgCansell>selected="selected"</#if> >否</option>
					</select>	
				</td>
				<th width="15%"><font color="#FF0000">*</font>是否备用:&nbsp;</th>
				<td width="18%">
					<select name="jxGoodsModel.jgSpare">
						<option value="true" <#if jxGoodsModel.jgSpare>selected="selected"</#if> >是</option>
						<option value="false" <#if !jxGoodsModel.jgSpare>selected="selected"</#if> >否</option>
					</select>	
				</td>
				<th width="15%"><font color="#FF0000">*</font>须整数卖:&nbsp;</th>
				<td width="18%">
					<select name="jxGoodsModel.jgIntsell">
						<option value="true" <#if jxGoodsModel.jgIntsell>selected="selected"</#if> >是</option>
						<option value="false" <#if !jxGoodsModel.jgIntsell>selected="selected"</#if> >否</option>
					</select>						
				</td>			
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jgRemark" name="jxGoodsModel.jgRemark" cssStyle="width:90%;height:65px;"/>	
		</td>
	</tr>		
</table>
	<div style="margin:10px 0;">
		<a href="#" class="easyui-linkbutton" onclick="reload()">Reload</a>
		<a href="#" class="easyui-linkbutton" onclick="setValue()">SetValue</a>
		<a href="#" class="easyui-linkbutton" onclick="getValue()">GetValue</a>
		<a href="#" class="easyui-linkbutton" onclick="disable()">Disable</a>
		<a href="#" class="easyui-linkbutton" onclick="enable()">Enable</a>
	</div>
</@s.form>
<@fkMacros.pageFooter />