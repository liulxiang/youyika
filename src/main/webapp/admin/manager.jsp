<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="content-header">
				<h1>修改密码</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">修改密码</a>
			</div>
			<div class="container-fluid">
                  <div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>修改密码</h5>
							</div>
							<div class="widget-content nopadding">
								<form class="form-horizontal" method="post" action="<c:url value="/admin/modifyPassword"/>" name="basic_validate" id="modifyPassword_validate" novalidate="novalidate" />
                                    <div class="control-group">
                                        <label class="control-label">原来密码：</label>
                                        <div class="controls">
                                            <input type="password" name="oldPassword" id="oldPassword" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">新密码</label>
                                        <div class="controls">
                                            <input type="password" name="newPassword" id="newPassword" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">确定密码：</label>
                                        <div class="controls">
                                          <input type="password" name="confirmNewPassword" id="pwd2" />
                                        </div>
                                    </div>
                                    <div class="form-actions">
                                        <input type="submit" value="Validate" class="btn btn-primary" />
                                    </div>
                                </form>
							</div>
						</div>			
					</div>
				</div>
     </div> 
        <script src="<c:url value="/resources/admin/js/jquery.validate.js"/>"></script> 
        <script type="text/javascript">
        $(document).ready(function(){
        $("#modifyPassword_validate").validate({
    		rules:{
    			oldPassword:{
    				required:true
    			},
    			newPassword:{
    				required: true,
    				minlength:6,
    				maxlength:20
    			},
    			confirmNewPassword:{
    				required:true,
    				minlength:6,
    				maxlength:20,
    				equalTo:"#newPassword"
    			}
    		},
    		errorClass: "help-inline",
    		errorElement: "span",
    		highlight:function(element, errorClass, validClass) {
    			$(element).parents('.control-group').addClass('error');
    		},
    		unhighlight: function(element, errorClass, validClass) {
    			$(element).parents('.control-group').removeClass('error');
    			$(element).parents('.control-group').addClass('success');
    		}
    	});
        })
        </script>

