<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Új felhasználó létrehoz</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
<form action="userUj" method="post">
	<div class="row">
		<div class="col-xs-6">
			<label for="nev">Felhasználó teljes neve:</label>
			<input type="text" class="form-control" id="nev" name="nev" required placeholder="Új felhasználó neve"/>
		</div>
		<div class="col-xs-6">
			<label for="email">Felhasználó e-mail címe:</label>
			<input type="email" class="form-control" id="email" name="email" required placeholder="Új felhasználó e-mail címe"/>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
		<label for="menus"><h2>Felhasználó funkciói:</h2></label>
		<#list newUserMenus as m>
				<h3 style="border-bottom: 1px solid white;">${m.mainMenuName}</h3>
				<#list m.subMenus as sm>
						<div class="row">
							 <div class="col-xs-6">
								<label for="menus">${sm.nev}</label>
							  </div>
				  				<div class="col-xs-2">
				  					<input type="checkbox" id="menus" name="menus" value="${sm.code}" class="form-control" />      
				  				</div> 
						</div>
				</#list>
		</#list>
		<center><input style="margin-top: 20px;" type="submit" class="btn" value="Mentés"/></center>
		</div>
	</div>
</form>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">