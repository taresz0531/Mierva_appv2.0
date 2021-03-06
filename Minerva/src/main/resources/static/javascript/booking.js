/*
 * színek az azonos foglaláshoz
 */
var colorArray = ['#ff8080','#ff1a1a','#b30000','#4d0000',
				  '#80ff80','#1aff1a','#00b300','#004d00',
				  '#8080ff','#1a1aff','#0000b3','#00004d',
				  '#ff4d4d','#e60000','#800000','#800000',
				  '#4dff4d','#00e600','#008000','#001a00',
				  '#4d4dff','#0000e6','#000080','#00001a',
				  '#ff0000','#00ff00','#0000ff'];

var isInfoPopup = true;

var dragCallId = 0;

var isMovCalendar = false;
var moveCalendarId;
var moveDateFrom;
var moveRoomType;
var actualCalendarId;
var actualDateFrom;
var actualRoomType;
var saveCalendarId = 0;

/*
 * cellák háttérszinének beállítása
 */
function printBackgound() {
	var cells = document.getElementsByClassName('calendarCells');
	var callIdArray = [0];
	var map = new Map();
	var callIdArrayIndex = 0;
	
	for (var i = 0; i < cells.length; i++) {
		var isContain = false;
		var callId = document.getElementById("id_" + cells[i].id).value;
		
		if(callId == 0){
			cells[i].draggable = "false";
			continue;
		}
		
		for (var j = 0; j < callIdArray.length; j++) {
			if(callIdArray[j] == callId){
				isContain = true;
				break;
			}
		}
		
		if(!isContain){
			callIdArray[callIdArrayIndex] = callId;
			callIdArrayIndex++;
			map.set('' + callId + '' , 0);
		}else{
			map.set('' + callId + '' , map.get('' + callId + '') + 1);
		}
	}
	
	for (var i = 0; i < cells.length; i++) {
		var callId = document.getElementById("id_" + cells[i].id).value;
		var color = document.getElementById("color_" + cells[i].id).value;
		for (var j = 0; j < callIdArray.length; j++) {
			if(callId == callIdArray[j]){
				if(map.get('' + callId + '') > 0){
					var item = document.getElementById(cells[i].id);
					item.style.background = color;
				}  
			}
		}	
	}
}

/*
 *ha egy cella felé viszed az egeret felugrik az infó ablak 
 */
function changeTo(item) {
	var id = item.id;
	var callId = document.getElementById("id_" + id).value;
	if(callId > 0 && isInfoPopup == true){
		var popup = document.getElementById("popup");
		
		var name = document.getElementById("name_" + id).value;
		var phone = document.getElementById("phone_" + id).value;
		var adults = document.getElementById("adults_" + id).value;
		var children = document.getElementById("children_" + id).value;
		var pay = document.getElementById("pay_" + id).value;
		var price = document.getElementById("price_" + id).value;
		var comment = document.getElementById("comment_" + id).value;
		var dateFrom = document.getElementById("dateFrom_" + id).value;
		var dateTo = document.getElementById("dateTo_" + id).value;
		
		popup.innerHTML = 'Név: ' + name + '<br/>' +
		'Tel: ' + phone + '<br/>' +
		'Felnőtt/gyerek: ' + adults + '/' + children + '<br/>' +
		'Fiz. mód/ár: ' + pay + '/' + price + 'Ft' + '<br/>' +
		'Dátum:' + dateFrom + " - " + dateTo + '<br/>' +
		'Megjegyzések<br/><div style=\'border: 1px solid black; border-radius: 5px; padding: 4px; font-size: 12px;\'>' + comment + '</div>';
		
		popup.style.display = "block";
	}
	
}

/*
 * ha lemegy a calláról az egér akkor eltűnik az infó ablak
 */
function changeBack(item) {
	var popup = document.getElementById("popup");
	popup.style.display = "none";
}

/*
 * az infó abalakot az egér poziciójához teszi
 */
function moveDivs(event)
{
	var popup = document.getElementById("popup");
	
    x=event.clientX + 12;
    y=event.clientY + 12;
    
    if(x > document.body.clientWidth/2){
    	x = x - popup.clientWidth - 15;
    }
    
    if(y > document.body.clientHeight/2){
    	y = y - popup.clientHeight - 15;
    }
    popup.style.left=x+"px";
    popup.style.top=y+"px";
}
/*
 * kijelöli a cellát
 */
