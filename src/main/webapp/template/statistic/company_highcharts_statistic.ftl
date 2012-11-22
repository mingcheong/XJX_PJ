<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<SCRIPT language=JavaScript type=text/javascript src="${resourcePath}/highcharts/WdatePicker.js"></SCRIPT>
<SCRIPT type=text/javascript src="${resourcePath}/highcharts/jquery.min.js"></SCRIPT>
<SCRIPT type=text/javascript src="${resourcePath}/highcharts/highcharts.js"></SCRIPT>
<SCRIPT type=text/javascript src="${resourcePath}/highcharts/grid1.js"></SCRIPT>
<SCRIPT type=text/javascript>
    $(document).ready(function () {
        $("#btnPrint").hide();
        var title = "区域行业统计";
        var options = {
          chart: {
            renderTo: 'container'
          },
          plotOptions: {
            series: {
                //cursor: 'pointer',
                events: {
                    click: function(e){
                        if (null != this.options.href) document.location.href = this.options.href;
                    }
                }
            }
          },
          title: {
             text:  title
          },
          xAxis: {
              categories: ${categories?default('')}
          },
          yAxis: {
             title: {
             	text: '企业家数'
          	}
          },
          tooltip: {
             formatter: function() {
                var s;
                if (this.point.name) { // the pie chart
                   s = ''+
                      this.point.name +': '+ this.y;
                } else {
                   s = ''+
                      this.series.name +': '+ this.y;
                }
                return s;
             }
          },
          labels: {
             items: [{
                html: '企业比重',
                style: {
                   left: '400px',
                   top: '800px',
                   color: 'red'            
                }
             }]
          }
        };
					
        $("#btnPrint").bind("click",function(event){
            var arrayObj = new Array(), data = new Array();
            data[0] = {type:'pie', data:[1500, 800, 1200]};
            
            var pie = data[0].data;
            var tAccident = pie[0];
            var tLAccident = pie[1];
            var tMAccident = pie[2];
            var pie_d = [{name: '危险化学品', y: data[0].data[0],color: highchartsOptions.colors[6]}, {name: '非煤矿山',y: data[0].data[1],color: highchartsOptions.colors[7]}, {name: '烟花爆竹',y: data[0].data[2],color: highchartsOptions.colors[8]}]
            
           
             <#list statisticDatas?if_exists as data>arrayObj.push(${data});</#list>
           
            
                    
            options.series=(arrayObj);
            var chart1 = new Highcharts.Chart(options);
        });
                                                    
        $("#btnPrint").trigger('click');
    })
</SCRIPT>

<META name=GENERATOR content="MSHTML 8.00.6001.19170"></HEAD>
<BODY>
	<TABLE style="TEXT-ALIGN: center; BORDER-COLLAPSE: collapse; FONT-SIZE: 12px" border=0 cellPadding=0 width=95%>
	  <TBODY>
	  	<TR valign="top" height=20>
	  		<TD align="right"><A href="${contextPath}/baseStatistic_company_maps.xhtml">切换到地图</a></TD>
	  	</TR>
	  </TBODY>
	</TABLE>
	<DIV style="min-width: 100%; height: 450px; margin: 0 auto" id=container></DIV>
	<INPUT id=btnPrint type=button style="display:none;">
</BODY>
</HTML>
