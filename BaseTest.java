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
			options.setApp("C://Users//Javi//git//javiandradeprojects//Appium//src//test//java//resources//ApiDemos-debug.apk");

			options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");
			
			// URl class deprecated from java 20
			//this should load apk selected on emulator
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
        service.stop();
		}

}
