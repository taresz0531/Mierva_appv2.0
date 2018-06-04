function ajanlatOldClick(){
	var oldDiv = document.getElementById('old');
	var readDiv = document.getElementById('read');
	
	if(oldDiv.style.display == 'block'){
		$(oldDiv).fadeOut("slow");
		oldDiv.style.display = "none";
	}
	else{
		$(oldDiv).fadeIn("slow");
		oldDiv.style.display = "block";
		readDiv.style.display = "none";
	}
}

function ajanlatReadClick(){
	var readDiv = document.getElementById('read');
	var oldDiv = document.getElementById('old');
	
	if(readDiv.style.display == 'block'){
		$(readDiv).fadeOut("slow");
		readDiv.style.display = "none";
	}
	else{
		$(readDiv).fadeIn("slow");
		readDiv.style.display = "block";
		oldDiv.style.display = "none";
	}
}

function emailKuldes(formName){
	 var selectFormElements = document.forms[formName].elements;
	 var popupFormElements = document.forms['popup-form'].elements;
	 var header = document.getElementById('header');
	 var popupName = document.getElementById("name");
	 var popupEmail = document.getElementById("emailCim");
	 
	 popupFormElements['id'].value = selectFormElements['id'].value;
	 popupName.innerHTML = selectFormElements['name_' + selectFormElements['id'].value].value;
	 popupEmail.value = selectFormElements['emailCim_' + selectFormElements['id'].value].value;
	 
	 var popupDiv = document.getElementById('ajanlat-valasz-popup');
	 popupDiv.style.display = "block";
	 header.style.display = "none";
}