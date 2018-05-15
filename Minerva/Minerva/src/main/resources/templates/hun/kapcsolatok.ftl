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
			document.getElementById("cim").value = "Adja meg a helyét!";
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
	    var person = prompt("Nem adott meg tartozkodási helyet!", "Hely?");
	    
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
	<div class="guest-div">
		<center><h1>Elérhetőségek:</h1></center>
	</div>
	<div class="guest-div">
	<center>
		<p>4024 Debrecen, Kossuth u. 59.</p>
		<p>Tel.: (+36)-52-531-363</p>
		<p>Fax.: (+36)-52-533-286</p>
		<p>E-mail: kofer74@freemail.hu</p>
	</center>
		<h3>Útvonal tervezés</h3>
		<p>Térkép</p>
		<div class="col-xs-12" id="googleMap" style="height: 350px; margin-bottom: 10px;"></div>
		<form class="form-horizontal" action="gyikKerdesServlet" method="post">	
			<div class="form-group">
			  <label class="control-label col-sm-2" for="eler">Indulási hely:</label>
			  <div class="col-sm-10">
			  	<input onclick="setEmtyCim()" class="form-control" type="text" id="cim"/>
			  </div>
			</div>
			<div align="left" class="form-group">
			  <div class="col-sm-12">
				<center><input class="btn" type="button" onclick="myFunction()" value="Tervezés" /></center>
			  </div>
			</div>
		</form>
	</div>
</div>

<#include "footer.ftl">