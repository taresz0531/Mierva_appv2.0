<meta charset="utf-8">
<div id="header">
	<#include "header.ftl">
</div>
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Olvasott ajánlatok</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<div class="row">
		<div class="col-xs-11">
			<h2>Lejárt ajánlatok</h2>
		</div>
		<div class="col-xs-1" onclick="ajanlatOldClick()">
			<p style="float: right; user-select: none;">&#9660;</p>
		</div>
	</div>
</div>
<div id="old" style="display: none;">
	<#list old as a>
		<div class="admin-div">
		<form action="ajanlatDelet" method="post" id="form${a.id}">
			<input type="hidden" id="id" name="id" value="${a.id}"/>
			<input type="hidden" id="name_${a.id}" name="name_${a.id}" value="${a.nev}"/>
			<input type="hidden" id="emailCim_${a.id}" name="emailCim_${a.id}" value="${a.email}"/>
			<h2>${a.nev} ajanlatot kér</h2>
			<p>Időtartam: ${a.tol} - ${a.ig}</p>
			<p>Személyek száma: ${a.szszam}</p>
			<p>Szoba típus: ${a.szoba}</p>
			<p>Reggelit kér: <#if a.reggeli = "n">Nem<#else>Igen</#if></p>
			<p>Elérhetőség: <#if a.mobil = "xxxx">${a.email}<#else>${a.mobil}</#if></p>
			<#if a.megjegyzes?? && a.megjegyzes!="" ><p>Megjegyzés: ${a.megjegyzes}</p></#if>
			<div style="border: 1px solid white; border-radius: 5px; padding: 10px; margin-bottom: 10px;">
				<p>Válasz: ${a.valasz}</p>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<input type="submit" class="form-control btn" value="Törlés">
				</div>
				<div class="col-xs-4">
					<#if a.mobil = "xxxx">
						<button type="button" class="form-control btn" onclick="emailKuldes('form${a.id}')">Email küld</button>
					</#if>
				</div>
			</div>
		</form>
		</div>
	</#list>
</div>
<div class="admin-div">
	<div class="row">
		<div class="col-xs-11">
			<h2>Megválaszolt ajánlatok</h2>
		</div>
		<div class="col-xs-1" onclick="ajanlatReadClick()">
			<p style="float: right; user-select: none;">&#9660;</p>
		</div>
	</div>
</div>
<div id="read" style="display: none;">
	<#list read as a>
		<div class="admin-div">
		<form action="#" method="post" id="form${a.id}">
			<input type="hidden" id="id" name="id" value="${a.id}"/>
			<input type="hidden" id="name_${a.id}" name="name_${a.id}" value="${a.nev}"/>
			<input type="hidden" id="emailCim_${a.id}" name="emailCim_${a.id}" value="${a.email}"/>	
			<h2>${a.nev} ajanlatot kér</h2>
			<p>Időtartam: ${a.tol} - ${a.ig}</p>
			<p>Személyek száma: ${a.szszam}</p>
			<p>Szoba típus: ${a.szoba}</p>
			<p>Reggelit kér: <#if a.reggeli = "n">Nem<#else>Igen</#if></p>
			<p>Elérhetőség: <#if a.mobil = "xxxx">${a.email}<#else>${a.mobil}</#if></p>
			<#if a.megjegyzes?? && a.megjegyzes!="" ><p>Megjegyzés: ${a.megjegyzes}</p></#if>
			<div style="border: 1px solid white; border-radius: 5px; padding: 10px; margin-bottom: 10px;">
				<p>Válasz: ${a.valasz}</p>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<input type="submit" class="form-control btn" value="Törlés" onclick="javascript: form.action='ajanlatDelet';">
				</div>
				<div class="col-xs-4">
					<#if a.autodelet == 0>
						<input type="submit" class="form-control btn" value="Autómata törlés be" onclick="javascript: form.action='ajanlatAutoDelet';">
					<#else>
						<input type="submit" class="form-control btn" value="Autómata törlés ki" onclick="javascript: form.action='ajanlatAutoDelet';">
					</#if>
				</div>
				<div class="col-xs-4">
					<#if a.mobil = "xxxx">
						<button type="button" class="form-control btn" onclick="emailKuldes('form${a.id}')">Email küld</button>
					</#if>
				</div>
			</div>
		</form>
		</div>
	</#list>
	
</div>
<div class="foldal-modosit-popup" id="ajanlat-valasz-popup">
		<form role="form" action="valaszOlvasott" method="post" name="popup-form">
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="emailCim" name="emailCim"/>
			
			<h2 id="name"></h2>
			<br/>
		   <textarea required class="form-control" id="leiras" name="leiras" rows="6" ></textarea>
			<!-- Initialize the editor. -->
		    <script>
				  $(function() {
				    $('textarea#leiras').froalaEditor({
				      height: 300,
				      language: 'hu',
				      direction: 'ltr',
				      toolbarButtons: ['fullscreen', 'bold', 'italic', 'underline', 'strikeThrough', 'subscript', 'superscript', 'fontFamily', 'fontSize', '|', 'color', 'paragraphStyle', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', '-', 'insertLink', 'insertImage', 'insertTable', '|', 'quote', 'insertHR', 'undo', 'redo', 'clearFormatting', 'selectAll', 'html']
				    })
				  });
				  $(function() { $('textarea').froalaEditor() });
			</script>
			<div class="row" style="margin-top: 10px;">
				<div class="form-group col-sm-4">
			  		<button type="button" class="btn form-control" style="margin-right: 10px;"onclick="submitForm('ajanlat-valasz-popup')">Küldés</button>
			  	</div>
			  	<div class="form-group col-sm-4">
			  		<button type="button" class="btn form-control" onclick="closeDiv('ajanlat-valasz-popup')">Mégsem</button>
			  	</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	$('#ajanlat-valasz-popup').hover(function() {
	    $('html').css('overflow', 'hidden');
	}, function() {
	    $('html').css('overflow', 'auto');
	});
	</script>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">