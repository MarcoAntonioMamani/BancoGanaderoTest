package Page;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FilterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Usado']/following-sibling::*[1]")
    private WebElement txtCantidadUsados;

    @FindBy(xpath = "//span[text()='Usado']//..")
    private WebElement liUsados;

    @FindBy(xpath = "//div[@class='andes-tag__label']")
    private WebElement txtTitleSearch;

    public FilterPage(WebDriver d) {
        this.driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void filtrarProductosUsados(int cantidadMinima){
        if (VerificarCantidad(cantidadMinima)){
            liUsados.click();
        }
    }

    public void ValidateResultFilter(String value){
        wait.until(ExpectedConditions.visibilityOf(txtTitleSearch));
        Assert.assertEquals(value.toUpperCase(),txtTitleSearch.getText().toUpperCase());
    }

    private Boolean VerificarCantidad(int cantidadMinima){
        wait.until(ExpectedConditions.visibilityOf(txtCantidadUsados));
        String cantidadUsados=txtCantidadUsados.getText();
        cantidadUsados=ObtenerNumero(cantidadUsados);
        if (Integer.parseInt(cantidadUsados)>=cantidadMinima){
            return true;
        }
        return false;

    }

    public String ObtenerNumero(String content){
        List<String> list = Arrays.asList(
                "(", ")");
        return content.replaceAll(String.valueOf(list),"");
    }

}
