package week4.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTables {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drivers = new ChromeDriver();
		drivers.manage().window().maximize();
		drivers.get("https://html.com/tags/table/");
		WebElement elementTable = drivers.findElement(By.tagName("table"));
		List<WebElement> row = elementTable.findElements(By.tagName("tr"));
		System.out.println("Number of Rows = "+row.size());
		int colum = 0;
		for (int i = 1; i < row.size()-1; i++) {
			WebElement each_Row = row.get(i);
			List<WebElement> column = each_Row.findElements(By.tagName("td"));
			colum = column.size();
		}
		System.out.println("Number of Columns = "+colum);
	}
}
