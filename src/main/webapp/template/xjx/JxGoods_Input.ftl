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
<@fkMacros.formValidator 'jxGoodsForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：添加jxGoodsForm </div></td>
  </tr>
</table>
<@s.form id="jxGoodsForm" action="jxGoods_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxGoodsModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxGoodsForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgIncode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgIncode" name="jxGoodsModel.jgIncode" cssStyle="width:75%"/>
			<ui:v for="jgIncode" rule="require" warn="不允许以空格为开始" empty="jgIncode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgCode:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgCode" name="jxGoodsModel.jgCode" cssStyle="width:75%"/>
			<ui:v for="jgCode" rule="require" warn="不允许以空格为开始" empty="jgCode不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgName:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgName" name="jxGoodsModel.jgName" cssStyle="width:75%"/>
			<ui:v for="jgName" rule="require" warn="不允许以空格为开始" empty="jgName不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgDept:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgDept" name="jxGoodsModel.jgDept" cssStyle="width:75%"/>
			<ui:v for="jgDept" rule="require" warn="不允许以空格为开始" empty="jgDept不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgSunit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSunit" name="jxGoodsModel.jgSunit" cssStyle="width:75%"/>
			<ui:v for="jgSunit" rule="require" warn="不允许以空格为开始" empty="jgSunit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgBunit:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgBunit" name="jxGoodsModel.jgBunit" cssStyle="width:75%"/>
			<ui:v for="jgBunit" rule="require" warn="不允许以空格为开始" empty="jgBunit不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgSpec:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSpec" name="jxGoodsModel.jgSpec" cssStyle="width:75%"/>
			<ui:v for="jgSpec" rule="require" warn="不允许以空格为开始" empty="jgSpec不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgCate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgCate" name="jxGoodsModel.jgCate" cssStyle="width:75%"/>
			<ui:v for="jgCate" rule="require" warn="不允许以空格为开始" empty="jgCate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgOrigin:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgOrigin" name="jxGoodsModel.jgOrigin" cssStyle="width:75%"/>
			<ui:v for="jgOrigin" rule="require" warn="不允许以空格为开始" empty="jgOrigin不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgFactory:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgFactory" name="jxGoodsModel.jgFactory" cssStyle="width:75%"/>
			<ui:v for="jgFactory" rule="require" warn="不允许以空格为开始" empty="jgFactory不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgRate:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgRate" name="jxGoodsModel.jgRate" cssStyle="width:75%"/>
			<ui:v for="jgRate" rule="require" warn="不允许以空格为开始" empty="jgRate不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgGuided:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgGuided" name="jxGoodsModel.jgGuided" cssStyle="width:75%"/>
			<ui:v for="jgGuided" rule="require" warn="不允许以空格为开始" empty="jgGuided不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgShelf:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgShelf" name="jxGoodsModel.jgShelf" cssStyle="width:75%"/>
			<ui:v for="jgShelf" rule="require" warn="不允许以空格为开始" empty="jgShelf不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgPtype:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgPtype" name="jxGoodsModel.jgPtype" cssStyle="width:75%"/>
			<ui:v for="jgPtype" rule="require" warn="不允许以空格为开始" empty="jgPtype不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgPcycle:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgPcycle" name="jxGoodsModel.jgPcycle" cssStyle="width:75%"/>
			<ui:v for="jgPcycle" rule="require" warn="不允许以空格为开始" empty="jgPcycle不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgStype:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgStype" name="jxGoodsModel.jgStype" cssStyle="width:75%"/>
			<ui:v for="jgStype" rule="require" warn="不允许以空格为开始" empty="jgStype不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgSeway:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSeway" name="jxGoodsModel.jgSeway" cssStyle="width:75%"/>
			<ui:v for="jgSeway" rule="require" warn="不允许以空格为开始" empty="jgSeway不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgCansell:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgCansell" name="jxGoodsModel.jgCansell" cssStyle="width:75%"/>
			<ui:v for="jgCansell" rule="require" warn="不允许以空格为开始" empty="jgCansell不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgSpare:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgSpare" name="jxGoodsModel.jgSpare" cssStyle="width:75%"/>
			<ui:v for="jgSpare" rule="require" warn="不允许以空格为开始" empty="jgSpare不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgIntsell:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgIntsell" name="jxGoodsModel.jgIntsell" cssStyle="width:75%"/>
			<ui:v for="jgIntsell" rule="require" warn="不允许以空格为开始" empty="jgIntsell不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>jgRemark:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jgRemark" name="jxGoodsModel.jgRemark" cssStyle="width:75%"/>
			<ui:v for="jgRemark" rule="require" warn="不允许以空格为开始" empty="jgRemark不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
