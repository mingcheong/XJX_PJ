<@fkMacros.pageHeader />
<STYLE type=text/css>
.T_h1 {
	TEXT-ALIGN: center; LINE-HEIGHT: 36px; COLOR: #245d8a; FONT-SIZE: 24px; FONT-WEIGHT: bold
}
.T_line {
	BORDER-BOTTOM: #99bbe8 1px solid; BORDER-LEFT: #99bbe8 1px solid; BORDER-COLLAPSE: collapse; FONT-SIZE: 12px; BORDER-TOP: #99bbe8 1px solid; BORDER-RIGHT: #99bbe8 1px solid
}
.T_line TD {
	BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-BOTTOM: 5px; PADDING-LEFT: 3px; PADDING-RIGHT: 3px; BORDER-COLLAPSE: collapse; BORDER-TOP: medium none; BORDER-RIGHT: #ccc 1px solid; PADDING-TOP: 5px
}
.T_line TH {
	BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-BOTTOM: 5px; PADDING-LEFT: 3px; PADDING-RIGHT: 3px; BORDER-COLLAPSE: collapse; BORDER-TOP: medium none; BORDER-RIGHT: #ccc 1px solid; PADDING-TOP: 5px
}
.T_line TH {
	BORDER-BOTTOM-COLOR: #99bbe8; PADDING-BOTTOM: 8px; BORDER-TOP-COLOR: #99bbe8; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; BACKGROUND: url(/images/img07.jpg) #f3f7ff repeat-x 50% bottom; COLOR: #416aa3; BORDER-RIGHT-COLOR: #99bbe8; BORDER-LEFT-COLOR: #99bbe8; PADDING-TOP: 8px
}
.T_line TH A:link {
	COLOR: #416aa3; TEXT-DECORATION: none
}
.T_line TH A:visited {
	COLOR: #416aa3; TEXT-DECORATION: none
}
.font A {
	COLOR: #416aa3; TEXT-DECORATION: none
}
.T_line TH A:hover {
	COLOR: #ff0000
}
.font A:hover {
	COLOR: #ff0000
}
.font {
	COLOR: #416aa3; FONT-WEIGHT: bold
}
.btn INPUT {
	BORDER-BOTTOM: #033d60 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #e5f2fb 1px solid; PADDING-BOTTOM: 0px; LINE-HEIGHT: 22px; BACKGROUND-COLOR: #0091c0; MARGIN: 0px 2px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; HEIGHT: 24px; COLOR: #ffffff; BORDER-TOP: #e5f2fb 1px solid; CURSOR: pointer; BORDER-RIGHT: #033d60 1px solid; PADDING-TOP: 0px
}
* HTML .btn INPUT {
	PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
* + HTML .btn INPUT {
	PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
.red {
	COLOR: #ff3366;
}
</STYLE>

<TABLE width="100%" align=center><TBODY><TR><TD class=T_h1>滁州市安全生产事故起数分析统计表 </TD></TR></TBODY></TABLE>
<TABLE id=tb class=T_line border=0 cellSpacing=0 cellPadding=0 width="99%">
  <TBODY>
  <TR>
    <TH width="15%"><DIV align=center>事故类型</DIV></TH>
    <#list areas?if_exists as item>
	<th class="operator" >
		${item[1]}
	</th>
	</#list>
	<th style="width:5%;">合计</th>	
   <tr style="height:30px;">
  	<#assign rowTotal=0>
  	<#list statisticDatas?if_exists as s>
	    <#if s_index%areas?size==0><#if s_index!=0></tr><tr style="height:30px;"><#assign rowTotal=0></#if><td class="font">${s[7]}</td></#if>
	    <td id="td_${s[4]}" ><#if s[0]!=0><a href="javascript:void(0)">${s[0]}</a><#else>${s[0]}</#if><#assign rowTotal=rowTotal+s[0]></td>
	    <#if areas?size gt 1>	
	    <#if (s_index+1)%areas?size==0><#if s_index!=0><td id="td_t"><#if rowTotal!=0><a href="javascript:void(0)" >${rowTotal}</a><#else>${rowTotal}</#if></td></#if></#if>
	    <#else>
	   	<td id="td_t"><#if rowTotal!=0><a href="javascript:void(0)">${rowTotal}</a><#else>${rowTotal}</#if></td>
	    </#if>
    </#list>
  </tr>	    
   <TR id=div_tr>
    <TD height=41 colSpan=31>
     
  </TBODY>
</TABLE>

<TABLE width="100%" align=center><TBODY><TR><TD class=T_h1>滁州市安全生产事故死亡人数分析统计表 </TD></TR></TBODY></TABLE>
<TABLE id=tb class=T_line border=0 cellSpacing=0 cellPadding=0 width="99%">
  <TBODY>
  <TR>
    <TH width="15%"><DIV align=center>事故类型</DIV></TH>
    <#list areas?if_exists as item>
	<th class="operator" >
		${item[1]}
	</th>
	</#list>
	<th style="width:5%;">合计</th>	
   <tr style="height:30px;">
  	<#assign rowTotal=0>
  	<#list statisticDatas?if_exists as s>
	    <#if s_index%areas?size==0><#if s_index!=0></tr><tr style="height:30px;"><#assign rowTotal=0></#if><td class="font">${s[7]}</td></#if>
	    <td id="td_${s[4]}" >${s[1]}<#assign rowTotal=rowTotal+s[1]></td>
	    <#if areas?size gt 1>	
	    <#if (s_index+1)%areas?size==0><#if s_index!=0><td id="td_t">${rowTotal}</td></#if></#if>
	    <#else>
	   	<td id="td_t">${rowTotal}</td>
	    </#if>
    </#list>
  </tr>	    
   <TR id=div_tr>
    <TD height=41 colSpan=31>
  </TBODY>
</TABLE>

<TABLE width="100%" align=center><TBODY><TR><TD class=T_h1>滁州市安全生产事故重伤人数分析统计表 </TD></TR></TBODY></TABLE>
<TABLE id=tb class=T_line border=0 cellSpacing=0 cellPadding=0 width="99%">
  <TBODY>
  <TR>
    <TH width="15%"><DIV align=center>事故类型</DIV></TH>
    <#list areas?if_exists as item>
	<th class="operator" >
		${item[1]}
	</th>
	</#list>
	<th style="width:5%;">合计</th>	
   <tr style="height:30px;">
  	<#assign rowTotal=0>
  	<#list statisticDatas?if_exists as s>
	    <#if s_index%areas?size==0><#if s_index!=0></tr><tr style="height:30px;"><#assign rowTotal=0></#if><td class="font">${s[7]}</td></#if>
	    <td id="td_${s[4]}" >${s[2]}<#assign rowTotal=rowTotal+s[2]></td>
	    <#if areas?size gt 1>	
	    <#if (s_index+1)%areas?size==0><#if s_index!=0><td id="td_t">${rowTotal}</td></#if></#if>
	    <#else>
	   		<td id="td_t">${rowTotal}</td>
	    </#if>
    </#list>
  </tr>	    
   <TR id=div_tr>
    <TD height=41 colSpan=31>
  </TBODY>
</TABLE>

<TABLE width="100%" align=center><TBODY><TR><TD class=T_h1>滁州市安全生产事故经济损失分析统计表 </TD></TR></TBODY></TABLE>
<TABLE id=tb class=T_line border=0 cellSpacing=0 cellPadding=0 width="99%">
  <TBODY>
  <TR>
    <TH width="15%"><DIV align=center>事故类型</DIV></TH>
    <#list areas?if_exists as item>
	<th class="operator" >
		${item[1]}
	</th>
	</#list>
	<th style="width:5%;">合计</th>	
   <tr style="height:30px;">
  	<#assign rowTotal=0>
  	<#list statisticDatas?if_exists as s>
	    <#if s_index%areas?size==0><#if s_index!=0></tr><tr style="height:30px;"><#assign rowTotal=0></#if><td class="font">${s[7]}</td></#if>
	    <td id="td_${s[4]}" >${s[3]}<#assign rowTotal=rowTotal+s[3]></td>
	    <#if areas?size gt 1>	
	    <#if (s_index+1)%areas?size==0><#if s_index!=0><td id="td_t">${rowTotal}</td></#if></#if>
	    <#else>
	   	<td id="td_t">${rowTotal}</td>
	    </#if>
    </#list>
  </tr>	    
   <TR id=div_tr>
    <TD height=41 colSpan=31>
      <DIV id="div_red" class="red" align=left>注：经济损失单位为万元！</DIV></TD></TR>
  </TBODY>
</TABLE>
<@fkMacros.pageFooter />