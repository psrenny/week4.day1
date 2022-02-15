package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/sorttable.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File fileName1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./src/main/resources/screenshots/Week4.Day1/SortTable/before.jpeg");
		FileUtils.copyFile(fileName1, dest1);
		
		List<WebElement> values = driver.findElements(By.xpath("//table//tr//td[2]"));
		List<String> Name = new ArrayList<String>();
		for (WebElement eachName : values) {		
			Name.add(eachName.getText());
		}
		Collections.sort(Name);
		System.out.println("Names before sorting : "+Name);
		
		driver.findElement(By.xpath("(//th[@class='sorting'])[1]")).click();
		File fileName2 = driver.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("./src/main/resources/screenshots/Week4.Day1/SortTable/afterSorting.jpeg");
		FileUtils.copyFile(fileName2, dest2);
		
		List<WebElement> sortValues = driver.findElements(By.xpath("//table//tr//td[2]"));
		List<String> sortName = new ArrayList<String>();
		for (WebElement eachSortName : sortValues) {		
			sortName.add(eachSortName.getText());
		}
		System.out.println("Names after sorting : "+sortName);

		//Comparing 2 lists
		for(int i=0; i<Name.size();i++)
		{
			if((Name.get(i)).equals(sortName.get(i)))
			{
				System.out.println("List1 name '"+Name.get(i)+"' is equal to List2 name '"+sortName.get(i)+"'");
			}		
			else
			{
			System.out.println("Names in 2 lists are not in sorted order");
			}
		}
		
	}

}
