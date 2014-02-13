<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="content-header">
	<h1>时光胶囊</h1>
	<div class="btn-group">
		<a class="btn btn-large tip-bottom" title="Manage Files"><i
			class="icon-file"></i></a> <a class="btn btn-large tip-bottom"
			title="Manage Users"><i class="icon-user"></i></a> <a
			class="btn btn-large tip-bottom" title="Manage Comments"><i
			class="icon-comment"></i><span class="label label-important">5</span></a>
		<a class="btn btn-large tip-bottom" title="Manage Orders"><i
			class="icon-shopping-cart"></i></a>
	</div>
</div>
<div id="breadcrumb">
	<a href="<c:url value="/admin/index.jsp"/>" title="Go to Home" class="tip-bottom"><i
		class="icon-home"></i> Home</a> <a href="#" class="current">时光胶囊</a>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 center" style="text-align: center;">
			<ul class="stat-boxes">
				<li>
					<div class="left peity_bar_good">
						<span>2,4,9,7,12,10,12</span>+20%
					</div>
					<div class="right">
						<strong id="currentSessionSize">8888</strong> 在线人数
					</div>
				</li>
				<li>
					<div class="left peity_bar_neutral">
						<span>3,5,9,7,12,20,40</span>+20%
					</div>
					<div class="right">
						<strong id="todySessionSize">8888</strong>今天访问量
					</div>
				</li>
				<li>
					<div class="left peity_bar_bad">
						<span>3,5,9,7,12,20,60</span>+30%
					</div>
					<div class="right">
						<strong id="allMemmberSize">8888</strong>注册用户
					</div>
				</li>
				<li>
					<div class="left peity_line_good">
						<span>12,6,9,23,14,10,17</span>+70%
					</div>
					<div class="right">
						<strong id="allSessionSize">8888</strong> 访问总量
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"><i class="icon-signal"></i></span>
					<h5>Site Statistics</h5>
					<div class="buttons">
						<a href="#" class="btn btn-mini"><i class="icon-refresh"></i>
							Update stats</a>
					</div>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span4">
							<ul class="site-stats">
								<li><i class="icon-user"></i> <strong>1433</strong> <small>Total
										Users</small></li>
								<li><i class="icon-arrow-right"></i> <strong>16</strong> <small>New
										Users (last week)</small></li>
								<li class="divider"></li>
								<li><i class="icon-shopping-cart"></i> <strong>259</strong>
									<small>Total Shop Items</small></li>
								<li><i class="icon-tag"></i> <strong>8650</strong> <small>Total
										Orders</small></li>
								<li><i class="icon-repeat"></i> <strong>29</strong> <small>Pending
										Orders</small></li>
							</ul>
						</div>
						<div class="span8">
							<div class="chart"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span6">
			
		</div>
		<div class="span6">
			
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box widget-calendar">
				<div class="widget-title">
					<span class="icon"><i class="icon-calendar"></i></span>
					<h5>Calendar</h5>
				</div>
				<div class="widget-content nopadding">
					<div class="calendar"></div>
				</div>
			</div>
		</div>
	</div>
</div>	

<script src="<c:url value="/resources/admin/js/unicorn.dashboard.js"/>"></script>
<script type="text/javascript">
$(document).ready(function(){
		$.ajax( {
		    url :Init.webUrl+"/admin/webCommon/sessionSysStateList",
		    type :"post",
		    dataType :"json",
		   // data :params,
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success :function(resultData){
		    	//alert(resultData.data.sessions.A23970F3695A74436BFD35297715C8DC);
		    	//$.each(resultData.data.sessions,function(key,value){
			           //$("#mapinfo").append(key+"----"+value+"<br/><hr/>");
			    //       alert(key);
			  // });
		    	$("#currentSessionSize").text(resultData.data.onlineSize);
		    	$("#todySessionSize").text(resultData.data.todaySize);
		    	$("#allMemmberSize").text(resultData.data.allMemberSize);
		    	$("#allSessionSize").text(resultData.data.allSize);
		     }
		});
		
		$("#sessionCounterId").click(function(){
			location.href =Init.webUrl+"/admin/webCommon/sessionList";
	     });
		
		
});
</script>




