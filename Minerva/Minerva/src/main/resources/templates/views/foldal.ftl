<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container" style="margin-bottom: 50px;">
	<#if hetimenu??>
		<div class="foldal-main-div col-xs-12">
			<div class="row">
				<div class="foldal-cim col-xs-11" id="foldal-cim-id-hetimenu">
					<p>${Session.foldal_napimenu}</p>
				</div>
				<div class="col-xs-1" onclick="foldalClick('foldal-leiras-id-hetimenu')">
					<p style="float: right; user-select: none;">&#9660;</p>
				</div>
			</div>
			<div class="foldal-leiras col-sm-12" id="foldal-leiras-id-hetimenu">
				<table class="col-sm-12">
					<tr class="row-div etel-header-row">
						<th class="col-sm-4"><p>Leves</p></th>
						<th class="col-sm-4"><p>Főétel</p></th>
						<th class="col-sm-4"><p>Köret</p></th>
					</tr>
					<tr style="height: 100px;">
						<td class="col-sm-4"><p><#if hetimenu.napimenu.leves??>${hetimenu.napimenu.leves?keep_before("/")}</#if></p></td>
						<td class="col-sm-4"><p><#if hetimenu.napimenu.foetel??>${hetimenu.napimenu.foetel?keep_before("/")}</#if></p></td>
						<td class="col-sm-4"><p><#if hetimenu.napimenu.koret??>${hetimenu.napimenu.koret?keep_before("/")}</#if></p></td>
					</tr>
				</table>
			</div>
			<div class="foldal-date" id="foldal-date-id-hetimenu">
				<p>${hetimenu.date}. ${hetimenu.dayName}</p>
			</div>
		</div>
	<#else>
		<div class="foldal-main-div col-xs-12">
			<h1>${Session.foldal_nincs}</h1>
		</div>
	</#if>
	<#list MainPageObject as mpo>
		<div class="foldal-main-div col-xs-12">
			<div class="row">
				<div class="foldal-cim col-xs-11" id="foldal-cim-id-${mpo?index}">
					<p>${mpo.cim}</p>
				</div>
				<div class="col-xs-1" onclick="foldalClick('foldal-leiras-id-${mpo?index}')">
					<p style="float: right; user-select: none;">&#9660;</p>
				</div>
			</div>
			<div class="foldal-leiras" id="foldal-leiras-id-${mpo?index}" style="<#if mpo.autoOpen == 0>display: none;</#if>">
				<p>${mpo.leiras}</p>
			</div>
			<div class="foldal-date" id="foldal-date-id-${mpo?index}">
				<p>Érvényesség: ${mpo.date} <#if mpo.dateTo != "0"> - ${mpo.dateTo} </#if></p>
			</div>
		</div>
	</#list>
</div>

<#include "footer.ftl">