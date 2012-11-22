<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.model;

import java.util.List;
import javax.persistence.*;

import com.safetys.framework.kernel.model.BaseModel;
import javax.servlet.http.HttpServletRequest;

<#include "/java_comment.include">
@Entity(name = "${classNameLower}Model")
@Table(name = "${table.sqlName}")
public class ${className}Model extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public ${className}Model(){ 
		super();
	}
	
	public ${className}Model(HttpServletRequest request, String tableId){
		super(request, tableId);
	}
	<@generateAreaFields/>
	<@generateFields/>
	<@generateAreaFieldsProperties/>
	<@generateNotPkProperties/>
	<@generateJavaManyToOne/>
	<@generateJavaOneToMany/>
}

<#macro generateFields>
<#if table.compositeId>
	private ${className}Id id;
	<#list table.columns as column>
	<#if !column.pk && column.columnNameLower != "isDeleted" && column.columnNameLower != "sortNum" && column.columnNameLower != "createDate" && column.columnNameLower != "modifyDate" 
		&& column.columnNameLower != "firstarea" && column.columnNameLower != "secondarea" && column.columnNameLower != "thirdarea" && column.columnNameLower != "fourtharea" && column.columnNameLower != "fiftharea">
	private ${column.javaType} ${column.columnNameLower};
		</#if>
	</#list>
<#else>
	<#list table.columns as column>
	<#if !column.pk && column.columnNameLower != "isDeleted" && column.columnNameLower != "sortNum" && column.columnNameLower != "createDate" && column.columnNameLower != "modifyDate" 
		&& column.columnNameLower != "firstarea" && column.columnNameLower != "secondarea" && column.columnNameLower != "thirdarea" && column.columnNameLower != "fourtharea" && column.columnNameLower != "fiftharea">
			<#if !column.fk>
	private ${column.javaType} ${column.columnNameLower};
			</#if>
		</#if>
	</#list>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	private ${fkPojoClass}Model ${fkPojoClassVar};
	</#list>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	private List<${fkPojoClass}Model> ${fkPojoClassVar}s;
</#list>
</#if>
</#macro>

<#macro generateAreaFields>
	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
</#macro>

<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if !column.pk && column.columnNameLower != "isDeleted" && column.columnNameLower != "sortNum" && column.columnNameLower != "createDate" && column.columnNameLower != "modifyDate" 
		&& column.columnNameLower != "firstarea" && column.columnNameLower != "secondarea" && column.columnNameLower != "thirdarea" && column.columnNameLower != "fourtharea" && column.columnNameLower != "fiftharea">
	<#if column.isDateTimeColumn>
	@Temporal(TemporalType.DATE)
	</#if>
	@Column(name = "${column.sqlName}", unique = ${column.unique?string}, nullable = ${column.nullable?string}, insertable = true, updatable = true, length = ${column.size})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
		</#if>
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	public void set${fkPojoClass}(${fkPojoClass}Model ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	<#list foreignKey.parentColumns?values as fkColumn>
	@JoinColumn(name = "${fkColumn}", nullable = false, insertable = false, updatable = false)
    </#list>
	public ${fkPojoClass}Model get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	public void set${fkPojoClass}s(List<${fkPojoClass}Model> ${fkPojoClassVar}s){
		this.${fkPojoClassVar}s = ${fkPojoClassVar}s;
	}
	
	<#list foreignKey.columns?values as fkColumn>
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="${fkColumn}")
	</#list>
	public List<${fkPojoClass}Model> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateAreaFieldsProperties>
	
	@Column(name = "A1", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFirstArea() {
		return firstArea;
	}
	
	public void setFirstArea(java.lang.String firstArea) {
		this.firstArea = firstArea;
	}
	
	@Column(name = "A2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSecondArea() {
		return secondArea;
	}
	
	public void setSecondArea(java.lang.String secondArea) {
		this.secondArea = secondArea;
	}
	
	@Column(name = "A3", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getThirdArea() {
		return thirdArea;
	}
	
	public void setThirdArea(java.lang.String thirdArea) {
		this.thirdArea = thirdArea;
	}
	
	@Column(name = "A4", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFourthArea() {
		return fourthArea;
	}
	
	public void setFourthArea(java.lang.String fourthArea) {
		this.fourthArea = fourthArea;
	}
	
	@Column(name = "A5", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFifthArea() {
		return fifthArea;
	}
	
	public void setFifthArea(java.lang.String fifthArea) {
		this.fifthArea = fifthArea;
	}
	
</#macro>
