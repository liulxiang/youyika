<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN" class="fixed_header">
<head>
  <c:import url="/WEB-INF/tags/web/header_title.jsp"/> 	
  <c:import url="/WEB-INF/tags/web/jsPlugin.jsp"/>
</head>

<body>
<!-- Navbar================================================== -->
	
<c:import url="/WEB-INF/tags/web/nav_header.jsp" />
 <sitemesh:write property="body"/>
 <c:import url="/WEB-INF/tags/web/main_footer.jsp"/>
<script src="<c:url value="/resources/web/js/application.js"/>" type="text/javascript"></script> 
</body>
</html>