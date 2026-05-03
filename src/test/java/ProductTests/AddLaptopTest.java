package ProductTests;


import DemoBlaze.pages.Cart_page;
import DemoBlaze.pages.Home_page;
import DemoBlaze.pages.PlaceOrder_page;
import DemoBlaze.utilities.TestDataProvider;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DemoBlaze.utilities.TestUtil.prop;

public class AddLaptopTest extends BaseTest {
    @Test(dataProvider = "PlaceOrder_page", dataProviderClass = TestDataProvider.class)
    public void test_homepage(String name, String country, String city,
                              String card, String month, String year) throws InterruptedException {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        SoftAssert soft = new SoftAssert();
        driver.get().get(prop.getProperty("url"));
        Home_page hp = new Home_page(driver.get(), wait.get());
        hp.ClickLaptops();
        hp.clickDell();
        hp.addToCart();


        Cart_page cp = new Cart_page(driver.get(), wait.get());
        cp.clickCartLoc();
        boolean result = cp.isLaptopPresent("2017 Dell 15.6 Inch");
        soft.assertTrue(result, "Product  found in cart");
        Thread.sleep(5000);
        cp.ClickPlaceOrderbtn();

        PlaceOrder_page pop = new PlaceOrder_page(driver.get(), wait.get());
        pop.fillForm(name, country, city, card, month, year);
        pop.ClickPurchaseButton();


        String actualMessage = pop.validatePurchasemsg();
        soft.assertEquals(actualMessage,"Thank you for your purchase!");


        soft.assertAll();
    }


}