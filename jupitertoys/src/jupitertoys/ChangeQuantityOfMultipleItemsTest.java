package jupitertoys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class ChangeQuantityOfMultipleItemsTest {
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
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#product-2 > div > p > a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#product-3 > div > p > a")).click();
		int expectedResult1=3;
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
		driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tbody > tr:nth-child(1) > td:nth-child(3) > input")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tbody > tr:nth-child(1) > td:nth-child(3) > input")).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tbody > tr:nth-child(2) > td:nth-child(3) > input")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tbody > tr:nth-child(2) > td:nth-child(3) > input")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tbody > tr:nth-child(3) > td:nth-child(3) > input")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tbody > tr:nth-child(3) > td:nth-child(3) > input")).sendKeys("4");
		double expectedTotal=102.91;
		String actualTotal=driver.findElement(By.cssSelector("body > div.container-fluid > div > form > table > tfoot > tr:nth-child(1) > td > strong")).getText();
		actualTotal = actualTotal.replace("Total:","");
		double priceValue=Double.parseDouble(actualTotal);
		if(priceValue == expectedTotal) {
			System.out.println("Correct total");
		} else {
			System.out.println("Incorrect total");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