function clickHeandler(item) {
	var cells = document.getElementsByClassName('calendarCells');
	for (var i = 0; i < cells.length; i++) {
		cells[i].style.border = '1px solid white';
	}
	
	item.style.border = '2px solid #ff9900';
	var callId = document.getElementById("id_" + item.id).value;
	var isEmty = document.getElementById("isEmty_" + item.id).value;
	
	if(callId != 0 && isEmty == "false"){
		
		saveMoveData(callId,dateFrom,roomType);
	}else{
		var roomType = document.getElementById("roomType_" + item.id).value;
		var dateFrom = document.getElementById("dateFromNew_" + item.id).value;
		saveActualData(callId,dateFrom,roomType);
	}
}

/*
 * megjelenik az az ablak ahol rögzíteni lehet a foglalást
 */
function doubleClickHeandler(event,item){
	var popupAdd = document.getElementById("popupAdd");
	
	var callId = document.getElementById("id_" + item.id).value;

		
	if(callId == 0){
		var roomType = document.getElementById("roomType_" + item.id).value;
		var dateFrom = document.getElementById("dateFromNew_" + item.id).value;
		var dateTo = document.getElementById("dateTo");
		dateTo.min = dateFrom;

		x=event.clientX + 12;
	    y=event.clientY + 12;

	    hiddenPopup();
	    popupAdd.style.display = "block";
	    
	    if(x > document.body.clientWidth/2){
	    	x = x - popupAdd.clientWidth - 15;
	    }
	    
	    if((y + popupAdd.clientHeight + 12) > document.body.clientHeight){
	    	y = y - ((y + popupAdd.clientHeight + 12) - document.body.clientHeight);
	    }else if(y - popupAdd.clientHeight - 12 < 100){
	    	y = 100;
	    }else{
	    	y = y - popupAdd.clientHeight - 12;
	    }
	    		
	    popupAdd.style.left=x+"px";
	    popupAdd.style.top=y+"px";
		
		var popDateFrom = document.getElementById('dateFrom');
		var popRoomType = document.getElementById('roomType')
		popDateFrom.value = dateFrom;
		popRoomType.value = roomType;
	}
	
}
/*
 * komment hozzáfűzése
 */
function rightClickHendler(event,item) {
	var isRight;
	if(event.button == 2){
		isRight = true;
	}else{
		isRight = false;
	}
	
	if(isRight){
		var popupAdd = document.getElementById("popupAddComment");
		var id = item.id;
		var callId = document.getElementById("id_" + id).value;
		if(callId > 0){
			x=event.clientX + 12;
		    y=event.clientY + 12;
		    
		    hiddenPopup();
		    popupAdd.style.display = "block";
		    
		    if(x > document.body.clientWidth/2){
		    	x = x - popupAdd.clientWidth - 15;
		    }
		    
		    if((y + popupAdd.clientHeight + 12) > document.body.clientHeight){
		    	y = y - ((y + popupAdd.clientHeight + 12) - document.body.clientHeight);
		    }else if((y - popupAdd.clientHeight - 12) < 100){
		    	y = 100;
		    }else{
		    	y = y - 12;
		    }
		    		
		    popupAdd.style.left=x+"px";
		    popupAdd.style.top=y+"px";
			
			var addId = document.getElementById("addCommentId");
			var addComment = document.getElementById("addComment");
			var comment = document.getElementById("comment_" + id).value;
			
			addComment.value = comment;
			addId.value = callId;
		}
	}
}

function allowDrop(ev,item) {
	var isEmty = document.getElementById("isEmty_" + item.id).value;
	if(isEmty == "false" || item.id  != 0){
		ev.preventDefault();
	}
}

function drag(ev,item) {
	 hiddenPopup();
	 
	var isEmty = document.getElementById("isEmty_" + item.id).value;
	if(isEmty == "false"){
		ev.dataTransfer.setData("text", ev.target.id);
		dragCallId = document.getElementById("id_" + item.id).value;
	}else{
		dragCallId = 0;
	}
	
}

