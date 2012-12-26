 <@fkMacros.pageHeader />
<script type="text/javascript">
	jQuery(function(){
	
		jQuery('#jgStype').add('#jgSeway').combogrid({
			panelWidth:200,
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

		jQuery('#jgPtype').combogrid({
			panelWidth:200,
			idField:'code',
			textField:'name',
			url:'jxPuchaseType_jsonList.xhtml',
			columns:[[
				{field:'code',title:'进货编码',width:80},
				{field:'name',title:'进货名称',width:100}
			]]
		});				
		
		jQuery('#jxGoodsForm').form('load',{
			'jxGoodsModel.jgIncode':'name2'
		});		
		
		jQuery('#saveBtn').click(function(){
			if(jQuery('#jxGoodsForm').form('validate')){
				jQuery('#jxGoodsForm').submit();
			}
		});
		
	});

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
		<th width="15%"><font color="#FF0000">*</font>商品内部编码:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgIncode" name="jxGoodsModel.jgIncode" data-options="required:true" style="width:200px;" missingMessage="商品内部编码不允许为空"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>商品编码:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgCode" name="jxGoodsModel.jgCode" data-options="required:true" style="width:200px;" missingMessage="商品编码不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>品名规格:&nbsp;</th>
		<td width="35%" colspan="3">
			<input class="easyui-validatebox" type="text" id="jgName" name="jxGoodsModel.jgName" data-options="required:true" style="width:500px;" missingMessage="品名规格不允许为空"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>所属部门:&nbsp;</th>
		<td width="35%">
			<select id="jgDept" name="jxGoodsModel.jgDept.jdCode" data-options="required:true" style="width:250px;" missingMessage="所属部门不允许为空"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>数量单位:&nbsp;</th>
		<td width="35%">
			<select id="jgSunit" name="jxGoodsModel.jgSunit.juCode" data-options="required:true" style="width:250px;" missingMessage="数量单位不允许为空"></select>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>外包装:&nbsp;</th>
		<td width="35%">
			<select id="jgBunit" name="jxGoodsModel.jgBunit.juCode" data-options="required:true" style="width:250px;" missingMessage="外包装不允许为空"></select>
		</td>
		<th width="15%">包装规格:&nbsp;</th>
		<td width="35%">
			<input class="easyui-validatebox" type="text" id="jgSpec" name="jxGoodsModel.jgSpec" style="width:200px;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>商品分类:&nbsp;</th>
		<td width="35%">
			<select id="jgCate" name="jxGoodsModel.jgCate.jpcCode" data-options="required:true" style="width:300px;" missingMessage="商品分类不允许为空"></select>
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
			<input class="easyui-numberbox" type="text" id="jgShelf" name="jxGoodsModel.jgShelf" style="width:100px;"/>&nbsp;天
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>进货类型:&nbsp;</th>
		<td width="35%">
			<select id="jgPtype" name="jxGoodsModel.jgPtype.jpCode" data-options="required:true" style="width:200px;" missingMessage="进货类型不允许为空"></select>
		</td>
		<th width="15%">进货周期:&nbsp;</th>
		<td width="35%">
			<input class="easyui-numberbox" type="text" id="jgPcycle" name="jxGoodsModel.jgPcycle" style="width:100px;" data-options="min:1,max:999"/>&nbsp;天
		</td>
	</tr>
	<tr>
		<th width="15%">付款类型:&nbsp;</th>
		<td width="35%">
			<select id="jgStype" name="jxGoodsModel.jgStype.jsCode" style="width:200px;"></select>
		</td>
		<th width="15%">结算方式:&nbsp;</th>
		<td width="35%">
			<select id="jgSeway" name="jxGoodsModel.jgSeway.jsCode" style="width:200px;"></select>
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
</@s.form>
<@fkMacros.pageFooter />