package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CountryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "BO") private WebElement lnkBolivia;

    public CountryPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);

    }

    public void SeleccionarPaisBolivia(){
        wait.until(ExpectedConditions.visibilityOf(lnkBolivia));
        lnkBolivia.click();

    }

}
