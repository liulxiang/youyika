<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--[if lte IE 8]>              <html class="ie8 no-js" lang="zh-CN" xml:lang="zh-CN">     <![endif]-->
<!--[if IE 9]>					<html class="ie9 no-js" lang="zh-CN" xml:lang="zh-CN">     <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->	<html class="not-ie no-js" lang="zh-CN" xml:lang="zh-CN">  <!--<![endif]-->
<head>
  <c:import url="/WEB-INF/tags/admin/header_title.jsp"/> 
</head>

<body>
    <div class="main-web">
         <c:import url="/WEB-INF/tags/admin/empty_footer.jsp"/>
		 <sitemesh:write property="body"/>
	</div>
    
</body>
</html>