<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import ${basepackage}.${subpackage}.dao.I${className}Dao;
import ${basepackage}.${subpackage}.model.${className}Model;
<#include "/java_comment.include">
@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseDaoImpl<${className}Model, Long> implements I${className}Dao {

	public ${className}DaoImpl() {
		super(${className}Model.class, "${classNameLower}Model");
	}
}

