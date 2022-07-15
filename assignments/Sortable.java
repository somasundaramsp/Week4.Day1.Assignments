package week4.day1.assignments;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		WebElement from_Element = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[6]"));
		WebElement to_Element = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[2]"));
		Actions builders = new Actions(driver);
		Action dragdrop = builders.clickAndHold(from_Element).moveToElement(to_Element).release(to_Element).build();
		dragdrop.perform();
	}
}