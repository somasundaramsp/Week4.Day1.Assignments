package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.className("catText")).click();
		driver.findElement(By.className("linkTest")).click();
		Thread.sleep(2000);
		String noOfShoes = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span")).getText();
		System.out.println("Number of Sports Shoes: " + noOfShoes);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//div[@class='sorting-sec animBounce']//ul/li)[2]")).click();
		Thread.sleep(2000);
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='product-price-row clearfix']//span[contains(@id,'display-price')]"));
		List<Integer> priceList = new ArrayList<>();
		List<Integer> sortList = new ArrayList<>();
		for (WebElement priceList1 : priceElements) {
			priceList.add(Integer.parseInt(priceList1.getText().substring(3).replace(",", "").trim()));
		}
		sortList.addAll(priceList);
		Collections.sort(sortList);
		if (priceList.equals(sortList))
			System.out.println("\'Low to High Price\' Items are sorted correctly");
		else {
			System.out.println("\'Low to High Price\' Items are sorted incorrectly");
			System.out.println(priceList);
		} 
		Thread.sleep(1000);
		WebElement from_Val = driver.findElement(By.xpath("//div[@class='price-text-box']//input[@name='fromVal']"));
		from_Val.clear();
		from_Val.sendKeys("900");
		WebElement toVal = driver.findElement(By.xpath("//div[@class='price-text-box']//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1500");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		Thread.sleep(1000);
		WebElement checkboxBlue = driver.findElement(By.xpath("//label[contains(@for,'Blue')]"));
		checkboxBlue.click();
		List<WebElement> productElements = driver.findElements(By.xpath("//p[@class='product-title']"));
		productElements.get(0).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listallWindows1 = new ArrayList<>(windowHandles1);
		Thread.sleep(1000);
		driver.switchTo().window(listallWindows1.get(1));
		String final_Price = driver.findElement(By.xpath("//span[@class='pdp-final-price']")).getText();
		String discount_Percent = driver.findElement(By.xpath("//span[@class='pdp-final-price']//following-sibling::span[contains(@class,'Discount')]")).getText();
		System.out.println("Final Price of Product: "+final_Price);
		System.out.println("Discount Percentage: "+discount_Percent);
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./scrshots/IMG-0001.png");
		FileUtils.copyFile(screenshot, dest);
		System.out.println("Screenshot Captured ");
	}
}
