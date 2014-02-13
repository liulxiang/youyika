<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/yangguang-content.css"/>" />
<div class="banner_box">
	<div class="banner">
		<div id="playbtn" class="playbutton" title="播放视频"></div>
		<div class="num_of_breathing">
			<p id="heat">797</p>
		</div>
		<input id="button" class="button_buy" type="button" name="buy"
			value="">
	</div>
</div>

<div class="banner4box">
	<a name="fn"></a>
	<div class="banner4_title">
		<img src="<c:url value="/resources/web/images/banner4_title.png"/>">
	</div>
	<div class="banner4_cont">
		<div class="banner4_cont_top">
			<ul>
				<li class="jq"></li>
				<li class="pm"></li>
				<li class="jz"></li>
				<li class="qt"></li>
				<li class="wd"></li>
			</ul>
		</div>
		<div class="banner4_cont_bottom">
			<ul>
				<li class="sd"></li>
				<li class="gz"></li>
				<li class="zy"></li>
				<li class="hxd"></li>
				<li class="cmaj"></li>
			</ul>
		</div>
	</div>
</div>


<!--banner5_start-->
 <div class="banner5box">
     <a name="app"></a>
     <div class="banner5">
         <input type="button" name="button3" id="button3" value="" class="app_button">
     </div>
 </div>
 <!--banner5_end-->

<div class="banner8">
	<div class="linkstyle">
		<img src="<c:url value="/resources/web/images/linkstyle.png"/>">
	</div>
</div>
<div class="banner7">
	<div class="product_size">
		<img src="<c:url value="/resources/web/images/size.png"/>">
	</div>
</div>



<div class="contact_box">
	<div class="contact">
		<div class="contact_title">
			<img src="<c:url value="/resources/web/images/contacttitle.png"/>">
		</div>
		<div class="email_box">
			<input id="email" class="contact_name" type="text" name="textfield">
		</div>
		<div class="dy_button">
			<input id="button2" class="button_dy" type="submit"
				onclick="addEmail();" value="" name="button2">  
		</div>
	</div>
</div>
