<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Jövőheti napi menük</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<form method="post" action="napiMenuUj">
<#list days as d>
	<div class="admin-div">
	<h1>${d}</h1>
	<!-- Leves -->
		<div class="row">
			<div class="form-group col-xs-4">
				<label for="leves_hu_${d}"><p>Leves magya:</p></label>
				<input type="text" class="form-control" id="leves_hu_${d}" name="leves_hu" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="leves_en_${d}"><p>Leves angol:</p></label>
				<input type="text" class="form-control" id="leves_en_${d}" name="leves_en" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="etlaprol_leves_${d}"><p>Etlapról:</p></label>
				<select id="etlaprol_leves_${d}" class="selectpicker form-control" onchange="select('leves','${d}')">
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
				<label for="foetel_hu_${d}"><p>Főétel magya:</p></label>
				<input type="text" class="form-control" id="foetel_hu_${d}" name="foetel_hu" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="foetel_en_${d}"><p>Főétel angol:</p></label>
				<input type="text" class="form-control" id="foetel_en_${d}" name="foetel_en" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="etlaprol_foetel_${d}"><p>Etlapról:</p></label>
				<select id="etlaprol_foetel_${d}" class="selectpicker form-control" onchange="select('foetel','${d}')">
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
				<label for="koret_hu_${d}"><p>Köret magya:</p></label>
				<input type="text" class="form-control" id="koret_hu_${d}" name="koret_hu" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="koret_en_${d}"><p>Köret angol:</p></label>
				<input type="text" class="form-control" id="koret_en_${d}" name="koret_en" value="<#if result??>${result.nev?keep_before("/")}</#if>">
			</div>
			<div class="form-group col-xs-4">
				<label for="etlaprol_koret_${d}"><p>Etlapról:</p></label>
				<select id="etlaprol_koret_${d}" class="selectpicker form-control" onchange="select('koret','${d}')">
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
	<center><input type="submit" class="btn" value="Mentés"/></center>
</div>
</form>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">