package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuscadorPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "cb1-edit")
    private WebElement txtSearch;
    @FindBy(className = "nav-search-btn")
    private WebElement btnSearch;
    @FindBy (xpath = "/html/body/div[2]/div[1]/div[2]/button[1]")
    private WebElement btnAcceptCookie;

    public BuscadorPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void IngresarTextoABuscar(String producto)  {
        wait.until(ExpectedConditions.visibilityOf(btnAcceptCookie));
        btnAcceptCookie.click();
        txtSearch.click();
        txtSearch.sendKeys(producto);
        txtSearch.sendKeys(Keys.ENTER);

    }




}
