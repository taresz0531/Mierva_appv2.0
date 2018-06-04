<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Kép töröl</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<#list galeria as g>
		<form role="form" action="galeriaTorol" method="post">
			<div class="row">
				<input type="hidden" id="id" name="id" value="${g.id}"/>
				<div class="form-group col-xs-4">
					<p>${g.leiras}</p>
				</div>
				<div class="form-group col-xs-6">
					<img class="image-class" style="max-height: 150px;" src="getImage?fileId=${g.id}&who=g" id="${g.id}">
				</div>
				<div class="form-group col-xs-2">
					<center><input  required="true" type="submit" class="btn"value="Törlés"></center>
				</div>
			</div>
		</form>
	</#list>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">