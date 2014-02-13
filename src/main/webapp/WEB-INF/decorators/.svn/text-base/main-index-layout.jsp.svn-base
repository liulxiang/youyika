<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="/WEB-INF/tags/web/header_title.jsp"/> 	
  <c:import url="/WEB-INF/tags/web/jsPlugin.jsp"/> 	
  <link href="<c:url value="/resources/web/css/index.css"/>" rel="stylesheet">
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">
<!-- Navbar================================================== -->
	<div class="jumbotron masthead">
		<div class="splash">
			<img src="<c:url value="/resources/web/img/home-banner-bg.jpg"/>" alt="Banner" />
		</div>
		<div class="splash">
			<img src="<c:url value="/resources/web/img/home-banner-bg2.jpg"/>" alt="Banner" />
		</div>
		<div class="splash">
			<img src="<c:url value="/resources/web/img/home-banner-bg3.jpg"/>" alt="Banner" />
		</div>
		<div class="splash">
			<img src="<c:url value="/resources/web/womiga/homepage.jpeg"/>" alt="Banner" />
		</div>
		<c:import url="/WEB-INF/tags/web/nav_header.jsp" />
		<div class="container show-case-item">
			<h1 class="title-font title-font">
				hi, 我是Womiga! <p/>欢迎来到Womiga 的地盘！
			</h1>
			<p>我是一名百度的码农屌丝！喜欢代码也喜欢旅游！</p>
			<a href="<c:url value="/web/blog.jsp"/>" class="bigbtn">这就是我</a>
			<div class="clearfix"></div>
		</div>
		<div class="container show-case-item">
			<h1 class="title-font title-font">
				记录工作的点点滴滴！<p/>
				作品与技术
			</h1>
			<p>分享我曾经的作品，分享哪些玩过得技术！</p>
			<a href="<c:url value="/web/work.jsp"/>" class="bigbtn">瞧一瞧</a>
			<div class="clearfix"></div>
		</div>
		<div class="container show-case-item">
			<h1 class="title-font title-font">
				分享生活的点点滴滴！<p/>
				爱好与旅游
			</h1>
			<p>这里记录了我生活的点点滴滴！</p>
			<a href="<c:url value="/web/travel.jsp"/>" class="bigbtn">瞅一瞅</a>
			<div class="clearfix"></div>
		</div>
		<div class="container show-case-item">
			<h1 class="title-font title-font">
				分享一些好的idea!<p/>
				创意与灵感
			</h1>
			<p>记录曾经想到的好的灵感！分享一些好的idea! </p>
			<a href="<c:url value="/web/blog.jsp"/>" class="bigbtn">看一看</a>
			<div class="clearfix"></div>
		</div>
		<div id="banner-pagination">
			<ul>
				<li><a href="#" class="active" rel="0"> <img
						src="<c:url value="/resources/web/img/slidedot-active.png"/>" alt="" /></a></li>
				<li><a href="#" rel="1"> <img src="<c:url value="/resources/web/img/slidedot.png"/>" alt="" /></a></li>
				<li><a href="#" rel="2"> <img src="<c:url value="/resources/web/img/slidedot.png"/>" alt="" /></a></li>
				<li><a href="#" rel="3"> <img src="<c:url value="/resources/web/img/slidedot.png"/>" alt="" /></a></li>
			</ul>
		</div>
	</div>
<script src="<c:url value="/resources/web/js/application.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/resources/web/js/superfish.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/resources/web/js/custom.js"/>" type="text/javascript"></script> 
<script type="text/javascript">
        $(document).ready(function () {

            var showCaseItems = $('.show-case-item').hide();

            var splashes = $('.splash').hide();
            //get each image for each slide and set it as a background of the slide
            //            splashes.each(function () {
            //                var img = $(this).find('img');
            //                var imgSrc = img.attr('src');
            //                img.css('visibility', 'hidden');
            //                $(this).css({ 'background-image': 'url(' + imgSrc + ')', 'background-repeat': 'no-repeat' });
            //            });

            splashes.eq(0).show();
            showCaseItems.eq(0).show();

            var prevIndex = -1;
            var nextIndex = 0;
            var currentIndex = 0;

            $('#banner-pagination li a').click(function () {

                nextIndex = parseInt($(this).attr('rel'));

                if (nextIndex != currentIndex) {
                    $('#banner-pagination li a').html('<img src="<c:url value='/resources/web/img/slidedot.png'/>" alt="slide"/>');
                    $(this).html('<img src="<c:url value='/resources/web/img/slidedot-active.png'/>" alt="slide"/>');
                    currentIndex = nextIndex;
                    if (prevIndex < 0) prevIndex = 0;

                    splashes.eq(prevIndex).css({ opacity: 1 }).animate({ opacity: 0 }, 500, function () {
                        $(this).hide();
                    });
                    splashes.eq(nextIndex).show().css({ opacity: 0 }).animate({ opacity: 1 }, 500, function () { });

                    showCaseItems.eq(prevIndex).css({ opacity: 1 }).animate({ opacity: 0 }, 500, function () {
                        $(this).hide();
                        showCaseItems.eq(nextIndex).show().css({ opacity: 0 }).animate({ opacity: 1 }, 200, function () { });
                    });

                    prevIndex = nextIndex;
                }

                return false;
            });

        });
    </script>
</body>
</html>