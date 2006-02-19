package fr.umlv.ir3.emagine.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UploadUtil {

	private static final String uploadPath = "D:/test"; 
	private static final String tmpExt = "tmp"; 
	
	public static File saveFileUpload(byte[] datas, String filename) throws IOException, NoSuchAlgorithmException {
		File file = createUploadFile(uploadPath, filename, tmpExt, datas);
		
		FileOutputStream out = new FileOutputStream(file);
		out.write(datas);
		out.flush();
		out.close();
		
		return file;
	}
	
	public static File getFileUploaded(String filename) throws NoSuchAlgorithmException, IOException {
		return new File(createUploadDir(uploadPath), filename);
	} 
	
	private static File createUploadFile(String dirPath, String filename, String ext, byte[] datas) throws NoSuchAlgorithmException, IOException {
		 MessageDigest algorithm = MessageDigest.getInstance("MD5");
	     algorithm.reset();
	     algorithm.update(datas);
	     byte messageDigest[] = algorithm.digest();
	                    
	     StringBuffer hexString = new StringBuffer();
	     for (int i=0;i<messageDigest.length;i++) {
	          hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
	     }

	     File file = new File(createUploadDir(dirPath), hexString.toString() + "." + ext);
	     file.createNewFile();
	     
	     return file;	
	}
	
	private static File createUploadDir(String dirPath) throws NoSuchAlgorithmException, IOException {
	     File file = new File(dirPath);
	     if(!file.exists())
	    	 file.mkdirs();
	     return file;	
	}
}