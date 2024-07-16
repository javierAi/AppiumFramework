package javiandradeprojects.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{

	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	{

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//where to scroll is known prior --> element "WebView"
		
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
		//No prior idea
		scrollToEndAction();
		
		//Thread.sleep(2000);
		
	
	
		
			
	}
	
	
}
