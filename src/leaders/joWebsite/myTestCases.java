package leaders.joWebsite;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class myTestCases {
	WebDriver driver;
    Random rand = new Random();
   
    String [] fullName= {"rubaomar","sanaahmad","ramiabdallah"};
    int index=rand.nextInt(fullName.length);
    String emails= fullName[index]+rand.nextInt(9999)+"@gmail.com";
    
 
    
	@BeforeTest
	public void beforeTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leaders.jo/en/product-category/mothers-day-offers-en/");
	}
	@Test(priority = 1)
	public void addToTheCart() throws InterruptedException {

		WebElement allItemsList=driver.findElement(By.cssSelector(".products.product-card-layout-1.columns-4.mobile-col-2.product-list-no-desc-mobile.mobile-show-atc.mobile-featured-icons--hover"));
		List<WebElement>allItems=allItemsList.findElements(By.tagName("li"));

        allItems.get(0).click();
        	
    		
    	WebElement addQuantity=driver.findElement(By.className("increase"));
    	addQuantity.click();
    	
    	WebElement addToCart=driver.findElement(By.className("single_add_to_cart_button"));
    	addToCart.click();
    	
    	Thread.sleep(5000);
        	
	}
	@Test(priority = 2)
	public void signup() throws InterruptedException {
     driver.get("https://leaders.jo/en/my-account/");
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     
     WebElement createAnAccount=driver.findElement(By.cssSelector("h2[class='register']"));
     createAnAccount.click();

     WebElement email=driver.findElement(By.id("reg_email"));
     email.sendKeys(emails);
     
     WebElement password=driver.findElement(By.id("reg_password"));
     password.sendKeys("AbsABS#!1234");//register
	 
     WebElement registerButton=driver.findElement(By.name("register"));
     registerButton.click();
     
		
	}
	
	@Test(priority = 3)
	public void changePassword()
	{
		driver.get("https://leaders.jo/en/my-account/edit-account/");
		
		
		 WebElement firstName=driver.findElement(By.name("account_first_name"));
		 firstName.sendKeys("ahmad");
		 
		 WebElement lastName=driver.findElement(By.name("account_last_name"));
		 lastName.sendKeys("omar");
		
		 WebElement currentPassword=driver.findElement(By.id("password_current"));
		 currentPassword.sendKeys("AbsABS#!1234");
		 
		 WebElement newPassword=driver.findElement(By.id("password_1"));
		 newPassword.sendKeys("abcABC4321##");
		 
		 WebElement confirmNewPassword=driver.findElement(By.id("password_2"));
		 confirmNewPassword.sendKeys("abcABC4321##");
		 
		 WebElement saveChanges=driver.findElement(By.name("save_account_details"));
		 saveChanges.click();
		  
		
	}

	

	
	@AfterTest
	public void postTest() {}

}
