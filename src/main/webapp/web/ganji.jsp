<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/ganji.css"/>" />


<div class="container content">
 <ol id="filters">
      <li data-filter="amsterdam">Amsterdam</li>
      <li data-filter="tokyo">Tokyo</li>
      <li data-filter="london">London</li>
      <li data-filter="paris">Paris</li>
      <li data-filter="berlin">Berlin</li>
      <li data-filter="sport">Sport</li>
      <li data-filter="fashion">Fashion</li>
      <li data-filter="video">Video</li>
      <li data-filter="art">Art</li>
    </ol>
    <br/>

    <div id="main" role="main">

      <ul id="tiles">
        <li data-filter-class='["london", "art"]'>
          <a href="<c:url value="/index"/>">
          <img src="<c:url value="/resources/web/images/sample-images/image_1.jpg"/>" height="283" width="200">
          </a>
           <p>Icebear / 20 € / &#9733;&#9733;&#9733;&#9733;</p>
        </li>
        <li data-filter-class='["berlin", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_2.jpg"/>" height="300" width="200">
          <p>Icebear / 20 € / &#9733;&#9733;&#9733;</p>
        </li>
        <li data-filter-class='["berlin", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_3.jpg"/>" height="252" width="200">
          <p>Berlin Video</p>
        </li>
        <li data-filter-class='["tokyo", "fashion"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_4.jpg"/>" height="158" width="200">
          <p>Tokyo Fashion</p>
        </li>
        <li data-filter-class='["berlin", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_5.jpg"/>" height="300" width="200">
          <p>Berlin Art</p>
        </li>
        <li data-filter-class='["tokyo", "fashion"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_6.jpg"/>" height="297" width="200">
          <p>Tokyo Fashion</p>
        </li>
        <li data-filter-class='["london", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_7.jpg"/>" height="200" width="200">
          <p>London Art</p>
        </li>
        <li data-filter-class='["tokyo", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_8.jpg"/>" height="200" width="200">
          <p>Tokyo Video</p>
        </li>
        <li data-filter-class='["tokyo", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_9.jpg"/>" height="398" width="200">
          <p>Tokyo Art</p>
        </li>
        <li data-filter-class='["berlin", "fashion"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_10.jpg"/>" height="267" width="200">
          <p>Berlin Fashion</p>
        </li>
        <li data-filter-class='["amsterdam", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_1.jpg"/>" height="283" width="200">
          <p>Amsterdam Art</p>
        </li>
        <li data-filter-class='["paris", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_2.jpg"/>" height="300" width="200">
          <p>Paris Video</p>
        </li>
        <li data-filter-class='["london", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_3.jpg"/>" height="252" width="200">
          <p>London Video</p>
        </li>
        <li data-filter-class='["london", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_4.jpg"/>" height="158" width="200">
          <p>London Video</p>
        </li>
        <li data-filter-class='["amsterdam"," video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_5.jpg"/>" height="300" width="200">
          <p>Amsterdam Video</p>
        </li>
        <li data-filter-class='["tokyo", "fashion"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_6.jpg"/>" height="297" width="200">
          <p>Tokyo Fashion</p>
        </li>
        <li data-filter-class='["tokyo", "sport"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_7.jpg"/>" height="200" width="200">
          <p>Tokyo Sport</p>
        </li>
        <li data-filter-class='["berlin", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_8.jpg"/>" height="200" width="200">
          <p>Berlin Video</p>
        </li>
        <li data-filter-class='["amsterdam", "fashion"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_9.jpg"/>" height="398" width="200">
          <p>Amsterdam Fashion</p>
        </li>
        <li data-filter-class='["berlin", "sport"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_10.jpg"/>" height="267" width="200">
          <p>Berlin Sport</p>
        </li>
        <li data-filter-class='["paris", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_1.jpg"/>" height="283" width="200">
          <p>Paris Video</p>
        </li>
        <li data-filter-class='["tokyo", "sport"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_2.jpg"/>" height="300" width="200">
          <p>Tokyo Sport</p>
        </li>
        <li data-filter-class='["amsterdam", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_3.jpg"/>" height="252" width="200">
          <p>Amsterdam Art</p>
        </li>
        <li data-filter-class='["berlin", "sport"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_4.jpg"/>" height="158" width="200">
          <p>Berlin Sport</p>
        </li>
        <li data-filter-class='["paris", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_5.jpg"/>" height="300" width="200">
          <p>Paris Art</p>
        </li>
        <li data-filter-class='["berlin", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_6.jpg"/>" height="297" width="200">
          <p>Berlin Art</p>
        </li>
        <li data-filter-class='["london", "art"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_7.jpg"/>" height="200" width="200">
          <p>London Art</p>
        </li>
        <li data-filter-class='["london", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_8.jpg"/>" height="200" width="200">
          <p>London Video</p>
        </li>
        <li data-filter-class='["london", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_9.jpg"/>" height="398" width="200">
          <p>London Video</p>
        </li>
        <li data-filter-class='["paris", "video"]'>
          <img src="<c:url value="/resources/web/images/sample-images/image_10.jpg"/>" height="267" width="200">
          <p>Paris Video</p>
        </li>
        <!-- End of grid blocks -->
      </ul>

    </div>



