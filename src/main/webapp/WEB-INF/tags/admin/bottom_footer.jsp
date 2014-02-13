<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">	
	<div class="row-fluid">
		<div id="footer" class="span12">
			2012 &copy; 时光胶囊 后台管理. Brought to you by <a
				href="http://www.shiguangjiaonang.com">liulxiang</a>
		</div>
	</div>
</div>
<script src="<c:url value="/resources/admin/js/jquery.ez-pinned-footer.js"/>" type="text/javascript"></script> 
<script>
	$(window).load(function() {
	    $("#footer").pinFooter();
	});

	$(window).resize(function() {
	    $("#footer").pinFooter();
	});
</script>