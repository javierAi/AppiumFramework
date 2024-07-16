package javiandradeprojects.Appium;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MisceallanousAppiumActions extends BaseTest{

	@Test
	public void Miscellanous() throws MalformedURLException
	{
		//KNOW THE ACTIVITY, HAVE THE EMULATOR ON THE PAGE DESIRED-->NAVIGATE DIRECTLY
		//adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
		// adb shell dumpsys window | find "mCurrentFocus"  - Windows
		//C:\Users\Javi>adb shell dumpsys window | find "mCurrentFocus"
		  // mCurrentFocus=Window{b43612e u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
		//App Package (global name) & App Activity (diferent pages within an app)   one package --> multiple activities

		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);--> deprecated
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", 
				ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies" ));
		//driver.currentActivity();
		//
		
		
		//////////////////
		//from portrait to landscape
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		/////////////////////

		
		//like copy but to clipboard
		driver.setClipboardText("Rahul Wifi");
		//like paste
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		//
		
		// Android buttons
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}
	
	
}
