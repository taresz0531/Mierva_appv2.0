<meta charset="utf-8">
<div id="header">
	<#include "header.ftl">
</div>
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Étlap módosít</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
<#if etlapList??>
	<#list etlapList as r>
		<div class="row" style="margin-bottom: 10px; padding-left: 20px;">
			<form role="form" action="etlapModosit" method="post" id="form${r.id}">
				<input type="hidden" id="id" name="id" value="${r.id}"/>
				<input type="hidden" id="originalNev" name="originalNev" value="${r.nev}"/>
				<input type="hidden" id="nev_hu" name="nev_hu" value="${r.nev?keep_before("/")}">
				<input type="hidden" id="nev_en" name="nev_en" value="${r.nev?keep_after("/")}">
				<input type="hidden" id="leiras_hu" name="leiras_hu" value="${r.leiras?keep_before("/")}">
				<input type="hidden" id="leiras_en" name="leiras_en" value="${r.leiras?keep_after("/")}">
				<input type="hidden" id="kategoria" name="kategoria" value="${r.kategoria}"/>
				<input type="hidden" id="ar" name="ar" value="${r.ar}"/>
				<input type="hidden" id="stat" name="stat" value="${r.stat}"/>
				<input type="hidden" id="is_kep" name="is_kep" value="${r.is_kep}"/>
			  	<input type="text" class="col-xs-6 form-control" id="nev_teljes" name="nev_teljes" value="${r.nev}" disabled style="max-width: 280px; margin-right: 5px;"/>
			  	<button type="button" class="btn col-xs-2" style="max-width: 80px; margin-right: 5px;" onclick="etlapModosit('form${r.id}')">Módosít</button>
			  	<input type="submit" class="btn col-xs-2" <#if r.stat == "A">value="Inaktivál"<#else>value="Aktivál"</#if> style="max-width: 80px; margin-right: 5px;" onclick="javascript: form.action='etlapChangeStat';">
			  	<input type="submit" class="btn col-xs-2" value="Töröl" style="max-width: 80px; margin-right: 5px;" onclick="javascript: form.action='etlapDelet';">
			</form>
		</div>
	</#list>
</#if>
	<div class="foldal-modosit-popup" id="etlap-modosit-popup">
		<form role="form" action="etlapModosit" method="post" enctype="multipart/form-data"  name="popup-form">
		<input type="hidden" id="id" name="id"/>
		<input type="hidden" id="is_kep" name="is_kep"/>
		<input type="hidden" id="originalNev" name="originalNev"/>
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="nev_hu"><p>Név magyarul:</p></label>
				<input required="true" type="text" class="form-control" id="nev_hu" name="nev_hu" placeholder="Név magyar">
			</div>
			<div class="form-group col-xs-6">
				<label for="nev_eng"><p>Név angolul:</p></label>
				<input required="true" type="text" class="form-control" id="nev_en" name="nev_en" placeholder="Név angol">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="leiras_hu"><p>Allergének magyarul:</p></label>
				<input required="true" type="text" class="form-control" id="leiras_hu" name="leiras_hu" placeholder="Leírás magyar">
			</div>
			<div class="form-group col-xs-6">
				<label for="leiras_eng"><p>Allergének angolul:</p></label>
				<input required="true" type="text" class="form-control" id="leiras_en" name="leiras_en" placeholder="Leírás angol">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="kategoria"><p>Kategória:</p></label>
				<select id="kategoria" name="kategoria" class="form-control">
					<#list kategoria as k>
						<option value="${k.id}"><p>${k.nev}</p></option>
					</#list>
				</select>
			</div>
			<div class="form-group col-xs-6">
				<label for="ar"><p>Ár:</p></label>
				<input  required="true" type="number" class="form-control" id="ar" name="ar" placeholder="100">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-12">
				<label for="kep"><p>Kép:</p></label>
				<img src="#" class="etlap-img" id="etlap_kep" name="etlap_kep" style="display: none; margin-bottom: 10px;"/>
				<input type="file" class="form-control" id="kep" name="kep">
			</div>
		</div>
		<button type="button" class="btn btn-default col-xs-3" style="margin-right: 10px;" id="submit-btn-foldal" onclick="submitForm('etlap-modosit-popup')">Módosít</button>
		<button type="button" class="btn btn-default col-xs-3" id="cancel-btn-foldal" onclick="closeDiv('etlap-modosit-popup')">Mégsem</button>
	   </form>
	</div>
	<script type="text/javascript">
	$('#etlap-modosit-popup').hover(function() {
	    $('html').css('overflow', 'hidden');
	}, function() {
	    $('html').css('overflow', 'auto');
	});
	</script>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">