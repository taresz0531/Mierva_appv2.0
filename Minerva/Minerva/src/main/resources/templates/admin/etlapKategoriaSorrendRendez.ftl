<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Új étel hozzáadása</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
<#if katList??>
<form method="post" action="etlapKategoriaSorrendRendez">
	<table id="sorrendTable">
		<tr style="border-bottom: 2px solid white;">
			<th class="col-xs-10"><h2>Kategória neve</h2></th>
			<th class="col-xs-1"><h2>Fel</h2></th>
			<th class="col-xs-1"><h2>Le</h2></th>
		</tr>
		<#list katList as r>
			<tr style="border-bottom: 1px solid white;">
				<td hidden><input type="text"  id="id" name="id" value="${r.id}"/></td>
				<td class="col-xs-10"><p>${r.nev}</p></td>
				<td class="col-xs-1"><center><input type="button" value="&#9650" class="move up" /></center></td>
				<td class="col-xs-1"><center><input type="button" value="&#9660" class="move down" /></center></td>
			</tr>			
		</#list>
	</table>
	<center><input class="btn" type="submit" value="Mentés" style="margin-top: 15px;"/></center>
</form>
	<script type="text/javascript">
		$('#sorrendTable input.move').click(function() {
	    var row = $(this).closest('tr');
	    if ($(this).hasClass('up'))
	        row.prev().before(row);
	    else
	        row.next().after(row);
		});
	</script>
</#if>
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">