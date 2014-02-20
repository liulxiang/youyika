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
					<form id="user-profile-form" class="form-horizontal" method="post">


						<div class="form-group">
							<label class="col-md-2 control-label">昵称</label>
							<div class="col-md-7 controls">
								<div class="control-text">
									sbsb <a href="nickname.jsp">修改</a>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">姓名</label>
							<div class="col-md-7 controls">

								<input type="text" id="profile_truename"
									name="profile[truename]" class="form-control" />

							</div>
						</div>

						<div class="help-block approval">
							<label class="col-md-2 control-label"></label>
							<p class="text-warning">
								您尚未实名认证，<strong><a href="/settings/approval/submit">点此认证</a>。
								</strong>
							</p>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">性别</label>
							</div>
							<div class="col-md-7 controls radios">
								<div id="profile_gender">
									<input type="radio" id="profile_gender_0"
										name="profile[gender]" required="required" value="male" /><label
										for="profile_gender_0" class="required">男</label><input
										type="radio" id="profile_gender_1" name="profile[gender]"
										required="required" value="female" /><label
										for="profile_gender_1" class="required">女</label>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">公司</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_company" name="profile[company]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">职业</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_job" name="profile[job]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_title">头衔</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_title" name="profile[title]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_signature">个人签名</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_signature"
									name="profile[signature]" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">自我介绍</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="profile[about]"
									class="form-control"></textarea>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_site">个人主页</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_site" name="profile[site]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weibo">微博</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_weibo" name="profile[weibo]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">微信</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_weixin" name="profile[weixin]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_qq">QQ</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_qq" name="profile[qq]"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_mobile">手机</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_mobile" name="profile[mobile]"
									class="form-control" />
							</div>
						</div>

						<div class="row">
							<div class="col-md-7 col-md-offset-2">
								<input type="hidden" id="profile__token" name="profile[_token]"
									value="a038bb52643745355e903084ae4e70558d3761c7" />
								<button type="submit" class="btn btn-primary">保存</button>
							</div>
						</div>

						<input type="hidden" name="_csrf_token"
							value="5ecd77f7b2416b573faa519e6622362a87b0ecd8">
					</form>



				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
