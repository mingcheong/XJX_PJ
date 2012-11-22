<@fkMacros.pageHeader />
<@fkMacros.formValidator 'fkUserForm'/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="topgzq" height="28" align="center">
  <tr>
    <td align="center" ><div class="dqwz">您现在的位置：添加用户 </div></td>
  </tr>
</table>
<@s.form id="fkUserForm" action="fkUser_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="fkUserModel.id" /><@s.hidden name="fkUserModel.resources" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="fkUserForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>所属区域:&nbsp;</th>
		<td width="35%">
			<div id="div-area"></div>
		</td>
		<th width="15%"><font color="#FF0000">*</font>所属机构:&nbsp;</th>
		<td width="35%">
			<@s.hidden id="fatherId" name="fkUserModel.fkOrganize.id" />
			<@s.textfield id="fatherName" name="fkUserModel.fkOrganize.orgName" readonly="true"  cssStyle="width:75%"/>&nbsp;
			<@fkMacros.radioTree 'fatherId','fatherName','fkOrganize_ajax.xhtml','${orgsNodes}'/>
			<ui:v for="fatherName" rule="require" warn="不允许以空格为开始" empty="组织机构不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">岗位名称:&nbsp;</th>
		<td width="35%">
			<select name="fkUserModel.position" id="userPosition"></select>
		</td>
		<th width="15%"><font color="#FF0000">*</font>角色配置:&nbsp;</th>
		<td width="35%">
			<@s.hidden id="fatherIds" name="fkUserModel.roles" />
			<@s.textfield id="fatherNames" name="fkUserModel.rolesName" readonly="true" cssStyle="width:75%"/>&nbsp;
			<@fkMacros.checkBoxTree '','fatherIds','fatherNames','fkRole_ajax.xhtml','${roleNodes}'/>
			<ui:v for="fatherNames" rule="require" warn="不允许以空格为开始" empty="角色不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>帐号名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="username" name="fkUserModel.username" cssStyle="width:75%"/>
			<ui:v for="username" rule="require" warn="不允许以空格为开始" empty="帐号名称不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>真实姓名:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="truename" name="fkUserModel.truename" cssStyle="width:75%"/>
			<ui:v for="truename" rule="require" warn="不允许以空格为开始" empty="真实姓名不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>登陆密码:&nbsp;</th>
		<td width="35%">
			<@s.hidden  name="fkUserModel.password" />
			<@s.password id="password" name="fkUserModel.rePassword" cssStyle="width:75%"/>
			<ui:v for="password" rule="require" warn="不允许以空格为开始" empty="登陆密码不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>身份证号码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="idCard" name="fkUserModel.idCard" cssStyle="width:75%"/>
			<ui:v for="idCard" rule="require" warn="不允许以空格为开始" empty="身份证号码不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>出生年月:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="bornDate" name="fkUserModel.bornDate" readonly="true" value="1980-01-01 00:00:00" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})" cssStyle="width:75%" />
			<ui:v for="bornDate" rule="require" warn="不允许以空格为开始" empty="出生年月不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>人员性别:&nbsp;</th>
		<td width="35%">
			<select name="fkUserModel.sex" width="15%">
				<option value="男" <#if fkUserModel.sex?if_exists == '男'>selected="selected"</#if>>男</option>
				<option value="女" <#if fkUserModel.sex?if_exists == '女'>selected="selected"</#if>>女</option>
			</select>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>固定电话:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="userPhone" name="fkUserModel.userPhone" cssStyle="width:75%"/>
			<ui:v for="userPhone" rule="phone" require="true" warn="号码格式不正确！" empty="固定电话不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%">手机号码:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="userMobile" name="fkUserModel.userMobile" cssStyle="width:75%"/>
			<ui:v for="userMobile" rule="mobile" require="false" warn="号码格式不正确！" empty="&nbsp;" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%">电子邮件:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="userEmail" name="fkUserModel.userEmail" cssStyle="width:75%"/>
			<ui:v for="userEmail" rule="email" require="false" warn="邮件格式不正确！" empty="&nbsp;" pass="&nbsp;"/>
		</td>
			<th width="15%">排&nbsp;&nbsp;序:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="sortNum" name="fkUserModel.sortNum" cssStyle="width:75%"/>
			<ui:v for="sortNum" rule="integer" require="false" warn="只许输入数字！" empty="&nbsp;" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>创建时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="createDate" name="fkUserModel.createDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"  cssStyle="width:75%"/>
			<ui:v for="createDate" rule="require" warn="不允许以空格为开始" empty="创建时间不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>修改时间:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="modifyDate" name="fkUserModel.modifyDate" readonly="true" onFocus="WdatePicker({minDate:'1900-01-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M',errDealMode:1})"  cssStyle="width:75%"/>
			<ui:v for="modifyDate" rule="require" warn="不允许以空格为开始" empty="修改时间不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@enum.initEnumXML/><@enum.initAreaXML/><@enum.initAllEnum /><script type="text/javascript"> <#if fkUserModel.position?if_exists != "">jQuery("#userPosition").val("${fkUserModel.position}");</#if> </script>
<@enum.selectAreas "fkUserModel","div-area","${fkUserModel.firstArea?if_exists}","${fkUserModel.secondArea?if_exists}","${fkUserModel.thirdArea?if_exists}","${fkUserModel.fouthArea?if_exists}","${fkUserModel.fifthArea?if_exists}" />
<@fkMacros.pageFooter />