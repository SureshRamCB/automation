package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class UtilityMethods {
public static String getTimeStamp() {
		
		String timeStamp="";
		
		Date d=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(d);
		int day=c.get(Calendar.DAY_OF_MONTH);
		int month=c.get(Calendar.MONTH);
		int year=c.get(Calendar.YEAR);
		int hour=c.get(Calendar.HOUR);
		int minuit=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		timeStamp=""+year+month+day+hour+minuit+second;
		return timeStamp;
	}
	
	
	public static void createFolder(String folderPath) {
		File f=new File(folderPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
	}
	
	public static String captureImage(String imageNAme,WebDriver driver) {
		createFolder(System.getProperty("user.dir")+"\\Screenshorts");
		imageNAme=imageNAme+getTimeStamp()+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		String base64string=ts.getScreenshotAs(OutputType.BASE64);
		try {
			Files.move(scr, new File(System.getProperty("user.dir")+"\\Screenshorts\\"+imageNAme));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return base64string;
	}
}
