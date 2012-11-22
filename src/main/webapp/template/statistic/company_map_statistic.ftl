<@fkMacros.pageHeader />
<link href="${resourcePath}/wbox/css/wbox.css" rel="stylesheet" type="text/css" />
<script src="${resourcePath}/wbox/wbox.js" type="text/javascript"></script>
<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script language="JavaScript" type="text/javascript">
	var geocoder;
	var marker;
  	var map;
  	var center = new google.maps.LatLng(129.868336,121.54399000000001);
  	var areaObj=new Area("${areaXmlUrl}");
   	var infowindow = new google.maps.InfoWindow();
   	var position;
   	var markerArray = new Array();
	window.onload=function(){
		geocoder = new google.maps.Geocoder();
	    var myOptions = {
	      zoom: 11,
	      mapTypeId: google.maps.MapTypeId.ROADMAP,
	      center: center
	    }
	     map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	     codeAddress(areaObj.getArea('${ac?default('')}')[0]);
	     google.maps.event.addListener(map, 'click', function() {
	  		infowindow.close();
	    })
	}
	function codeAddress(address) {
	    geocoder.geocode( { 'address': address}, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {
	        map.setCenter(results[0].geometry.location);
	      } 
	    });
	  }
	  function addreesToLatLng(address){
	 	var url;
	  	geocoder.geocode( { 'address': address}, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {
	      	url = results[0].geometry.location;
	      } 
	    });
	    return url;
	  }
	function addMarker(json){
		position = addreesToLatLng(json.address);
		if(position && position != '' && position != 'undefined'){
			var marker = new google.maps.Marker({
		        map: map,
		        position: position,
				title:json.comname,
		        animation: google.maps.Animation.DROP
		    });
		    markerArray.push(marker);
		    google.maps.event.addListener(marker, 'click', function() {
		    	infowindow.setContent(json.content);
		  		infowindow.open(map, marker);
	    	})
		}
	}
	function showMarkers(ec,ac){
		if(markerArray && markerArray != '' && markerArray != 'undefined'&&markerArray.length>0){
			for(var i = 0;i<markerArray.length;i++){
				markerArray[i].setMap(null);
			}
		}
		markerArray.splice(0,markerArray.length);  
		jQuery.ajax({
				url:'${contextPath}/baseStatistic_cpmpsnyJosnForGIS.xhtml',
				type:'post',
				dataType:'html',
				data:'ec=' + ec +'&ac=' + ac +'&m='+Math.round(Math.random() * 10000),
				success:function(msg){
				var json =  eval(msg);
					if(json&&json.length>0){
						for(var i = 0;i<json.length;i++){
							addMarker(json[i]);
						}
					}
				}
		});
	}
	function selectHerf(obj){
		var wbox = jQuery("#selectHerf"+obj).wBox({
			title:"企业详细信息",
			requestType: "iframe", 
			iframeWH:{width:800,height:600},
			target:"${contextPath}/companyInfo_detailForGIS.xhtml?id="+obj
		});
	}
	
	</script>
<TABLE style="TEXT-ALIGN: center; BORDER-COLLAPSE: collapse; FONT-SIZE: 12px" border=0 cellPadding=0 width=95%>
  <TBODY>
  <TR>
    <td align="right" width="200px" height="20px"><td><TH>企业分布图</TH><td align="right" width="200px"><A href="${contextPath}/baseStatistic_company_charts.xhtml">切换到图形统计</a><td>
  </TR>
 </TBODY></TABLE>
    <div>
<DIV style="WIDTH: 20%; FLOAT: left;"><TABLE align=center class=table_list_01 border=0 cellSpacing=0 cellPadding=0 width="100%">
  <TBODY>
  <TR>
    <TH width="50%" noWrap>行　业</TH>
    <TH width="50%" noWrap>企业家数</TH></TR>
    <#list statisticDatas?if_exists as o>
    <TR>
    <TD><DIV align=center>${o[0]}</DIV></TD>
    <TD><DIV align=center><a onclick="showMarkers('${o[1]}','${o[2]}');" href="javascript:;">${o[3]}</a></DIV></TD></TR>
  <TR>
    </#list>
  </TBODY></TABLE></DIV>
<div id="map_canvas" style="WIDTH: 80%; FLOAT: left;height:100%"></div>
</div>
<@fkMacros.pageFooter />