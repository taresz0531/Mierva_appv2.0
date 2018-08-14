<meta charset="utf-8">
<div id="header">
	<#include "header.ftl">
</div>
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Foglalási nyilvántartó</h1></center>	
	</div>
	<div class="row">
		
	<#include "adminMenu.ftl">
<!-- ez a kód -->
<div id="bookingDiv" class="bookingDiv" onmousemove="moveDivs(event)" oncontextmenu="return false;">
	<table class="bookingTable">
		<#list 0..4 as i>
			<tr>
				<td class="cellfirst cellSizeLarge  col-xs-1"> </td>
				<#list 0..6 as j>
					<td class="col-xs-1 cellSizeSmall cellBorder">
						<#switch i>
							<#case 0>
								<p>1 ágyas szoba: 
									<#assign x = 0>
									<#list bookingRooms as r>
										<#if r.date?string('yyyy.MM.dd') == weekDays[j].date?string('yyyy.MM.dd')>
											<#assign x = 1>
											<#if r.bed1 != 0> ${r.bed1} <#else> 0 </#if>
										</#if>
									</#list>
									<#if x !=1>
										0
									</#if>
								</p>
								<#break>
							<#case 1>
								<p>2 ágyas szoba:<#assign x = 0>
									<#list bookingRooms as r>
										<#if r.date?string('yyyy.MM.dd') == weekDays[j].date?string('yyyy.MM.dd')>
											<#assign x = 1>
											<#if r.bed2 != 0> ${r.bed2} <#else> 0 </#if>
										</#if>
									</#list>
									<#if x !=1>
										0
									</#if>
								</p>
								<#break>
							<#case 2>
								<p>3 ágyas szoba:
								<#assign x = 0>
									<#list bookingRooms as r>
										<#if r.date?string('yyyy.MM.dd') == weekDays[j].date?string('yyyy.MM.dd')>
											<#assign x = 1>
											<#if r.bed3 != 0> ${r.bed3} <#else> 0 </#if>
										</#if>
									</#list>
									<#if x !=1>
										0
									</#if>
								</p>
								<#break>
							<#case 3>
								<p>4 ágyas szoba:
									<#assign x = 0>								
									<#list bookingRooms as r>
										<#if r.date?string('yyyy.MM.dd') == weekDays[j].date?string('yyyy.MM.dd')>
											<#assign x = 1>
											<#if r.bed4 != 0> ${r.bed4} <#else> 0 </#if>
										</#if>
									</#list>
									<#if x !=1>
										0
									</#if>
								</p>
								<#break>
							<#default>
								<p>tetőtéri 2 ágyas:
									<#assign x = 0>
									<#list bookingRooms as r>
										<#if r.date?string('yyyy.MM.dd') == weekDays[j].date?string('yyyy.MM.dd')>
											<#assign x = 1>
											<#if r.bedAttic2 != 0> ${r.bedAttic2} <#else> 0 </#if>
										</#if>
									</#list>
									<#if x !=1>
										0
									</#if>
								</p>
						</#switch>
					</td>
				</#list>
			</tr>
		</#list>
		<tr>
			<td class="cellfirst cellSizeLarge cellBorder col-xs-1"></td>
			<#list 0..6 as i>
				<td class="col-xs-1 bookingTable"><center><p class="cellSizeLarge">${weekDays[i].date?string('yyyy.MM.dd')}</p></center></td>
			</#list>
		</tr>
		<tr>
			<td class="cellfirst cellSizeLarge cellBorder col-xs-1"><center><p>Megnevezés</p></center></td>
			<#list 0..6 as i>
				<td class="col-xs-1 bookingTable"><center><p class="cellSizeLarge">${weekDays[i].name}</p></center></td>
			</#list>
		</tr>
		<#assign callIds = [-1]>
		<#list roomTypes as rt>
			<tr>
				<td class="cellfirst cellSizeLarge cellBorder col-xs-1">
					<center><p>${rt.name + "("} ${rt.description + ")"}</p></center>
				</td>
				<#list 0..6 as i>
					<td id="${rt?index}${i}"  class="col-xs-1 bookingTable calendarCells" draggable="true" ondragstart="drag(event,this)" ondrop="drop(event,this)" ondragover="allowDrop(event,this)" onmousedown="rightClickHendler(event,this)" onmouseover="changeTo(this)" onmouseout="changeBack(this)" ondblclick="doubleClickHeandler(event,this)" onclick="clickHeandler(this)">
						<#list cells as c>
							<#if weekDays[i].date?string('yyyy-MM-dd') == c.day.date?string('yyyy-MM-dd') && c.room.name == rt.name>
								<#if callIds?seq_contains(c.calendar.id)?string('yes', 'no') == 'no'>
									<#assign callIds = callIds + [c.calendar.id]>
									<p class="cellSizeSmall"><#if c.calendar.name??> Név: ${c.calendar.name}</#if></p>
									<p class="cellSizeSmall"><#if c.calendar.phone??> Tel: ${c.calendar.phone}</#if></p>
									<input type="hidden" id="isEmty_${rt?index}${i}" value="false"/>
								</#if>
								<input type="hidden" id="isEmty_${rt?index}${i}" value="true"/>
								<#if c.calendar.id != 0 && c.calendar.dateTo?string('yyyy-MM-dd') != weekDays[i].date?string('yyyy-MM-dd')>
									<input type="hidden" id="id_${rt?index}${i}" value="${c.calendar.id}" />
								<#else>
									<input type="hidden" id="id_${rt?index}${i}" value="0" />
								</#if>
								<#if c.calendar.id != 0 && c.calendar.dateTo?string('yyyy-MM-dd') != weekDays[i].date?string('yyyy-MM-dd')>
									<input type="hidden" id="name_${rt?index}${i}" value="${c.calendar.name}" />
									<input type="hidden" id="phone_${rt?index}${i}" value="${c.calendar.phone}" />
									<input type="hidden" id="adults_${rt?index}${i}" value="${c.calendar.adultsNum}" />
									<input type="hidden" id="children_${rt?index}${i}" value="${c.calendar.childrenNum}" />
									<input type="hidden" id="pay_${rt?index}${i}" value="${c.calendar.payType}" />
									<input type="hidden" id="price_${rt?index}${i}" value="${c.calendar.price}" />
									<input type="hidden" id="comment_${rt?index}${i}" value="${c.calendar.comment}" />
									<input type="hidden" id="roomType_${rt?index}${i}" value="${rt.type}" />
									<input type="hidden" id="dateFrom_${rt?index}${i}" value="${c.calendar.dateFrom?string('yyyy-MM-dd')}" />
									<input type="hidden" id="dateTo_${rt?index}${i}" value="${c.calendar.dateTo?string('yyyy-MM-dd')}" />
									<input type="hidden" id="dateFromNew_${rt?index}${i}" value="${weekDays[i].date?string('yyyy-MM-dd')}" />
									<input type="hidden" id="color_${rt?index}${i}" value="${c.calendar.color}" />
								<#else>
									<input type="hidden" id="dateFromNew_${rt?index}${i}" value="${weekDays[i].date?string('yyyy-MM-dd')}" />
									<input type="hidden" id="roomType_${rt?index}${i}" value="${rt.type}" />
									<input type="hidden" id="color_${rt?index}${i}" value="#000" />
								</#if>
							</#if>
						</#list>
					</td>
				</#list>
			</tr>
		</#list>
	</table>
	<div class="buttons-layout">
		<div class="left-buttons">
				<form action="/" method="post">
					<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
					 <div class="btn-group" role="group" aria-label="...">
						<input style="height: 36" type="submit" class="btn btn-default" value="Előző hét" onclick="javascript: form.action='bookingPrev'; form.target=''"/>
						<input style="height: 36" type="submit" class="btn btn-default" value="Aktuális hét" onclick="javascript: form.action='bookingTable'; form.target=''"/>
						<input style="height: 36" type="submit" class="btn btn-default" value="Következő hét" onclick="javascript: form.action='bookingNext'; form.target=''"/>
						<input type="week" id="dateT" name="dateT" class="btn btn-default"/>
						<input style="height: 36" type="submit" class="btn btn-default" value="Ugrás" onclick="javascript: form.action='bookingWeek'; form.target=''"/>
					 </div>				
				</form>
		</div>
		<div class="right-buttons">
			<div>
				<input id="moveButton" class="btn" type="button" <#if !Session.moveCalendar?exists || Session.moveCalendar == "0">style="display: block;"<#else>style="display: none;"</#if> onclick="moveCalendar()" value="Áthelyezés másik hétre">
				<div id="saveMoveCalendar" <#if Session.moveCalendar?exists && Session.moveCalendar == "1">style="display: block;"<#else>style="display: none;"</#if>>
					<form action="bookingChange" method="post" id="form-saveMoveCalendar" name="form-saveMoveCalendar">
						<input type="hidden" id="newCalId" name="newCalId" <#if Session.saveCalId?exists && Session.saveCalId != "0">value="${Session.saveCalId}"<#else> value="0"</#if>/>
						<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
						<input type="hidden" id="change_idw" name="change_id" />
						<input type="hidden" id="change_roomTypew" name="change_roomType" />
						<input type="hidden" id="change_dateFromw" name="change_dateFrom" />
						<input class="btn" type="button" onclick="saveMoveCalendar()" value="Mentés ide"/>
					</form>
				</div>
			</div>
			<div>
				<input id="moveCancelButton" <#if Session.moveCalendar?exists && Session.moveCalendar == "1">style="display: block;"<#else>style="display: none;"</#if> class="btn" type="button" onclick="moveCalendarCancel()" value="Mégsem">
			</div>
			<div>
				<form action="printBookingTable" method="post" target="_blank">
					<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
					<button class="btn" type="submit">Nyomtatás</button>
				</form>
			</div>
			<div>
				<button class="btn" type="button">Segítség</button>
			</div>
			<div>
				<a href="admin?pageName=1"><button type="button" class="btn">Kilép</button></a>
			</div>
		</div>
	</div>
	
	
	
	<div id="popup" class="popupWindows"></div>
	
	<div id="popupAdd" class="popupWindows">
		<form role="form" action="bookingSave" method="post" name="popup-form-add">
			<input type="hidden" id="dateFrom" name="dateFrom" value=""/>
			<input type="hidden" id="roomType" name="roomType" value=""/>
			<div class="form-group col-xs-12">
		      	<label for="dateTo"><p style="color: black;">Távozás dátuma:</p></label>
				<input  type="date" id="dateTo" name="dateTo" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-12">
		      	<label for="name"><p style="color: black;">Név:</p></label>
				<input required="true" type="text" id="name" name="name" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-12">
		      	<label for="phone"><p style="color: black;">Telefonszám:</p></label>
				<input required="true" type="text" id="phone" name="phone" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="adultsNum"><p style="color: black;">Felnőttek száma:</p></label>
				<input required="true" type="number" id="adultsNum" name="adultsNum" class="form-control" value="1"/>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="childrenNum"><p style="color: black;">Gyerekek száma:</p></label>
				<input required="true" type="number" id="childrenNum" name="childrenNum" class="form-control" value="0"/>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="payType"><p style="color: black;">Fizetés típusa:</p></label>
				<select id="payType" name="payType" class="form-control">
						<option value="Készpénz"><p>Készpénz</p></option>
						<option value="Átutalás"><p>Átutalás</p></option>
				</select>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="price"><p style="color: black;">Ár:</p></label>
				<input required="true" type="number" id="price" name="price" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-12">
		      	<label for="comment"><p style="color: black;">Megjegyzés:</p></label>
		      	<textarea rows="4"  id="comment" name="comment" class="form-control"></textarea>
		    </div>
		    <center>
		    	<input type="submit" value="Mentés" class="btn btn-default"/>
		    	<input onclick="closepopupadd('popupAdd')" type="button" class="btn btn-default" value="Mégsem"/>
		    </center>
		</form>
	</div>
	
	<div id="popupModif" class="popupWindows">
		<form role="form" action="bookingModif" method="post" name="popup-form-modif">
			<input type="hidden" id="id_modif" name="id_modif" value=""/>
			<div class="form-group col-xs-12">
		      	<label for="dateTo"><p style="color: black;">Távozás dátuma:</p></label>
				<input  type="date" id="dateTo_modif" name="dateTo" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-12">
		      	<label for="name"><p style="color: black;">Név:</p></label>
				<input required="true" type="text" id="name_modif" name="name" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-12">
		      	<label for="phone"><p style="color: black;">Telefonszám:</p></label>
				<input required="true" type="text" id="phone_modif" name="phone" class="form-control"/>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="adultsNum"><p style="color: black;">Felnőttek száma:</p></label>
				<input required="true" type="number" id="adultsNum_modif" name="adultsNum" class="form-control" value="1"/>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="childrenNum"><p style="color: black;">Gyerekek száma:</p></label>
				<input required="true" type="number" id="childrenNum_modif" name="childrenNum" class="form-control" value="0"/>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="payType"><p style="color: black;">Fizetés típusa:</p></label>
				<select id="payType_modif" name="payType" class="form-control">
						<option value="Készpénz"><p>Készpénz</p></option>
						<option value="Átutalás"><p>Átutalás</p></option>
				</select>
		    </div>
		    <div class="form-group col-xs-6">
		      	<label for="price"><p style="color: black;">Ár:</p></label>
				<input required="true" type="number" id="price_modif" name="price" class="form-control"/>
		    </div>
		    <center>
		    	<input type="submit" value="Mentés" class="btn btn-default"/>
		    	<input type="submit" value="Törlés" class="btn btn-default" onclick="javascript: form.action='bookingDelet'; form.target=''"/>
		    	<input onclick="closepopupadd('popupModif')" type="button" class="btn btn-default" value="Mégsem"/>
		    </center>
		</form>
	</div>
	
	<div id="popupAddComment" class="popupWindows">
		<form role="form" action="bookingAddComment" method="post" name="popup-form-add-comment">
			<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
			<input type="hidden" id="addCommentId" name="addCommentId" value=""/>
			<input type="hidden" id="addComment" name="addComment" value=""/>
		    <div class="form-group col-xs-12">
		      	<label for="comment"><p style="color: black;">Megjegyzés:</p></label>
		      	<textarea rows="4"  id="comment" name="comment" class="form-control"></textarea>
		    </div>
		    <center>
		    	<input type="submit" value="Hozzáad" class="btn btn-default"/>
		    	<input onclick="closepopupadd('popupAddComment')" type="button" class="btn btn-default" value="Mégsem"/>
		    </center>
		</form>
	</div>
	
	<div class="changeForm" style="display: none;">
		<form role="form" action="bookingChange" method="post" name="form-change" id="form-change">
			<input type="hidden" id="change_id" name="change_id" value=""/>
			<input type="hidden" id="date" name="date" value="${monday?string('yyyy-MM-dd')}" />
			<input type="hidden" id="change_roomType" name="change_roomType" value=""/>
			<input type="hidden" id="change_dateFrom" name="change_dateFrom" value=""/>
		</form>
	</div>
	
</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<script type="text/javascript">
$(document).ready(printBackgound());
</script>

<#include "footer.ftl">