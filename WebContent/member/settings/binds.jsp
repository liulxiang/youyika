<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"/>'>首页</a></li>
			<li class="active"><a href="#">设置</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<div class="list-group">
			<a href="settings.jsp" class="list-group-item active"> <span
				class="glyphicon glyphicon-cog"></span> 基本信息
			</a> <a href="avatar.jsp" class="list-group-item"> <span
				class="glyphicon glyphicon-picture"></span> 头像设置
			</a> <a href="password.jsp" class="list-group-item"> <span
				class="glyphicon glyphicon-lock"></span> 密码修改
			</a> <a href="email.jsp" class="list-group-item"> <span
				class="glyphicon glyphicon-envelope"></span> 邮箱设置
			</a> <a href="binds.jsp" class="list-group-item"> <span
				class="glyphicon glyphicon-circle-arrow-right"></span> 第三方登陆
			</a>
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
				<div class="panel-heading">第三方登录</div>
  <div class="panel-body">        
       <ul class="media-list">
           
                      <li class="media">
              <img src="<c:url value="/resources/img/images/weibo.png"/>" class=" media-object pull-left">
              <div class="media-body">
                                <a href="/settings/bind/weibo" class="bind btn btn-primary pull-right">绑定</a>
                
                <div>新浪微博帐号</div>
                                  <div class="text-muted">未绑定</div>
                
              </div>
            </li>
                   
                      <li class="media">
              <img src="<c:url value="/resources/img/images/qzone.png"/>" class=" media-object pull-left">
              <div class="media-body">
                                <a href="/settings/bind/qq" class="bind btn btn-primary pull-right">绑定</a>
                
                <div>QQ帐号</div>
                                  <div class="text-muted">未绑定</div>
                
              </div>
            </li>
                   
                      <li class="media">
              <img src="<c:url value="/resources/img/images/renren.gif"/>" class=" media-object pull-left">
              <div class="media-body">
                                <a href="/settings/bind/renren" class="bind btn btn-primary pull-right">绑定</a>
                
                <div>人人网帐号</div>
                                  <div class="text-muted">未绑定</div>
                
              </div>
            </li>
                   
      </ul>

				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
