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
    	<td align="center" ><div class="dqwz">您现在的位置：商品档案维护</div></td>
    </tr>
</table>
<@s.form id="jxGoodsForm" action="jxGoods_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">商品编码:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jgCode" name="jxGoodsModel.jgCode" cssStyle="width:75%"/>
				</td>
				<th width="15%">品名规格:&nbsp;</th>
				<td width="35%">
					<@s.textfield id="jgName" name="jxGoodsModel.jgName" cssStyle="width:75%"/>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('jxGoodsModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="jxGoods" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="jxGoods" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="jxGoods" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=jxGoodsModels  limit=jxGoodsModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="jxGoods" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="jxGoodsModel" exportTypes="pdf,excel,csv">
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${jxGoods.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="jgIncode" title="内部编码" width="20%"/>
				<@jmesa.htmlColumn property="jgCode" title="商品编码" width="20%"/>
				<@jmesa.htmlColumn property="jgName" title="品名规格" width="20%"/>
				<@jmesa.htmlColumn property="jgSunit.juName" title="数量单位" width="15%" style="text-align:center"/>
				<@jmesa.htmlColumn property="jgCate.jpcName" title="商品分类" width="20%" style="text-align:center"/>
				<@jmesa.htmlColumn property="jgCansell" title="可销售" width="10%" style="text-align:center">
					<#if jxGoods.jgCansell?if_exists == true>是<#else>否</#if>
				</@jmesa.htmlColumn>				
				<@jmesa.htmlColumn property="jgSpare" title="是否备用" width="10%" style="text-align:center">
					<#if jxGoods.jgSpare?if_exists == true>是<#else>否</#if>
				</@jmesa.htmlColumn>					
				<@jmesa.htmlColumn property="jgIntsell" title="须整数卖" width="10%" style="text-align:center">
					<#if jxGoods.jgIntsell?if_exists == true>是<#else>否</#if>
				</@jmesa.htmlColumn>				
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
        window.open('jxGoods_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

