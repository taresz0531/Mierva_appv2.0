package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.entity.Permission;

public class PermissionMenuObj {

	public String subMenuName;
	public List<Permission> perm = new ArrayList<Permission>();
	
	public PermissionMenuObj() {
	}

	public PermissionMenuObj(String subMenuName, List<Permission> perm) {
		this.subMenuName = subMenuName;
		this.perm = perm;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public List<Permission> getPerm() {
		return perm;
	}

	public void setPerm(List<Permission> perm) {
		this.perm = perm;
	}
	
}
