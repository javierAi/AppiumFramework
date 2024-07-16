package javiandradeprojects.Appium;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver; 
	public AppiumDriverLocalService service; //local appium server
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		//code to start Appium server	
				//AndroidDriver , IOSDriver
				//Appium code - > Appium Server -> Mobile Device
				//to start appium server from here
				//
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Javi//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
					
			UiAutomator2Options options = new UiAutomator2Options();
			//options.setDeviceName("RahulPhone"); //emulator
			options.setDeviceName("Pixel_Javi"); //from Android Studio
			//options.setApp("C://Users//Javi//git//javiandradeprojects//Appium//src//test//java//resources//ApiDemos-debug.apk");
			options.setApp("C://Users//Javi//git//javiandradeprojects//Appium//src//test//java//resources//General-Store.apk");
			options.setChromedriverExecutable("C://Users//Javi//Desktop//Utils//chromedriver.exe"); //to switch to web if HYBRID
			
			// URl class deprecated from java 20
			//this should load apk selected on emulator
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
			//example of explicit
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
			//implicit, wait for all elements in DOM to be available
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// MOBILE GESTURE
	//https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md
	public void longPressAction(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"duration",2000));
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	
	
	public void swipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));//remove $ simbol + cast to double
		return price;
	}
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();
        service.stop();
		}

}
