jQuery(document).ready(
		function() {
			jQuery("input[name='selectedIds']").attr("checked", false);
			
			var selectedIds = "";
			var url = "";
			jQuery("#checkAll").click(function() {
				if (jQuery(this).attr("checked")) {
					jQuery("input[name='selectedIds']").attr("checked", true);
					selectedIds = "";
					jQuery("input[name='selectedIds']").each(function() {
						ajustSelectedIds(jQuery(this));
					});
				} else {
					jQuery("input[name='selectedIds']").attr("checked", false);
					selectedIds = "";
				}
			});
			jQuery("input[name='selectedIds']").click(function() {
				ajustAllStatus();
				ajustSelectedIds(jQuery(this));
			});
			jQuery("#add").click(function() {
				url = jQuery("#add").attr("obj") + "_insert.xhtml";
				var id = jQuery("#id").val();
				if (id != undefined) {
					url += "?id=" + id;
				}
				locateTo(url);
			});
			jQuery("#companyAdd").click(
				function() {
					if (!checkEmpty()) {
						return false;
					}
					if (!checkSingle()) {
						return false;
					}
					url = jQuery("#companyAdd").attr("obj")+"?id="+ selectedIds;
				locateTo(url);
			});
			jQuery("#companyAddStand").click(//添加 企业对应下的事故 ,证书,标准化 需要企业ID
					function() {
					
						url = jQuery("#companyAddStand").attr("obj")+"?id="+ jQuery("#companyId").val();
					locateTo(url);
				});
			jQuery("#companyDelAll").click(//添加 企业对应下的事故 ,证书,标准化,删除完之后跳到删除前的页面, 需要企业ID
					function() {
						if (!checkEmpty()) {
							return false;
						}
						if (!confirm("确定彻底删除吗？"))
							return false;

						url = jQuery("#companyDelAll").attr("obj")+"?id="+ jQuery("#companyId").val()+"&selectedIds=" + selectedIds;
					locateTo(url);
				});
			jQuery("#paramAdd").click(
					function() {
						url = jQuery("#paramAdd").attr("obj")+"?param="+ jQuery("#param").val();
					locateTo(url);
				});
			jQuery("#paramEdit").click(
					function() {
						if (!checkEmpty()) {
							return false;
						}
						if (!checkSingle()) {
							return false;
						}
						url = jQuery("#paramEdit").attr("obj")+"?param="+ jQuery("#param").val()+"&id="+ selectedIds;
					locateTo(url);
				});
			jQuery("#paramDelAll").click(
					function() {
						if (!checkEmpty()) {
							return false;
						}
						url = jQuery("#paramDelAll").attr("obj")+"?param="+ jQuery("#param").val()+"&selectedIds="+ selectedIds;
					locateTo(url);
				});
			jQuery("#companyEdit").click(
					function() {
						if (!checkEmpty()) {
							return false;
						}
						if (!checkSingle()) {
							return false;
						}
						url = jQuery("#companyEdit").attr("obj")+"?id="+ selectedIds;
					locateTo(url);
				});
			jQuery("#edit").click(
				function() {
					if (!checkEmpty()) {
						return false;
					}
					if (!checkSingle()) {
						return false;
					}
					url = jQuery("#edit").attr("obj") + "_modify.xhtml?id=" + selectedIds;
					locateTo(url);
				});
			jQuery("#delAll").click(
				function() {
					if (!checkEmpty()) {
						return false;
					}
					if (!confirm("确定彻底删除吗？"))
						return false;
					url = jQuery("#delAll").attr("obj") + "_remove.xhtml?selectedIds=" + selectedIds;
					locateTo(url);
				});
			jQuery("#save").click(function() {
				if (formValidator.validate()) {
					var formId = jQuery("#save").attr("obj");
					jQuery("#" + formId).submit();
				}
			});
			jQuery("#back").click(function() {
				window.history.back(-1);
			});
			function ajustAllStatus() {
				var count = 0;
				var flag = false;
				jQuery("input[name='selectedIds']").each(function() {
					if (!jQuery(this).attr("checked")) {
						count++;
					}
				});
				if (count == 0) {
					flag = true;
				}
				jQuery("#checkAll").attr("checked", false);
			}
			function ajustSelectedIds(o) {
				if (jQuery(o).attr("checked")) {
					if ("" == selectedIds) {
						selectedIds += jQuery(o).val();
					} else {
						if (selectedIds.indexOf(jQuery(o).val()) < 0) {
							selectedIds += "," + jQuery(o).val();
						}
					}
				} else {
					var index = selectedIds.indexOf(jQuery(o).val());
					if (index > 0) {
						selectedIds = selectedIds.substring(0, index - 1)
								+ selectedIds.substring(index
										+ jQuery(o).val().length);
					} else if (index == 0) {
						selectedIds = selectedIds.substring(0, index)
								+ selectedIds.substring(index
										+ jQuery(o).val().length);
					}
					deleteHeadOrTail();
				}
			}
			function deleteHeadOrTail() {
				if (selectedIds.indexOf(",") == 0) {
					selectedIds = selectedIds.substring(1);
				}
				if (selectedIds.lastIndexOf(",") == selectedIds.length - 1) {
					selectedIds = selectedIds.substring(0,
							selectedIds.length - 1);
				}
			}
			function checkEmpty() {
				if (null == selectedIds || "undefined" == selectedIds
						|| "" == selectedIds) {
					alert("请选择一条要操作的记录！");
					return false;
				}
				return true;
			}
			function checkSingle() {
				if (selectedIds.indexOf(",") > 0) {
					alert("只能选择一条！");
					return false;
				}
				return true;
			}
		});
