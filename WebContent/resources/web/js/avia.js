(function($)
{  
    $(document).ready(function()
    {	 
        // decreases header size when user scrolls down
        avia_header_size(); 
    });
 
    //check if the browser supports element rotation
    function avia_header_size()
    {
        var win	            = $(window),
            header          = $('.fixed_header #header'),
            logo			= header.find('.logo img'),
            elements        = $('#header_main .container, .top_nav ul:first-child > li > a:not(.avia_mega_div a),.top_about ul:first-child > li > a:not(.avia_mega_div a)'),
            el_height       = $(elements).filter(':first').height(),
            isMobile        = 'ontouchstart' in document.documentElement,
            scroll_top		= $('#scroll-top-link'),
            set_height      = function()
            {
                var st = win.scrollTop(), newH = 0;

                if(st < el_height/3*2)
                {
                    if (el_height - st < el_height / 3 * 2) newH = el_height / 3 * 2;
                    else newH = el_height - st;
                    //header.removeClass('shadow');
                }
                else
                {
                    newH = el_height/3*2;
                    //header.addClass('shadow');
                }

                elements.css({height: newH + 'px', lineHeight: newH + 'px'});
            }

        	if(!header.length) return false;

            if(isMobile)
            {
                return false;
            }

            win.scroll(set_height);
            set_height();
    }  
})( jQuery );

  