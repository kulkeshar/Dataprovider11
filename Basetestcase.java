package Base;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetestcase {
	public static WebDriver driver;
	public static Properties pro = new Properties();
	public static Properties loc = new Properties();

	
	@BeforeMethod
	public void SetUp() throws IOException {
		if (driver == null) {
			// System.out.println(System.getProperty("user.dir"));
			FileInputStream input = new FileInputStream(
					(System.getProperty("user.dir")) + "\\src\\test\\resources\\configfile\\configfile.properties");
			FileInputStream input1 = new FileInputStream(
					(System.getProperty("user.dir")) + "\\src\\test\\resources\\configfile\\locators.preperties");
			pro.load(input);
			loc.load(input1);
			System.out.println(pro.getProperty("browser"));
		}

		if (pro.getProperty("browser").equals("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(pro.getProperty("baseurl"));
		} else if (pro.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pro.getProperty("baseUrl"));
		}
	}

	@AfterMethod
	public void TearDown() {
		 driver.quit();
	}

}
