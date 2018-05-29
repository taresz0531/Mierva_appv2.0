<meta charset="utf-8">
<div id="header">
	<#include "header.ftl">
</div>
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Bookingos szobák kezelése</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<#function getRoom dd bookingList>
	<#list bookingList as b>
		<#if b.date?string('yyyy-MM-dd') == dd.date?string('yyyy-MM-dd')>
			<#return b>
		</#if>
	</#list>
	<#return "0">
</#function>
		
<div class="admin-div">
	<#list weekDays as d>
		<#global rooms = getRoom(d, bookingRooms)>
		<#if rooms == "0">
			<#global bookId = 0>
			<#global bed1 = 0>
			<#global bed2 = 0>
			<#global bed3 = 0>
			<#global bed4 = 0>
			<#global bedAttic = 0>
		<#else>
			<#global bookId = rooms.id>
			<#global bed1 = rooms.bed1>
			<#global bed2 = rooms.bed2>
			<#global bed3 = rooms.bed3>
			<#global bed4 = rooms.bed4>
			<#global bedAttic = rooms.bedAttic2>
		</#if>
		<div> 
			<h2>${d.name} (${d.date?string('yyyy-MM-dd')})</h2>
		</div>
		<div>
			<table>
				<tr>
					<th><p>1 ágyas</p></th>
					<th><p>2 ágyas</p></th>
					<th><p>3 ágyas</p></th>
					<th><p>4 ágyas</p></th>
					<th><p>tetőtéri 2</p></th>
				</tr>
				<tr>
					<form action="bookingBookSave" method="post">
						<input type="hidden" value="${bookId}"/>
						<td><input type="number" class="form-control" value="${bed1}" /></td>
						<td><input type="number" class="form-control" value="${bed2}" /></td>
						<td><input type="number" class="form-control" value="${bed3}" /></td>
						<td><input type="number" class="form-control" value="${bed4}" /></td>
						<td><input type="number" class="form-control" value="${bedAttic}" /></td>
						<td><input type="submit" class="btn" value="Mentés"/></td>
					</form>
				</tr>
			</table>
		</div>
	</#list>
</div>

<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">