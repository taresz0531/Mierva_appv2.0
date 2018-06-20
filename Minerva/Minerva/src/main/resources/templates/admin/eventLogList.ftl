<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Eseménynapló</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<#assign currentDate = .now?date?string('yyyy-MM-dd')>
<#assign currentTime = .now?time?string('hh:mm')>
<#function getPreDate>
	<#list currentDate?split("-") as da>
		<#if da?index == 0>
			<#assign y = da>
		<#elseif da?index == 1>
			<#assign m = da>
		<#else>
			<#assign d = da>
		</#if>
	</#list>
	<#if m?number != 1>
		<#assign m = m?number - 1>
	<#else>
		<#assign y = y?number -1>
		<#assign m = 12>
	</#if>

	<#if m?number < 10>
		<#assign m = "0" + m>
	</#if>
	
	<#return "" + y + "-" + m + "-" + d + "T" + currentTime>
</#function>
<div class="admin-div">
	<div class="row">
		<div class="col-xs-6">
			<label for="dateFrom">Dátum tól:</label>
			<input type="datetime-local" class="form-control" id="dateFrom" name="dateFrom" value="${getPreDate()}"/>
		</div>
		<div class="col-xs-6">
			<label for="dateTo">Dátum ig:</label>
			<input type="datetime-local" class="form-control" id="dateTo" name="dateTo" value="${currentDate}T${currentTime}"/>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<center>
				<label for="user">Felhasználó:</label>
				<select id="user" name="user" class="form-control">
					<option value="-1"></option>
				<#list users as u>
					<option value="${u.id}">${u.name}</option>
				</#list>
				</select>
			</center>
		</div>
	</div>
	<div class="row">
		<center><input style="margin-top: 10px;" type="button" class="btn" value="Listáz" onclick="searchEvent()"/></center>
	</div>
</div>

<div class="admin-div" id="eventListDiv" style="display: none;">
	<table id="listTable">
		<tr>
			<th class="col-xs-1"><p>Id</p></th>
			<th class="col-xs-3"><p>Név</p></th>
			<th class="col-xs-3"><p>Dátum</p></th>
			<th class="col-xs-5"><p>Esemény</p></th>
		</tr>
	</table>
</div>

<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">