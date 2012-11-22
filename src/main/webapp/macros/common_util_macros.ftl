<#--顶部菜单栏按钮-->
<#macro menu_add title><li><a href="javascript:void(0);" id="add" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_add.png">${title}</span></a></li></#macro>
<#macro menu_edit title><li><a href="javascript:void(0);" id="edit" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_edit.png">${title}</span></a></li></#macro>
<#macro menu_save title><li><a href="javascript:void(0);" id="save" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_save.png">${title}</span></a></li></#macro>
<#macro menu_delAll title><li><a href="javascript:void(0);" id="delAll" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_del_all.png">${title}</span></a></li></#macro>
<#macro menu_info title><li><a href="javascript:void(0);" id="info" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_info.png">${title}</span></a></li></#macro>
<#macro menu_report title><li><a href="javascript:void(0);" id="report" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_report.png">${title}</span></a></li></#macro>
<#macro menu_statistic title><li><a href="javascript:void(0);" id="statistic" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_statistic.png">${title}</span></a></li></#macro>
<#macro menu_excel title><li><a href="javascript:void(0);" id="excel" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_excel.png">${title}</span></a></li></#macro>
<#macro menu_back title><li><a href="javascript:void(0);" id="back" title="${title}"><span><img src="${resourcePath}/default/img/tool_back.png">${title}</span></a></li></#macro>
<#macro menu_reload title><li><a href="javascript:void(0);" id="reload" onclick="window.location.reload();" title="${title}"><span><img src="${resourcePath}/default/img/tool_reload.png">${title}</span></a></li></#macro>
<#macro company_add title><li><a href="javascript:void(0);" id="companyAdd" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_add.png">${title}</span></a></li></#macro>
<#macro company_addStand title><li><a href="javascript:void(0);" id="companyAddStand" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_add.png">${title}</span></a></li></#macro>
<#macro company_delAll title><li><a href="javascript:void(0);" id="companyDelAll" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_del_all.png">${title}</span></a></li></#macro>
<#macro company_edit title><li><a href="javascript:void(0);" id="companyEdit" <#nested> title="${title}"><span>${title}</span></a></li></#macro>
<#macro param_edit title><li><a href="javascript:void(0);" id="paramEdit" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_edit.png">${title}</span></a></li></#macro>
<#macro param_del title><li><a href="javascript:void(0);" id="paramDelAll" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_del_all.png">${title}</span></a></li></#macro>
<#macro param_add title><li><a href="javascript:void(0);" id="paramAdd" <#nested> title="${title}"><span><img src="${resourcePath}/default/img/tool_add.png">${title}</span></a></li></#macro>
<#macro fckEditPanl editorName editorValue="">
<@fck.editor instanceName="${editorName}" height="550px" basePath="/resources/fckeditor" value="${editorValue}" />
</#macro>

<#--把录入页面转变成只读页面-->
<#macro editToView>
		<script>
			<#--读取input，如果一个TD中出现了父级节点，则在除第一个子节点后的节点中，添加一个parent=父ID属性。额外显示的信息用SPAN标签-->
			jQuery("#inputTab input[type='text']").each(function(){
				var tdElement = getParentTdNode(this);
				var flag = jQuery(tdElement).attr("ignoreReadonly");
				if(flag==null || flag==false){
					if (tdElement){//找得到父级节点
						var val = this.value;
						if(val==null||val==""){
							val="&nbsp;";
						}
						tdElement.innerHTML = val +" "+jQuery(tdElement).find("span").text();
					}else{//找不到父级节点，（出现于一个TD中出现了2个以上的input情况）
						var parent = jQuery(this).attr("parent");
						var obj = jQuery("#"+parent);//父级几点
						val = jQuery(this).val();
						if(parent!=null){
							jQuery(obj).text(jQuery(obj).text()+" "+jQuery(obj).find("span").text()+" "+val);
						}
					}
				}
			})
			<#--读取radio，需要设置title属性为该输入项的真实取值-->
			jQuery("#inputTab input[type='radio']").each(function(){
				var tdElement = getParentTdNode(this);
				var val = "";
				var flag = jQuery(this).attr("checked");
				if (tdElement && flag!=null && flag==true){
					val = jQuery(this).attr("title");
					if(val==null||val==""){
						val="&nbsp;";
					}
					tdElement.innerHTML = val +" "+jQuery(tdElement).find("span").text();
				}
			});
			<#--读取checkbox,需要设置title属性为该输入项的真实取值-->
			//var tdElement = jQuery("#inputTab input[type='checkbox']").eq(0).parent();
			jQuery("#inputTab input[type='checkbox']").each(function(){
				var tdElement = jQuery(this).parent();
				var val = "&nbsp;";
				if (jQuery(this).attr('checked')==true){
					val = jQuery(this).attr("yes");
				}else{
					val = jQuery(this).attr("no");
				}
				if(val==null||val==""||val=="undefined"){
					val="&nbsp;";
				}
				jQuery(tdElement).html(val);
			});
			<#--隐藏textarea-->
			jQuery("textarea[id='content']").each(function(){
				var tdElement = getParentTdNode(this);
				if (tdElement){
					var val = this.value;
					if(val==null||val==""){
						val="&nbsp;";
					}
					tdElement.innerHTML = val ;
				}
			})
			<#--读取textarea-->
			jQuery.each(jQuery("#inputTab textarea"),function(i,n){
				var text = jQuery(n).val().replace(new RegExp("\n","gm"),"<br/>");
				var rows = jQuery(n).attr("rows");
				if(text==null||text=="undefined"||text=="")
				text="&nbsp;";
				jQuery(n).replaceWith("<div type='textarea' rows='"+rows+"'>"+text+"</div>");
			});
			<#--隐藏文件上传-->
			jQuery("input[id='entityFile']").hide();
			jQuery("span[id='entityFileWarn']").hide();
			<#--隐藏底部保存按钮-->
			jQuery(".buttonBarTr td").html("&nbsp;").css("border","0px");
			<#--读取select-->
			jQuery.each(jQuery("#inputTab select"),function(i,n){
				var flag = jQuery(n).parent().attr("ignoreReadonly");
				if(flag==null || flag==false){
					var text = this.options[this.selectedIndex].text;
					if(text.contains("请选择"))
						text="";
					if (this.id.indexOf("first-area") > -1 && jQuery(n).parent().attr("tagName").toUpperCase() == "DIV") {//区域
						var areas = jQuery(n).parent().children();
						for (var i=0; i<areas.length; i++) {
							text += i==0 ? "" : "  " + areas[i].options[areas[i].selectedIndex].text;
						}
						jQuery(n).parent().text(text);
					} else {
						jQuery(n).parent().text(text);
					}
				}
			});
			//找到父级节点
			function getParentTdNode(obj){
				var parentNode = obj.parentNode;
				if(parentNode!=null){
					while(parentNode.nodeName.toUpperCase() != "TD"){
						parentNode = parentNode.parentNode;
					}
				}
				return parentNode;
			};
		</script>
</#macro>