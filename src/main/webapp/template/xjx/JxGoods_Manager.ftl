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
    	<td align="center" ><div class="dqwz">您现在的位置：jxGoods管理</div></td>
    </tr>
</table>
<@s.form id="jxGoodsForm" action="jxGoods_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="15%">请放置查询对象</th>
		        <td>
		        	<input name="demo" type="text" size="25" id="demo" value="这是一个演示字段" maxlength="20">
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
				<@jmesa.htmlColumn property="jgIncode" title="jgIncode" />
				<@jmesa.htmlColumn property="jgCode" title="jgCode" />
				<@jmesa.htmlColumn property="jgName" title="jgName" />
				<@jmesa.htmlColumn property="jgDept" title="jgDept" />
				<@jmesa.htmlColumn property="jgSunit" title="jgSunit" />
				<@jmesa.htmlColumn property="jgBunit" title="jgBunit" />
				<@jmesa.htmlColumn property="jgSpec" title="jgSpec" />
				<@jmesa.htmlColumn property="jgCate" title="jgCate" />
				<@jmesa.htmlColumn property="jgOrigin" title="jgOrigin" />
				<@jmesa.htmlColumn property="jgFactory" title="jgFactory" />
				<@jmesa.htmlColumn property="jgRate" title="jgRate" />
				<@jmesa.htmlColumn property="jgGuided" title="jgGuided" />
				<@jmesa.htmlColumn property="jgShelf" title="jgShelf" />
				<@jmesa.htmlColumn property="jgPtype" title="jgPtype" />
				<@jmesa.htmlColumn property="jgPcycle" title="jgPcycle" />
				<@jmesa.htmlColumn property="jgStype" title="jgStype" />
				<@jmesa.htmlColumn property="jgSeway" title="jgSeway" />
				<@jmesa.htmlColumn property="jgCansell" title="jgCansell" />
				<@jmesa.htmlColumn property="jgSpare" title="jgSpare" />
				<@jmesa.htmlColumn property="jgIntsell" title="jgIntsell" />
				<@jmesa.htmlColumn property="jgRemark" title="jgRemark" />
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

