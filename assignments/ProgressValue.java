package week4.day1.assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgressValue {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement elementTable = driver.findElement(By.tagName("table"));
		List<WebElement> row = elementTable.findElements(By.tagName("tr"));
		for (int s = 1; s < row.size(); s++) {
			WebElement each_Row = row.get(s);
			List<WebElement> columns = each_Row.findElements(By.tagName("td"));
			for (int p = 0; p < columns.size(); p++) {
				if (columns.get(p).getText().contains("Learn to interact with Elements")) {
					System.out.println(row.get(s).getText());
				}
			}
		}
	}
}
