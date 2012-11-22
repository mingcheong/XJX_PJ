<#--初始化枚举XML-->
<#macro initEnumXML>
<script type="text/javascript">var enumObj=new Enum("${enumXmlUrl}");</script>
</#macro>

<#--初始化区域XML-->
<#macro initAreaXML>
<script type="text/javascript">var areaObj=new Area("${areaXmlUrl}");</script>
</#macro>

<#--输出枚举值
用法说明：code此参数代表你要输出的枚举的编码 -->
<#macro getSelectEnum code="">
<script>var str = enumObj.getSelect('${code?trim}');if(str==null || str.length<=0)str="&nbsp;";document.write(str);</script>
</#macro>

<#--输出区域值
参数说明：code此参数代表你要输出的区域的编码，如：310200 指宁波-->
<#macro getSelectArea code="">
<script>var arr = areaObj.getArea('${code?trim}');if(arr){var value = arr[0];if (value && value != 'undefined'){document.write(value);}else{document.write("&nbsp;");}}</script>
</#macro>

<#--初始化要取的枚举类型
说明：get('*')是取对象，类似document.getElementById("*");
	 initSelect('*','*');参数一指枚举代码，参数二指你所要绑定的下拉框的ID；-->
<#macro initAllEnum>
<script type="text/javascript">
if(get("notice_type")){enumObj.initSelect("notice_type","notice_type");}//通知类型
if(get("ReportType")){enumObj.initSelect("ReportType","ReportType");}//上报状态初始化
if(get("industrial")){enumObj.initSelect("industrial","industrial");}//行业类型
if(get("character")){enumObj.initSelect("character","character");}//企业性质
if(get("MeetingModelType")){enumObj.initSelect("MeetingModelType","MeetingModelType");}//会议记录类别
if(get("SummaryModelType")){enumObj.initSelect("SummaryModelType","SummaryModelType");}//工作总结类别
if(get("WorkplanModelType")){enumObj.initSelect("WorkplanModelType","WorkplanModelType");}//工作计划类别
if(get("userPosition")){enumObj.initSelect("position","userPosition");}//职位信息初始化
if(get("safetyStandards")){enumObj.initSelect("safetyStandards","safetyStandards");}//安全达标开展情况
if(get("rules_type")){enumObj.initSelect("rules_type","rules_type");}//法律法规
if(get("listing_level")){enumObj.initSelect("listing_level","listing_level");}//挂牌级别
if(get("state")){enumObj.initSelect("equipmentState","state");}	
if(get("equipentType")){enumObj.initSelect("equipmentType","equipentType");}		//设备类型
if(get("economicType")){enumObj.initSelect("economicType","economicType");}		//经济类型
if(get("inspectType")){enumObj.initSelect("inspectType","inspectType");}		//执法类型
</script>
</#macro>

