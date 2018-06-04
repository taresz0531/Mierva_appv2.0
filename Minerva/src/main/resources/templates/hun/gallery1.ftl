<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>Galéria</h1></center>	
	</div>
	<div class="guest-div" style="float: left;">
	<#list gallery as g>
		 <div class="col-sm-4 galleri-div" onclick="openImage(${g.id})">
		    	<img class="image-class" src="getImage?fileId=${g.id}&who=g" id="${g.id}" name="${g?index}">
		    	<b><p class="leiras">${g.leiras}</p></b>
		  </div>
	 </#list>
	</div>
	<div class="fullscreen-div container" id="fullscreen-div">
		<img class="fullscreen-image" src="" id="fullscreen-image">
		<p class="close-x" onclick="closeFullscreen()">x</p>
		<p class="next" onclick="next()">&#9654</p>
		<p class="pre" onclick="pre()">&#x25c0</p>
	</div>
	<script type="text/javascript">
		var imageIndex = 0;
		
		function next(){
			imageIndex++;
			
			var imgs = document.getElementsByClassName("image-class");
			var img = document.getElementById("fullscreen-image");
			
			if(imageIndex==imgs.length){
				imageIndex = 0;
			}
			
			img.src = imgs[imageIndex].src;
		}
		
		function pre(){
			imageIndex--;
			
			var imgs = document.getElementsByClassName("image-class");
			var img = document.getElementById("fullscreen-image");
			
			if(imageIndex==-1){
				imageIndex = imgs.length-1;
			}
			
			img.src = imgs[imageIndex].src;
		}
	
		function openImage(id){
			var div = document.getElementById("fullscreen-div");
			var img = document.getElementById("fullscreen-image");
			var image = document.getElementById(id);
			
			imageIndex = image.getAttribute("name");
			
			div.style.display = "block";
			img.src = "getImage?fileId=" + id + "&who=g";
		}
	
		function closeFullscreen(){
			var div = document.getElementById("fullscreen-div");
			div.style.display = "none";
		}
	</script>
</div>


<#include "footer.ftl">