		<div class="col-sm-4 admin-div">
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