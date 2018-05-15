<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>Galéria</h1></center>	
	</div>
	<div class="tz-gallery guest-div">
		 <div class="row">
			<#list gallery as g>
				  <div class="col-sm-6 col-md-4 lightbox"  onclick="openImage(${g.id})">
               		<img class="img-cl" src="getImage?fileId=${g.id}&who=g" alt="${g.leiras}" id="${g.id}" name="${g?index}">
		          </div>
			 </#list>
		</div>
	</div>
</div>
<div role="dialog" id="baguetteBox-overlay"
	aria-labelledby="baguetteBox-figure-0"
	aria-describedby="baguetteBox-figcaption-0"
	style="background-color: rgba(0, 0, 0, 0.8);" class="visible">
	<div id="baguetteBox-slider" style="transform: translate3d(0%, 0px, 0px);">
	<div class="full-image" id="baguette-img-0">
		<figure id="baguetteBox-figure-0">
			<img class="img-fsc" src="" alt="image" id="img-fsc">
		</figure>
	</div>
	</div>
	<button type="button" id="previous-button" aria-label="Previous" class="baguetteBox-button" onclick="pre()">
		<svg width="44" height="60">
			<polyline points="30 10 10 30 30 50" stroke="rgba(255,255,255,0.5)"
				stroke-width="4" stroke-linecap="butt" fill="none"
				stroke-linejoin="round"></polyline></svg>
	</button>
	<button type="button" id="next-button" aria-label="Next" class="baguetteBox-button" onclick="next()">
		<svg width="44" height="60">
			<polyline points="14 10 34 30 14 50" stroke="rgba(255,255,255,0.5)"
				stroke-width="4" stroke-linecap="butt" fill="none"
				stroke-linejoin="round"></polyline></svg>
	</button>
	<button type="button" id="close-button" aria-label="Close" class="baguetteBox-button" onclick="closeFullscreen()">
		<svg width="30" height="30">
			<g stroke="rgb(160,160,160)" stroke-width="4">
			<line x1="5" y1="5" x2="25" y2="25"></line>
			<line x1="5" y1="25" x2="25" y2="5"></line></g></svg>
	</button>
</div>
<script>

'use strict';

document.addEventListener('keydown', (event) => {
  const keyName = event.key;
  if(keyName == 'ArrowRight')
  	galleryfn.n();
  else if(keyName == 'ArrowLeft')
	  galleryfn.p();
  else if(keyName == 'Escape')
	  galleryfn.c();
});

</script>
<#include "footer.ftl">