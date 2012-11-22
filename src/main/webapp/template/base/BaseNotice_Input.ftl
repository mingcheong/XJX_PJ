<@fkMacros.pageHeader />
<link href="${resourcePath}/wbox/css/wbox.css" rel="stylesheet" type="text/css" />
<script src="${resourcePath}/wbox/wbox.js" type="text/javascript"></script>
<@fkMacros.formValidator 'baseNoticeForm'/><@enum.initEnumXML />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：通知公告 </div></td>
  </tr>
</table>
<@s.form id="baseNoticeForm" action="baseNotice_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="baseNoticeModel.id" />
	<@s.hidden id="orgsId" name="baseNoticeModel.fkOrganizeModel.id" value="${currentUser.fkOrganize.id}"/>
			<@s.hidden id="userId" name="baseNoticeModel.fkUserModel.id" value="${currentUser.id}"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="baseNoticeForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>通知标题:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="name" name="baseNoticeModel.name" cssStyle="width:90%"/>
			<ui:v for="name" rule="require" warn="不允许以空格为开始" empty="标题不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>通知对象:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.hidden name="baseNoticeModel.userIds" id="selectedIds"/>
			<@s.textarea id="selectedNames" readonly="true" name="baseNoticeModel.userNames"  cssStyle="width:90%" rows="5"/>
			&nbsp;&nbsp;<a herf="＃" id="selectHerf">请选择</a>
			<ui:v for="selectedNames" rule="require" warn="不允许以空格为开始" empty="通知对象不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">制定单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="ruleUnit" name="baseNoticeModel.ruleUnit" cssStyle="width:75%"/>
		</td>
		<th width="15%">实施单位:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="implUnit" name="baseNoticeModel.implUnit" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>通知类型:&nbsp;</th>
		<td width="35%">
			<select name="baseNoticeModel.type" id="notice_type"></select>
			<ui:v for="notice_type" rule="require" warn="不允许以空格为开始" empty="类型不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>发布时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="releaseDate" name="baseNoticeModel.releaseDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"   cssStyle="width:75%"/>
			<ui:v for="releaseDate" rule="require" warn="不允许以空格为开始" empty="发布时间不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">内容:&nbsp;</th>
		<td colspan="3"> 
			<@util.fckEditPanl editorName="baseNoticeModel.content" editorValue="${baseNoticeModel.content?default('')}"/>
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="remark" name="baseNoticeModel.remark" cssStyle="width:90%" rows="3"></@s.textarea>
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
<#if baseNoticeModel.type?if_exists != "">jQuery("#notice_type").val("${baseNoticeModel.type}");</#if>
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
