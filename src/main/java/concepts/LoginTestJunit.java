package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestJunit {
	WebDriver driver;

	@BeforeClass // runs once before any of the test methods in the class
	public static void beforeClass() {
		System.out.println("Before Class Method");
	}

	@Before // runs before @Test
	public void init() {
		System.out.println("Init Method");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}

	@Test // the method to run
	public void loginTest() throws InterruptedException {
		System.out.println("Login Test Method");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		Thread.sleep(3000);
	}

	@Test // the method to run
	public void negativeLoginTest() throws InterruptedException {
		System.out.println("Negative Login Test Method");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();

		Thread.sleep(3000);
	}

	@After // runs after @Test
	public void tearDown() {
		System.out.println("Tear Down Method");
		driver.close();
	}

	@AfterClass // runs once after all the test methods in the class have been run
	public static void afterClass() {
		System.out.println("after Class Method");
	}
}
