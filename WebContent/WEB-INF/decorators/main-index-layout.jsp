<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN" class="fixed_header">
<head>
  <c:import url="/WEB-INF/tags/web/header_title.jsp"/> 	
  <c:import url="/WEB-INF/tags/web/jsPlugin.jsp"/>
</head>

<body>
<c:import url="/WEB-INF/tags/web/nav_header.jsp" />
 <sitemesh:write property="body"/>
 <c:import url="/WEB-INF/tags/web/main_footer.jsp"/>
</body>
</html>