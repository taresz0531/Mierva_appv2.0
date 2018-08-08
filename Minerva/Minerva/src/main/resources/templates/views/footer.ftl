<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta charset="utf-8">
<footer class="footer-div container">
	<div class="text-center col-xs-4" id="footer-div">
		<p class="top-margin-10" style="font-size: 10px;">${Session.footer_contact}</p>
		<p style="font-size: 10px;">${Session.footer_address}</p>
	</div>
	<dir class="col-xs-4 text-center">
		<a href="https://www.booking.com/hotel/hu/minerva-panzio-etterem-kavezo.hu.html?label=gen173nr-1FCAEoggJCAlhYSDNYBGhniAEBmAERwgEKd2luZG93cyAxMMgBDNgBAegBAfgBC5ICAXmoAgM;sid=3a52b0c80af50ec3da9819fa0a9e182b;dest_id=-851960;dest_type=city;dist=0;from_sr_elem=1;group_adults=2;hapos=1;hpos=1;room1=A%2CA;sb_price_type=total;srepoch=1530977648;srfid=8f6b9c9ec782f5ef220e46d45d787ef0b622b9acX1;srpvid=e4676d77c404012e;type=total;ucfs=1&#hotelTmpl" target="_blank"><img class="shear-button" src="icon/booking.png" width="40" height="40"/></a>
		<a href="https://www.facebook.com/sharer/sharer.php?u=http://www.minervapanziodebrecen.hu/index.html" target="_blank"><img style="border-radius: 7px;" class="shear-button" src="icon/Facebook.png" width="40" height="40"/></a>
		<a href="https://twitter.com/share?url=http://www.minervapanziodebrecen.hu/index.html" target="_blank"><img class="shear-button" src="icon/Twitter.png" width="40" height="40"/></a>
		<a href="https://plus.google.com/share?url=http://www.minervapanziodebrecen.hu/index.html" target="_blank"><img class="shear-button" src="icon/googleplus.png" width="40" height="40"/></a>
	</dir>
	<dir class="col-xs-4 text-center" float: left;">
			<img src="image/header/kartyak01.png" width="150px" style="margin-top: 10px;" />
			<img src="image/header/kartyak02.png" width="150px" style="margin-top: 8px;"/>
	</dir>
	<img src="icon/up.png" id="myBtn" onclick="topFunction(700)"/>
</footer>
<script>
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction(scrollDuration) {
	var scrollStep = -window.scrollY / (scrollDuration / 15),
    scrollInterval = setInterval(function(){
    if ( window.scrollY != 0 ) {
        window.scrollBy( 0, scrollStep );
    }
    else clearInterval(scrollInterval); 
},15);
}
</script>
</body>
</html>