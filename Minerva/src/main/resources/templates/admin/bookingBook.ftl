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
			<#global date = monday?string('yyyy-MM-dd')>
		<#else>
			<#global bookId = rooms.id>
			<#global bed1 = rooms.bed1>
			<#global bed2 = rooms.bed2>
			<#global bed3 = rooms.bed3>
			<#global bed4 = rooms.bed4>
			<#global bedAttic = rooms.bedAttic2>
			<#global date = rooms.date?string('yyyy-MM-dd')>
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
						<input id="id" name="id" type="hidden" value="${bookId}"/>
						<td><input id="bed1" name="bed1"  type="number" class="form-control" value="${bed1}" /></td>
						<td><input id="bed2" name="bed2" type="number" class="form-control" value="${bed2}" /></td>
						<td><input id="bed3" name="bed3" type="number" class="form-control" value="${bed3}" /></td>
						<td><input id="bed4" name="bed4" type="number" class="form-control" value="${bed4}" /></td>
						<td><input id="bedAttic2" name="bedAttic2"  type="number" class="form-control" value="${bedAttic}" /></td>
						<input type="hidden" id="date" name="date" value="${date}" />
						<td><input type="submit" class="btn" value="Mentés"/></td>
					</form>
				</tr>
			</table>
		</div>
	</#list>
	<div>
		<div class="row">
			<div class="bookingBook-btn">
				<form action="/bookingBookPrev" method="post">
					<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
					<input type="submit" class="btn" value="Előző hét"/>
				</form>
			</div>
			<div class="bookingBook-btn">
				<form action="/bookingBook" method="get">
					<input type="submit" class="btn" value="Aktuális hét"/>
				</form>
			</div>
			<div class="bookingBook-btn">
				<form action="/bookingBookNext" method="post">
					<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
					<input type="submit" class="btn" value="Következő hét"/>
				</form>
			</div>
		</div>
		<div class="row">
			<div>
				<form action="/bookingBookWeek" method="post">
					<div class="bookingBook-btn">
						<input required type="week" id="date" name="date" class="form-control"/>
					</div>
					<div class="bookingBook-btn">
						<input type="submit" class="btn" value="Ugrás"/>
					</div>
				</form>
			</div>
			<div class="bookingBook-btn">
				<button class="btn" type="button">Mindet ment</button>
			</div>
		</div>
	</div>
</div>

<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">