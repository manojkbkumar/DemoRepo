package myPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTest
{
WebDriver driver;
@BeforeTest
public void m1()
{
	System.out.println("Before Test");
}
@BeforeMethod
public void m2()
{
	System.out.println("Before Method");
}
@AfterMethod
public void m3()
{
	System.out.println("After Method");
}
@AfterTest
public void m4()
{
	System.out.println("After Test");
}
@AfterGroups
public void m5()
{
	System.out.println("After Group");
}
@BeforeGroups
public void m6()
{
	System.out.println("Before Group");
}
@BeforeClass
public void m7()
{
	System.out.println("Before Class");
}
@Test(priority=3)
public void Browser()
{
	System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver//chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://www.google.com");
	String strPageTitle = driver.getTitle();
	System.out.println("Page title: - "+strPageTitle);
	Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
 
    driver.quit();
}
@AfterClass
public void tearDown() {
	if(driver!=null) {
		System.out.println("After class");
		driver.quit();
	}
}
@Test(priority=1,enabled=false)
public void m8()
{
	System.out.println("Method m8");
}
@Test(priority=2)
public void m9()
{
	System.out.println("Method m9");
}
}