<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>Ajánlatkérés</h1></center>	
	</div>
	<div class="guest-div">
		<form class="form-horizontal" action="ajanlat" method="post">
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="nev">Teljes név:</label>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="nev" name="nev" required="true">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="email">Elérhetőség(tel. vagy e-mail):</label>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="email" name="email" required="true">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="szszam">Személyek száma:</label>
				  <div class="col-sm-3">
					<input type="number" class="form-control" id="szszam" name="szszam" required="true">
				  </div>
				  <label class="col-sm-2 control-label" for="szoba">Szoba típusa:</label>
				  <div class="col-sm-3">
					<select name="szoba" id="szoba" class="form-control">
						<option value="Mindegy">Mindegy</option>
						<option value="Egy ágyas">Egy ágyas</option>
						<option value="Két ágyas">Két ágyas</option>
						<option value="Három ágyas">Három ágyas</option>
						<option value="Négy ágyas">Négy ágyas</option>
						<option value="Francia ágyas">Francia ágyas</option>
						<option value="Apartman">Apartman</option>
					</select>
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="tol">Érkezés:</label>
				  <div class="col-sm-3">
					<input type="date" class="form-control" id="tol" name="tol" required="true">
				  </div>
				  <label class="col-sm-2 control-label" for="ig">Távozás:</label>
				  <div class="col-sm-3">
					<input type="date" class="form-control" id="ig" name="ig" required="true">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="reggeli">Reggeli:</label>
				  <div class="col-sm-8">
					<label for="reggeli" class="btn active">Kérek</label>
	  				<input type="checkbox" id="reggeli" name="reggeli" autocomplete="off" />       
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="megjegyzes">Megjegyzés:</label>
				  <div class="col-sm-8">
					<textarea type="text" class="form-control" id="megjegyzes" name="megjegyzes" cols="35" rows="3"></textarea>
				  </div>
			</div>
			<center><input class="btn" type="submit" value="Küldés" /></center>
		</form>
	</div>
</div>

<#include "footer.ftl">