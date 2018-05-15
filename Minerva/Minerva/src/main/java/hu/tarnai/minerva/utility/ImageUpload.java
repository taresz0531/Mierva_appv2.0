package hu.tarnai.minerva.utility;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ImageUpload {
    
	static public byte[] getImage(MultipartHttpServletRequest request){
		byte[] imagebytes = null;
		
		if (!ServletFileUpload.isMultipartContent(request)) {
            return null;
        }
        
        try {
        	request.setCharacterEncoding("UTF-8");
        	Iterator<String> itrator = request.getFileNames();
            MultipartFile multiFile = request.getFile(itrator.next());
            imagebytes = multiFile.getBytes();
           
	         if(imagebytes.length>0){
	        	 imagebytes = new ImageResizable().resizeImageAsJPG(imagebytes, 1366);
	         }
	         else{
	        	 imagebytes = null;
	         }
	         
	         return imagebytes;
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        	return null;
        }
	}
	
	public static String GetFileName(MultipartHttpServletRequest request) {
		if (!ServletFileUpload.isMultipartContent(request)) {
            return null;
        }
		
		try {
			request.setCharacterEncoding("UTF-8");
			Iterator<String> itrator = request.getFileNames();
			MultipartFile multiFile = request.getFile(itrator.next());
			return multiFile.getOriginalFilename();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}