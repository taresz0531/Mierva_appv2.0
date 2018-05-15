<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta http-equiv="x-ua-compatible" content="ie=edge">
		
		<title>Minerva Panzió</title>
		
<!-- 	start bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
		<script src="http://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- 	end bootstrap -->

<!-- 	szövegszerkesztő -->
		<!-- Include external CSS. -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">
		
		<!-- Include Editor style. -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />
		<link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_style.min.css" rel="stylesheet" type="text/css" />
		<!-- Include external JS libs. -->
		<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>
		
		<!-- Include Editor JS files. -->
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/js/froala_editor.pkgd.min.js"></script>
		<script type="text/javascript" src="javascript/hu.js"></script>
<!-- 	end szövegszerkesztő -->

<!-- 	start gallery -->
		<link href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.css">
<!-- 	end gallery -->

<!-- 	css files -->
		<link rel="stylesheet" href="css/navobar.css">
		<link rel="stylesheet" href="css/footer.css">
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/foldal.css">
		<link rel="stylesheet" href="css/gallery.css">
		<link rel="stylesheet" href="css/etlap.css">
    	<link rel="stylesheet" href="css/gallery-grid.css">
	
<!-- 	header picture slides -->
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
<!-- 	include js files -->
		<script type="text/javascript" src="javascript/foldal.js"></script>
		<script type="text/javascript" src="javascript/gallery.js"></script>

	</head>
	<body>
		<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">
		  <div class="container" style="width: 100%">
		    <div class="navbar-header">
		      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a href="/Minerva" class="navbar-brand">Minerva Panzió</a>
		    </div>
		    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		      <ul class="nav navbar-nav">
				<li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Étterem <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="hetimenu">Heti menü</a></li>
			          <li><a href="etlap">Étlap</a></li>
			        </ul>
			    </li>
		        <li>
		          <a href="gallery">Galéria</a>
		        </li>
		        <li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Információk <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="szolgaltatas">Szolgáltatásaink</a></li>
			          <li><a href="arak">Árak</a></li>
			          <li><a href="gyik">Gyakori kérdések</a></li>
			        </ul>
			    </li>
		        <li>
		          <a href="ajanlat">Ajánlatkérés</a>
		        </li>
		        <li>
		          <a href="kapcsolatok">Kapcsolatok</a>
		        </li>
		      </ul>
		      <div style="float: right;" >
		      	<#if Session.nyelv = "eng">
		      		<a href="hun"><img class="icon" src="icon/Hungary-icon.png"  height="50px" /></a>
		      	<#else>
		      		<a href="eng"><img class="icon" src="icon/United-Kingdom-icon.png"  height="50px"/></a>
		      	</#if>
		      	<#if Session.userId?? && Session.userId != -1>
			      	<div style="float: right; margin-left: 10px; margin-top: 8px;" >
			      		<form action="logOut">
				      		<button type="submit" class="btn">Kijelentkezés</button>
			      		</form>
			      	</div>
			      	<div style="float: right; margin-left: 10px; margin-top: 8px;" >
				      		<a href="adminRedirect"><button type="button" class="btn">Vissza</button></a>
			      	</div>
		      	</#if>
		      </div>
		    </nav>
		  </div>
		</header>
		<div style="width: 100%; margin-top: 25px;">
		    <img class="mySlides w3-animate-top" src="image/header/IMG_20150614_144232.jpg" width="100%" style="max-width: 1920px; margin-top: 50px;">
		    <img class="mySlides w3-animate-top" src="image/header/fejlec.jpg" width="100%" style="max-width: 1920px; margin-top: 50px;">
		</div>
		<script>
			var myIndex = 0;
			carousel();
	
			function carousel() {
			    var i;
			    var x = document.getElementsByClassName("mySlides");
			    for (i = 0; i < x.length; i++) {
			      x[i].style.display = "none";  
			    }
			    myIndex++;
			    if (myIndex > x.length) {myIndex = 1}    
			    x[myIndex-1].style.display = "block";  
			    setTimeout(carousel, 5000);    
			}	
		</script>
		<div class="main-div container">
			<#if Session.message!="">
				<#if Session.message=="success">
					<div id="alert" class="alert alert-success fade in message-div">
					<script>
					 	$(document).ready(function(){
					 		setTimeout(function(){
					 	        $("#alert").hide(1500);
							 }, 10000);
					 	});
					</script>
				<#elseif Session.message=="error">
				 	<div id="alert" class="alert alert-danger fade in message-div">
				 	<script>
					 	$(document).ready(function(){
					 		setTimeout(function(){
					 	        $("#alert").hide(1500);
							 }, 25000);
					 	});
					</script>
				<#elseif Session.message=="warning">
					<div id="alert" class="alert alert-warning fade in message-div">
					<script>
					 	$(document).ready(function(){
					 		setTimeout(function(){
					 	        $("#alert").hide(1500);
							 }, 10000);
					 	});
					</script>
				</script>
				</#if>
		      		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<center>${Session.msg}</center>
				</div>
			</#if>
		</div>