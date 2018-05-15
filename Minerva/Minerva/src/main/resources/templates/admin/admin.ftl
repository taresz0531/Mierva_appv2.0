<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="admin-div">
		<center><h1>Adminisztrációs felület</h1></center>	
	</div>
	<div class="row">
		<div class="admin-menu-div col-sm-4 admin-div">
			<#list menus as m>
				<div class="dropdown">
					<h3 class="" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						 ${m.mainMenuName}
					</h3>
					<#list m.subMenus as sm>
						<div class="dropdown-menu admin-dropdawn row" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="${sm.url}">${sm.nev}</a>
						</div>
					</#list>
				</div>
			</#list>
		</div>
		<div class="admin-function-div col-sm-8">
			<#if pageName == "0">
				<div class="admin-div">
					<center><h1>Válasszon egy funkciót</h1></center>
				</div>
				<#else>
					<#include "${pageName}.ftl">
			</#if>
		</div>
	</div>
</div>

<#include "footer.ftl">