package week4.day1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> columns = driver.findElements(By.xpath("//table//th"));
		System.out.println("No of Columns in the table is : "+columns.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		System.out.println("No of Rows in the table is : "+rows.size());
				
		List<WebElement> values = driver.findElements(By.xpath("//table//tr//td"));
				
		for(int i=0; i<values.size();i++)
		{
			WebElement rowText = values.get(i);
			if(rowText.getText().equalsIgnoreCase("Learn to interact with Elements"))
			{
				System.out.println("Progress for "+values.get(i).getText()+" is : "+values.get(i+1).getText());								
			}
		}
		int[] k=new int[4];
		List<WebElement> smallNumber = driver.findElements(By.xpath("//table//tr//td[2]"));
		for(int a=0; a<smallNumber.size();a++)
		{
			WebElement smallNum = smallNumber.get(a);
			String j=smallNum.getText();			
			String h=j.replace("%", "");		
			k[a]=Integer.parseInt(h);			
		}
		Arrays.sort(k);
		String s=String.valueOf(k[0]);  
		String r = s.concat("%");
		System.out.println("Smallest percentage is :"+r);
		
		for(int i=0; i<values.size();i++)
		{
			WebElement rowText = values.get(i);
			if(rowText.getText().equalsIgnoreCase(r))
			{
			    driver.findElement(By.xpath("(//table//tr//td//input)[3]")).click();
									
			}
		}

	}

}