<#--
动态生成多级联动区域下拉框(最大支持五级）
参数说明：entityNmae 对象名称
		 divId 用来存放选择器的属性
-->
<#macro selectAreas entityName divId selectedFirstAreaCode="" selectedSecondAreaCode="" selectedThirdAreaCode="" selectedFouthAreaCode="" selectedFifthAreaCode="">
<script language="javascript">
function initNextAreaSelect(thisSelectValue,nextSelectId,thisTagName,nextTagName){var nextObj=document.getElementById(nextSelectId);if(nextObj!=null&&nextObj!=undefined){nextObj.options.length=1;var thisAreas = xmlobject.responseXML.getElementsByTagName(thisTagName);for(var i=0;i<thisAreas.length;i++){if(thisAreas[i].getAttribute("code")==thisSelectValue){var nextAreas = thisAreas[i].getElementsByTagName(nextTagName);for(var j=1;j<=nextAreas.length;j++){var opt = new Option(nextAreas[j-1].getAttribute("name"),nextAreas[j-1].getAttribute("code")) ;nextObj.options[j] = opt ;opt = null ;}break;}}}}
function initXMLHttpClient() {var xmlhttp;try {xmlhttp = new XMLHttpRequest();} catch (e) {var XMLHTTP_IDS = new Array('MSXML2.XMLHTTP.5.0','MSXML2.XMLHTTP.4.0','MSXML2.XMLHTTP.3.0','MSXML2.XMLHTTP','Microsoft.XMLHTTP' );var success = false;for (var i=0;i < XMLHTTP_IDS.length && !success; i++) {try {xmlhttp = new ActiveXObject(XMLHTTP_IDS[i]);success = true;} catch (e) {}}if (!success) {throw new Error('Unable to create XMLHttpRequest.');}}return xmlhttp;}var xmlobject=initXMLHttpClient();xmlobject.onreadystatechange = function(){if (xmlobject.readyState == 4) {if (xmlobject.status == 200) {var firstAreas = xmlobject.responseXML.getElementsByTagName('first-area');var firstResult="",secondResult="",thirdResult="",fouthResult="",fifthResult="",nextElement=firstAreas[0];if(nextElement!=null){firstResult='<select id="${entityName}first-area" name="${entityName}.firstArea">';nextElement=nextElement.firstChild;if(nextElement!=null){secondResult='<select id="${entityName}second-area" name="${entityName}.secondArea"  onchange="initNextAreaSelect(this.value,\'${entityName}third-area\',\'second-area\',\'third-area\');">';secondResult+='<option value="0">--请选择--</option>';nextElement=nextElement.firstChild;if(nextElement!=null){thirdResult='<select id="${entityName}third-area" name="${entityName}.thirdArea"  onchange="initNextAreaSelect(this.value,\'${entityName}fouth-area\',\'third-area\',\'fouth-area\');">';thirdResult+='<option value="0">--请选择--</option>';nextElement=nextElement.firstChild;if(nextElement!=null){fouthResult='<select id="${entityName}fouth-area" name="${entityName}.fouthArea" onchange="initNextAreaSelect(this.value,\'${entityName}fifth-area\',\'fouth-area\',\'fifth-area\');">';fouthResult+='<option value="0">--请选择--</option>';nextElement=nextElement.firstChild;if(nextElement!=null){fifthResult='<select id="${entityName}fifth-area" name="${entityName}.fifthArea"  onchange="initNextAreaSelect(this.value,\'${entityName}sixth-area\',\'fifth-area\',\'sixth-area\');">';fifthResult+='<option value="0">--请选择--</option>';}}}}}if(firstAreas.length>0){for(var i=1;i<=firstAreas.length;i++){firstResult+='<option value="'+firstAreas[i-1].getAttribute("code")+'" selected="selected">'+firstAreas[i-1].getAttribute("name")+'</option>';var secondAreas = firstAreas[i-1].getElementsByTagName('second-area');
for(var j=1;j<=secondAreas.length;j++){if("${selectedSecondAreaCode}"!=""&&secondAreas[j-1].getAttribute("code")=="${selectedSecondAreaCode}"){secondResult+='<option value="'+secondAreas[j-1].getAttribute("code")+'" selected="selected">'+secondAreas[j-1].getAttribute("name")+'</option>';var thirdAreas = secondAreas[j-1].getElementsByTagName('third-area');for(var k=1;k<=thirdAreas.length;k++){if(thirdResult!=''){if("${selectedThirdAreaCode}"!=""&&thirdAreas[k-1].getAttribute("code")=="${selectedThirdAreaCode}"){thirdResult+='<option value="'+thirdAreas[k-1].getAttribute("code")+'" selected="selected">'+thirdAreas[k-1].getAttribute("name")+'</option>';var fouthAreas = thirdAreas[k-1].getElementsByTagName('fouth-area');if(fouthResult!=''){for(var m=1;m<=fouthAreas.length;m++){if("${selectedFouthAreaCode}"!=""&&fouthAreas[m-1].getAttribute("code")=="${selectedFouthAreaCode}"){fouthResult+='<option value="'+fouthAreas[m-1].getAttribute("code")+'" selected="selected">'+fouthAreas[m-1].getAttribute("name")+'2222</option>';var fifthAreas = fouthAreas[m-1].getElementsByTagName('fifth-area');if(fifthResult!=''){for(var n=1;n<=fifthAreas.length;n++){if("${selectedFifthAreaCode}"!=""&&fifthAreas[n-1].getAttribute("code")=="${selectedFifthAreaCode}"){fifthResult+='<option value="'+fifthAreas[n-1].getAttribute("code")+'" selected="selected">'+fifthAreas[n-1].getAttribute("name")+'</option>';}else{fifthResult+='<option value="'+fifthAreas[n-1].getAttribute("code")+'">'+fifthAreas[n-1].getAttribute("name")+'</option>';}}}}else{fouthResult+='<option value="'+fouthAreas[m-1].getAttribute("code")+'">'+fouthAreas[m-1].getAttribute("name")+'1111</option>';}}}}else{thirdResult+='<option value="'+thirdAreas[k-1].getAttribute("code")+'">'+thirdAreas[k-1].getAttribute("name")+'</option>' ;}}}}else{secondResult+='<option value="'+secondAreas[j-1].getAttribute("code")+'">'+secondAreas[j-1].getAttribute("name")+'</option>';}}}
var divArea = document.getElementById("${divId}");var totalResult="";if(firstResult!=""){totalResult+=firstResult+"</select>&nbsp;&nbsp;";}if(secondResult!=""){totalResult+=secondResult+"</select>&nbsp;&nbsp;";}if(thirdResult!=""){totalResult+=thirdResult+"</select>&nbsp;&nbsp;";}if(fouthResult!=""){totalResult+=fouthResult+"</select>&nbsp;&nbsp;";}if(fifthResult!=""){totalResult+=fifthResult+"</select>";}divArea.innerHTML=totalResult;}} else {alert('Loading Areas Error: ['+xmlobject.status+'] '+xmlobject.statusText);}}}
xmlobject.open('GET','${areaXmlUrl}',false);
xmlobject.send(null);</script>
</#macro>