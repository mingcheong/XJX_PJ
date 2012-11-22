<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.${subpackage}.dao.I${className}Dao;
import ${basepackage}.${subpackage}.model.${className}Model;
import ${basepackage}.${subpackage}.service.I${className}Service;
<#include "/java_comment.include">
@Service("${classNameLower}Service")
@Transactional(propagation = Propagation.REQUIRED)
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Model, Long> implements I${className}Service {

	@Resource(name = "${classNameLower}Dao")
	protected I${className}Dao ${classNameLower}Dao;
	
	@Autowired
	public ${className}ServiceImpl(@Qualifier("${classNameLower}Dao") I${className}Dao ${classNameLower}Dao) {
		super(${classNameLower}Dao);
	}
	
}