<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

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
			    <div class="panel-heading">头像</div>
  <div class="panel-body">
      <form id="settings-avatar-form" class="form-horizontal" method="post" enctype="multipart/form-data">

          

        <div class="form-group">
          <div class="col-md-2 control-label"><b>当前头像</b></div>
          <div class="controls col-md-8 controls">
          	<img src="/assets/img/default/avatar.png?2.1.0">
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label">
          <label for="form_avatar" class="required">新头像</label>
          </div>
          <div class="controls col-md-8 controls">
            <input type="file" id="form_avatar" name="form[avatar]" required="required"    accept="image/gif,image/jpeg,image/png" />
            <p class="help-block">你可以上传JPG、GIF或PNG格式的文件，文件大小不能超过<strong>524.3MB</strong>。</p>
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"></div>
          <div class="controls col-md-8 controls">
            <input type="hidden" id="form__token" name="form[_token]" value="a038bb52643745355e903084ae4e70558d3761c7" />
            <button type="submit" class="btn btn-primary">上传</button>
            <input type="hidden" name="_csrf_token" value="5ecd77f7b2416b573faa519e6622362a87b0ecd8">
          </div>
        </div>

        
      </form>
        


				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
