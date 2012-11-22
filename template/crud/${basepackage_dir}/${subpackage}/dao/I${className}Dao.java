<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.dao;

import com.safetys.framework.kernel.dao.IBaseDao;
import ${basepackage}.${subpackage}.model.${className}Model;
<#include "/java_comment.include">
public interface I${className}Dao extends IBaseDao<${className}Model, Long> {

}
