<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<meta charset="utf-8" />
	 <title>时光胶囊后台管理</title> 
	 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="shortcut icon" href="<c:url value="/resources/img/logo_16.ico"/>">
	<link href="<c:url value="/resources/admin/css/googleapi.css"/>" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap-responsive.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/fullcalendar.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/uniform.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/select2.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/unicorn.main.css"/>" />
	
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/unicorn.grey.css"/>" class="skin-color" />
	<script type="text/javascript" src="<c:url value="/resources/admin/js/initWeb.js" />"></script> 
    <script type="text/javascript" language="javascript">
        
        
        //js获取项目根路径，如： http://localhost:8080/taotaoti  
        function getRootPath(){  
            //获取当前网址，如： http://localhost:8080/taotaoti/index.jsp
            var curWwwPath=window.document.location.href;  
            //获取主机地址之后的目录，如： taotaoti/index.jsp
            var pathName=window.document.location.pathname;  
            var pos=curWwwPath.indexOf(pathName);  
            //获取主机地址，如： http://localhost:8080  
            var localhostPaht=curWwwPath.substring(0,pos);  
            //获取带"/"的项目名，如：/taotaoti  
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
            return(localhostPaht+projectName);  
        }  
        Init.webUrl=getRootPath();
    </script>
    
   
