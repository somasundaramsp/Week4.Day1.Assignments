package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drivers = new ChromeDriver();
		drivers.manage().window().maximize();
		drivers.get("https://www.chittorgarh.com/");
		drivers.findElement(By.id("navbtn_stockmarket")).click();
		drivers.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		List<WebElement> element_Names = drivers.findElements(By.xpath("//table[contains(@class,'table table-bordered')]/tbody/tr/td[3]"));
		List<String> secs_Name = new ArrayList<String>();
		System.out.println("Security Names List:");
		for (int s = 0; s < element_Names.size(); s++) {
			secs_Name.add(element_Names.get(s).getText());
		}
		System.out.println(secs_Name);
		System.out.println("\n Duplicate Entries are: ");

		for (int p = 0; p <= secs_Name.size() - 1; p++) {

			for (int m = p + 1; m < secs_Name.size();) {
				if (secs_Name.get(p).equalsIgnoreCase(secs_Name.get(m))) {
					System.out.println(secs_Name.get(p));
				}
				break;
			}
		}
	}
}