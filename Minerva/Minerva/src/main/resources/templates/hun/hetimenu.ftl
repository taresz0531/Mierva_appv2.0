<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>Heti menü</h1></center>	
	</div>
	
	<div class="guest-div">
		<center><h3>Minerva Étterem</h3></center>
		<center><p>4024 Debrecen, Kossuth U. 59. Tel.: (52) 531-363</p></center>
		<center><p>Erzsébet utalványt, SZÉP kártyát, étkezési jegyeket elfogadunk!</p></center>
		<center><p>Az étterem elõtt gépkocsi parkolók találhatók.</p></center>
		<center><p>MENÜ ÁR bruttó 1.050,- Ft/nap</p></center>
		<center><p>A menühöz kis adag csemege uborka, káposztasaláta rendelhető bruttó 170,- Ft/adag áron.</p></center>
		<center><p>Amennyiben a levest nem szereti, azt felár nélkül cseréljük csontlevesre.</p></center>
		<center><p>A változtatás jogát fenntartjuk!</p></center>
		<center><p>Elõjegyzést felveszünk!</p></center>
	</div>
	
	<div class="guest-div">
		<table>
			<tr class="row-div etel-header-row">
				<th class="col-sm-4"><p>Nap</p></th>
				<th class="col-sm-3"><p>Leves</p></th>
				<th class="col-sm-3"><p>Főétel</p></th>
				<th class="col-sm-2"><p>Köret</p></th>
			</tr>
			<#list hetiMenuObj as h>
				<#if !h?is_last>
					<tr class="etel-row" style="height: 100px;">
				<#else>
					<tr style="height: 100px;">
				</#if>
						<td class="col-sm-4"><h3>${h.date}. ${h.dayName}</h3></td>
						<td class="col-sm-3"><p><#if h.napimenu.leves??>${h.napimenu.leves?keep_before("/")}</#if></p></td>
						<td class="col-sm-3"><p><#if h.napimenu.foetel??>${h.napimenu.foetel?keep_before("/")}</#if></p></td>
						<td class="col-sm-2"><p><#if h.napimenu.koret??>${h.napimenu.koret?keep_before("/")}</#if></p></td>
					</tr>
			</#list>
		</table>
	</div>
	
</div>

<#include "footer.ftl">