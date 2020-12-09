package com.kh.onairstudy.common;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String getRenamedFileName(String originalFilename) {
		String renamedFilename = null;
		
		//확장자
		int beginIndex = originalFilename.lastIndexOf('.');
		String ext = originalFilename.substring(beginIndex); //.png
		
		//년월일 포맷, 난수 포맷객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS_");
		DecimalFormat df = new DecimalFormat("000");
		
		renamedFilename = sdf.format(new Date())
						+ df.format(Math.random() * 1000)
						+ ext;
		
		return renamedFilename;
	}
	
	
	

}
