<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN" class="fixed_header">
<head>
  <c:import url="/WEB-INF/tags/web/header_title.jsp"/> 	
  <c:import url="/WEB-INF/tags/web/jsPlugin.jsp"/>
</head>

<body>
  <c:import url="/WEB-INF/tags/web/nav_header.jsp" />
    <div class="row youyika nav-common">
		<div class="container intro">
			<div class="intro-item wallet  col-lg-4">
				<h2>
					<span class="hidden">生活助手steel-grey2-bg</span> <a href="javascript:;"></a>
				</h2>
				<ul class="clearfix">
					<li><a target="_blank"
						href="http://life.baifubao.com/sj?o_ref=life">手机充值</a> |</li>
					<li><a target="_blank"
						href="http://life.baifubao.com/wy?o_ref=sj">网游充值</a> |</li>
					<li><a target="_blank"
						href="http://life.baifubao.com/gongyi?o_ref=wy">爱心捐款</a></li>
				</ul>
			</div>
			<div class="intro-item life  col-lg-4">
				<h2>
					<span class="hidden">生活助手</span> <a href="javascript:;"></a>
				</h2>
				<ul class="clearfix">
					<li><a target="_blank"
						href="http://life.baifubao.com/sj?o_ref=life">手机充值</a> |</li>
					<li><a target="_blank"
						href="http://life.baifubao.com/wy?o_ref=sj">网游充值</a> |</li>
					<li><a target="_blank"
						href="http://life.baifubao.com/gongyi?o_ref=wy">爱心捐款</a></li>
				</ul>
			</div>
			<div class="intro-item life  col-lg-4">
				<h2>
					<span class="hidden">生活助手</span> <a href="javascript:;"></a>
				</h2>
				<ul class="clearfix">
					<li><a target="_blank"
						href="http://life.baifubao.com/sj?o_ref=life">手机充值</a> |</li>
					<li><a target="_blank"
						href="http://life.baifubao.com/wy?o_ref=sj">网游充值</a> |</li>
					<li><a target="_blank"
						href="http://life.baifubao.com/gongyi?o_ref=wy">爱心捐款</a></li>
				</ul>
			</div>
		</div>
	</div>

	<sitemesh:write property="body"/>
 <c:import url="/WEB-INF/tags/web/main_footer.jsp"/>
</body>
</html>