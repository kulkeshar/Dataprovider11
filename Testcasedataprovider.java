package Testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Basetestcase;


public class Testcasedataprovider extends Basetestcase{
	@DataProvider(name="LoginCredntials")
	public Object[][] dataset(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
		} ;
	
	}

		@Test(dataProvider ="LoginCredntials") 

	public static void login(String username1, String password1) throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys(username1);
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys(password1);
		driver.findElement(By.cssSelector(loc.getProperty("login"))).click();
         Thread.sleep(500);
	}
		@Test(dataProvider ="LoginCredntials") 
	public static void CountItems(String username1,String password1) throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys("username1");
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys("password1");
		driver.findElement(By.cssSelector(loc.getProperty("login"))).click();
		
		List<WebElement> items= driver.findElements(By.className(loc.getProperty("iteam")));
		System.out.println(items.size());
		 Thread.sleep(500);
	
	}
		@Test(dataProvider ="LoginCredntials") 
	public static void GetTitle(String username1,String password1) throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(loc.getProperty("username"))).sendKeys("username1");
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys("password1");
		driver.findElement(By.cssSelector(loc.getProperty("login"))).click();

		String title = driver.getTitle();
		System.out.println(title);
		 Thread.sleep(500);
	}

}

