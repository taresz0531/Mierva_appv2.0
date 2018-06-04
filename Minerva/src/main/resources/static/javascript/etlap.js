function etlapModosit(formName){
	 var selectFormElements = document.forms[formName].elements;
	 var popupFormElements = document.forms['popup-form'].elements;
	 var header = document.getElementById('header');
	 
	 popupFormElements['id'].value = selectFormElements['id'].value;
	 popupFormElements['nev_hu'].value = selectFormElements['nev_hu'].value;
	 popupFormElements['originalNev'].value = selectFormElements['originalNev'].value;
	 popupFormElements['nev_en'].value = selectFormElements['nev_en'].value;
	 popupFormElements['leiras_hu'].value = selectFormElements['leiras_hu'].value;
	 popupFormElements['leiras_en'].value = selectFormElements['leiras_en'].value;
	 popupFormElements['kategoria'].value = selectFormElements['kategoria'].value;
	 popupFormElements['ar'].value = selectFormElements['ar'].value;
	 popupFormElements['is_kep'].value = selectFormElements['is_kep'].value;
	 
	 var image = document.getElementById('etlap_kep');
	 
	 if(selectFormElements['is_kep'].value == 1){
		 image.src = "getImage?fileId=" + selectFormElements['id'].value + "&who=e";
		 image.style.display = "block";
	 }else{
		 image.style.display = "none";
		 image.src = "#";
	 }
	  
	 var popupDiv = document.getElementById('etlap-modosit-popup');
	 popupDiv.style.display = "block";
	 header.style.display = "none";
}

function etlapKategoriaModosit(formName){
	 var selectFormElements = document.forms[formName].elements;
	 var popupFormElements = document.forms['popup-form'].elements;
	 var header = document.getElementById('header');
	 
	 popupFormElements['id'].value = selectFormElements['id'].value;
	 popupFormElements['nev_hu'].value = selectFormElements['nev_hu'].value;
	 popupFormElements['nev_en'].value = selectFormElements['nev_en'].value;
	  
	 var popupDiv = document.getElementById('etlap-kategoria-modosit-popup');
	 popupDiv.style.display = "block";
	 header.style.display = "none";
}

function select(type,day){
	var etel_hu = document.getElementById(type + "_hu_" + day);
	var etel_en = document.getElementById(type + "_en_" + day);
	var select = document.getElementById("etlaprol_" + type + "_" + day);
	var select_etel_hu = select.options[select.selectedIndex].value;
	var select_etel_en = select.options[select.selectedIndex+1].value;
	
	etel_hu.value = select_etel_hu;
	etel_en.value = select_etel_en;
	
}