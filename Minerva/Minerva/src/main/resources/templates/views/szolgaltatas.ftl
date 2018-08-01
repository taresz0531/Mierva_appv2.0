<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>${Session.szolg_cim}</h1></center>	
	</div>
	<div class="guest-div">
		<h3>${Session.szolg_szoba}</h3>
		<ul>
			<li>${Session.szolg_tagas}</li>
			<li>${Session.szolg_mini}</li>
			<li>${Session.szolg_wifi}</li>
			<li>${Session.szolg_tv}</li>
			<li>${Session.szolg_zuhany}</li>
			<li>${Session.szolg_kondi}</li>
			<li>${Session.szolg_dohany}</li>
			<li>${Session.szolg_baba}</li>
			<li>${Session.szolg_akadaly}</li>
		</ul>
		<h3>${Session.szolg_etterem}</h3>
		<ul>
			<li>${Session.szolg_sved}</li>
			<li>${Session.szolg_kondi2}</li>
			<li>${Session.szolg_wifi2}</li>
			<li>${Session.szolg_jegy}</li>
		</ul>
		<h3>${Session.szolg_konferencia}</h3>
		<ul>
			<li>${Session.szolg_rend}</li>
			<li>${Session.szolg_kondi3}</li>
			<li>${Session.szolg_technika}</li>
		</ul>
		<h3>${Session.szolg_tovabb}</h3>
		<ul>
			<li>${Session.szolg_eloter}</li>
			<li>${Session.szolg_zart}</li>
			<li>${Session.szolg_recept}</li>
			<li>${Session.szolg_hitel}</li>
			<li>${Session.szolg_udules}</li>
		</ul>
	</div>
</div>

<#include "footer.ftl">