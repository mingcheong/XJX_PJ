<@fkMacros.pageHeader />
<link href="${resourcePath}/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script src="${resourcePath}/ztree/js/jquery.ztree.all-3.1.min.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">jQuery(document).ready(function(){var options={url:'authoriz_save.xhtml',dataType:'html',beforeSubmit:showRequest,success:showResponse};jQuery("#authoriz").ajaxForm(options);jQuery("#typeCode").change(function(){var typeCode=jQuery(this).val();jQuery.ajax({url:'authoriz_ajax.xhtml',type:'post',dataType:'html',data:'typeCode='+typeCode+'&s='+Math.round(Math.random()*10000),success:function(xml){if(window.ActiveXObject){var doc=new ActiveXObject("Microsoft.XMLDOM");doc.loadXML(xml);changTypeList(typeCode,doc)}else{var parser=new DOMParser();var doc=parser.parseFromString(xml,"text/xml");changTypeList(typeCode,doc)}}})});function changTypeList(typeCode,doc){var nodes=doc.getElementsByTagName("node");if(nodes!=null){var id="";var name="";var code="";var temp="";for(var i=0;i<nodes.length;i++){id=nodes[i].getAttribute("id");name=nodes[i].getAttribute("name");temp+="<tr><td><input type=\"radio\" name=\"id\" value=\""+id+"\"onclick=\"selectedRadio('"+id+"');\"> "+name+"</td></tr>"}jQuery("#typeList").html(temp)}}});function selectedRadio(id){var type=jQuery("#typeCode").val();jQuery.ajax({url:'authoriz_getModelsToJson.xhtml',type:'post',dataType:'html',data:'id='+id+'&typeCode='+type+'&s='+Math.round(Math.random()*10000),success:function(txt){if(txt!="undefined"&&txt!="null"&&txt.length>0){jQuery("#selectedIds").attr("value",txt);var treeObj1=jQuery.fn.zTree.getZTreeObj("simpleTree");treeObj1.checkAllNodes(false);var nodes=txt.split(",");for(var i=0;i<nodes.length-1;i++){var nodetm=treeObj1.getNodeByParam("id",nodes[i],null);treeObj1.checkNode(nodetm,true,false)}}else{var treeObj1=jQuery.fn.zTree.getZTreeObj("simpleTree");treeObj1.checkAllNodes(false);jQuery("#selectedIds").attr("value",'')}}})}function showRequest(){var resourceIds=jQuery("#selectedIds").val();if(resourceIds!=null){return true}else{alert("请检查菜单资源是否已分配好！")}}function showResponse(msg){alert(msg)} var setting={data:{simpleData:{enable:true}},check:{enable:true,chkStyle:"checkbox",chkboxType:{"Y":"ps","N":"ps"}},callback:{onCheck:checkBoxOnCheck}};var zNodes=${resourceIds};function checkBoxOnCheck(e,treeId,treeNode){var zTree=jQuery.fn.zTree.getZTreeObj("simpleTree"),nodes=zTree.getCheckedNodes(true),v1="";for(var i=0,l=nodes.length;i<l;i++){v1+=nodes[i].id+","}if(v1.length>0)v1=v1.substring(0,v1.length-1);jQuery("#selectedIds").attr("value",v1)}jQuery(document).ready(function(){jQuery.fn.zTree.init(jQuery("#simpleTree"),setting,zNodes)});</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center"><tr><td align="center" ><div class="dqwz">您现在的位置：权限配置 </div></td></tr></table>
<@s.form id="authoriz"  method="post" ><@s.token /><@s.hidden name="selectedIds" id="selectedIds"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center">
	  <div class="menu_left">
		<ul>
			<li>选择类型:&nbsp;&nbsp;<SELECT name="typeCode" id="typeCode">
				<option value="role" selected="selected">按角色</option>
                <option value="orges">按组织</option>
                <option value="user">按个人</option>
            </SELECT></li>
            <li></li><li></li><li></li><li></li><li></li><li></li><li>同步到服务器</li>
            <li><input type="submit" class="buttonStyle" value="确 定" /></li>
			<li><input type="button" id="back" class="buttonStyle" value="返 回" /></li>
		</ul>
	  </div>
	</td>
  </tr>
</table>
<table  width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="35%" style='height: 500px;'>
			 <div style='height: 100%; overflow-x: no; overflow-y: auto; word-break: break-all;'><table id="typeList" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
				<#list fkRoleModels?if_exists as item>
				<tr><td><input name="id" value="${item.id}" type="radio" onclick="selectedRadio('${item.id}');">&nbsp;${item.roleName}</td></tr>
				</#list></table></div>
		</th>
		<td width="65%" style='height: 500px;'><ul id="simpleTree" class="ztree" style="width:98%;height:100%"></ul></td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />