<!--
 Copyright 2012 [SAFETYS], Inc. All rights reserved. 
 WebSite: http://www.safetys.cn/
 此文件通过快速开发平台自动生成
 @author Stone 
 @email wsgajl@163.com
 @version 1.0
 @since 1.0
 -->
<@fkMacros.pageHeader />
<@fkMacros.formValidator 'jxEmployeeForm'/>
<#-- 验证参考 for 对应着你要验证的属性的ID,rule指的是验证规则，require表示是否必填。
	必填验证方式
	<ui:v for="邮编" rule="zip" require="true" warn="邮编格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="邮件" rule="email" require="true" warn="邮件格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="电话号码" rule="phone" require="true" warn="电话号码格式不正确！" empty="电话号码不允许为空！" pass="&nbsp;"/>
	<ui:v for="手机" rule="mobile" require="true" warn="手机格式不正确！" empty="手机不允许为空！" pass="&nbsp;"/>
	<ui:v for="URL" rule="url" require="true" warn="地址格式不正确！" empty="地址不允许为空！" pass="&nbsp;"/>
	<ui:v for="IP" rule="ip" require="true" warn="IP格式不正确！" empty="IP不允许为空！" pass="&nbsp;"/>
	<ui:v for="帐号" rule="username" require="true" warn="帐号格式不正确！" empty="帐号不允许为空！" pass="&nbsp;"/>
	<ui:v for="数字" rule="integer" require="true" warn="数字格式不正确！" empty="数字不允许为空！" pass="&nbsp;"/>
	选填的验证方式
	<ui:v for="邮编" rule="zip" require="false" warn="邮编格式不正确！" empty="&nbsp;" pass="&nbsp;"/>
-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxEmployeeModel.id == -1>添加<#else>修改</#if>员工档案 </div></td>
  </tr>
</table>
<@s.form id="jxEmployeeForm" action="jxEmployee_save.xhtml"  method="post">
<s:token /><@s.hidden name="jxEmployeeModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxEmployeeForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>员工编号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jeCode" name="jxEmployeeModel.jeCode" cssStyle="width:75%"/>
			<ui:v for="jeCode" rule="require" warn="不允许以空格为开始" empty="员工编号不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>员工姓名:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jeName" name="jxEmployeeModel.jeName" cssStyle="width:75%"/>
			<ui:v for="jeName" rule="require" warn="不允许以空格为开始" empty="员工姓名不允许为空" pass="&nbsp;"/>
		</td>		
	</tr>
	<tr>
		<th width="15%">籍　　贯:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jePlace" name="jxEmployeeModel.jePlace" cssStyle="width:75%"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>员工分类:&nbsp;</th>
		<td width="15%">
			<@s.textfield id="jeClazz" name="jxEmployeeModel.jeClazz" cssStyle="width:25%"/>&nbsp;ABC分类
			<ui:v for="jeClazz" rule="require" warn="不允许以空格为开始" empty="员工分类不允许为空" pass="&nbsp;"/>
		</td>		
		<th width="10%">等　　级:&nbsp;</th>
		<td width="10%">
			<@s.textfield id="jeLevel" name="jxEmployeeModel.jeLevel" cssStyle="width:75%"/>
		</td>		
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>所属部门:&nbsp;</th>
		<td width="35%">
			<@s.hidden id="fatherId" name="jxEmployeeModel.jeDept.id" />
			<@s.textfield id="fatherName" name="jxEmployeeModel.jeDept.jdName" readonly="true"  cssStyle="width:200px;"/>&nbsp;
			<@fkMacros.radioTree 'fatherId','fatherName','jxDept_ajax.xhtml','${deptsNodes}'/>
			<ui:v for="fatherName" rule="require" warn="不允许以空格为开始" empty="所属部门不允许为空" pass="&nbsp;"/>
		</td>		
		<th width="15%">性　　别:&nbsp;</th>
		<td width="35%" colspan="3">
			<select name="jxEmployeeModel.jeSex">
				<option value="true" <#if jxEmployeeModel.jeSex>selected="selected"</#if> >男</option>
				<option value="false" <#if !jxEmployeeModel.jeSex>selected="selected"</#if> >女</option>
			</select>
		</td>		
	</tr>
	<tr>
		<th width="15%">身份证号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jeIdcard" name="jxEmployeeModel.jeIdcard" cssStyle="width:75%"/>
		</td>
		<th width="15%">学　　历:&nbsp;</th>
		<td width="35%" colspan="3">
			<select name="jxEmployeeModel.jeDegree" style="width:35%;">
				<option value="1" <#if jxEmployeeModel.jeDegree == 1>selected="selected"</#if> >小学</option>
				<option value="2" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >初中</option>
				<option value="3" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >高中</option>
				<option value="4" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >职高</option>
				<option value="5" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >中专</option>
				<option value="6" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >大专</option>
				<option value="7" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >本科</option>
				<option value="8" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >硕士</option>
				<option value="9" <#if jxEmployeeModel.jeDegree == 2>selected="selected"</#if> >博士</option>
			</select>
		</td>				
	</tr>	
	<tr>
		<th width="15%">职　　位:&nbsp;</th>
		<td width="35%">
			<select name="jxEmployeeModel.jeJob" style="width:35%;">
				<option value="1" <#if jxEmployeeModel.jeJob == 1>selected="selected"</#if> >开票员 </option>
			</select>			
		</td>
		<th width="15%"><font color="#FF0000">*</font>生　　日:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jeBirthday" name="jxEmployeeModel.jeBirthday" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:200px;"/>
			<ui:v for="jeBirthday" rule="require" warn="不允许以空格为开始" empty="生日不允许为空" pass="&nbsp;"/>
		</td>
	</tr>		
	<tr>
		<th width="15%">居住地址:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jeAddress" name="jxEmployeeModel.jeAddress" cssStyle="width:75%"/>
		</td>
		<th width="15%">邮　　编:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jePost" name="jxEmployeeModel.jePost" cssStyle="width:75%"/>
		</td>
	</tr>
	<tr>
		<th width="15%">电　　话:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jePhone" name="jxEmployeeModel.jePhone" cssStyle="width:75%"/>
		</td>
		<th width="15%">是否在职:&nbsp;</th>
		<td width="35%" colspan="3">
			<select name="jxEmployeeModel.jeIsjob">
				<option value="true" <#if jxEmployeeModel.jeIsjob>selected="selected"</#if> >是</option>
				<option value="false" <#if !jxEmployeeModel.jeIsjob>selected="selected"</#if> >否</option>
			</select>
		</td>		
	</tr>
	<tr>
		<th width="15%">参加工作日期:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jeWorkdate" name="jxEmployeeModel.jeWorkdate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:200px"/>
		</td>
		<th width="15%">进入公司日期:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textfield id="jeIndate" name="jxEmployeeModel.jeIndate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:200px"/>
		</td>		
	</tr>
	<tr>
		<th width="15%">简　　历:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textarea id="jeResume" name="jxEmployeeModel.jeResume" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">社会关系 :&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textarea id="jeRelation" name="jxEmployeeModel.jeRelation" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">备　　注:&nbsp;</th>
		<td width="35%" colspan="5">
			<@s.textarea id="jeRemark" name="jxEmployeeModel.jeRemark" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
