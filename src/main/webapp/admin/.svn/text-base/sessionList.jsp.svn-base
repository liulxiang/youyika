<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
	
			<div id="content-header">
				<h1>在线列表</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">在线列表</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<h5>目前在线用户统计</h5>
							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered data-table">
									<thead>
									<tr>
									<th>访问Session</th>
									<th>访问IP</th>
									<th>访问时间</th>
									</tr>
									</thead>
									<tbody>
									 <c:if test="${sessions!= null}">
											<c:forEach var="session" varStatus="status" items="${sessions}">
												<tr class="gradeX">
												<td>${session.sessionId}</td>
												<td>${session.ip}</td>
												<td>${session.onlineTime}</td>
												</tr>
										   </c:forEach>
								   </c:if>
									</tbody>
									</table>  
							</div>
						</div>
					</div>
				</div>
				
			</div>
		
      <script src="<c:url value="/resources/admin/js/unicorn.tables.js"/>"></script> 
