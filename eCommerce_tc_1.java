package javiandradeprojects.Appium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{

	
	@Test
	public void FillForm() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Javi Andrade Projects");
		driver.hideKeyboard(); //not forget this
		//xpath with tagname
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		
		driver.findElement(By.id("android:id/text1")).click(); //select dropdown first
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spain\"));")); //search
		driver.findElement(By.xpath("//android.widget.TextView[@text='Spain']")).click(); //click
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Thread.sleep(3000);
		
		//TOAST MESSAGES CAN NOT BE CAPTURED FROM SIMULATOR
		//driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
		//String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//Assert.assertEquals(toastMessage,"Please enter your name");
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		//because it can be several ADD TO CART buttons with same atributes
	int productCount =	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size(); //number of elements with the same element
	
	for(int i =0;i<productCount;i++)
	{
		String productName =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		
		if(productName.equalsIgnoreCase("Jordan 6 Rings"))// buscamos el campo concreto
		{
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click(); 
		}
	}
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	//
	
	//validate we are on Cart page and the products selected are
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5)); //could need include maven dependency on pom.xml
    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
	
	String lastPageProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
	
	}	
	
}
		