<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>${Session.heti_cim}</h1></center>	
	</div>
	
	<div class="guest-div">
		<center><h3>${Session.heti_cim2}</h3></center>
		<center><p>${Session.heti_cim3}</p></center>
		<center><p>${Session.heti_utalvany}</p></center>
		<center><p>${Session.heti_parkolo}</p></center>
		<center><p>${Session.heti_menuar}</p></center>
		<center><p>${Session.heti_savanyu}</p></center>
		<center><p>${Session.heti_csere}</p></center>
		<center><p>${Session.heti_jog}</p></center>
		<center><p>${Session.heti_elojegyzes}</p></center>
	</div>
	
	<div class="guest-div">
		<table style="width: 100%;">
			<tr class="row-div etel-header-row">
				<th class="menu-v-align"><p>${Session.heti_nap}</p></th>
				<th class="menu-v-align"><p>${Session.heti_leves}</p></th>
				<th class="menu-v-align"><p>${Session.heti_foetel}</p></th>
				<th class="menu-v-align"><p>${Session.heti_koret}</p></th>
			</tr>
			<#list hetiMenuObj as h>
				<#if !h?is_last>
					<tr class="etel-row" style="height: 70px;">
				<#else>
					<tr style="height: 70px;">
				</#if>
						<td class="menu-v-align"><h4>${h.date} ${h.dayName}</h4></td>
						<td class="menu-v-align"><p><#if h.napimenu.leves??>${h.napimenu.leves}</#if></p></td>
						<td class="menu-v-align"><p><#if h.napimenu.foetel??>${h.napimenu.foetel}</#if></p></td>
						<td class="menu-v-align"><p><#if h.napimenu.koret??>${h.napimenu.koret}</#if></p></td>
					</tr>
			</#list>
		</table>
	</div>
	
</div>

<#include "footer.ftl">