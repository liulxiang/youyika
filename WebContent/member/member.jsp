<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">买卡</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<div class="list-group">
			<a href="#" class="list-group-item active">类型</a> <a href="#"
				class="list-group-item">电子卡</a> <a href="#" class="list-group-item">充值卡</a>
			<a href="#" class="list-group-item">积分卡</a> <a href="#"
				class="list-group-item">物理卡</a>
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="input-group">
				<input type="text" class="form-control" />
				<div class="input-group-btn">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown" id="drop2">
						Action <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="drop2">
						<li role="menuitem"><a tabindex="-1" href="#">Action</a></li>
						<li role="menuitem"><a tabindex="-1" href="#">Link</a></li>
						<li role="menuitem"><a tabindex="-1" href="#">Link</a></li>
						<li role="menuitem" class="divider"></li>
						<li role="menuitem"><a tabindex="-1" href="#">Link</a></li>
					</ul>
				</div>
			</div>
		</div>


		<div class="row-fluid">
			<div class="brand-index visible-desktop">
				<span>Brand Index:</span> <a class="brand-index-item, "
					rel="nofollow" href="/buy-gift-cards?starts_with=number">#</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=A">A</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=B">B</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=C">C</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=D">D</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=E">E</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=F">F</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=G">G</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=H">H</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=I">I</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=J">J</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=K">K</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=L">L</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=M">M</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=N">N</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=O">O</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=P">P</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=Q">Q</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=R">R</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=S">S</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=T">T</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=U">U</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=V">V</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=W">W</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=X">X</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=Y">Y</a> <a
					class="brand-index-item, " rel="nofollow"
					href="/buy-gift-cards?starts_with=Z">Z</a>
			</div>
		</div>



		<div class="row-fluid">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<td>Doe</td>
							<th class="tr">Username</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><span class="img"> <a itemprop="url"
									href="<c:url value="/resources/web/images/buy/lands-end.png"/>">
										<img width="69" height="43"
										src="<c:url value="/resources/web/images/buy/lands-end.png"/>"
										itemprop="image"
										data-src="https://s3.amazonaws.com/assets.coupontrade.com/assets/product-sources/269/thumb/lands-end.png?1370009162"
										alt="Buy Lands' End Gift Card">
								</a>
							</span></td>
							<td>John</td>
							<td>Smith</td>
							<td>Doe</td>
							<td class="tr"><button class="btn btn-success">Success</button></td>
						</tr>
						<tr>
							<td><span class="img"> <a itemprop="url"
									href="<c:url value="/resources/web/images/buy/lands-end.png"/>">
										<img width="69" height="43"
										src="<c:url value="/resources/web/images/buy/lands-end.png"/>"
										itemprop="image"
										data-src="https://s3.amazonaws.com/assets.coupontrade.com/assets/product-sources/269/thumb/lands-end.png?1370009162"
										alt="Buy Lands' End Gift Card">
								</a>
							</span></td>
							<td>John</td>
							<td>Smith</td>
							<td>Doe</td>
							<td class="tr"><button class="btn btn-success">Success</button></td>
						</tr>
						<tr>
							<td><span class="img"> <a itemprop="url"
									href="<c:url value="/resources/web/images/buy/lands-end.png"/>">
										<img width="69" height="43"
										src="<c:url value="/resources/web/images/buy/lands-end.png"/>"
										itemprop="image"
										data-src="https://s3.amazonaws.com/assets.coupontrade.com/assets/product-sources/269/thumb/lands-end.png?1370009162"
										alt="Buy Lands' End Gift Card">
								</a>
							</span></td>
							<td>John</td>
							<td>Smith</td>
							<td>Doe</td>
							<td class="tr"><button class="btn btn-success">Success</button></td>
						</tr>

					</tbody>
				</table>
		</div>
		<div class="row-fluid">
			<div class="list-group">
				<a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">List group item heading</h4>
					<p class="list-group-item-text">Donec id elit non mi porta
						gravida at eget metus. Maecenas sed diam eget risus varius
						blandit.</p>
				</a> <a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">List group item heading</h4>
					<p class="list-group-item-text">Donec id elit non mi porta
						gravida at eget metus. Maecenas sed diam eget risus varius
						blandit.</p>
				</a> <a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">List group item heading</h4>
					<p class="list-group-item-text">Donec id elit non mi porta
						gravida at eget metus. Maecenas sed diam eget risus varius
						blandit.</p>
				</a>
			</div>
		</div>


	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
