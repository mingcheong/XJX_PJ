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
    	<td align="center" ><div class="dqwz">您现在的位置：用户管理</div></td>
    </tr>
</table>
<@s.form id="fkUserForm" action="fkUser_manager.xhtml"><@s.token />
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				<th width="8%">组织机构:&nbsp;</th>
				<td width="15%">
					<@s.hidden id="fatherId" name="fkUserModel.orgsId" />
					<@s.textfield id="fatherName" name="orgsName" readonly="true" value="${orgsName?default('')}" cssStyle="width:75%"/>
					<@fkMacros.radioTree 'fatherId','fatherName','fkOrganize_ajax.xhtml','${treeNodes}'/>
				</td>
				<th width="8%">真实姓名:&nbsp;</th>
				<td width="15%">
					<@s.textfield id="truename" name="fkUserModel.truename" cssStyle="width:75%"/>
				</td>
				<th width="8%">身份证号码:&nbsp;</th>
				<td width="15%">
					<@s.textfield id="idCard" name="fkUserModel.idCard" cssStyle="width:75%"/>
				</td>
				<th width="8%">固定电话:&nbsp;</th>
				<td width="15%">
					<@s.textfield id="userPhone" name="fkUserModel.userPhone" cssStyle="width:75%"/>
				</td>
		        <td>
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('fkUserModel','filter');"/>
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
			<@util.menu_add '添 加'> obj="fkUser" </@util.menu_add>
			<@util.menu_edit '编 辑'> obj="fkUser" </@util.menu_edit>
			<@util.menu_delAll '删 除'> obj="fkUser" </@util.menu_delAll>
			<@util.menu_reload '刷 新'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=fkUserModels  limit=fkUserModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="fkUser" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="fkUserModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${fkUser.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn width="15%" property="fkOrganize.orgName" title="机构名称" />
				<@jmesa.htmlColumn width="10%" property="username" title="帐号名称" />
				<@jmesa.htmlColumn width="10%" property="truename" title="真实姓名" >
					<a href="fkUser_detail.xhtml?id=${fkUser.id}" title="点击查看详细信息!">${fkUser.truename}</a>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn width="15%" property="idCard" title="身份证" />
				<@jmesa.htmlColumn width="10%" property="bornDate" title="出生年月" />
				<@jmesa.htmlColumn width="8%" property="userMobile" title="手机号码" />
				<@jmesa.htmlColumn width="10%" property="userPhone" title="固定电话" />
				<@jmesa.htmlColumn width="12%" property="userEmail" title="邮箱地址" />
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
        window.open('fkUser_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