function drop(ev,item) {

	 var callId = document.getElementById("id_" + item.id).value;
	
	if((callId == 0 || callId == dragCallId) && dragCallId != 0){
		var roomType = document.getElementById("roomType_" + item.id).value;
		var dateFrom = document.getElementById("dateFromNew_" + item.id).value;
		var r = confirm("Biztos áthelyezi a foglalást erre az időpontra? " + dateFrom);
		if (r == true) {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text");
			ev.target.appendChild(document.getElementById(data));
			
			var change_id = document.getElementById('change_id');
			var change_roomType = document.getElementById('change_roomType');
			var change_dateFrom = document.getElementById('change_dateFrom');
			
			change_id.value = dragCallId;
			change_dateFrom.value = dateFrom;
			change_roomType.value = roomType;
			
			document.getElementById("form-change").submit();
		}
		
		dragCallId = 0;
	}
	
	showPopup();
}

function moveCalendar() {
	var moveButton = document.getElementById('moveButton');
	var moveCancelButton = document.getElementById('moveCancelButton');
	var saveMcalendar = document.getElementById("saveMoveCalendar");
	if(moveCalendarId > 0){
		
		var name = "moveCalendar";
		var value = 1;
		
		var u = "/ajaxSessionSet?name=" + name + "&param=" + value;
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: u,
			timeout : 100000,
			success: function (data) {
				moveButton.style.display = "none";
				moveCancelButton.style.display = "block";
				saveMcalendar.style.display = "block";
				saveCalendarId = moveCalendarId;
			},
			error: function (e) {
				console.log("error: " + e);
			}
		});
		
		name = "saveCalId";
		value = moveCalendarId;
		u = "/ajaxSessionSet?name=" + name + "&param=" + value;
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: u,
			timeout : 100000,
			success: function (data) {
				
			},
			error: function (e) {
				console.log("error: " + e);
			}
		});
		
	}
}

function saveMoveCalendar(){
	var newCalId = document.getElementById('newCalId');
	
	if(newCalId.value > 0 && actualCalendarId == 0){
		var r = confirm("Biztos áthelyezi a foglalást erre az időpontra? " + actualDateFrom);
		if (r == true) {
			var change_id = document.getElementById('change_idw');
			var change_roomType = document.getElementById('change_roomTypew');
			var change_dateFrom = document.getElementById('change_dateFromw');
			
			change_id.value = newCalId.value;
			change_dateFrom.value = actualDateFrom;
			change_roomType.value = actualRoomType;
			
			var name = "moveCalendar";
			var value = 0;
			
			var u = "/ajaxSessionSet?name=" + name + "&param=" + value;
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: u,
				timeout : 100000,
				success: function (data) {
					moveButton.style.display = "none";
					moveCancelButton.style.display = "block";
					saveMcalendar.style.display = "block";
					saveCalendarId = moveCalendarId;
				},
				error: function (e) {
					console.log("error: " + e);
				}
			});
			
			document.getElementById("form-saveMoveCalendar").submit();
		}
	}
}

function moveCalendarCancel(){
	var moveButton = document.getElementById('moveButton');
	var moveCancelButton = document.getElementById('moveCancelButton');
	var saveMcalendar = document.getElementById("saveMoveCalendar");
	
	var data = {};
	
	data["name"] = "moveCalendar";
	data["param"] = 0;
	
	var u = "/ajaxSessionSet?name=" + data["name"] + "&param=" + data["param"];
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: u,
		timeout : 100000,
		success: function (data) {
			moveButton.style.display = "block";
			moveCancelButton.style.display = "none";
			saveMcalendar.style.display = "none";
			saveCalendarId = 0;
		},
		error: function (e) {
			console.log("error: " + e);
		}
	});
}

function saveMoveData(calId,date,room) {
	moveCalendarId = calId;
	moveDateFrom = date;
	moveRoomType = room;
}

function saveActualData(calId,date,room) {
	actualCalendarId = calId;
	actualDateFrom = date;
	actualRoomType = room;
}

function closepopupadd(popupName){
	var popupAdd = document.getElementById(popupName);
	popupAdd.style.display = "none";
	isInfoPopup = true;
}

function hiddenPopup() {
	isInfoPopup = false;
	var popup = document.getElementById("popup");
	popup.style.display = "none";
}

function showPopup() {
	isInfoPopup = true;
	var popup = document.getElementById("popup");
	popup.style.display = "block";
}

function sleep(milliseconds) {
	  var start = new Date().getTime();
	  for (var i = 0; i < 1e7; i++) {
	    if ((new Date().getTime() - start) > milliseconds){
	      break;
	    }
	  }
	}
