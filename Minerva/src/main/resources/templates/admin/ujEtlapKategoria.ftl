<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Új ételkategória</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<form role="form" action="ujEtlapKategoria" method="post">
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
			<center><input  required="true" type="submit" class="btn"value="Mentés"></center>
		</div>
	</form>
</div>

<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">