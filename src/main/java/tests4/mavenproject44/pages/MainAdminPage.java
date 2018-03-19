
package tests4.mavenproject44.pages;

import tests4.mavenproject44.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class MainAdminPage {
    public final EventFiringWebDriver driver;
    private final GeneralActions act;
    public static By catalog = By.xpath("//span[contains(text(), 'Каталог')]");

    public MainAdminPage(EventFiringWebDriver driver) {
        this.driver = driver;
        this.act = new GeneralActions(driver);
    }

    public void goCreateProduct() {
        act.findClickWait(catalog, CreateProductPage.newProdBtn);

    }
}