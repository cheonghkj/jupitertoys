package jupitertoys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class CheckoutTest {
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
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-large']")).click();
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-success btn-large']")));
		} catch(TimeoutException tEx) {
			System.out.println("The load time to enter the shop page was longer than 3 seconds!");
		}
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#product-1 > div > p > a")).click();
		int expectedResult1=1;
		String actualResult1=driver.findElement(By.xpath("//span[@class='cart-count ng-binding']")).getText();
		int cartValue=Integer.parseInt(actualResult1);
		if(cartValue == expectedResult1) {
			System.out.println("Correct number of items in the cart");
		} else {
			System.out.println("Incorrect number of items in the cart");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("nav-cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='btn-checkout btn btn-success  ng-scope']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("forename")));
		driver.findElement(By.id("forename")).sendKeys("Jonathan");
		Thread.sleep(1000);
		driver.findElement(By.id("surname")).sendKeys("Cheong");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("email123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("telephone")).sendKeys("0421234567");
		Thread.sleep(1000);
		driver.findElement(By.id("address")).sendKeys("123 Something Street");
		Thread.sleep(1000);
		Select droplist = new Select(driver.findElement(By.id("cardType")));
		droplist.selectByVisibleText("Visa");
		Thread.sleep(1000);
		driver.findElement(By.id("card")).sendKeys("1234 5678 1234 5678");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button#checkout-submit-btn.btn.btn-primary")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));		
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.popup.modal.hide.ng-scope")));
		Thread.sleep(3000);
		driver.quit();
	}
}
