<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>Étlap</h1></center>	
	</div>
	<#list etlapObject as etObj>
		<div class="guest-div">
			<div> 
				<h1>${etObj.nev?keep_before("/")}</h1>
			</div>
			<table>
				<tr class="row-div etel-header-row">
					<th class="col-sm-5"><p>Étel neve</p></th>
					<th class="col-sm-3"><p>Allergének</p></th>
					<th class="col-sm-1"><p>Ár</p></th>
					<th class="col-sm-3"><p>Kép</p></th>
				</tr>
				<#list etObj.etelek as e>
					<#if !e?is_last>
						<tr class="etel-row">
					<#else>
						<tr style="height: 150px;">
					</#if>
						<td class="col-sm-5"><p>${e.nev?keep_before("/")}</p></td>
						<td class="col-sm-3"><p>${e.leiras?keep_before("/")}</p></td>
						<td class="col-sm-1"><p>${e.ar}.-</p></td>
						<#if e.is_kep == 0>
							<td class="col-sm-3"><p>Nincs kép</p></td>
						<#else>
							<td class="col-sm-3"><img src="getImage?fileId=${e.id}&who=e" id="${e.id}" class="etlap-img" onclick="openImage(${e.id})"/></td>
						</#if>
					</tr>
				</#list>
			</table>
		</div>
	</#list>
	<div class="fullscreen-div container" id="fullscreen-div">
		<img class="fullscreen-image" src="#" id="fullscreen-image">
		<p class="close-x" onclick="closeFullscreen()">x</p>
	</div>
	<script type="text/javascript">
	
		function openImage(id){
			var div = document.getElementById("fullscreen-div");
			var img = document.getElementById("fullscreen-image");
			var image = document.getElementById(id);
			
			div.style.display = "block";
			img.src = "/getImage?fileId=" + id + "&who=e";
		}
	
		function closeFullscreen(){
			var div = document.getElementById("fullscreen-div");
			div.style.display = "none";
		}
	</script>
</div>

<#include "footer.ftl">