package javiandradeprojects.Appium;



import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{

	@Test
	public void WifiSettingsName()  throws MalformedURLException, URISyntaxException {
		
		//Xpath, id, accessibilityId, classname, androidUIAutomator -->only for mobile
			driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			 //tagName[@attribute='value']  -> //tagName
			driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
			driver.findElement(By.id("android:id/checkbox")).click();
			driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
			String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
			Assert.assertEquals(alertTitle, "WiFi settings");	
			driver.findElement(By.id("android:id/edit")).sendKeys("prueba");
			driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


	}
	

}

