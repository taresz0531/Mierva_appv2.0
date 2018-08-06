<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<div class="guest-div">
		<center><h1>${Session.ajan_cim}</h1></center>	
	</div>
	<div class="guest-div">
		<form class="form-horizontal" action="ajanlat" method="post">
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="nev">${Session.ajan_nev}</label>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="nev" name="nev" required="true">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="email">${Session.ajan_tel}</label>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="email" name="email" required="true">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="szszam">${Session.ajan_szemely}</label>
				  <div class="col-sm-3">
					<input type="number" class="form-control" id="szszam" name="szszam" required="true">
				  </div>
				  <label class="col-sm-2 control-label" for="szoba">${Session.ajan_szoba}</label>
				  <div class="col-sm-3">
					<select name="szoba" id="szoba" class="form-control">
						<option value="Mindegy">${Session.ajan_mind}</option>
						<option value="Egy ágyas">${Session.ajan_egy}</option>
						<option value="Két ágyas">${Session.ajan_ketto}</option>
						<option value="Három ágyas">${Session.ajan_harom}</option>
						<option value="Négy ágyas">${Session.ajan_negy}</option>
						<option value="Apartman">${Session.ajan_apart}</option>
					</select>
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="tol">${Session.ajan_erkez}</label>
				  <div class="col-sm-3">
					<input type="date" class="form-control" id="tol" name="tol" required="true">
				  </div>
				  <label class="col-sm-2 control-label" for="ig">${Session.ajan_tavoz}</label>
				  <div class="col-sm-3">
					<input type="date" class="form-control" id="ig" name="ig" required="true">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="reggeli">${Session.ajan_reggel}</label>
				  <div class="col-sm-8">
					<label for="reggeli" class="btn active">${Session.ajan_kerek}</label>
	  				<input type="checkbox" id="reggeli" name="reggeli" autocomplete="off" />       
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="megjegyzes">${Session.ajan_megj}</label>
				  <div class="col-sm-8">
					<textarea type="text" class="form-control" id="megjegyzes" name="megjegyzes" cols="35" rows="3"></textarea>
				  </div>
			</div>
			<center><input class="btn" type="submit" value="${Session.ajan_kuld}" /></center>
		</form>
	</div>
</div>

<#include "footer.ftl">