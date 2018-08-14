<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>${Session.etlap_cim}</h1></center>	
	</div>
	<#list etlapObject as etObj>
		<div class="guest-div">
			<div> 
				<h1>${etObj.nev?keep_before("/")}</h1>
			</div>
			<table style="width: 100%;">
				<tr class="row-div etel-header-row">
					<th class="menu-v-align"><p>${Session.etlap_etel}</p></th>
					<th class="menu-v-align"><p>${Session.etlap_alergen}</p></th>
					<th class="menu-v-align"><p>${Session.etlap_ar}</p></th>
					<th class="menu-v-align"><p>${Session.etlap_kep}</p></th>
				</tr>
				<#list etObj.etelek as e>
					<#if !e?is_last>
						<tr class="etel-row">
					<#else>
						<tr style="height: 70px;">
					</#if>
						<td class="menu-v-align"><p><#if e.nev??>${e.nev}</#if></p></td>
						<td class="menu-v-align"><p><#if e.leiras??>${e.leiras}</#if></p></td>
						<td class="menu-v-align"><p><#if e.ar??>${e.ar}.-</#if></p></td>
						<#if e.is_kep == 0>
							<td class="menu-v-align"><p>${Session.etlap_nincs_kep}</p></td>
						<#else>
							<td class="menu-v-align"><img src="getImage?fileId=${e.id}&who=e" id="${e.id}" class="etlap-img" onclick="openImage(${e.id})"/></td>
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
			img.src = "getImage?fileId=" + id + "&who=e";
		}
	
		function closeFullscreen(){
			var div = document.getElementById("fullscreen-div");
			div.style.display = "none";
		}
	</script>
</div>

<#include "footer.ftl">