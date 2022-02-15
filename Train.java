package week4.day1;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Train {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
        driver.manage().window().maximize(); // Maximize the opened chrome browser window
        driver.get("https://erail.in/"); // Loads the URL in the opened browser
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement from = driver.findElement(By.id("txtStationFrom"));
        from.clear();
        from.sendKeys("TPJ", Keys.TAB);
        WebElement to = driver.findElement(By.id("txtStationTo"));
        to.clear();
        to.sendKeys("MDU", Keys.TAB);
        driver.findElement(By.id("chkSelectDateOnly")).click();
        Thread.sleep(2000);
        WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
        List<WebElement> eachRow = table.findElements(By.tagName("tr"));
        for(int i=0; i<eachRow.size();i++)
        {
        	WebElement currentRow = eachRow.get(i);
        	List<WebElement> eachColumn = currentRow.findElements(By.tagName("td"));
        	for(int j=0; j<eachColumn.size(); j++)
            {
        		//System.out.println(eachColumn.get(j).getText());
        		String SF = eachColumn.get(j).getText();
        		
        		//boolean status = eachColumn.contains("SF");
            	if(SF.contains("SF"))
            	{
            		System.out.println("Trains are : "+SF);
            		System.out.println("Train No : "+eachColumn.get(j-1).getText());
            	}
            }
        	
        }  

	}

}
