package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.bo.UserBo;
import hu.tarnai.minerva.entity.Menu;

public class UserMenusObject {
	public String mainMenuName;
	public List<Menu> subMenus = new ArrayList<Menu>();
	
	public UserMenusObject(String name){
		mainMenuName = name;
	}
	
	public static List<UserMenusObject> get(HttpServletRequest request){
		UserBo bo = new UserBo();
		List<String> mainMenuName = bo.getUserMainMenus(request);
		List<UserMenusObject> userMenuObj = new ArrayList<UserMenusObject>();
		List<Menu> subMenus = bo.getUserSubMenus(request);
		
		for(String m:mainMenuName){
			userMenuObj.add(new UserMenusObject(m));
		}
		
		for(int i=0;i<userMenuObj.size();i++){
			for(Menu m:subMenus){
				if(userMenuObj.get(i).getMainMenuName().equals(m.getMain())){
					userMenuObj.get(i).getSubMenus().add(m);
				}
			}
		}
		
		for(int i=0;i<userMenuObj.size();i++){
			if(userMenuObj.get(i).getSubMenus().size()<1){
				userMenuObj.remove(i);
			}
		}
				
		return userMenuObj;
	}
	
	public static List<UserMenusObject> getAll(HttpServletRequest request){
		UserBo bo = new UserBo();
		List<String> mainMenuName = bo.getAllMainMenus();
		List<UserMenusObject> userMenuObj = new ArrayList<UserMenusObject>();
		List<Menu> subMenus = bo.getAllSubMenus();
		
		for(String m:mainMenuName){
			userMenuObj.add(new UserMenusObject(m));
		}
		
		for(int i=0;i<userMenuObj.size();i++){
			for(Menu m:subMenus){
				if(userMenuObj.get(i).getMainMenuName().equals(m.getMain())){
					userMenuObj.get(i).getSubMenus().add(m);
				}
			}
		}
		
		for(int i=0;i<userMenuObj.size();i++){
			if(userMenuObj.get(i).getSubMenus().size()<1){
				userMenuObj.remove(i);
			}
		}
				
		return userMenuObj;
	}
	
	public String getMainMenuName() {
		return mainMenuName;
	}
	public void setMainMenuName(String mainMenuName) {
		this.mainMenuName = mainMenuName;
	}
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
}