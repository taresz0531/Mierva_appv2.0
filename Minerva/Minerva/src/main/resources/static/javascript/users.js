function selsecUser(){
	var usersSelector = document.getElementById('users');
	var data = usersSelector.options[usersSelector.selectedIndex].value.split("#");
	var userMenus = data[0].split(",");
	var id = data[1];

	var menuDiv = document.getElementById('function');
	
	var allFunction = document.getElementsByName('menus');
	for(i=0;i<allFunction.length;i++){
		allFunction[i].checked = false;
	}
	
	var userId = document.getElementById('id');
	
	if(userMenus[0] != "-1"){
		menuDiv.style.display = 'block';
		for(i=0;i<userMenus.length;i++){
			var m = document.getElementById(userMenus[i]);
			m.checked  = true;
		}
		userId.value = id;
	}else{
		menuDiv.style.display = 'none';
	}
	
}