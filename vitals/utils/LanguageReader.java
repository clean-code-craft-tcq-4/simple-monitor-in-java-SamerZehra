package vitals.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class LanguageReader {
	private static final Logger LOGGER = Logger.getLogger(LanguageReader.class.getName());
	
	static Properties prop = new Properties();
	static int langInput = 2;
	
	public static void getUserInput() {
		Scanner sc=new Scanner(System.in); 
		LOGGER.info("Select the Language : \n"
				+ "1.GERMAN \n2.ENGLISH");  
		langInput= sc.nextInt();
		readPropertiesFile();
	}
	
	private static void readPropertiesFile() {

		InputStream inputStream = null;
		try {
			if (langInput == 1) {
				inputStream = new FileInputStream("C:\\Samer_Zehra\\Workspaces\\GitHub\\simple-monitor-in-java-SamerZehra-master\\resources\\MessageBundle_de.properties");
				
			} else {
				inputStream = new FileInputStream("C:\\Samer_Zehra\\Workspaces\\GitHub\\simple-monitor-in-java-SamerZehra-master\\resources\\MessageBundle_en.properties");
			}
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printLanguageString(String key) {
		LOGGER.info(prop.getProperty(key));
	}
}
