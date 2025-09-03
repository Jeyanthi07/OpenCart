import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sanity {
	public static void main(String[] args) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.LINUX);
		cap.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());
		driver.quit();
	}

}
