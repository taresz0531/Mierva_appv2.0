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
					<input type="text" class="form-control" id="nev" name="nev" required="true" value="<#if ajanlat.nev??>${ajanlat.nev}</#if>">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="email">${Session.ajan_tel}</label>
				  <div class="col-sm-8">
					<input type="text" class="form-control" id="email" name="email" required="true" value="<#if ajanlat.email?? && ajanlat.email != "xxxx">${ajanlat.email}<#else><#if ajanlat.mobil?? && ajanlat.mobil != "xxxx">${ajanlat.mobil}</#if></#if>">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="szszam">${Session.ajan_szemely}</label>
				  <div class="col-sm-3">
					<input type="number" class="form-control" id="szszam" name="szszam" required="true" value="<#if ajanlat.szszam??>${ajanlat.szszam}</#if>">
				  </div>
				  <label class="col-sm-2 control-label" for="szoba">${Session.ajan_szoba}</label>
				  <div class="col-sm-3">
					<select name="szoba" id="szoba" class="form-control">
						<option value="Mindegy" <#if ajanlat.szoba?? && ajanlat.szoba = 'Mindegy'>selected</#if>>${Session.ajan_mind}</option>
						<option value="Egy ágyas" <#if ajanlat.szoba?? && ajanlat.szoba = 'Egy ágyas'>selected</#if>>${Session.ajan_egy}</option>
						<option value="Két ágyas" <#if ajanlat.szoba?? && ajanlat.szoba = 'Két ágyas'>selected</#if>>${Session.ajan_ketto}</option>
						<option value="Három ágyas" <#if ajanlat.szoba?? && ajanlat.szoba = 'Három ágyas'>selected</#if>>${Session.ajan_harom}</option>
						<option value="Négy ágyas" <#if ajanlat.szoba?? && ajanlat.szoba = 'Négy ágyas'>selected</#if>>${Session.ajan_negy}</option>
						<option value="Apartman" <#if ajanlat.szoba?? && ajanlat.szoba = 'Apartman'>selected</#if>>${Session.ajan_apart}</option>
					</select>
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="tol">${Session.ajan_erkez}</label>
				  <div class="col-sm-3">
					<input type="date" class="form-control" id="tol" name="tol" required="true" value="<#if ajanlat.tol??>${ajanlat.tol?string('yyyy-MM-dd')}</#if>">
				  </div>
				  <label class="col-sm-2 control-label" for="ig">${Session.ajan_tavoz}</label>
				  <div class="col-sm-3">
					<input type="date" class="form-control" id="ig" name="ig" required="true" value="<#if ajanlat.ig??>${ajanlat.ig?string('yyyy-MM-dd')}</#if>">
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="reggeli">${Session.ajan_reggel}</label>
				  <div class="col-sm-8">
					<label for="reggeli" style="font-size: 12px;">${Session.ajan_kerek}</label>
	  				<input type="checkbox" id="reggeli" name="reggeli" autocomplete="off" <#if ajanlat.reggeli?? && ajanlat.reggeli != "n">checked="checked"</#if>/>       
				  </div>
			</div>
			<div class="form-group row row-div">
				  <label class="col-sm-4 control-label" for="megjegyzes">${Session.ajan_megj}</label>
				  <div class="col-sm-8">
					<textarea type="text" class="form-control" id="megjegyzes" name="megjegyzes" cols="35" rows="3"><#if ajanlat.megjegyzes??>${ajanlat.megjegyzes}</#if></textarea>
				  </div>
			</div>
			<div class="form-group row row-div">
			<div class="col-sm-4"></div>
				  <div class="col-sm-8">
					<label class="col-sm-11" for="reggeli" style="font-size: 10px;">${Session.ajan_adatvedelem1}<a target="_blank" style="text-decoration: underline; color: #0066cc;" href="doc/Adatvedelmi_szabalyzat.pdf" >${Session.ajan_adatvedelem2}</a>${Session.ajan_adatvedelem3}</label>
	  				<input class="col-sm-1" type="checkbox" id="adat" name="adat" autocomplete="off" required/>       
				  </div>
			</div>
			<div class="form-group row row-div">
				<div class="col-sm-4"></div>
				 <div class="col-sm-8">
					<div class="g-recaptcha" data-sitekey="6LcR-3AUAAAAADYvzE6nuUJj3gDrLiDYuZmRgQoj"></div>
				</div>
			</div>
			<center><input class="btn" type="submit" value="${Session.ajan_kuld}" /></center>
		</form>
	</div>
</div>

<#include "footer.ftl">