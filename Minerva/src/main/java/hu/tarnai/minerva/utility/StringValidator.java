package hu.tarnai.minerva.utility;

public class StringValidator {

	public static boolean isEmpty(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String str){
		if(str!=null&&!str.equals("")){
			return true;
		}
		return false;
	}
}
