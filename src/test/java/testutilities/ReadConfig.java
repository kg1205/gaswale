package testutilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("exception is "+e.getMessage());
		}
		
	}
	public String geturl() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String getusername() {
		String usname=pro.getProperty("usename");
		return usname;
		
	}
	public String paswrd() {
		String passwd=pro.getProperty("pass");
		return passwd;
		
	}
	public String chrome() {
		String chrmpth=pro.getProperty("chromepath");
		return chrmpth;
	}
	
}
