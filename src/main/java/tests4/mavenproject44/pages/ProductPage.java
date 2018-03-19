package tests4.mavenproject44.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import tests4.mavenproject44.GeneralActions;
import tests4.mavenproject44.model.ProductData;

import static tests4.mavenproject44.model.ProductData.generate;


public class ProductPage {

    public static By checkPriceProduct = By.cssSelector(".current-price");
    public static By checkQtyProduct = By.className("product-quantities");
    public static By detailsBtn = By.className("nav-link");


    public final EventFiringWebDriver driver;
    private final GeneralActions act;
    private final ProductData productData;

    public ProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
        this.act = new GeneralActions(driver);
        productData = generate();
    }

    public void checkProduct() {
        String nameProd = productData.getName();
        String priceProd=productData.getPrice();
        String qtyProd=Integer.toString(productData.getQty());
        final By findProd=By.xpath("//h1 [contains (text(), '"+nameProd+"')]");
        Assert.assertNotNull(findProd, "Element not found");
        act.egualsEls(checkPriceProduct,priceProd+" ₴");
        act.findClickWait(detailsBtn,checkQtyProduct);
        act.egualsEls(checkQtyProduct,"По наличию "+qtyProd+" Товары");
}
}
