<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service;

import ${basepackage}.${subpackage}.model.${className}Model;
import com.safetys.framework.kernel.service.IBaseService;

<#include "/java_comment.include">
public interface I${className}Service extends IBaseService<${className}Model, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
}
