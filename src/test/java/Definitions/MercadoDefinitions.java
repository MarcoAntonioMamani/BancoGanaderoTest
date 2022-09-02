package Definitions;

import Page.BuscadorPage;
import Page.CountryPage;
import Page.FilterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;

import java.util.logging.Filter;

public class MercadoDefinitions {

    CountryPage countryPage;
    BuscadorPage buscadorPage;
    FilterPage filterPage;
    public MercadoDefinitions(){
        countryPage=new CountryPage(Hooks.driver);
        buscadorPage=new BuscadorPage(Hooks.driver);
        filterPage=new FilterPage(Hooks.driver);
    }
    @Given("la pagina de Mercado Libre esta estable")
    public void laPaginaDeMercadoLibreEstaEstable() {
        Hooks.driver.get("https://mercadolibre.com/");
    }

    @When("doy click en el pais bolivia")
    public void doyClickEnElPaisBolivia() {
        countryPage.SeleccionarPaisBolivia();
    }

    @And("ingreso el producto {string} a buscar")
    public void ingresoElProductoABuscar(String producto) {
        buscadorPage.IngresarTextoABuscar(producto);
    }

    @And("verificamos y filtramos los productos usados mayor o igual a {int}")
    public void verificamosYFiltramosLosProductosUsadosMayorOIgualA(int cantidad) {
  filterPage.filtrarProductosUsados(cantidad);
    }

    @Then("El listado de resultados nos desplegara solo de los productos {string}")
    public void elListadoDeResultadosNosDesplegaraSoloDeLosProductos(String value) {
        filterPage.ValidateResultFilter(value);
    }
}
