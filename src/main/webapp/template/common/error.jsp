<%@ page contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%><%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><title>滁州市公共安全监管平台!</title>
<script>jQuery.noConflict();</script></head><body></body></html>
<script language="javascript">
<c:if test="${not empty ActionErrors}">
alert('${ActionErrors[0]}');
window.history.back(-1);
</c:if>
</script>