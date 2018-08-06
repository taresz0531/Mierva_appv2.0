<meta charset="utf-8">
<#include "header.ftl">

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDhXj7PhwGkYxXebrjqkJOMmXJy3Ff5j94"></script>
<script>
	var myCenter=new google.maps.LatLng(47.5302213,21.6343274);
	var loc = document.getElementById("cim");
	function setlocal(){
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function (position) {
			 	var lat = position.coords.latitude;
			 	var ln  = position.coords.longitude;
			 	document.getElementById("cim").value = lat.toString() + "," + ln.toString();
			});
		}
		else{
			var ad = document.getElementById('ad');
			document.getElementById("cim").value = ad.value;
		}
	}
	function initialize() {
	  setlocal();
	  var mapProp = {
	    center:myCenter,
	    zoom:15,
	    mapTypeId:google.maps.MapTypeId.ROADMAP
	  };
	  var map=new google.maps.Map(document.getElementById("googleMap"), mapProp);
	  var marker=new google.maps.Marker({
		  position:myCenter,
		  animation:google.maps.Animation.BOUNCE
		  });
		
		marker.setMap(map);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
	
	function myFunction2() {
		var nemhely = document.getElementById('nemhely');
	    var person = prompt(nemhely.value, "");
	    
	    if (person != null) {
	        document.getElementById("cim").value = person;
	    }
	}
	
	function myFunction() {
		var cim = document.getElementById("cim");
		if(cim.value == null || cim.value == ""){
			myFunction2();
			window.open("https://www.google.hu/maps/dir/" + cim.value + "/'47.5302213,21.6343274'?hl=hu", '_blank');

		}
		else{
			window.open("https://www.google.hu/maps/dir/" + cim.value + "/'47.5302213,21.6343274'?hl=hu", '_blank');
		}
	}
	
	function setEmtyCim(){
		document.getElementById("cim").value = "";
	}
	</script>
<div class="main-div container">
	<input type="hidden" value="${Session.eler_ad}" id="ad"/>
	<input type="hidden" value="${Session.eler_nemhely}" id="nemhely"/>
	<div class="guest-div">
		<center><h1>${Session.eler_cim}</h1></center>
	</div>
	<div class="guest-div">
	<center>
		<p>4024 Debrecen, Kossuth u. 59.</p>
		<p>${Session.eler_tel} +36 52/531-363</p>
		<p>${Session.eler_fax} +36 52/533-286</p>
		<p>E-mail: kofer74@freemail.hu</p>
	</center>
	<div class="row">
		<div class="col-xs-6">
			<center>
				<p>${Session.eler_igazgat}</p>
				<p>Dr. Kondorosiné Vizer Viola</p>
				<p>${Session.eler_tel} +36 30/978-7485</p>
				<p>konfer74@freemail.hu</p>
			</center>
		</div>
		<div class="col-xs-6">
			<center>
				<p>${Session.eler_igazhely}</p>
				<p>Czimre János</p>
				<p>${Session.eler_tel} +36 30/994-9164</p>
				<p>czimre.janos@freemail.hu</p>
			</center>
		</div>
	</div>
		<h3>${Session.eler_utvonal}</h3>
		<p>${Session.eler_terkep}</p>
		<div class="col-xs-12" id="googleMap" style="height: 350px; margin-bottom: 10px;"></div>
		<form class="form-horizontal" action="gyikKerdesServlet" method="post">	
			<div class="form-group">
			  <label class="control-label col-sm-2" for="eler">${Session.eler_hely}</label>
			  <div class="col-sm-10">
			  	<input onclick="setEmtyCim()" class="form-control" type="text" id="cim"/>
			  </div>
			</div>
			<div align="left" class="form-group">
			  <div class="col-sm-12">
				<center><input class="btn" type="button" onclick="myFunction()" value="${Session.eler_terv}" /></center>
			  </div>
			</div>
		</form>
	</div>
</div>

<#include "footer.ftl">