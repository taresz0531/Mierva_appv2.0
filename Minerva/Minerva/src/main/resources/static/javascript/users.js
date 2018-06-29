function selsecUser(){
	var usersSelector = document.getElementById('users');
	var data = usersSelector.options[usersSelector.selectedIndex].value.split("#");
	var userMenus = data[0].split(",");
	var userPerm = data[1]!=null?data[1].split(","):null;
	var id = data[2];

	var menuDiv = document.getElementById('function');
	var menuDiv2 = document.getElementById('function2');
	
	var allFunction = document.getElementsByName('menus');
	for(i=0;i<allFunction.length;i++){
		allFunction[i].checked = false;
	}
	
	var allFunction2 = document.getElementsByName('perms');
	for(i=0;i<allFunction2.length;i++){
		allFunction2[i].checked = false;
	}
	
	var userId = document.getElementById('id');
	
	if(userMenus[0] != "-1"){
		menuDiv.style.display = 'block';
		menuDiv2.style.display = 'block';
		for(i=0;i<userMenus.length;i++){
			var m = document.getElementById(userMenus[i]);
			if(m!=null)
				m.checked  = true;
		}
		
		for(i=0;i<userPerm.length;i++){
			var p = document.getElementById("perm_" + userPerm[i]);
			if(p!=null)
				p.checked  = true;
		}
		userId.value = id;
	}else{
		menuDiv.style.display = 'none';
		menuDiv2.style.display = 'none';
	}
	
}