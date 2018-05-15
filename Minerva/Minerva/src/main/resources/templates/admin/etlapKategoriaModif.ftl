<meta charset="utf-8">
<div id="header">
	<#include "header.ftl">
</div>
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Étlap Katgória módosít</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
<#if katList??>
	<#list katList as r>
		<div class="row" style="margin-bottom: 10px; padding-left: 20px;">
			<form role="form" action="etlapKategoriaModif" method="post" id="form${r.id}">
				<input type="hidden" id="id" name="id" value="${r.id}"/>
				<input type="hidden" id="nev_hu" name="nev_hu" value="${r.nev?keep_before("/")}">
				<input type="hidden" id="nev_en" name="nev_en" value="${r.nev?keep_after("/")}">
			  	<input type="text" class="col-xs-6 form-control" id="nev_teljes" name="nev_teljes" value="${r.nev}" disabled style="max-width: 280px; margin-right: 5px;"/>
			  	<button type="button" class="btn col-xs-2" style="max-width: 80px; margin-right: 5px;" onclick="etlapKategoriaModosit('form${r.id}')">Módosít</button>
			  	<input type="submit" class="btn col-xs-2" <#if r.stat == "A">value="Inaktivál"<#else>value="Aktivál"</#if> style="max-width: 80px; margin-right: 5px;" onclick="javascript: form.action='/etlapKategoriaChangeStat';">
			  	<input type="submit" class="btn col-xs-2" value="Töröl" style="max-width: 80px; margin-right: 5px;" onclick="javascript: form.action='/etlapKategoriaDelet';">
			</form>
		</div>
	</#list>
</#if>
<div class="foldal-modosit-popup" id="etlap-kategoria-modosit-popup">
	<form role="form" action="etlapKategoriaModif" method="post" name="popup-form">
	<input type="hidden" id="id" name="id"/>
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="nev_hu"><p>Név magyarul:</p></label>
				<input required="true" type="text" class="form-control" id="nev_hu" name="nev_hu" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-6">
				<label for="nev_eng"><p>Név angolul:</p></label>
				<input required="true" type="text" class="form-control" id="nev_en" name="nev_en" value="<#if result??>${result.nev?keep_after("/")}</#if>">
			</div>
		</div>
		<center><button type="button" class="btn btn-default col-xs-1" style="margin-right: 10px;" id="submit-btn-foldal" onclick="submitForm('etlap-kategoria-modosit-popup')">Módosít</button>
		<button type="button" class="btn btn-default col-xs-1" id="cancel-btn-foldal" onclick="closeDiv('etlap-kategoria-modosit-popup')">Mégsem</button></center>
	</form>
</div>
<script type="text/javascript">
	$('#etlap-kategoria-modosit-popup').hover(function() {
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