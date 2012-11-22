<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 ManagerList
 -->
<@fkMacros.pageHeader />
<@enum.initEnumXML/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" >
    		<div class="dqwz">
    			您现在的位置：<#if companyInfoModel?if_exists != "">${companyInfoModel.companyName} 的</#if>标准化管理列表
    		</div>
    	</td>
    </tr>
</table>
<@s.form id="companyTrainForm" action="companyTrain_managerList.xhtml?id=${companyInfoModel.id}"><@s.token />
<input type="hidden" id="companyId" name="companyAccident.accidentUnit.id" value="${companyInfoModel.id}"/>
<table width="100%" rules="none" frame="void">
  <tr>
    <td class="queryTable" align="center">
		<table width="90%" border="0" cellpadding="0" cellspacing="0" id="queryTable" rules="none" frame="void">
			<tr>
				
		        <th width="10%" align="right">培训类型&nbsp;&nbsp;&nbsp;</th>
		        <td width="15%">
		           <input type="hidden" id="companyId" name="companyTrain.companyInfo.id" value="${companyInfoModel.id}"/>
		           <select id="trainType" name="companyTrainModel.trainType" />
		        </td>
		        <th width="10%" align="right">所在区域&nbsp;&nbsp;&nbsp;</th>
		        <td width="25%" >
					<div id="div-area"></div>
		        </td>
		         <th width="10%" align="right">培训状态&nbsp;&nbsp;&nbsp;</th>
		         <td width="15%">
		        	<select id="state" name="companyTrainModel.state">
		        		<option value="">--请选择--</option>
		        		<option value="1">已培训</option>
		        		<option value="0">未培训</option>
		        	</select>
		        </td>
		        
		        <td width="10%" rowspan="2">
		        	<input type="button" value="查 询" onclick="javascript:onInvokeAction('companyTrainModel','filter');"/>
		        </td>
	     	</tr>
	     	<tr>
	     		<th align="right">证书编号&nbsp;&nbsp;&nbsp;</th>
		        <td >
		        	<@s.textfield id="certificateNumber" name="companyTrainModel.certificateNumber" />
		        </td>
				<th align="right">培训人员姓名&nbsp;&nbsp;&nbsp;</th>
		        <td >
		        	<@s.textfield id="personName" name="companyTrainModel.personName" />
		        </td>
		        <th align="right">身份证&nbsp;&nbsp;&nbsp;</th>
		        <td>
		        	<@s.textfield id="personIdcard" name="companyTrainModel.personIdcard" />
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
			<@util.company_addStand '添加培训'> obj="companyTrain_insert.xhtml"</@util.company_addStand>
			<@util.menu_edit '编辑培训'> obj="companyTrain" </@util.menu_edit>
			<@util.company_delAll '删 除'> obj="companyTrain_remove.xhtml" </@util.company_delAll>
			<@util.menu_reload '刷 新'/>
			
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<@jmesa.tableModel items=companyTrainModels  limit=companyTrainModel.limit filterMatcherMap="com.safetys.framework.filter.TagFilterMatcherMap" stateAttr="restore"
	 var="companyTrain" view="com.safetys.framework.jmesa.DefautHtmlView" toolbar="com.safetys.framework.jmesa.DefaultToolBar" id="companyTrainModel" >
	<@jmesa.htmlTable width="100%" style="text-align:left;">
		<@jmesa.htmlRow>
				<@jmesa.htmlColumn property="id" style="text-align: center;" width="3%" title="<input type='checkbox' id='checkAll' name='checkAll'/>" filterable=false sortable=false>
					<input type="checkbox" name="selectedIds" value="${companyTrain.id}" />
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="personName" title="培训人员姓名" />
				<@jmesa.htmlColumn property="companyTrain.companyInfo.companyName" title="单位名称" >
					${companyTrain.companyInfo.companyName}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="companyTrain.companyInfo.address" title="单位地址" >
					${companyTrain.companyInfo.address}
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="personIdcard" title="身份证号"/>
				<@jmesa.htmlColumn property="certificateCode" title="证书号"/>
				<@jmesa.htmlColumn property="trainType" title="培训类型" >
					<@enum.getSelectEnum companyTrain.trainType/>
				</@jmesa.htmlColumn>
				<@jmesa.htmlColumn property="state" title="培训状态" >
					<#if companyTrain.state?if_exists==1>
						已培训
					<#else>
						未培训
					</#if>
				</@jmesa.htmlColumn>
		</@jmesa.htmlRow>
	</@jmesa.htmlTable>
</@jmesa.tableModel>

</@s.form>
<@enum.selectAreas "companyTrainModel","div-area","${companyTrainModel.firstArea?if_exists}","${companyTrainModel.secondArea?if_exists}","${companyTrainModel.thirdArea?if_exists}","${companyTrainModel.fouthArea?if_exists}","${companyTrainModel.fifthArea?if_exists}" />
<script type="text/javascript">
	if(get("trainType")){enumObj.initSelect("trainType","trainType");}		//培训类型
	
	<#if companyTrainModel.trainType?if_exists != "">
		jQuery("#trainType").val("${companyTrainModel.trainType}");
	</#if>

	function onInvokeAction(id) {
		jQuery.jmesa.setExportToLimit(id, '');
		jQuery.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
	}
	function onInvokeExportAction(id) {
        var parameterString = jQuery.jmesa.createParameterStringForLimit(id);
        window.open('companyStandard_report.xhtml?' + parameterString);
    }
</script>
<@fkMacros.pageFooter />

