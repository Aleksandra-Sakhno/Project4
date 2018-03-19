
package tests4.mavenproject44.pages;

import tests4.mavenproject44.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class LogginPage {
    public final EventFiringWebDriver driver;
    public static By emailInput = By.id("email");
    private final By passInput = By.id("passwd");
    private final By loginBtb = By.name("submitLogin");

    private final GeneralActions act;

    public LogginPage(EventFiringWebDriver driver) {
        this.driver = driver;
        this.act = new GeneralActions(driver);
    }

    public void loginAsAdmin(String login, String password) {
        act.findPrint(emailInput, login);
        act.findPrint(passInput, password);
        act.findClickWait(loginBtb, MainAdminPage.catalog);
    }

}
