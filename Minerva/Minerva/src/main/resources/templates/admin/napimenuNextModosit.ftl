<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Jövőheti napimenü módosít</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<form method="post" action="napimenuNextModosit">
<#list hetiMenu as m>
	<div class="admin-div">
	<h1>${m.nap}</h1>
	<!-- Leves -->
		<div class="row">
			<div class="form-group col-xs-4">
				<label for="leves_hu_${m.nap}"><p>Leves magyar:</p></label>
				<input type="text" class="form-control" id="leves_hu_${m.nap}" name="leves_hu" value="<#if m.leves??>${m.leves?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="leves_en_${m.nap}"><p>Leves angol:</p></label>
				<input type="text" class="form-control" id="leves_en_${m.nap}" name="leves_en" value="<#if m.leves??>${m.leves?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="etlaprol_leves_${m.nap}"><p>Etlapról:</p></label>
				<select id="etlaprol_leves_${m.nap}" class="selectpicker form-control" onchange="select('leves','${m.nap}')">
					  <optgroup label="">
						    <option></option>
					  </optgroup>
					<#list etelek as e>
						  <optgroup label="${e.nev?keep_before("/")}">
							  	<#list e.etelek as ee>
							    	<option>${ee.nev?keep_before("/")}</option>
							    	<option hidden>${ee.nev?keep_after("/")}</option>
							    </#list>
						  </optgroup>
					</#list>
				</select>
			</div>
		</div>
		<!-- Főétel -->
		<div class="row">
			<div class="form-group col-xs-4">
				<label for="foetel_hu_${m.nap}"><p>Főétel magyar:</p></label>
				<input type="text" class="form-control" id="foetel_hu_${m.nap}" name="foetel_hu" value="<#if m.foetel??>${m.foetel?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="foetel_en_${m.nap}"><p>Főétel angol:</p></label>
				<input type="text" class="form-control" id="foetel_en_${m.nap}" name="foetel_en" value="<#if m.foetel??>${m.foetel?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="etlaprol_foetel_${m.nap}"><p>Etlapról:</p></label>
				<select id="etlaprol_foetel_${m.nap}" class="selectpicker form-control" onchange="select('foetel','${m.nap}')">
					<optgroup label="">
						    <option></option>
					</optgroup>
					<#list etelek as e>
						  <optgroup label="${e.nev?keep_before("/")}">
							  	<#list e.etelek as ee>
							    	<option>${ee.nev?keep_before("/")}</option>
							    	<option hidden>${ee.nev?keep_after("/")}</option>
							    </#list>
						  </optgroup>
					</#list>
				</select>
			</div>
		</div>
		<!-- köret -->
		<div class="row">
			<div class="form-group col-xs-4">
				<label for="koret_hu_${m.nap}"><p>Köret magyar:</p></label>
				<input type="text" class="form-control" id="koret_hu_${m.nap}" name="koret_hu" value="<#if m.koret??>${m.koret?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="koret_en_${m.nap}"><p>Köret angol:</p></label>
				<input type="text" class="form-control" id="koret_en_${m.nap}" name="koret_en" value="<#if m.koret??>${m.koret?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="etlaprol_koret_${m.nap}"><p>Etlapról:</p></label>
				<select id="etlaprol_koret_${m.nap}" class="selectpicker form-control" onchange="select('koret','${m.nap}')">
					<optgroup label="">
						    <option></option>
					  </optgroup>
					<#list etelek as e>
						  <optgroup label="${e.nev?keep_before("/")}">
							  	<#list e.etelek as ee>
							    	<option>${ee.nev?keep_before("/")}</option>
							    	<option hidden>${ee.nev?keep_after("/")}</option>
							    </#list>
						  </optgroup>
					</#list>
				</select>
			</div>
		</div>
	</div>
</#list>
<div class="admin-div">
	<center>
		<div class="btn-group" role="group" aria-label="...">
			<input type="submit" class="btn btn-default" value="Mentés" onclick="javascript: form.action='napimenuNextModosit'; form.target=''"/>
			<input type="submit" class="btn btn-default" value="Nyomtatás" onclick="javascript: form.action='printNapimenuNext'; form.target='_blank'"/>
		</div>
	</center>
</div>
</form>
<!-- <div> -->
<!-- 	<form action="/printNapimenu" method="post"> -->
<!-- 		<input type="submit" value="Nyomtatás"> -->
<!-- 	</form> -->
<!-- </div> -->
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">