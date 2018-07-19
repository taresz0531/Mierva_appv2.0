<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Nyomtatványok</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
	<div class="row" style="margin: 10px;">
		<form action="/printNapimenuActual" method="post" target="_blank">
			<div class="col-xs-8">
				<label for="actualprint">Aktuális heti menü nyomtatása</label>
			</div>
			<div class="col-xs-4">
				<input  id="actualprint" type="submit" class="btn btn-default" value="Nyomtat" />
			</div>
		</form>
	</div>
	<div class="row" style="margin: 10px;">
		<form action="/printNapimenuNext" method="post" target="_blank">
			<div class="col-xs-8">
				<label for="actualprint">Jövő heti menü nyomtatása</label>
			</div>
			<div class="col-xs-4">
				<input  id="actualprint" type="submit" class="btn btn-default" value="Nyomtat"/>
			</div>
		</form>
	</div>
	<div class="row" style="margin: 10px;">
		<form action="/printBookingTable" method="post" target="_blank">
			<label style="margin-left: 12px;" for="actualprint">Foglalási nyilvántartó nyomtatása</label>
			<div class="col-xs-12 btn-group" role="group" aria-label="...">
				<input type="week" id="date" name="date" class="btn btn-default"/>
				<input  id="actualprint" type="submit" class="btn btn-default" value="Nyomtat"  style="height: 36"/>
			</div>
		</form>
	</div>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">