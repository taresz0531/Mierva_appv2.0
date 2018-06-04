<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="admin-div">
		<center><h1>Aktiváció</h1></center>	
	
		<form class="form-horizontal" action="actival" method="post">
			<input type="hidden" value="${activeUserId}" id="id" name="id"/>
			<div class="form-group row row-div">
				<label class="col-sm-3 control-label" for="fnev">Felhasználó név:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="fnev" name="fnev" required="true" placeholder="Felhasználó név" />
				</div>
				<div class="col-sm-3">
				</div>
			</div>
			<div class="form-group row row-div">
				<label class="col-sm-3 control-label" for="pw">Jelszó:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="pw" name="pw"elszo" required="true">
				</div>
				<div class="col-sm-3">
				</div>
			</div>
			<div class="form-group row row-div">
				<label class="col-sm-3 control-label" for="pw_re">Jelszó újra:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="pw_re" name="pw_re" required="true">
				</div>
				<div class="col-sm-3">
				</div>
			</div>
			<center><input class="btn" type="submit" value="Aktiválás" /></center>
		</form>
	</div>
</div>

<#include "footer.ftl">