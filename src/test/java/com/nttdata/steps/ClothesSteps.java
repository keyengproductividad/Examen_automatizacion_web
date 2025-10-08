package com.nttdata.steps;

import com.nttdata.page.CarritoModalPage;
import com.nttdata.page.CarritolPage;
import com.nttdata.page.ClothePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClothesSteps {

    private WebDriver driver;

    //contrsuctor
    public ClothesSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getCategoriaTitle(){
        return this.driver.findElement(ClothePage.categoriaTitle).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */
    public String getSubcategoriaTitle(){
        return this.driver.findElement(ClothePage.subCategoriaTitle).getText();
    }

    public String getCarritoTitle(){
        return this.driver.findElement(CarritolPage.carritoTitle).getText();
    }

    public void agregarProductoCarrito(int unidades){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clothes = wait.until(ExpectedConditions.elementToBeClickable(ClothePage.categoriaTitle));
        clothes.click();

        WebElement men = wait.until(ExpectedConditions.elementToBeClickable(ClothePage.subCategoriaTitle));
        men.click();

        WebElement primerProducto = wait.until(ExpectedConditions.elementToBeClickable(
                ClothePage.producto
        ));
        primerProducto.click();

        WebElement cantidadBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                ClothePage.cantidad
        ));
        cantidadBtn.clear();
        cantidadBtn.sendKeys(String.valueOf(unidades));

        WebElement añadirCarritoBtn = wait.until(ExpectedConditions.elementToBeClickable(
                ClothePage.añadirCarritoBtn
        ));
        añadirCarritoBtn.click();
    }

    public String getCantidad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                CarritoModalPage.modalConfirmacionProducto
        ));
        WebElement cantidadProductoModal = modal.findElement(CarritoModalPage.cantidadProductoModal);
        return cantidadProductoModal.getText();

    }

    public String getPrecioUnitario(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                CarritoModalPage.modalConfirmacionProducto
        ));
        WebElement precioUnitarioModal = modal.findElement(CarritoModalPage.precioUnitarioModal);
        return precioUnitarioModal.getText();
    }

    public String getConfirmacionProducto(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                CarritoModalPage.modalConfirmacionProducto
        ));
        WebElement confirmacionProducto = modal.findElement(CarritoModalPage.confirmacionProducto);
        return confirmacionProducto.getText();
    }

    public String getObtenerMonto(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                CarritoModalPage.modalConfirmacionProducto
        ));
        WebElement monto = modal.findElement(CarritoModalPage.monto);
        return monto.getText();
    }

    public void finalizarCompra(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                CarritoModalPage.modalConfirmacionProducto
        ));

        WebElement finalizarCompraBtn = wait.until(ExpectedConditions.elementToBeClickable(
                CarritoModalPage.finalizarCompraBtn
        ));
        finalizarCompraBtn.click();
    }
}
