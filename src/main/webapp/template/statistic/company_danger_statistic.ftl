<@fkMacros.pageHeader />
<style>
.f1 A { COLOR: #416aa3; TEXT-DECORATION: none }

.f1 A:hover { COLOR: #ff0000; TEXT-DECORATION: none }
.f1 { COLOR: blue;}
.T_h1 { COLOR: #245d8a; FONT-SIZE: 24px; FONT-WEIGHT: bold }
.T_line {
	BORDER-BOTTOM: medium none; BORDER-LEFT: #b5d6e7 1px solid; BORDER-TOP: #b5d6e7 1px solid; BORDER-RIGHT: medium none
}
.T_line TD {
	BORDER-BOTTOM: #b5d6e7 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #fff 1px solid; PADDING-BOTTOM: 5px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; COLOR: #000000; BORDER-TOP: #fff 1px solid; BORDER-RIGHT: #b5d6e7 1px solid; PADDING-TOP: 5px;height:35px;
}
.T_line TH {
	BORDER-BOTTOM: #b5d6e7 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #fff 1px solid; PADDING-BOTTOM: 5px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; BACKGROUND: #e8f2fb; COLOR: #0e4a8c; BORDER-TOP: #fff 1px solid; BORDER-RIGHT: #b5d6e7 1px solid; PADDING-TOP: 5px;
}
.T_line A {
	COLOR: #0e4a8c; TEXT-DECORATION: none
}
.T_line A:hover {
	COLOR: #ff7e00; TEXT-DECORATION: underline
}
.T_h1 {
	COLOR: #0e4a8c; FONT-WEIGHT: bold
}

</style>
<div align="center" class="data_content">
	<div id="fillDiv" style=""></div>
	<div name="checkboxFrom" style="padding-left:5px;">
	
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" align=center>
  	<TR>
    	<TD class="T_h1" align=middle height="50">滁州市重大隐患统计表</TD>
    </TR>
    </TABLE>
	
		<table width="100%" border="1" cellpadding="0" cellspacing="0" class="T_line" id="">
			  <tr>
				<th align="middle" style="height:40px">行业类型</th>
			    <#list areas?if_exists as item>
					<th class="operator" >
						${item[1]}
					</th>
			    </#list>
			    <th style="width:5%;">合计</th>		
			    <tr>
			    
			  	<#assign rowTotal=0>
			  	<#assign test=0>
			  	<#list statisticDatas?if_exists as s>
				    <#if s_index%areas?size==0>
				    	<#if s_index!=0>
				    		</tr><tr>
				    		<#assign rowTotal=0>
				    	</#if>
				    		<td >${s[4]}</td>
				    </#if>
				    <td id="td_${s[1]}" ><#if s[0]!=0><a href="javascript:void(0)">${s[0]}</a><#else>${s[0]}</#if><#assign rowTotal=rowTotal+s[0]></td>
				    <#if areas?size gt 1>	
				    	<#if (s_index+1)%areas?size==0>
				    		<#if s_index!=0>
				    			<td id="td_t">
				    			<#if rowTotal!=0>
				    				<a href="javascript:void(0)" class="f1" >${rowTotal}</a>
				    			<#else>
				    				${rowTotal}
				    			</#if>
				    			</td>
				    		</#if>
				    	</#if>
				    <#else>
				    	<td id="td_t">
				    	<#if rowTotal!=0>
				    		<a href="javascript:void(0)">${rowTotal}</a>
				    	<#else>
				    		${rowTotal}
				    	</#if>
				    	</td>
				    </#if>
				    
			    </#list>
			  </tr>	    
			  </tr>
  		</table>
	</div>
</div>
<@fkMacros.pageFooter />