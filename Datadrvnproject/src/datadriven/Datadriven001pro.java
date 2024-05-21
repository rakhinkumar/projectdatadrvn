package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriven001pro {
	WebDriver driver;
	@Test(dataProvider="testdata")
	public void DemoProject(String firstName, String lastName, String phoneNumber, String email, String address,
            String city, String state, String pincode, String country, String username, String password,
            String confirmPassword)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rakhi N Kumar\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.name("phone")).sendKeys(phoneNumber);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(pincode);
		driver.findElement(By.name("country")).sendKeys(country);
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
		driver.findElement(By.name("submit")).click();
	}
	@DataProvider(name="testdata")
	public Object[][] testdatafeed()
	{
		ReadExcel001 config=new ReadExcel001("C:\\Users\\Rakhi N Kumar\\OneDrive\\Desktop\\datadriven22.xlsx");
		
		 int totalRows = Math.min(config.getRowCount(0), 2);
		
		Object[][] credntls=new Object[totalRows][12];//mentilon ony 2 values in excel sheet
		 for(int i = 0; i < totalRows; i++) 
		for (int j = 0; j < 12; j++)
		{
			credntls[i][j] = config.getData(0, i, j);
			
		}
		return credntls;
		
		}
	}



