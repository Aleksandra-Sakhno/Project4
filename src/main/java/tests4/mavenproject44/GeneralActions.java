package tests4.mavenproject44;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class GeneralActions {
    private final WebDriver driver;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waiteFor(By locat) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locat));
        WebElement waitedElement = driver.findElement(locat);
        Assert.assertNotNull(waitedElement, "Element not found");
        return waitedElement;
    }

    public void findClick(By locat) {
        WebElement el = driver.findElement(locat);
        Assert.assertNotNull(el, "Element not found");
        el.click();
    }

    public void findClickWait(By locat1, By locat2) {
        WebElement el = driver.findElement(locat1);
        el.click();
        waiteFor(locat2);
    }

    public void findClickWaitClick(By locat1, By locat2) {
        findClick(locat1);
        WebElement waitedElement = waiteFor(locat2);
        waitedElement.click();
        Assert.assertNotNull(waitedElement, "Element not found");
    }

    public void findPrint(By locat, String keys) {
        driver.findElement(locat).sendKeys(keys);
        Assert.assertNotNull(driver.findElement(locat), "Element not found");
    }

    public void findCleanPrint(By locat, String keys) {

        WebElement el=driver.findElement(locat);
        el.sendKeys("\b\b\b\b\b\b\b\b");
        el.sendKeys(keys);
        Assert.assertNotNull(driver.findElement(locat), "Element not found");
    }


    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void egualsEls(By locat,String text) {
        WebElement element = driver.findElement(locat);
        String str = element.getText();
        Assert.assertEquals(str, text, "Element not found");
    }
}