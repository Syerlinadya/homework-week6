package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Step {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login swag labs")
    public void halaman_login_swag_labs() {
        // Implementasi logika untuk langkah ini
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("Input username")
    public void input_username() {
        // Implementasi logika untuk langkah ini
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("Input password")
    public void input_password() {
        // Implementasi logika untuk langkah ini
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("click login button")
    public void click_login_button() {
        // Implementasi logika untuk langkah ini
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User in on products page")
    public void user_in_on_products_page() {
        // Implementasi logika untuk langkah ini
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }

    @And("Input Invalid Password")
    public void input_invalid_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
    }

    @Then("user get error message")
    public void user_get_error_message(){
        String errorlogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorlogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @When("user add product to cart")
    public void user_add_product_to_cart() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("Product should be in cart")
    public void product_should_be_in_cart() {
        driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click();
    }

    @Then("user click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.cssSelector("div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.primary_header div.shopping_cart_container:nth-child(3) > a.shopping_cart_link")).click();
    }

    @Then("user click checkout")
    public void user_click_checkout() {
        driver.findElement(By.cssSelector("#checkout")).click();

    }
}
