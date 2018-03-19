
package tests4.mavenproject44.pages;

import tests4.mavenproject44.GeneralActions;
import tests4.mavenproject44.model.ProductData;
import static tests4.mavenproject44.model.ProductData.generate;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ShopPage {
public final By allProd=By.className("all-product-link");
public final By winFind=By.className("ui-autocomplete-input");
public final By ProdFind=By.cssSelector("h1.h1");
public final EventFiringWebDriver driver;
private final GeneralActions act;
private final ProductData productData;
public ShopPage (EventFiringWebDriver  driver){
    this.driver=driver; 
    this.act=new GeneralActions(driver);
    productData = generate();
}
    
public void findProduct(){
    String nameProd = productData.getName();
    final By findProd=By.xpath("//a [contains (text(), '"+nameProd+"')]");
    act.findClickWait(allProd, winFind);
    act.findClickWait(findProd, ProdFind);
}
}
