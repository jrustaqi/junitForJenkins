package concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogingTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		init();
		loginTest();
		tearDown();
		
//		init();
//		negativeLoginTest();
//		tearDown();

	}

	public static void init() {
		driver = new ChromeDriver();

		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public static void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		Thread.sleep(3000);
	}
	
	public static void negativeLoginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();

		Thread.sleep(3000);
	}

	public static void tearDown() {
		driver.close();
	}

}
