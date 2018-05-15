<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Felhaszáló inaktiválása/aktiválása</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
<#list users as u>
<form action="userDelet" method="post">
	<input type="hidden" name="id" id="id" value="${u.id}"/>
	<div class="row">
		<div class="col-xs-8">
			<input disabled type="text" class="form-control" id="nev" name="nev" value="${u.nev}"/>
		</div>
		<div class="col-xs-4">
			<input type="submit" class="form-control btn" <#if u.stat = "R">disabled</#if>  <#if u.stat = "A">value="Tiltás"<#elseif u.stat = "D">value="Engedélyez"<#else>value="Nem aktivált"</#if> />
		</div>
	</div>
</form>
</#list>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">