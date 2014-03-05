<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/login.css"/>" />
<div class="row first-row">
    <div class="col-lg-12">
      <div id="carousel-example-generic" class="carousel slide">
        <!-- Indicators //-->
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <img src="<c:url value="/resources/web/images/index/youyika_index_1.jpg"/>" alt="">
            <div class="carousel-caption">
              <h3>Caption 1</h3>
              <p>scotch, scothity, scotch, scotch</p>
            </div>
          </div>
          <div class="item">
            <img src="<c:url value="/resources/web/images/index/youyika_index_1.jpg"/>" alt="">
            <div class="carousel-caption">
              <h3>Caption 2</h3>
              <p>scotch, scothity, scotch, scotch</p>
            </div>
          </div>
          <div class="item">
            <img src="<c:url value="/resources/web/images/index/youyika_index_1.jpg"/>" alt="">
            <div class="carousel-caption">
              <h3>Caption 3</h3>
              <p>scotch, scothity, scotch, scotch</p>
            </div>
          </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
          <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
          <span class="icon-next"></span>
        </a>
      </div><!-- carousel end //-->
    
    
    <input id="button" class="button_buy" type="button" name="buy"
			value="">
	 <form action="">
	      
	 </form>
    </div>
    
  </div>
  
<script>
$('.carousel').carousel();
</script>