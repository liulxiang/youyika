<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
	
			<div id="content-header">
				<h1>Tables</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">Tables</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						
						
						
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-th"></i>
								</span>
								<h5>Static table with checkboxes in box with padding</h5>
								<span class="label label-info">Featured</span>
							</div>
							<div class="widget-content">
								<table class="table table-bordered table-striped with-check">
									<thead>
										<tr>
											<th><input type="checkbox" id="title-table-checkbox" name="title-table-checkbox" /></th>
											<th>Column name</th>
											<th>Column name</th>
											<th>Column name</th>
											<th>Column name</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="checkbox" /></td>
											<td>Row 1</td>
											<td>Row 2</td>
											<td>Row 3</td>
											<td>Row 4</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>Row 1</td>
											<td>Row 2</td>
											<td>Row 3</td>
											<td>Row 4</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>Row 1</td>
											<td>Row 2</td>
											<td>Row 3</td>
											<td>Row 4</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>Row 1</td>
											<td>Row 2</td>
											<td>Row 3</td>
											<td>Row 4</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>Row 1</td>
											<td>Row 2</td>
											<td>Row 3</td>
											<td>Row 4</td>
										</tr>
										<tr>
											<td><input type="checkbox" /></td>
											<td>Row 1</td>
											<td>Row 2</td>
											<td>Row 3</td>
											<td>Row 4</td>
										</tr>
									</tbody>
								</table>							
							</div>
						</div>
						
					</div>
				</div>
				
			</div>
		
      <script src="<c:url value="/resources/js/unicorn.tables.js"/>"></script> 
