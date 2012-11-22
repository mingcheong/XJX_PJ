<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><@fkMacros.title />
<link href="${resourcePath}/default/css/css.css" rel="stylesheet" type="text/css" />
<script src="${resourcePath}/javascript/global/jquery-1.7.1.min.js" type="text/javascript"></script>
<script>jQuery.noConflict();</script></head><body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="left"  >
	  <div class="menu_left">
		<ul>
			&nbsp;&nbsp;<input type="button" onclick="chooseOperator();" value="确&nbsp;定">
			&nbsp;&nbsp;<input type="button" onclick="closewBox();" id="fail" value="取&nbsp;消">
		</ul>
	  </div>
	</td>
  </tr>
</table>
<TABLE border=0 width="100%" height="100%"  align=left>
	<TR>
		<TD width="213px" align="left" valign="top" style="border-right: #000000 1px dashed">
			<@fkMacros.checkBoxTree2 'orgsFrame','${treeNodes}','fkOrganize_ajax.xhtml' />
		</TD>
		<TD align=left valign=top>
			<IFRAME id="orgsFrame" Name="orgsFrame" url="fkOrganize_operatorList.xhtml?selectedIds=" FRAMEBORDER=0  
			SCROLLING=AUTO width=100%  height=100% src="fkOrganize_operatorList.xhtml"></IFRAME>
		</TD>
	</TR>
</TABLE>
<@fkMacros.pageFooter />
<script type="text/javascript">
function chooseOperator(){
	var selectedIds = "";
	var selectedNames = "";
	jQuery(window.frames["orgsFrame"].document).find("input[name='selectId']").each(function() {
		if (jQuery(this).attr("checked")) {
			if ("" == selectedIds) {
				selectedIds += jQuery(this).val();
				selectedNames += jQuery(this).attr("title");
			} else {
				if (selectedIds.indexOf(jQuery(this).val()) < 0) selectedIds += "," + jQuery(this).val();
				selectedNames += "," + jQuery(this).attr("title");
			}
		}
	});
	if(selectedIds == ""){
		alert("请选择人员！");
	}else{
		jQuery(window.parent.document).find("#selectedIds").val(selectedIds);
		jQuery(window.parent.document).find("#selectedNames").val(selectedNames);
		closewBox();
	}
}
function closewBox(){
	parent.wbox.close();
}
</script>