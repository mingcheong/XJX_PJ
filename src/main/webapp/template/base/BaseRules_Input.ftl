<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 -->
<@fkMacros.pageHeader /><@enum.initEnumXML />
<@fkMacros.formValidator 'baseRulesForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：法律法规 </div></td>
  </tr>
</table>
<@s.form id="baseRulesForm" action="baseRules_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="baseRulesModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="baseRulesForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>标题:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="title" name="baseRulesModel.title" cssStyle="width:75%"/>
			<ui:v for="title" rule="require" warn="不允许以空格为开始" empty="标题不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">制定单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="formUnit" name="baseRulesModel.formUnit" cssStyle="width:75%"/>
		</td>
		<th width="15%">实施单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="implUnit" name="baseRulesModel.implUnit" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>类型:&nbsp;</th>
		<td width="35%">
			<select name="baseRulesModel.rulesType" id="rules_type"></select>
			<ui:v for="rules_type" rule="require" warn="不允许以空格为开始" empty="类型不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>发布时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="releaseDate" name="baseRulesModel.releaseDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"   cssStyle="width:75%"/>
			<ui:v for="releaseDate" rule="require" warn="不允许以空格为开始" empty="发布不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">内容:&nbsp;</th>
		<td width="35%" colspan="3">
		<@util.fckEditPanl editorName="baseRulesModel.content" editorValue="${baseRulesModel?if_exists.content?default('')}"/>
		</td>
	</tr>
	<tr>
		<th width="15%">附件:&nbsp;</th>
		<td width="35%" colspan="3">
			<div>
				<#list fkAnnexModels?if_exists as o>
					<div><img id="img${o.id}" src="${resourcePath}/default/img/sc.gif" title="删除此附件" border="0" style="cursor: hand;" onclick="removeAnnex('${o.id}')">&nbsp;&nbsp;&nbsp;<a href="${contextPath}/fkAnnex_download.xhtml?id=${o.id}" target="_blank" title="点击下载">${o.annexName}</a></div>
				</#list>
			</div><br>
			<table border="0" cellpadding="0" cellspacing="0" width="90%" id="AnnexTable">
				<tr>
					<td align="left" width="85%"><input name="Filedata" type="file" style="width: 100%"></td>
					<td align="center" width="15%"><img src='${resourcePath}/default/img/+.gif' border="0" style="cursor: hand;" onclick="addRow('AnnexTable')" /></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initAllEnum /><script type="text/javascript">
<#if baseRulesModel?if_exists.rulesType?if_exists != "">jQuery("#rules_type").val("${baseRulesModel?if_exists.rulesType}");</#if>
	var wbox = jQuery("#selectHerf").wBox({
		title:"选择通知对象！",
		requestType: "iframe", 
		iframeWH:{width:800,height:600},
		target:"fkOrganize_chooseOperator.xhtml"
	});
	//增加一行
	function addRow(table) {
	    var tableObj = document.getElementById(table);
	    var rowIndex = getNextRowIndex(tableObj);
	    var trObj = tableObj.insertRow(rowIndex);
	    var tdObj = trObj.insertCell(0);
	    tdObj.align = "left";
	    tdObj.innerHTML = '<input name="Filedata" type="file" style="width:100%" class="textInput">';
	    tdObj = trObj.insertCell(1);
	    tdObj.align = "center";
	    tdObj.innerHTML = '<img src="${resourcePath}/default/img/-.gif" border="0" style="cursor:hand;" onclick="delRow(\'AnnexTable\',this.parentNode)">';
	}
	//得到当前行号
	function getRowIndex(tdObj) {
	    var trObj = tdObj.parentNode;
	    return trObj.rowIndex;
	}
	//得到下一行的序号  
	function getNextRowIndex(tableObj) {
	    return tableObj.rows.length;
	}
	//删除一行
	function delRow(table, tdObj) {
	    var tableObj = document.getElementById(table);
	    var currentRow = getRowIndex(tdObj);
	    tableObj.deleteRow(currentRow);
	}
	function removeAnnex(annexid){
		jQuery.ajax({
			url:'fkAnnex_ajaxRemove.xhtml',
			type:'post',
			dataType:'html',
			data:'id='+annexid+"&m="+Math.round(Math.random() * 10000),
			success:function(msg){
				alert(msg);
			}
		});
		jQuery("#img"+annexid).parent().remove(); 
	}
</script>
<@fkMacros.pageFooter />
