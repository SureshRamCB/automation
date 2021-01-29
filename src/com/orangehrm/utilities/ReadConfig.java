package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {
		File f=new File(System.getProperty("user.dir")+"\\Configurations\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(f);
			prop=new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}

	}

	public String getApplicationUrl() {
		String url=prop.getProperty("baseURL");
		return url;
	}

	public String getuserName() {
		String userName=prop.getProperty("username");
		return userName;
	}

	public String getPassword() {
		String passWord=prop.getProperty("password");
		return passWord;
	}
}

