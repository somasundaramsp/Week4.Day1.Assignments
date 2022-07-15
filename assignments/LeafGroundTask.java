package week4.day1.assignments;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTask {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		List<WebElement> progressValue = driver.findElements(By.xpath("//table//tr/td[2]"));
		List<Integer> progvalue = new ArrayList<>();
		for (WebElement progValue : progressValue) {
			progvalue.add(Integer.parseInt(progValue.getText().replace("%", "")));
			}
		int minivalue = progvalue.get(0);
		int minivalueRow = 0;
		for (int s = 0; s < progvalue.size(); s++) {
			if (minivalue > progvalue.get(s)) {
				minivalue = progvalue.get(s);
				minivalueRow = s+2;
			}
		}
		driver.findElement(By.xpath("//table//tr["+minivalueRow+"]/td[3]")).click();
		boolean leafChecked = driver.findElement(By.xpath("(//input[@name='vital'])[5]")).isEnabled();
		System.out.println("LeafGround for least completed progress is checked: "+leafChecked);
		}	
	}	
