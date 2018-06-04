<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="admin-div">
		<center><h1>Bejelentkezés</h1></center>	
	
		<form class="form-horizontal" action="login" method="post">
			<div class="form-group row row-div">
				<label class="col-sm-3 control-label" for="fnev">Felhasználó név:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="fnev" name="fnev" required="true" placeholder="Felhasználó név" />
				</div>
				<div class="col-sm-3">
				</div>
			</div>
			<div class="form-group row row-div">
				<label class="col-sm-3 control-label" for="jelszo">Jelszó:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="jelszo" name="jelszo" required="true">
				</div>
				<div class="col-sm-3">
				</div>
			</div>
			<center><input class="btn" type="submit" value="Bejelentkez" /></center>
		</form>
	</div>
</div>

<#include "footer.ftl">