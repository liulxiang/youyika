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
			    <div class="panel-heading">密码修改</div>
  <div class="panel-body">      
      <form id="settings-password-form" class="form-horizontal" method="post" >

          
        
        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_currentPassword" class="required">当前密码</label></div>
          <div class="controls col-md-8 controls">
            <input type="password" id="form_currentPassword" name="form[currentPassword]" required="required"    class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_newPassword" class="required">新密码</label></div>
          <div class="controls col-md-8 controls">
            <input type="password" id="form_newPassword" name="form[newPassword]" required="required"    class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_confirmPassword" class="required">确认密码</label></div>
          <div class="controls col-md-8 controls">
            <input type="password" id="form_confirmPassword" name="form[confirmPassword]" required="required"    class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"></div>
          <div class="controls col-md-8 controls">
            <input type="hidden" id="form__token" name="form[_token]" value="a038bb52643745355e903084ae4e70558d3761c7" />
            <button type="submit" class="btn btn-primary">提交</button>
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
