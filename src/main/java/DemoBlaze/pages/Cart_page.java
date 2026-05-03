package DemoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Cart_page {

    WebDriver driver;
    WebDriverWait wait;
    public Cart_page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    By CartLoc = By.id("cartur");
    By CartTable = By.xpath("//table[@class = 'table table-bordered table-hover table-striped']/tbody/tr");
    By PlaceorderBtn = By.xpath("//button[text() = 'Place Order']");

    public void clickCartLoc(){
        driver.findElement(CartLoc).click();
    }


    public boolean isPhonePresent(String value) {
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CartTable));
        for (WebElement row : rows) {
            if (row.getText().contains(value)) {
                System.out.println("Your mobile is added in cart");
                return true;
            }

        }
        return false;
    }
    public boolean isLaptopPresent(String value) {
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CartTable));
        for (WebElement row : rows) {
            if (row.getText().contains(value)) {
                System.out.println("Your Laptop is added in cart");
                return true;
            }

        }
        return false;
    }


    public void ClickPlaceOrderbtn() {
        driver.findElement(PlaceorderBtn).click();
    }
}



