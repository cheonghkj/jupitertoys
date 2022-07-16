package jupitertoys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class FeedbackFormTest {
	private static ChromeDriver driver;
	
	public static void main (String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dinoc\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://jupiter.cloud.planittesting.com/#/home");
		driver.manage().window().maximize();
		String expectedResult="Jupiter Toys";
		String actualResult=driver.getTitle();
		if(expectedResult.equals(actualResult)) {
			System.out.println("Correct Website");
		} else {
			System.out.println("Wrong Website");
		}
		driver.findElement(By.id("nav-contact")).click();
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-contact")));
		} catch(TimeoutException tEx) {
			System.out.println("The load time to enter the contact page was longer than 3 seconds!");
		}
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));		
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("forename")));
		driver.findElement(By.id("forename")).sendKeys("Jonathan");
		Thread.sleep(1000);
		driver.findElement(By.id("surname")).sendKeys("Cheong");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("email123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("telephone")).sendKeys("0421234567");
		Thread.sleep(1000);
		driver.findElement(By.id("message")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='btn-contact btn btn-primary']")).click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));		
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
