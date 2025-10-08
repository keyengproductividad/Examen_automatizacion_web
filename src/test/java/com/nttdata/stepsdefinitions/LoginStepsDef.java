package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarritoSteps;
import com.nttdata.steps.ClothesSteps;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class LoginStepsDef {

    private WebDriver driver;


    private ClothesSteps clothesSteps(WebDriver driver){
        return new ClothesSteps(driver);
    }

    private CarritoSteps carritoSteps(WebDriver driver){
        return new CarritoSteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y contraseña {string}")
    public void meLogueoConMiUsuarioYContraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        String title =  clothesSteps(driver).getCategoriaTitle();
        //prueba: validamos el título del producto
        Assertions.assertEquals(categoria, title);
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        clothesSteps(driver).agregarProductoCarrito(unidades);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        // Write code here that turns the phrase above into concrete actions
        String title =  clothesSteps(driver).getConfirmacionProducto();
        //prueba: validamos el título del producto
        Assertions.assertTrue(title.contains("Producto añadido correctamente a su carrito de compra"));
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String cantidadProducto =  (clothesSteps(driver).getCantidad());
        String precioUnitarioString =  clothesSteps(driver).getPrecioUnitario();
        int size = precioUnitarioString.length();
        double precioUnitario = Double.parseDouble(precioUnitarioString.substring(0, size - 4).replace(",", "."));
        String montoObtenido = clothesSteps(driver).getObtenerMonto();
        double montoCalculado = Double.parseDouble(cantidadProducto)*precioUnitario;
        String montoCalculadoString = String.format("%.2f", montoCalculado) + " PEN";
        Assertions.assertEquals(montoObtenido, montoCalculadoString);
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        // Write code here that turns the phrase above into concrete actions
        clothesSteps(driver).finalizarCompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String title =  carritoSteps(driver).getTitle();
        Assertions.assertEquals(title, "CARRITO");
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String cantidadProductoString =  (carritoSteps(driver).getCantidad());
        int size = cantidadProductoString.length();
        double cantidadProducto = Double.parseDouble(cantidadProductoString.substring(0, size - 10).replace(",", "."));
        String precioUnitarioString =  carritoSteps(driver).getPrecioUnitario();
         size = precioUnitarioString.length();
        double precioUnitario = Double.parseDouble(precioUnitarioString.substring(0, size - 4).replace(",", "."));
        String montoObtenido = carritoSteps(driver).getMonto();
        double montoCalculado = cantidadProducto*precioUnitario;
        String montoCalculadoString = String.format("%.2f", montoCalculado) + " PEN";
        Assertions.assertEquals(montoObtenido, montoCalculadoString);
    }
}

