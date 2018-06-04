<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Új étel hozzáadása</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<form role="form" action="etlapUj" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="nev_hu"><p>Név magyarul:</p></label>
				<input required="true" type="text" class="form-control" id="nev_hu" name="nev_hu" value="<#if result??>${result.nev?keep_before("/")}</#if>" placeholder="Név magyar">
			</div>
			<div class="form-group col-xs-6">
				<label for="nev_eng"><p>Név angolul:</p></label>
				<input required="true" type="text" class="form-control" id="nev_en" name="nev_en" value="<#if result??>${result.nev?keep_after("/")}</#if>" placeholder="Név angol">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="leiras_hu"><p>Allergének magyarul:</p></label>
				<input type="text" class="form-control" id="leiras_hu" name="leiras_hu" value="<#if result??>${result.leiras?keep_before("/")}</#if>" placeholder="Leírás magyar">
			</div>
			<div class="form-group col-xs-6">
				<label for="leiras_eng"><p>Allergének angolul:</p></label>
				<input type="text" class="form-control" id="leiras_en" name="leiras_en" value="<#if result??>${result.leiras?keep_after("/")}</#if>" placeholder="Leírás angol">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-6">
				<label for="kategoria"><p>Kategória:</p></label>
				<select id="kategoria" name="kategoria" class="form-control" value="<#if result??>${result.kategoria}</#if>">
					<#list kategoria as k>
						<option value="${k.id}"><p>${k.nev}</p></option>
					</#list>
				</select>
			</div>
			<div class="form-group col-xs-6">
				<label for="ar"><p>Ár:</p></label>
				<input  required="true" type="number" class="form-control" id="ar" name="ar" value="<#if result??>${result.ar}</#if>" placeholder="100">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-12">
				<label for="kep"><p>Kép:</p></label>
				<input type="file" class="form-control" id="kep" name="kep">
			</div>
		</div>
		<div class="row">
			<center><input  required="true" type="submit" class="btn"value="Mentés"></center>
		</div>
	   </form>
</div>

<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">