<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta http-equiv="x-ua-compatible" content="ie=edge">
		
		<title>Minerva Panzió</title>
		
<!-- 	start bootstrap -->
<!-- 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
<!-- 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
		<script src="http://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
	
<!-- 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->
<!-- 	end bootstrap -->

<!-- 	szövegszerkesztő -->
		<!-- Include external CSS. -->
<!-- 		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" /> -->
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		
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
		<script type="text/javascript" src="https://www.google.com/recaptcha/api.js?hl=${Session.js_notrobot}"></script>

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
		      <a href="/Minerva" class="navbar-brand"><img alt="logo" src="icon/logo.png" height="60px" style="margin-top: -18px;"></a>
		      <a href="/Minerva" class="navbar-brand">${Session.menu_pansio}</a>
		    </div>
		    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		      <ul class="nav navbar-nav">
				<li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${Session.menu_etterem}<b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="hetimenu">${Session.menu_napi}</a></li>
			          <li><a href="etlap">${Session.menu_etlap}</a></li>
			        </ul>
			    </li>
		        <li>
		          <a href="gallery">${Session.menu_galeria}</a>
		        </li>
		        <li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${Session.menu_info}<b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="szolgaltatas">${Session.menu_szolgaltat}</a></li>
			          <li><a href="arak">${Session.menu_arak}</a></li>
			          <li><a href="varosinfo">${Session.menu_varos}</a></li>
			          <li><a href="hazirend">${Session.menu_hazi}</a></li>
			          <li><a href="gyik">${Session.menu_gyik}</a></li>
			        </ul>
			    </li>
		        <li>
		          <a href="ajanlat">${Session.menu_ajanlat}</a>
		        </li>
		        <li>
		          <a href="kapcsolatok">${Session.menu_kapcsolat}</a>
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
		<div style="margin-top: 25px;">
			<img src="image/header/fejlec_front_static.png" width="100%" style="min-width: 580px; top: 25px; border-bottom: 2px solid black; border-radius: 10px;">
				<img class="mySlides w3-animate-top" src="image/header/kozepso_eloadoterem.png" width="100%" style="min-width: 580px; top: 25px; position: absolute;">
				<img class="mySlides w3-animate-top" src="image/header/kozepso_etterem.png" width="100%" style="min-width: 580px; top: 25px; position: absolute;">
				<img class="mySlides w3-animate-top" src="image/header/kozepso_parkolo.png" width="100%" style="min-width: 580px; top: 25px; position: absolute;">
				<img class="mySlides w3-animate-top" src="image/header/kozepso_szobak.png" width="100%" style="min-width: 580px; top: 25px; position: absolute;">
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
			    setTimeout(carousel, 10000);    
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