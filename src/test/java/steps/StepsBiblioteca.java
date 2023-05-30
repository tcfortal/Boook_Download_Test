package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class StepsBiblioteca {
	
	
	WebDriver driver = new ChromeDriver();
	
	
	@Before
	public void before() {
		System.setProperty( "webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
	}
	
	
	
	
	
	@Given("that Im on the site {string}")
	public void that_im_on_the_site(String url) {
		driver.get(url);
	  
	}

	

	@And("enter the name of the book to be searched {string}")
	public void enter_the_name_of_the_book_to_be_searched(String nomeLivro) {
		driver.findElement(By.name("nome")).sendKeys(nomeLivro);
		
	   
	}
	
	

	@And("I click search")
	public void i_click_search() {
		driver.findElement(By.name("submit")).click();
	   
	}
	
	
	
	
	@And("should return the searched book {string}")
	public void should_return_the_searched_book(String nomeLivro1) {
	assertTrue(driver.getPageSource().contains("Atenção Básica no Sistema Único de Saúde (SUS)"));
	String livroEncontrado = driver.findElement(By.xpath("//*[@id=\"service-page\"]/div/div/div/div/div/div/div/section[4]/div/div/div/div/div/div/div/div/article/div/div/div/header/h2/a")).getText();
    assertEquals(nomeLivro1, livroEncontrado);	
	
	
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	
	

	
	
	
	@And("I click access")
	public void i_click_access() {
		
		driver.findElement(By.xpath("//*[@id=\"service-page\"]/div/div/div/div/div/div/div/section[4]/div/div/div/div/div/div/div/div/article/div/div/div/div/div/a[1]")).click();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}


	
	
	
	@And("I click on another in access")
	public void i_click_on_another_in_access() {
		
		driver.findElement(By.xpath("/html/body/div[1]/div/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"service-page\"]/div/div/div/div/div/div/div/section[2]/div/div/div/div/div/div/div/div/article/div[2]/div[4]/p/a")).click();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	

	@When("the book open in pdf")
	public void the_book_open_in_pdf() {
	String nomePdf = driver.findElement(By.xpath("/html/body/div/a[2]")).getText();
	assertEquals(nomePdf, "n. 93 (2022): Atenção Básica no Sistema Único de Saúde (SUS))");
	   
	}
	
	
	

	@Then("I download {string}")
	public void i_download(String tituloBaixar) {
		
	String baixar = driver.findElement(By.xpath("/html/body/div/a[3]")).getText();
	assertEquals(tituloBaixar, baixar);
	driver.findElement(By.xpath("/html/body/div/a[3]")).click();
	
	
	
	

	  
	}
	
	
	@Then("close")
	public void close() throws InterruptedException {
		Thread.sleep(7000);
		
		System.out.println("TESTE FINALIZADOOOOOO");
		
		driver.close();

		
	}
	
	
	
	
	

}
