<@fkMacros.pageHeader />

	<script>
	
		jQuery(function(){
			jQuery('#cc').combogrid({
				panelWidth:450,
				value:'006',

				idField:'code',
				textField:'name',
				url:'http://localhost:8080/XJX_PJ/resources/javascript/global/datagrid_data.json',
				columns:[[
					{field:'code',title:'Code',width:60},
					{field:'name',title:'Name',width:100},
					{field:'addr',title:'Address',width:120},
					{field:'col4',title:'Col41',width:100}
				]]
			});
		});
		function reload(){
			jQuery('#cc').combogrid('grid').datagrid('reload');
		}
		function setValue(){
			jQuery('#cc').combogrid('setValue', '002');
		}
		function getValue(){
			var val = jQuery('#cc').combogrid('getValue');
			alert(val);
		}
		function disable(){
			jQuery('#cc').combogrid('disable');
		}
		function enable(){
			$('#cc').combogrid('enable');
		}
	</script>
<@fkMacros.formValidator 'jxGoodsForm'/>
<#-- 验证参考 for 对应着你要验证的属性的ID,rule指的是验证规则，require表示是否必填。
	必填验证方式
	<ui:v for="邮编" rule="zip" require="true" warn="邮编格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="邮件" rule="email" require="true" warn="邮件格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="电话号码" rule="phone" require="true" warn="电话号码格式不正确！" empty="电话号码不允许为空！" pass="&nbsp;"/>
	<ui:v for="手机" rule="mobile" require="true" warn="手机格式不正确！" empty="手机不允许为空！" pass="&nbsp;"/>
	<ui:v for="URL" rule="url" require="true" warn="地址格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="IP" rule="ip" require="true" warn="IP格式不正确！" empty="IP不允许为空！" pass="&nbsp;"/>
	<ui:v for="帐号" rule="username" require="true" warn="帐号格式不正确！" empty="帐号不允许为空！" pass="&nbsp;"/>
	<ui:v for="数字" rule="integer" require="true" warn="数字格式不正确！" empty="数字不允许为空！" pass="&nbsp;"/>
	选填的验证方式
	<ui:v for="邮编" rule="zip" require="false" warn="邮编格式不正确！" empty="&nbsp;" pass="&nbsp;"/>
-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxGoodsModel.id == -1>添加<#else>修改</#if>商品档案 </div></td>
  </tr>
</table>
<@s.form id="jxGoodsForm" action="jxGoods_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxGoodsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
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
			<@s.textfield id="jgIncode" name="jxGoodsModel.jgIncode" cssStyle="width:75%"/>
			<ui:v for="jgIncode" rule="require" warn="不允许以空格为开始" empty="商品内部编码不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>商品编码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgCode" name="jxGoodsModel.jgCode" cssStyle="width:75%"/>
			<ui:v for="jgCode" rule="require" warn="不允许以空格为开始" empty="商品编码不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>品名规格:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jgName" name="jxGoodsModel.jgName" cssStyle="width:75%"/>
			<ui:v for="jgName" rule="require" warn="不允许以空格为开始" empty="品名规格不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>所属部门:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgDept" name="jxGoodsModel.jgDept" cssStyle="width:75%"/>
			<ui:v for="jgDept" rule="require" warn="不允许以空格为开始" empty="所属部门不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>数量单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSunit" name="jxGoodsModel.jgSunit" cssStyle="width:75%"/>
			<ui:v for="jgSunit" rule="require" warn="不允许以空格为开始" empty="数量单位不允许为空" pass="&nbsp;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>外包装:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgBunit" name="jxGoodsModel.jgBunit" cssStyle="width:75%"/>
			<ui:v for="jgBunit" rule="require" warn="不允许以空格为开始" empty="外包装不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">包装规格:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSpec" name="jxGoodsModel.jgSpec" cssStyle="width:75%"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>商品分类:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgCate" name="jxGoodsModel.jgCate" cssStyle="width:75%"/>
			<ui:v for="jgCate" rule="require" warn="不允许以空格为开始" empty="商品分类不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">产地:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgOrigin" name="jxGoodsModel.jgOrigin" cssStyle="width:75%"/>
		</td>		
	</tr>
	<tr>
		<th width="15%">税率:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgRate" name="jxGoodsModel.jgRate" cssStyle="width:75%"/>
		</td>	
		<th width="15%">制造商:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgFactory" name="jxGoodsModel.jgFactory" cssStyle="width:75%"/>
		</td>			
	</tr>
	<tr>
		<th width="15%">指导价:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgGuided" name="jxGoodsModel.jgGuided" cssStyle="width:75%"/>
		</td>
		<th width="15%">保质（修）期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgShelf" name="jxGoodsModel.jgShelf" cssStyle="width:75%"/>
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
			<select id="cc" name="dept" style="width:250px;"></select>
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
</@s.form>
<@fkMacros.pageFooter />