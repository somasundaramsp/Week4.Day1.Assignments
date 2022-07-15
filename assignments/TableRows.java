package week4.day1.assignments;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableRows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement element_Table = driver.findElement(By.tagName("table"));
		List<WebElement> row = element_Table.findElements(By.tagName("tr"));
		System.out.println("Number of Rows = "+row.size());
	}
}
