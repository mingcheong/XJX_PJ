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
<@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：企业列表</div></td>
    </tr>
</table>
<@s.form id="companyInfoForm" action="companyInfo_list.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="8%" align="right">企业名称&nbsp;&nbsp;&nbsp;</th>
				<td width="20%" >
					<@s.textfield id="companyName" name="companyInfoModel.companyName" cssStyle="width:75%"/>
				</td>
				<th width="8%" align="right">企业地址&nbsp;&nbsp;&nbsp;</th>
				<td width="20%">
					<@s.textfield id="address" name="companyInfoModel.address" cssStyle="width:75%"/>
				</td>
				<th width="8%" align="right">区域&nbsp;&nbsp;&nbsp;</th>
				<td>
					<div id="div-area"></div>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyInfoModel','filter');"/>
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
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyInfoModels  limit=companyInfoModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyInfo" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyInfoModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="序号" filterable=false sortable=false>
					${rowcount+((companyInfoModel.pageNo-1)*companyInfoModel.pageSize)}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyName" title="单位名称" ><a href="${contextPath}/companyInfo_detail.xhtml?id=${companyInfo.id}">${companyInfo.companyName}</a></@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="address" title="地址" />
				<@jmesa.htmlColumn property="legalPerson" title="法人代表" />
				<@jmesa.htmlColumn property="legalContact" title="联系电话" />
				<@jmesa.htmlColumn property="industrial" title="所属行业" ><@enum.getSelectEnum code="${companyInfo.industrial}"/></@jmesa.htmlColumn>
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
        window.open('companyInfo_report.xhtml?' + parameterString);
    }
</script>
<@enum.selectAreas "companyInfoModel","div-area","${companyInfoModel.firstArea?if_exists}","${companyInfoModel.secondArea?if_exists}","${companyInfoModel.thirdArea?if_exists}","${companyInfoModel.fouthArea?if_exists}","${companyInfoModel.fifthArea?if_exists}" /> 
<@fkMacros.pageFooter />

