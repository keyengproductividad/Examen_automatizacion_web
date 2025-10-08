package com.nttdata.page;

import org.openqa.selenium.By;

public class ClothePage {

    public static By categoriaTitle = By.xpath("//*[@id=\"category-3\"]/a");
    public static By subCategoriaTitle = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By producto = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    public static By cantidad = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By añadirCarritoBtn = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By precioUnitario = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]");
}