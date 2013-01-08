<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="${resourcePath}/javascript/global/jquery-1.7.1.min.js" type="text/javascript"></script>
<link href="${resourcePath}/default/css/mainFrame.css" rel="stylesheet" type="text/css" /><script>jQuery.noConflict();</script></head><body>
</head><body class="topbody">
<TABLE class="head" border=0 cellSpacing=0 cellPadding=0 width="100%" height="92px;">
<tr>
    <td >
	  <table class=header border=0 cellSpacing=0 cellPadding=0 width="100%">
        <tr>
          <td height="35" style="PADDING-BOTTOM: 9px; VERTICAL-ALIGN: bottom" width="100%" align=right colspan="2" valign="top">
		  	<table class=right_navi border=0 cellSpacing=0 cellPadding=0>
              <tr>
             	<td style="COLOR: #ffffff" width="25%" noWrap><img src="${resourcePath}/default/images/admin.gif" />欢迎您，${currentUser.truename} ！！</td>
               	<TD align=middle>|</TD>
                <td width="25%" noWrap><a href="#" onfocus="this.blur()" onclick="goIndex();"><img src="${resourcePath}/default/images/house.gif" />返回首页</a></td>
                <TD align=middle>|</TD>
                <td width="25%" noWrap><a href="#" onfocus="this.blur()" onclick="reset();"><img src="${resourcePath}/default/images/door.gif" width="16" height="16" />退出系统</a></td>
              </tr>
            </table>
		  </td>
        </tr>
        <tr>
		   <td width="505"></td>
		   <TD style="PADDING-BOTTOM: 9px; VERTICAL-ALIGN: bottom" width="100%"  align=right>
		   		<div id="navi"><ul>
		   		<#list fkResourceModels?if_exists as item>
		   			<li class="t1"><a href="javascript:void(0);" onclick="switchTag(${item.id}, '${item.resourceUrl?default('')}', true);this.blur();" resourceId="${item.id}"><span>${item.resourceName}</span></a></li>
		   		</#list>
		   		</ul></div>
		   </td>
        </tr>
      </table>
	  </td>
  </tr>
</table>
</body>
<script type"text/javascript">
jQuery(document).ready(function(){
	jQuery("#navi li").click(function(){
		jQuery("#navi li").each(function(i){
			jQuery(this).attr("class", "t1");
		})
		jQuery(this).attr("class", "current");
	})
});

function switchTag(parentId, resourceUrl, isAutoChange){
	var url = "workspace_left.xhtml?id=" +parentId;
	if (isAutoChange){
		window.parent.leftFrame.location.href = url;
		if(jQuery.trim(resourceUrl)!==""){
			window.parent.mainFrame.location.href = resourceUrl;	
		}
	}else{
		window.parent.leftFrame.location.href = url;
	}

}

function goIndex(){
	window.parent.mainFrame.location.href = "workspace_content.xhtml";
	window.parent.leftFrame.location.href = "workspace_left.xhtml";		
}
function modify_pwd(){
	window.parent.mainFrame.location.href = "fkUser_modifySelfInfo.xhtml";
}

function reset(){
	if(window.confirm("您确认现在退出系统吗？"))
		window.parent.location.href = "dispatch_exits.xhtml";
}
</script>
</html>