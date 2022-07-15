package week4.day1.assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTableValues {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drivers = new ChromeDriver();
		drivers.manage().window().maximize();
		drivers.get("https://html.com/tags/table/");
		List<WebElement> head_Element = drivers.findElements(By.xpath("//div[@class='render']/table/thead/tr/th"));
		List<WebElement> row_1 = drivers.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
		List<WebElement> row_2 = drivers.findElements(By.xpath("//div[@class='render']/table/tbody/tr[2]/td"));
		for (WebElement each_Header : head_Element) {
			System.out.print("  "+each_Header.getText()+"      ");
		}
			System.out.println();
			for (WebElement first_Row : row_1) {
				
				System.out.print(first_Row.getText()+"\t   ");
			}
			System.out.println();
				for (WebElement second_Row : row_2) {
				
					System.out.print(second_Row.getText()+"\t   ");
				}
	}
}