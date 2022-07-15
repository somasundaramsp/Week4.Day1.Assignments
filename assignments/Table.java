package week4.day1.assignments;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement element_Table = driver.findElement(By.tagName("table"));
		List<WebElement> row = element_Table.findElements(By.tagName("tr"));
		int colum = 0;
		for (int i = 1; i < row.size(); i++) {
			WebElement eachRow = row.get(i);
			List<WebElement> columns = eachRow.findElements(By.tagName("td"));
			colum = columns.size();
		}
		System.out.println("Number of Columns = "+colum);
	}
}
