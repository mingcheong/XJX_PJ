<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 -->
<@fkMacros.pageHeader />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：jxGoodsPriceSet管理</div></td>
    </tr>
</table>
<@s.form id="jxGoodsPriceSetForm" action="jxGoodsPriceSet_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">商品代码:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jgCode" name="jxGoodsPriceSetModel.jpGoods.jgCode" cssStyle="width:75%"/>
				</td>
				<th width="15%">商品名称:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jgName" name="jxGoodsPriceSetModel.jpGoods.jgName" cssStyle="width:75%"/>
				</td>
				<td>&nbsp;</td>
	     	</tr>
			<tr>
				<th width="15%">客户条码:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jgCode" name="jxGoodsPriceSetModel.jpCustomer.jcCode" cssStyle="width:75%"/>
				</td>
				<th width="15%">客户名称:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jgName" name="jxGoodsPriceSetModel.jpCustomer.jcName" cssStyle="width:75%"/>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('jxGoodsPriceSetModel','filter');"/>
		        </td>
	     	</tr>	     	
	    </table>		    
    </td>
  </tr>
  <tr>
    <td class="tool-toggle-td"><a id="J_SearchBoxToggle" state="show" hidefocus="true" href="javascript:;" title="收起/展开" onClick="toggleQueryPanel()" class="tool-toggle"></a></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_add '添 加'> obj="jxGoodsPriceSet" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="jxGoodsPriceSet" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="jxGoodsPriceSet" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=jxGoodsPriceSetModels filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="jxGoodsPriceSet" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="jxGoodsPriceSetModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${jxGoodsPriceSet.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="jpGoods.jgCode" title="商品条码"  width="15%"/>
				<@jmesa.htmlColumn property="jpGoods.jgName" title="商品名称"  width="15%"/>
				<@jmesa.htmlColumn property="jpCustomer.jcCode" title="客户编码"  width="15%"/>
				<@jmesa.htmlColumn property="jpCustomer.jcName" title="客户名称"  width="15%"/>
				<@jmesa.htmlColumn property="jpPrice" title="售价"  width="8%" style="text-align: center;"/>
				<@jmesa.htmlColumn property="jpPricelast" title="售价末次"  width="8%" style="text-align: center;"/>
				<@jmesa.htmlColumn property="jpCost" title="成本"  width="8%" style="text-align: center;"/>
				<@jmesa.htmlColumn property="jpDate" title="建档时间"  width="15%" style="text-align: center;"/>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>
</@s.form>
<script type="text/javascript">
	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('jxGoodsPriceSet_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

