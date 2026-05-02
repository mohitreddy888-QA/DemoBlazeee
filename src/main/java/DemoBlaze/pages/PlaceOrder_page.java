package DemoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder_page {
    WebDriver driver;
    WebDriverWait wait;
    public PlaceOrder_page(WebDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait = wait;
    }
    By NameLoc = By.id("name");
    By CountryLoc = By.id("country");
    By cityLoc = By.id("city");
    By creditCardLoc = By.id("card");
    By monthLoc = By.id("month");
    By yearLoc = By.id("year");
    By PurchaseButtonLoc = By.xpath("//button[contains(text(),'Purchase')]");
    By purchaseMsg = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
    //By purchaseMsgLoc = By.xpath("//html/body/div[10]/h2");



    public void enterText(By locator, String value) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.clear();
        element.sendKeys(value);
    }

    public void fillForm(String name, String country, String city,
                         String card, String month, String year) {

        enterText(NameLoc, name);
        enterText(CountryLoc, country);
        enterText(cityLoc, city);
        enterText(creditCardLoc, card);
        enterText(monthLoc, month);
        enterText(yearLoc, year);
    }


    public void ClickPurchaseButton(){
        driver.findElement(PurchaseButtonLoc).click();
    }

    public String validatePurchasemsg(){
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseMsg)).getText();
        System.out.println(message);
        return message;

    }

}
