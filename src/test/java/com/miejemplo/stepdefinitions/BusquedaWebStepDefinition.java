package com.miejemplo.stepdefinitions;

import com.miejemplo.hooks.AbrirNavegador;
import com.miejemplo.questions.TituloPagina;
import com.miejemplo.tasks.RealizarBusqueda;
import com.miejemplo.util.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.StringContains.containsString;

public class BusquedaWebStepDefinition {
  @Given("que el usuario se encuentra en la pagina principal de Yahoo!")
  public void queElUsuarioSeEncuentraEnLaPaginaPrincipalDeYahoo() {
    OnStage.theActorCalled(Constantes.ACTOR).attemptsTo(
            AbrirNavegador.abrirUrl(Constantes.URL_YAHOO)
    );
  }

  @When("el usuario ingresa los {string} de busqueda validos")
  public void elUsuarioIngresaLosDeBusquedaValidos(String datos) {
    theActorInTheSpotlight().attemptsTo(
            RealizarBusqueda.buscarTexto(datos)
    );
  }

  @Then("el sistema muestra el titulo de la pagina con la informacion {string}")
  public void elSistemaMuestraElTituloDeLaPaginaConLaInformacion(String datos) {
    theActorInTheSpotlight().should(
            seeThat(TituloPagina.actual(),
                      containsString(datos))
    );
  }
}
