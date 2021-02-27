package com.facebook.test.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class InitDriver extends BaseTest {

	public static void closeAllBrowser() {

		try {

			String cmd = "taskkill /F /IM iexplore.exe";

			Process proc = Runtime.getRuntime().exec(cmd);
			proc.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static WebDriver getCurrentDriver() {

		if (driver == null) {
			System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");

			try {
				closeAllBrowser();
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
		/*		driver = new FirefoxDriver(); */

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return driver;
	}

	public static void close() {

		try {

			driver.quit();

			driver = null;

		} catch (UnreachableBrowserException e) {
			// TODO: handle exception
		}
	}

}
