<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="<c:url value="/resources/admin/css/unicorn.login.css"/>" />


        <div id="logo">
            <img src="<c:url value="/resources/admin/img/logo.png"/>" alt="" />
        </div>
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" action="<c:url value="/admin/loginMe"/>"/>
				<p>Enter username and password to continue.</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Username"  name="username"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Password"  name="userpassword"/>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link" id="to-recover">Lost password?</a></span>
                    <span class="pull-right"><input type="submit" class="btn btn-inverse" value="Login" /></span>
                </div>
            </form>
            <form id="recoverform" action="#" class="form-vertical" />
				<p>Enter your e-mail address below and we will send you instructions how to recover a password.</p>
				<div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link" id="to-login">&lt; Back to login</a></span>
                    <span class="pull-right"><input type="submit" class="btn btn-inverse" value="Recover" /></span>
                </div>
            </form>
        </div>
        
        <script src="<c:url value="/resources/admin/js/unicorn.login.js"/>"></script> 