function locateTo(h) {
	window.location.href = h;
}
function openWindows(url, w, h) {
	var iTop = (screen.height - 30 - h) / 2;
	var iLeft = (screen.width - 10 - w) / 2;
	window.open(url,'window','height='+ h + ',width=' + w + ',top=' + iTop + ',left=' + iLeft + ',toolbar=no,menubar=no,scrollbars=yes,resizeable=no,location=no,status=no');
}
function openDialog(l, w, h) {
	if (w == null)
		w = 600;
	if (h == null)
		h = 400;
	var parArray = window.showModalDialog(l, window, 'dialogWidth:' + w + 'px;dialogHeight:' + h + 'px;center:yes;help:no;status:yes;scroll:auto');
	return parArray;
}
function updateSelectedElement(selectElementID, selectedValue) {
	var selectElement = document.getElementById(selectElementID);
	for ( var i = 0; i < selectElement.options.length; i++) {
		if (selectElement.options[i].value == selectedValue) {
			selectElement.options[i].selected = true;
		} else {
			selectElement.options[i].selected = false;
		}
	}
}
function updateRadioElement(radioElementName, radioValue) {
	var radioElement = document.getElementsByName(radioElementName);
	for ( var i = 0; i < radioElement.length; i++) {
		if (radioElement[i].value == radioValue) {
			radioElement[i].checked = true;
		}
	}
}
function updateCheckBoxElement(checkBoxElementName, checkValue) {
	var checkBoxElement = document.getElementsByName(checkBoxElementName);
	var checkValueArray = new Array();
	checkValueArray = checkValue.split(",");
	for ( var i = 0; i < checkBoxElement.length; i++) {
		for ( var j = 0; j < checkValueArray.length; j++) {
			if (checkBoxElement[i].value == checkValueArray[j]) {
				checkBoxElement[i].checked = true;
			}
		}
	}
}
function getSelectedValue(selectElementID) {
	var selectElement = document.getElementById(selectElementID);
	return selectElement.options[selectElement.selectedIndex].value;
}
function getRadioValue(selectElementName) {
	var radioElement = document.getElementsByName(selectElementName);
	var readioValue = '';
	for ( var i = 0; i < radioElement.length; i++) {
		if (radioElement[i].checked == true)
			readioValue = radioElement[i].value;
		break;
	}
	return readioValue;
}
function getCheckBoxValue(checkBoxElementName) {
	var checkBoxElement = document.getElementsByName(checkBoxElementName);
	var result = "";
	for ( var i = 0; i < checkBoxElement.length; i++) {
		if (checkBoxElement[i].checked) {
			if (i == 0)
				result += checkBoxElement[i].value;
			else
				result += "," + checkBoxElement[i].value;
		}
	}
	return result;
}
function conversionXmlToDoc(xml) {
	var doc = "";
	if (window.ActiveXObject) {
		doc = new ActiveXObject("Microsoft.XMLDOM");
		doc.loadXML(xml);
	} else {
		var parser = new DOMParser();
		doc = parser.parseFromString(xml, "text/xml");
	}
	return doc;
}