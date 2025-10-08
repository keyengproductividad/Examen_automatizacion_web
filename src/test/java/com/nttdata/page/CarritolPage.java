package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritolPage {

    public static By carritoTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By precioUnitario = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By cantidad = By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]");
    public static By monto = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
}