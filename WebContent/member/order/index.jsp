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
	<div class="row-fluid">
	    
	
		<div class="panel panel-info panel-col">
			<div class="panel-heading">购物车</div>
			<div class="panel-body">

				<table class="table table-condensed">
					<thead>
						<tr>
							<th>购物信息</th>
							<th>数量</th>
							<th>单价</th>
							<th class="tr">小计</th>
						</tr>
					</thead>
					<tbody>
						<tr class="J_cart_goods" data-id="43655">
							<td>
								<div class="pos">
									<a href="/detail/279" class="pic shadow" target="_blank"> <img
										src="http://img0.yytcdn.com/uploads/goods/279/ED4D01432D5D06497F0560E76DC98198.jpg"
										width="80" height="80" alt="">
									</a> <a href="/detail/279" class="c_6" target="_blank">[东方神起]正规七辑《Tense》全款/补款
										-- 黑版 </a> <a href="javascript:;"
										class="ico_close J_confirm_remove" data-cart-id="43655"
										title="删除">删除</a>
								</div>
							</td>
							<td><a href="javascript:;" class="pay_cart_plus J_delete">-</a>
								<input class="input_text pay_cart_num" type="text"
								data-cart-id="43655" data-price="127.00" value="3"> <a
								href="javascript:;" class="pay_cart_minus J_add">+</a></td>
							<td>
								<p>127.00元</p>

							</td>
							<td class="tr"><span class="">381.00</span>元</td>
						</tr>


					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td></td>
							<td></td>

							<td class="tr">
								<a class="btn btn-primary" href="../../index.jsp">继续逛</a>
								<a class="btn btn-primary" href="commitorder.jsp">下一步</a>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>
