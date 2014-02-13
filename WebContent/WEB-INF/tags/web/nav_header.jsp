<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/nav-header.css"/>" />
<script src="<c:url value="/resources/web/js/avia.js"/>" type="text/javascript"></script> 
<c:if test="${sessionScope.UserConstant_VISITOR != null}">
<div class="container nav-header-alert">
<!-- alert -->
<div class="alert alert-block">
<button class="close" data-dismiss="alert" type="button">x</button>
   <form class="form-inline alert-login-form">
   <p>登录或注册提醒----欢迎来到传承网！
       <span class="alert-login-form-content">
	    <input type="text" class="input-small span3" placeholder="邮箱 或 电话号码">
	    <input type="password" class="input-small span2" placeholder="密码">
	    <label class="checkbox">
	    <input type="checkbox"> 记住密码
	    </label>
	    <button type="submit" class="btn btn-success">登录</button>
	    <button type="submit" class="btn btn-info">注册</button>
	    </span>
    </p>
    </form>
</div>
</div>
</c:if>
<div id="header" class="header_color light_bg_color">
     <div id="header_main" class="container_wrap container_wrap_logo">
         <div class="container">
			<strong class="logo"> <a href="<c:url value="/index.jsp"/>""> <img
					src="<c:url value="/resources/web/images/Logo_youyika.png"/>" alt=""></a></strong>
		   <strong class="joinus"><a href="#app"> <img
					src="<c:url value="/resources/web/images/joinus.png"/>" alt=""></a></strong>
			<div class="top_nav">
                 <ul>
                     <li><a href="#fn">买&nbsp;&nbsp;卡</a></li>
                     <li><a href="#fn">卖&nbsp;&nbsp;卡</a></li>
                     <li><a href="#buy">礼&nbsp;&nbsp;品</a></li>
                     <li><a href="#buy">卡&nbsp;&nbsp;包</a></li>
                     <li><a href="#buy">过期回收</a></li>
                 </ul>
             </div>
             <div class="top_about">
                 <ul>
                     <li><a href="#fn">登&nbsp;&nbsp;陆</a></li>
                     <li><a href="#app" >注&nbsp;&nbsp;册</a></li>
                     <li><a href="<c:url value="/help/index.jsp"/>" target="_blank" >关于我们</a></li>
                 </ul>
             </div>
            
             <!-- end container-->
         </div>
         <!-- end container_wrap-->
     </div>
     <div class="header_bg">
     </div>
     <!-- end header -->
 </div>
