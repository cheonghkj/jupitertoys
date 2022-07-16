package jupitertoys;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.netty.handler.timeout.TimeoutException;

public class LoginTest {
	private static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.id("nav-login")).click();
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-login")));
		} catch(TimeoutException tEx) {
			System.out.println("The load time of the login popup was longer than 3 seconds!");
		}
		driver.findElement(By.id("loginUserName")).sendKeys("username123");
		Thread.sleep(1000);
		driver.findElement(By.id("loginPassword")).sendKeys("password123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}