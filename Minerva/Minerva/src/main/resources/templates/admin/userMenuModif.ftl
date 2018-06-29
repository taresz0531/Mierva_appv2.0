<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Felhasználó funkcióinak módosítása</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<div class="row">
		<div class="col-xs-12">
			<label for="users">Felhasználók:</label>
			<select id="users" class="form-control" onchange="selsecUser()">
				<option value="-1">Kérem vállasszon egy felhasználót!</option>
				<#list users as u>
					<option value="${u.menu}#${u.permission}#${u.id}">${u.nev} (${u.email})</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="row" id="function" style="display: none;">
	<form action="userMenuModif" method="post">
	<input type="hidden" id="id" name="id"/>
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
					  					<input type="checkbox" id="${sm.code}" name="menus" value="${sm.code}" class="form-control" />      
					  				</div> 
							</div>
					</#list>
			</#list>
			</div>
	</div>
	<div class="row" id="function2" style="display: none;" style="margin-top: 20px;">
		<div class="col-xs-12">
		<label for="menus"><h2>Felhasználó jogok:</h2></label>
			<#list permission as perm>
				<h3 style="border-bottom: 1px solid white;">${perm.mainMenu}</h3>
					<#list perm.permMenu as pm>
						<h4 style="margin-left: 20px;">${pm.subMenuName}</h4>
							<#list pm.perm as p>
								<div class="row" style="margin-left: 40px;">
									<div class="col-xs-8">
										<label for="menus" style="font-size: 12px;">${p.description}</label>
									</div>
					  				<div class="col-xs-2">
					  					<input type="checkbox" id="perm_${p.id}" name="perms" value="${p.id}" class="form-control" />      
					  				</div> 
								</div>
							</#list>
					</#list>
			</#list>
		</div>
		<center><input style="margin-top: 20px;" type="submit" class="btn" value="Mentés"/></center>
	</div>
</form>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">