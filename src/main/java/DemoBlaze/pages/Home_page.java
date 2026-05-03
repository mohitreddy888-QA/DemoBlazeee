package DemoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_page {

    WebDriver driver;
    WebDriverWait wait;

    public Home_page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By phones = By.xpath("//a[contains(text(),'Phones')]");
    By sony = By.xpath("//a[contains(text(),'Sony xperia z5')]");
    By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");
    By LaptopLoc = By.xpath("//a[contains(text(),'Laptops')]");
    By Dell = By.xpath("//a[contains(text(),'2017 Dell 15.6 Inch')]");

    public void clickPhones() {
        wait.until(ExpectedConditions.elementToBeClickable(phones)).click();
    }
    public void ClickLaptops(){
        wait.until(ExpectedConditions.elementToBeClickable(LaptopLoc)).click();
    }

    public void clickSony() {
        wait.until(ExpectedConditions.elementToBeClickable(sony)).click();
    }
    public void clickDell() {
        wait.until(ExpectedConditions.elementToBeClickable(Dell)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

        // wait for alert properly
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}