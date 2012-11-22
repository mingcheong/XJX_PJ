<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head><@fkMacros.title /><link href="${resourcePath}/default/css/css.css" rel="stylesheet" type="text/css" /><link href="${resourcePath}/default/css/data.css" rel="stylesheet" type="text/css" /><link href="${resourcePath}/datepicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" /><link href="${resourcePath}/jmesa/css/jmesa.css" rel="stylesheet" type="text/css" /><script src="${resourcePath}/javascript/global/jquery-1.7.1.min.js" type="text/javascript"></script><script src="${resourcePath}/javascript/global/jquery.form.js" type="text/javascript"></script><script src="${resourcePath}/datepicker/WdatePicker.js" type="text/javascript"></script><script src="${resourcePath}/javascript/global/public.js" type="text/javascript"></script><script src="${resourcePath}/javascript/global/common.js" type="text/javascript"></script><script src="${resourcePath}/jmesa/js/jmesa.min.js" type="text/javascript"></script><script src="${resourcePath}/jmesa/js/jquery.jmesa.min.js" type="text/javascript"></script><script>jQuery.noConflict();</script></head><body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
    <tr>
    	<td align="center" ><div class="dqwz">您现在的位置：枚举管理</div></td>
    </tr>
</table>
<TABLE border=0 width="100%" height="100%"  align=left>
	<TR>
		<TD width="213px" align="left" valign="top" style="border-right: #000000 1px dashed">
			<@fkMacros.simpleTree 'enumframe','${treeNodes}','fkEnum_ajax.xhtml' />
		</TD>
		<TD align=left valign=top>
			<IFRAME id="enumframe" Name="enumframe" url="fkEnum_manager.xhtml?fkEnumModel.fatherId=" FRAMEBORDER=0 
			SCROLLING=AUTO width=100%  height=100% src="fkEnum_manager.xhtml"></IFRAME>
		</TD>
	</TR>
</TABLE>
<@fkMacros.pageFooter />