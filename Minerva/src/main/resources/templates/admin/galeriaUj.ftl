<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Új kép feltöltés</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<form role="form" action="galeriaUj" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="form-group col-xs-12">
				<label for="leiras"><p>Leírás:</p></label>
				<input required="true" type="text" class="form-control" id="leiras" name="leiras" value="<#if result??>${result.leiras}</#if>" placeholder="Leírás">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-xs-12">
				<label for="kep"><p>Kép:</p></label>
				<input type="file" class="form-control" id="kep" name="kep">
			</div>
		</div>
		<div class="row">
			<center><input  required="true" type="submit" class="btn"value="Feltöltés"></center>
		</div>
	</form>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">