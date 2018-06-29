package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.bo.PermissionBo;
import hu.tarnai.minerva.bo.UserBo;
import hu.tarnai.minerva.entity.Menu;
import hu.tarnai.minerva.entity.Permission;

public class PermissionObj {
	public String mainMenu;
	public List<PermissionMenuObj> permMenu = new ArrayList<PermissionMenuObj>(); 

	public PermissionObj() {
	}

	public PermissionObj(String mainMenu, List<PermissionMenuObj> permMenu) {
		super();
		this.mainMenu = mainMenu;
		this.permMenu = permMenu;
	}
	
	public static List<PermissionObj> getAll() {
		PermissionBo bo = new PermissionBo();
		UserBo uBo = new UserBo();
		
		List<PermissionObj> permObj = new ArrayList<PermissionObj>();
		List<Permission> perms = bo.getAll();
		
		boolean isPerm = false;
		boolean isSubmenu = false;
		boolean isMenu = false;
		
		for(Permission p:perms) {
			Menu menu = uBo.getMenuByCode(p.getMenuCode());
			isMenu = false;
			for(int i=0;i<permObj.size();i++) {
				isSubmenu = false;
				if(permObj.get(i).getMainMenu().equals(menu.getMain())) {
					for(int j=0;j<permObj.get(i).getPermMenu().size();j++) {
						isPerm = false;
						if(permObj.get(i).getPermMenu().get(j).getSubMenuName().equals(menu.getNev())) {
							for(int k=0;k<permObj.get(i).getPermMenu().get(j).getPerm().size();k++) {
								if(permObj.get(i).getPermMenu().get(j).getPerm().get(k).getId() == p.getId()) {
									isPerm = true;
									break;
								}
							}
							if(!isPerm) {
								permObj.get(i).getPermMenu().get(j).getPerm().add(p);
							}
							isSubmenu = true;
							break;
						}
					}
					if(!isSubmenu) {
						List<Permission> pp = new ArrayList<Permission>();
						pp.add(p);
						permObj.get(i).getPermMenu().add(new PermissionMenuObj(menu.getNev(), pp));
						
					}
					
					isMenu = true;
					break;
				}
			}
			
			if(!isMenu) {
				List<Permission> pp = new ArrayList<Permission>();
				pp.add(p);
				List<PermissionMenuObj> pm = new ArrayList<PermissionMenuObj>();
				pm.add(new PermissionMenuObj(menu.getNev(), pp));
				permObj.add(new PermissionObj(menu.getMain(), pm));
			}
		}
		
		return permObj;
	}

	public String getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}

	public List<PermissionMenuObj> getPermMenu() {
		return permMenu;
	}

	public void setPermMenu(List<PermissionMenuObj> permMenu) {
		this.permMenu = permMenu;
	}
	
	
}
