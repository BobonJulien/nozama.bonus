package StepDefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CLI003N {

	WebDriver driver;
	private StringBuffer verifyElement = new StringBuffer();
	String baseURL = "http://127.0.0.1/nozama";

	@Given("^je suis sur la page nozama$")
	public void je_suis_sur_la_page_nozama() /* throws Throwable */ {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		// throw new PendingException();
		try {
			assertTrue(driver.findElement(By.xpath("//div[@id='edit-name-wrapper']/label")).getText()
			.matches("Nom d'utilisateur : [//s//S]*$"));
		} catch (Error e) {
		verifyElement.append(e.toString());
		}
	}

	@When("^je rentre le nom dun produit dans la barre de recherche$")
	public void je_rentre_le_nom_dun_produit_dans_la_barre_de_recherche()/* throws Throwable */ {
		
		// throw new PendingException();
	}

	@When("^je clique sur le bouton de recherche$")
	public void je_clique_sur_le_bouton_de_recherche() /* throws Throwable */ {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^selectionne le produit recherche$")
	public void selectionne_le_produit_recherche() /* throws Throwable */ {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^que jenregistre le produit dans mon panier$")
	public void que_jenregistre_le_produit_dans_mon_panier() /* throws Throwable */ {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^le produit recherche est ajoute dans le panier$")
	public void le_produit_recherche_est_ajoute_dans_le_panier()/* throws Throwable */ {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}
}
