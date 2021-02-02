package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CLI002N {
	WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	String baseURL = "http://127.0.0.1/nozama";
	
	
	@Given("^je suis sur la homepage nozama$")
	public void je_suis_sur_la_homepage_nozama() /*throws Throwable*/ {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		try {
			assertTrue(driver.findElement(By.xpath("//div[@id='edit-name-wrapper']/label")).getText()
					.matches("^Nom d'utilisateur : [\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	    //throw new PendingException();
	}

	@When("^je choisis une categorie$")
	public void je_choisis_une_categorie() /*throws Throwable*/ {
		List<WebElement> elements = driver.findElements(By.linkText("Jeux vidéo (5)"));
		assert(elements.size() > 0);
		driver.findElement(By.linkText("Jeux vidéo (5)")).click();
	    //throw new PendingException();
	}

	@When("^je selectionne le produit recherche$")
	public void je_selectionne_le_produit_recherche() /*throws Throwable*/ {
		//je selectionne playstation
		driver.findElement(By.linkText("Playstation")).click();
	    //throw new PendingException();
	}

	@When("^jenregistre le produit dans le panier$")
	public void jenregistre_le_produit_dans_le_panier() /*throws Throwable*/ {
		List<WebElement> elements = driver.findElements(By.id("edit-submit-16"));
	      assert(elements.size() > 0);
	      driver.findElement(By.id("edit-submit-16")).click();
	    //throw new PendingException();
	}

	@Then("^larticle est ajoute au panier$")
	public void larticle_est_ajoute_au_panier() /*throws Throwable*/ {
		 List<WebElement> elements = driver.findElements(By.id("edit-checkout"));
	     assert(elements.size() > 0);
	     driver.findElement(By.id("edit-checkout")).click();
	     driver.close();
	    //throw new PendingException();
	}


}
