package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.Disconnection;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CLI001N {
	WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	@Given("^navigateur Chrome ouvert et application sur homepage$")
	public void navigateur_Chrome_ouvert_et_application_sur_homepage() /*throws Throwable*/ {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1/nozama");
		//verifier que le formulaire de connexion est bien present
		try {
			assertTrue(driver.findElement(By.xpath("//div[@id='edit-name-wrapper']/label")).getText()
					.matches("^Nom d'utilisateur : [\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue(driver.findElement(By.xpath("//div[@id='edit-pass-wrapper']/label")).getText()
					.matches("^Mot de passe : [\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    //throw new PendingException();
	}

	@When("^renseigner username password$")
	public void renseigner_username_password() /*throws Throwable*/ {
		//verifier que les champs sont bien presents avant de les remplir
		try {
			assertTrue(isElementPresent(By.id("edit-name")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue(isElementPresent(By.id("edit-pass")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		//remplir les champs
		driver.findElement(By.id("edit-name")).click();
		driver.findElement(By.id("edit-name")).clear();
		driver.findElement(By.id("edit-name")).sendKeys("demo1");
		driver.findElement(By.id("edit-pass")).click();
		driver.findElement(By.id("edit-pass")).clear();
		driver.findElement(By.id("edit-pass")).sendKeys("demo1");
		try {
			assertTrue(isElementPresent(By.id("edit-submit")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    //throw new PendingException();
	}

	@When("^valider le formulaire$")
	public void valider_le_formulaire() /*throws Throwable*/ {
		//cliquer sur le bouton se connecter
		driver.findElement(By.id("edit-submit")).click();
	    //throw new PendingException();
	}

	@Then("^verifier que je suis connecte avec login et mdp$")
	public void verifier_que_je_suis_connecte_avec_login_et_mdp() /*throws Throwable*/ {
		//verifier que le bouton se deconnecter est present
		try {
			assertTrue(isElementPresent(By.linkText("Se déconnecter")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Disconnection.disconnect(driver);
		try {
			assertTrue(driver.findElement(By.xpath("//div[@id='edit-name-wrapper']/label")).getText()
					.matches("^Nom d'utilisateur : [\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.close();
	    //throw new PendingException();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
		return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
