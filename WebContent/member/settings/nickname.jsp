<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/yangguang-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">设置</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<div class="list-group">
			<a href="settings.jsp" class="list-group-item active">
			  <span class="glyphicon glyphicon-cog"></span>
			   基本信息
			</a> 
			<a href="avatar.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-picture"></span>
			   头像设置
			</a> 
			<a href="password.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-lock"></span>
			   密码修改
			</a> 
			<a href="email.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   邮箱设置
			</a> 
			<a href="binds.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-circle-arrow-right"></span>
			   第三方登陆
			</a> 
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">基础信息</div>
			     <div class="panel-body">
					<form id="nickname-form" class="form-horizontal" method="post" enctype="multipart/form-data">

	          
	        		
		    <div class="form-group">
		      <div class="col-md-2 control-label"> 
		        <label for="nickname">昵称</label> 
		      </div>
		      <div class="col-md-8 controls">
		       <input data-url=/settings/nickname/check type="text" id="nickname" name="nickname" class="form-control" value="sbsb">
		      </div>
		    </div>

	        <div class="row">
	            <div class="col-md-7 col-md-offset-2">
	             <button type="submit" class="btn btn-primary">提交</button>
		    	 <a class="btn btn-link" href="settings.jsp">返回</a>
	            </div>
	        </div>

	           <input type="hidden" name="_csrf_token" value="5ecd77f7b2416b573faa519e6622362a87b0ecd8">
	        </form>
        


				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
