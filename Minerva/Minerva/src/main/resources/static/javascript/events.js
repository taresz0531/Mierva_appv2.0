var currentIndex = 0;
var eventList;

function searchEvent(){
	var id = document.getElementById('user');
	var dateFrom = document.getElementById('dateFrom');
	var dateTo = document.getElementById('dateTo');
	
	var u = "/searchEvent?dateFrom=" + dateFrom.value.replace("T", " ") + "&dateTo=" + dateTo.value.replace("T", " ") + "&id=" + id.value;
	console.log("url: " + u);
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: u,
		timeout : 100000,
		success: function (data) {
			try{
				eventList = JSON.parse(data);
				var table = document.getElementById('listTable');
	
				while(table.rows.length > 1){
					table.deleteRow(1);
				}
				
				for(var i=0;i<eventList.length;i++){
					var tr = document.createElement("tr");
	
					var tdId = document.createElement("td");
					var centerId = document.createElement("center");
					var pId = document.createElement("p");
					var textId = document.createTextNode("" + eventList[i].id);
					pId.appendChild(textId);
					centerId.appendChild(pId);
					tdId.appendChild(centerId); 
					tr.appendChild(tdId);
					
					var tdName = document.createElement("td");
					var pName = document.createElement("p");
					var textName = document.createTextNode("" + eventList[i].name);
					pName.appendChild(textName);
					tdName.appendChild(pName);
					tr.appendChild(tdName);
					
					var tdDate = document.createElement("td");
					var pDate = document.createElement("p");
					var textDate = document.createTextNode("" + eventList[i].date);
					pDate.appendChild(textDate);
					tdDate.appendChild(pDate);
					tr.appendChild(tdDate);
					
					var tdEvent = document.createElement("td");
					var pEvent = document.createElement("p");
					var textEvent = document.createTextNode("" + eventList[i].event);
					pEvent.appendChild(textEvent);
					tdEvent.appendChild(pEvent);
					tr.appendChild(tdEvent);
					
					table.appendChild(tr);
				}
				
				console.log("rownum: " + table.rows.length + "/eventList: " + eventList.length);
				
				var div = document.getElementById("eventListDiv");
				div.style.display = "block";
			}catch (e) {
				console.log("Ex: " + e);
			}
				
			},
			error: function (e) {
				console.log("error: " + e);
			}
		});
}