<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/user.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">买卡</a></li>
		</ul>
	</div>
</div>
<div class="container">
	
<div class="es-row-wrap  container-gap userpage-header">
  <div class="row">
    <div class="col-md-12">
      <img class="avatar" src="<c:url value="/resources/img/images/avatar-large.png"/>">
      <div class="userpage-header-info">
          <div class="actions">
                      </div>
          <h1>sbsb <small></small></h1>
          <div class="about"></div>
          <div class="links">
          </div>
      </div>
    </div>
  </div>
</div>

<div class="es-row-wrap container-gap userpage-body">

  <ul class="nav nav-pills userpage-nav clearfix">
  	    <li ><a href="/user/2132/learn">在学课程</a></li>
    <li class="active"><a href="/user/2132/favorited">收藏的课程</a></li>
    <li ><a href="/user/2132/following">关注/粉丝</a></li>
  </ul>

  <div class="row">
  <div class="col-md-12">
				  			  <div class="empty">无收藏的课程</div>
				  	</div>
</div>

</div>



</div>



