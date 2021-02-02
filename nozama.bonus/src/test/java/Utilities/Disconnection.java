package Utilities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Disconnection {

	public static void disconnect(WebDriver driver) {
		WebElement boutonDeconnexion = driver.findElement(By.linkText("Se d�connecter"));
		try {
			driver.findElement(By.linkText("Se d�connecter"));
		} catch (Error e) {
			assertFalse(e.toString(), false);
		}
		boutonDeconnexion.click();
	}
}
