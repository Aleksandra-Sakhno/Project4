package tests4.mavenproject44.pages;

import org.openqa.selenium.*;
import tests4.mavenproject44.GeneralActions;
import tests4.mavenproject44.model.ProductData;

import static tests4.mavenproject44.model.ProductData.generate;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateProductPage {

    public static By newProdBtn = By.xpath("//span[@class='title'][contains(text(), 'Новый товар')]");
    public static By nameProduct = By.id("form_step1_name_1");
    public static By priceProduct = By.id("form_step1_price_shortcut");
    public static By qtyProduct = By.id("form_step1_qty_0_shortcut");
    public static By switchInp = By.className("switch-input");
    public static By saveProd = By.cssSelector(".btn-primary.js-btn-save");
    public static By close = By.className("growl-close");
    public final EventFiringWebDriver driver;
    private final GeneralActions act;
    private final ProductData productData;


    public CreateProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
        this.act = new GeneralActions(driver);
        productData = generate();
    }

    public void createProduct() {
        String nameProd = productData.getName();
        String priceProd = productData.getPrice();
        String qtyProd = Integer.toString(productData.getQty());
        act.findClickWait(newProdBtn, nameProduct);
        act.findPrint(nameProduct, nameProd);
        act.findCleanPrint(qtyProduct, qtyProd);
        act.scroll();
        act.findCleanPrint(priceProduct, priceProd);
        act.findClickWaitClick(switchInp, close);
        act.findClickWaitClick(saveProd, close);
        }
}
