<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Salyát adatok módosítása</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<form action="userModif" method="post">
		<div class="row">
			<div class="col-xs-12">
				<label for="fnev">Felhasználó név:</label>
				<input type="text" class="form-control" value="${user.fnev}" id="fnev" name="fnev" required>	
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<label for="pw">Aktuális jelszó:</label>
				<input type="password" class="form-control" id="pw" name="pw" required>	
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<label for="pw_new_1">Új jelszó:</label>
				<input type="password" class="form-control" id="pw_new_1" name="pw_new_1">	
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<label for="pw_new_2">Új jelszó mégegyszer:</label>
				<input type="password" class="form-control" id="pw_new_2" name="pw_new_2">
			</div>
		</div>
		<center><input type="submit" value="Mentés" class="btn" style="margin-top: 10px;"/></center>
	</form>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">