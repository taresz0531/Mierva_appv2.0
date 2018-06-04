var imageIndex = 0;
var galleryfn = {		
	n: function (){
		imageIndex++;
		
		var imgs = document.getElementsByClassName("img-cl");
		var img = document.getElementById("img-fsc");
		
		if(imageIndex==imgs.length){
			imageIndex = 0;
		}
		
		img.src = imgs[imageIndex].src;
	},
	
	p: function (){
		imageIndex--;
		
		var imgs = document.getElementsByClassName("img-cl");
		var img = document.getElementById("img-fsc");
		
		if(imageIndex==-1){
			imageIndex = imgs.length-1;
		}
		
		img.src = imgs[imageIndex].src;
	},
	
	c: function (){
		var div = document.getElementById("baguetteBox-overlay");
		div.style.display = "none";
	}
};

function next(){
	imageIndex++;
	
	var imgs = document.getElementsByClassName("img-cl");
	var img = document.getElementById("img-fsc");
	
	if(imageIndex==imgs.length){
		imageIndex = 0;
	}
	
	img.src = imgs[imageIndex].src;
}

function pre(){
	imageIndex--;
	
	var imgs = document.getElementsByClassName("img-cl");
	var img = document.getElementById("img-fsc");
	
	if(imageIndex==-1){
		imageIndex = imgs.length-1;
	}
	
	img.src = imgs[imageIndex].src;
}

function openImage(id){
	var div = document.getElementById("baguetteBox-overlay");
	var img = document.getElementById("img-fsc");
	var image = document.getElementById(id);
	
	imageIndex = image.getAttribute("name");
	
	div.style.display = "block";
	img.src = "getImage?fileId=" + id + "&who=g";
}

function closeFullscreen(){
	var div = document.getElementById("baguetteBox-overlay");
	div.style.display = "none";
}