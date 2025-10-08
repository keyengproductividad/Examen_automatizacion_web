package com.nttdata.steps;

import com.nttdata.page.CarritoModalPage;
import com.nttdata.page.CarritolPage;
import com.nttdata.page.ClothePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoSteps {

    private WebDriver driver;

    //contrsuctor
    public CarritoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getTitle(){
        return this.driver.findElement(CarritolPage.carritoTitle).getText();
    }

    public String getPrecioUnitario(){
        return this.driver.findElement(CarritolPage.precioUnitario).getText();
    }

    public String getMonto(){
        return this.driver.findElement(CarritolPage.monto).getText();
    }

    public String getCantidad(){
        return this.driver.findElement(CarritolPage.cantidad).getText();
    }

}
