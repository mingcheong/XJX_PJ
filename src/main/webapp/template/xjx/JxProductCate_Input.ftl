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
<@fkMacros.formValidator 'jxProductCateForm'/>
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
    <td align="center" ><div class="dqwz">您现在的位置：<#if jxProductCateModel.id == -1>添加<#else>修改</#if>商品分类 </div></td>
  </tr>
</table>
<@s.form id="jxProductCateForm" action="jxProductCate_save.xhtml"  method="post" enctype="multipart/form-data">
<s:token /><@s.hidden name="jxProductCateModel.id" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_menu" height="30" align="center">
  <tr>
    <td align="center"  >
	<div >
	  <div class="menu_left">
		<ul>
			<@util.menu_save '保 存'> obj="jxProductCateForm" </@util.menu_save>
			<@util.menu_back '返 回'/>
		</ul>
	  </div>
	</div>
	</td>
  </tr>
</table>
<table id="inputTab" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_input" align="center">
	<tr>
		<th width="15%"><font color="#FF0000">*</font>商品分类编号:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jpcCode" name="jxProductCateModel.jpcCode" cssStyle="width:75%"/>
			<ui:v for="jpcCode" rule="require" warn="不允许以空格为开始" empty="商品分类编号不允许为空" pass="&nbsp;"/>
		</td>
		<th width="15%"><font color="#FF0000">*</font>商品分类名称:&nbsp;</th>
		<td width="35%">
			<@s.textfield id="jpcName" name="jxProductCateModel.jpcName" cssStyle="width:75%"/>
			<ui:v for="jpcName" rule="require" warn="不允许以空格为开始" empty="商品分类名称不允许为空" pass="&nbsp;"/>
		</td>
	</tr>
	<tr>
		<th width="15%"><font color="#FF0000">*</font>可使用:&nbsp;</th>
		<td width="35%" colspan="3">
			<select name="jxProductCateModel.jpcUse">
				<option value="true" <#if jxProductCateModel.jpcUse>selected="selected"</#if> >是</option>
				<option value="false" <#if !jxProductCateModel.jpcUse>selected="selected"</#if> >否</option>
			</select>				
		</td>
	</tr>
	<tr>
		<th width="15%">备注:&nbsp;</th>
		<td width="35%" colspan="3">
			<@s.textarea id="jpcMemo" name="jxProductCateModel.jpcMemo" cssStyle="width:90%;height:65px;"/>
		</td>
	</tr>
</table>
</@s.form>
<@fkMacros.pageFooter />