</div>




  <!-- Include the imagesLoaded plug-in -->
  <script src="<c:url value="/resources/web/js/jquery.imagesloaded.js"/>"></script>

  <!-- Include the plug-in -->
  <script src="<c:url value="/resources/web/js/jquery.wookmark.js"/>"></script>

  <script type="text/javascript">
    (function ($){
    	
    
   	var handler = null,
       page = 1,
       isLoading = false,
       apiURL = 'http://www.wookmark.com/api/json/popular';

    // Prepare layout options.
    var options = {
      autoResize: true, // This will auto-update the layout when the browser window is resized.
      container: $('#tiles'), // Optional, used for some extra CSS styling
      offset: 2, // Optional, the distance between grid items
      itemWidth: 210 // Optional, the width of a grid item
    };
    
    $('#tiles').imagesLoaded(function() {
        // Prepare layout options.
        var options = {
          autoResize: true, // This will auto-update the layout when the browser window is resized.
          container: $('#tiles'), // Optional, used for some extra CSS styling
          offset: 2, // Optional, the distance between grid items
          itemWidth: 210, // Optional, the width of a grid item
          fillEmptySpace: true // Optional, fill the bottom of each column with widths of flexible height
        };

        // Get a reference to your grid items.
        var handler = $('#tiles li'),
            filters = $('#filters li');

        // Call the layout function.
        handler.wookmark(options);

        /**
         * When a filter is clicked, toggle it's active state and refresh.
         */
        var onClickFilter = function(event) {
          var item = $(event.currentTarget),
              activeFilters = [];

          if (!item.hasClass('active')) {
            filters.removeClass('active');
          }
          item.toggleClass('active');

          // Filter by the currently selected filter
          if (item.hasClass('active')) {
            activeFilters.push(item.data('filter'));
          }

          handler.wookmarkInstance.filter(activeFilters);
        }

        // Capture filter click events.
        filters.click(onClickFilter);
      });

    /**
     * When scrolled all the way to the bottom, add more tiles.
     */
    function onScroll(event) {
      // Only check when we're not still waiting for data.
      if(!isLoading) {
        // Check if we're within 100 pixels of the bottom edge of the broser window.
        var closeToBottom = ($(window).scrollTop() + $(window).height() > $(document).height() - 100);
        if(closeToBottom) {
          loadData();
        }
      }
    };

    /**
     * Refreshes the layout.
     */
    function applyLayout() {
      options.container.imagesLoaded(function() {
        // Create a new layout handler when images have loaded.
        handler = $('#tiles li');
        handler.wookmark(options);
      });
    };

    /**
     * Loads data from the API.
     */
    function loadData() {
      isLoading = true;
      $('#loaderCircle').show();

      $.ajax({
        url: apiURL,
        dataType: 'jsonp',
        data: {page: page}, // Page parameter to make sure we load new data
        success: onLoadData
      });
    };

    /**
     * Receives data from the API, creates HTML for images and updates the layout
     */
    function onLoadData(data) {
      isLoading = false;
      $('#loaderCircle').hide();

      // Increment page index for future calls.
      page++;

      // Create HTML for the images.
      var html = '';
      var i=0, length=data.length, image;
      for(; i<length; i++) {
        image = data[i];
        html += '<li>';

        // Image tag (preview in Wookmark are 200px wide, so we calculate the height based on that).
        html += '<img src="'+image.preview+'" width="200" height="'+Math.round(image.height/image.width*200)+'">';

        // Image title.
        html += '<p>'+image.title+'</p>';

        html += '</li>';
      }

      // Add image HTML to the page.
      $('#tiles').append(html);

      // Apply layout.
      applyLayout();
    };

    // Capture scroll event.
    $(document).bind('scroll', onScroll);

    // Load first data from the API.
    loadData();
    
      
    })(jQuery);
  </script>