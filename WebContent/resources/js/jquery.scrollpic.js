(function($){

	$.fn.hhScrollpic = function(options){

		var opts = $.extend({},$.fn.hhScrollpic.defaults, options);
		
		//主体代码
		return this.each(function(){
			
			var $this = $(this);
			var $Mth = opts.scrollPicMth; //每页显示个数
			var speed = opts.speed; //速度
			var defaultSpeed = opts.defaultSpeed;   //默认滚动时间  点击按钮滚动时间
			var speed = opts.speed;   //自动播放滚动时间
			var $downContent = $this.find('.downContent');
			var bLen = $this.find('.downContent ul li').length;  //总个数
			var liPicWidth = $this.find('.downContent li').width();
			var bUlWidth = bLen * liPicWidth + bLen * 20;
			var number=0;
			var index=0;
			var oldStartTime = 0;
			var bshowPics;
			var picTimer;
			
			//计算当前对象的宽度
			var $thisWidth = ($Mth * liPicWidth) +  (($Mth-1)*20);
			$this.css('width',$thisWidth); //没有必要
			//$this.css('width','1000px'); //没有必要
			$this.find('.downContent ul').width(bUlWidth);
			
			var btn = '<div class="thLeft up"><div class="thLeft buttom"><span class="buttom_left"></span></div><ul  class="yb_box_topbs">';
			if(bLen % $Mth == 0){
				number = parseInt(bLen/$Mth);
			}else{
				number = parseInt(bLen/$Mth)+1;
			}
			//number=number.toFixed(0);
			for(var i = 0; i < number; i++) {
				btn += "<li>" + i + "</li>";
			}
			btn += '</ul><div class="buttom thLeft"><span class="buttom_right"></span></div></div>';
			$this.find('.wrapper').before(btn);
			
			//滚动圆点和按钮
			var $ulBoxLi	= $this.find('.yb_box_topbs li');
			$ulBoxLi.eq(index).addClass('current').siblings().removeClass('current');
			var $butLeft = $this.find('.buttom_left');
			var $butRight = $this.find('.buttom_right');
			
			//计算按钮到边框的距离
			var b = $this.find('.up').width();
			var a = ($thisWidth/2)-(b/2);
			$this.find('.up').css('padding-left',a);
			
			
			function bshowPics(index) {

    		$downContent.stop().animate({left:-$thisWidth-20},defaultSpeed, "swing",
    		function(){
    		    for (var i = 0; i < $Mth; i++){
    		        $downContent.children().append($downContent.children().children(":first"));
    		    }
    		    $downContent.css({left: 0});
    		})
    		
				if(index+1==number){
					index=0;
				}else{
					index+=1;
				}
				$ulBoxLi.eq(index).addClass('current').siblings().removeClass('current');
				
			}

			$downContent.hover(function() {
			    clearInterval(picTimer);
			},function() {
			    picTimer = setInterval(function(){
						bshowPics(index);
						index++;
						if(index == number) {index = 0;}
					},speed);
			}).trigger('mouseleave');
			
			$butLeft.hover(function() {
			   clearInterval(picTimer);
			},function(){
				picTimer = setInterval(function(){
						bshowPics(index);
						index -= 1;
						if(index == -1) {index = number - 1;}
					},speed);
			});
			
			$butRight.hover(function() {
			    clearInterval(picTimer);
			},function(){
				picTimer = setInterval(function(){
						bshowPics(index);
						index++;
						if(index == number) {index = 0;}
					},speed);
			});

			$butLeft.click(function() {
				
				var currentIndex=$this.find('ul.yb_box_topbs li.current').index();
				if(currentIndex-1<0){
					currentIndex=number-1;
				}else{
					currentIndex-=1;
				}
				$ulBoxLi.eq(currentIndex).addClass('current').siblings().removeClass('current');

				var startTime = Date.parse(new Date()); 
				var cha = startTime-oldStartTime;
				if(cha == 0){
					
					for (var i = 0; i < $Mth; i++) {
			  	    $downContent.children().children(":first").before($downContent.children().children(":last"));
			  	}
			  	$downContent.stop().css({"left":-$thisWidth-20}).animate({left: 0},100, "swing");
			  	
				}else{
					
					for (var i = 0; i < $Mth; i++) {
			  	    $downContent.children().children(":first").before($downContent.children().children(":last"));
			  	}
			  	$downContent.stop().css({"left":-$thisWidth-20}).animate({left: 0},defaultSpeed, "swing");
			  	
				}
				oldStartTime=startTime;
				
			});
			
			$butRight.click(function(){
				
				var currentIndex=$this.find('ul.yb_box_topbs li.current').index();
				if(currentIndex+1==number){
					currentIndex=0;
				}else{
					currentIndex+=1;
				}
				$ulBoxLi.eq(currentIndex).addClass('current').siblings().removeClass('current');
								
/*				
				bshowPics(index);
				index++;
				if(index == number) {index = 0;}
*/				
				var startTime = Date.parse(new Date()); 
				var cha=startTime-oldStartTime;
				//$("body").append("startTime:"+startTime+" oldStartTime:"+oldStartTime+"  cha:"+cha+"<br/>");
				if(cha == 0){
					$downContent.stop().animate({left:-$thisWidth-20},100, "swing",
					function() {
    		    for (var i = 0; i < $Mth; i++) {
    		        $downContent.children().append($downContent.children().children(":first"));
    		    }
    		    $downContent.css({left: 0});
    			});
				}else{
					$downContent.stop().animate({left:-$thisWidth-20},defaultSpeed, "swing",
					function() {
    		    for (var i = 0; i < $Mth; i++) {
    		        $downContent.children().append($downContent.children().children(":first"));
    		    }
    		    $downContent.css({left: 0});
    			});
				}
				oldStartTime=startTime;

			});
			
		});
		
	};
	
	// 默认参数
	$.fn.hhScrollpic.defaults = {
		
		scrollPicMth:2,  //每页显示个数
		defaultSpeed : 1000,   //默认滚动时间  点击按钮滚动时间
		speed : 5000   //自动播放滚动时间
		
	};
	
	$.fn.hhScrollpic.setDefaults = function(settings) {
		
		$.extend( $.fn.hhScrollpic.defaults, settings );
		
	};
	
})(jQuery);