package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoModalPage {

    public static By modalConfirmacionProducto = By.xpath("//*[@id=\"blockcart-modal\"]/div");
    public static By confirmacionProducto = By.xpath("//*[@id=\"myModalLabel\"]");
    public static By monto = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[2]/span[2]");
    public static By cantidadProductoModal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By precioUnitarioModal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By finalizarCompraBtn = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
}