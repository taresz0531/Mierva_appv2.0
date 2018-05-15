function foldalClick(id){
	var idName = document.getElementById(id);
	if(idName.style.display == 'block'){
		$(idName).fadeOut("slow");
		idName.style.display = "none";
	}
	else{
		$(idName).fadeIn("slow");
		idName.style.display = "block";
	}
}

function foldalModosit(formName,leirasDiv){
	 var selectFormElements = document.forms[formName].elements;
	 var popupFormElements = document.forms['popup-form'].elements;
	 var lDiv = document.getElementById(leirasDiv);
	 var leirasText = document.getElementById('leirDiv');
	 var header = document.getElementById('header');
	 
	 popupFormElements['id'].value = selectFormElements['id'].value;
	 popupFormElements['cim'].value = selectFormElements['cim'].value;
	 popupFormElements['originalCim'].value = selectFormElements['originalCim'].value;
	 leirasText.innerHTML = lDiv.innerHTML;
	 popupFormElements['date'].value = selectFormElements['date'].value;
	 popupFormElements['dateTo'].value = selectFormElements['dateTo'].value;
	 popupFormElements['nyelv'].value = selectFormElements['nyelv'].value;
	 popupFormElements['autoO'].value = selectFormElements['autoO'].value;
	  
	 var popupDiv = document.getElementById('foldal-modosit-popup');
	 popupDiv.style.display = "block";
	 header.style.display = "none";
}

function resetFoldalPopupForm(){
	var leirasText = document.getElementById('leirDiv');
	
	popupFormElements['id'].value = "";
	popupFormElements['cim'].value = "";
	popupFormElements['originalCim'].value = "";
	leirasText.innerHTML = "";
	popupFormElements['date'].value = "";
	popupFormElements['dateTo'].value = "";
	popupFormElements['nyelv'].value = "";
	popupFormElements['autoO'].value = "";
}

function submitForm(id){
	var popupDiv = document.getElementById(id);
	var header = document.getElementById('header');
	
	popupDiv.style.display = "none";
	header.style.display = "block";
	document.forms['popup-form'].submit();
	resetFoldalPopupForm();
}

function closeDiv(id){
	var popupDiv = document.getElementById(id);
	var header = document.getElementById('header');
	
	popupDiv.style.display = "none";
	header.style.display = "block";
}
