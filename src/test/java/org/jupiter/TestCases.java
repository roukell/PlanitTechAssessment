package org.jupiter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.jupiter.pages.Cart;
import org.jupiter.pages.Contact;
import org.jupiter.pages.Home;
import org.jupiter.pages.Shop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {
    WebDriver driver;
    Home home;
    Contact contact;
    Shop shop;
    Cart cart;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://jupiter.cloud.planittesting.com/");
        home = new Home(driver, wait);
        contact = new Contact(driver, wait);
        shop = new Shop(driver, wait);
        cart = new Cart(driver, wait);
    }

    @Test
    public void testCase1() {
        home.clickContact();
        contact.clickSubmitBtn()
                .validateErrorAndDealWithIt()
                .isErrorPresentIfYesFailTest();
    }

    @Test
    public void testCase2() {
        home.clickContact();
        contact.enterForename("John")
                .enterSurname("Doe")
                .enterEmail("test2@test.com")
                .enterPhone("0422333444")
                .enterMessage("Amazing website!")
                .clickSubmitBtn()
                .isErrorPresentIfYesFailTest();
    }

    @Test
    public void testCase3() {
        int numOfFunnyCow = 0;
        int numOfFluffyBunny = 0;

        home.clickShop();

        // buy 2 funny cow
        while (numOfFunnyCow < 2) {
            shop.clickBuyFunnyCow();
            numOfFunnyCow++;
        }

        // buy 1 fluffy bunny
        while (numOfFluffyBunny < 1) {
            shop.clickBuyFluffyBunny();
            numOfFluffyBunny++;
        }

        home.clickCart();
        cart.verifyFunnyCowItem(numOfFunnyCow)
                .verifyFluffyBunnyItem(numOfFluffyBunny);
    }

    @Test
    public void testCase4() {
        int numOfFrog = 0;
        int numOfFluffyBunny = 0;
        int numOfValentineBear = 0;

        home.clickShop();

        // buy 2 stuffed frog
        while (numOfFrog < 2) {
            shop.clickBuyStuffedFrog();
            numOfFrog++;
        }

        // buy 5 fluffy bunny
        while (numOfFluffyBunny < 5) {
            shop.clickBuyFluffyBunny();
            numOfFluffyBunny++;
        }

        // buy 3 valentines bear
        while (numOfValentineBear < 3) {
            shop.clickBuyValentineBear();
            numOfValentineBear++;
        }

        home.clickCart();
        cart.verifyFluffyBunnyItemAndSubtotal(numOfFluffyBunny)
                .verifyStuffedFrogItemAndSubtotal(numOfFrog)
                .verifyValentineBearItemAndSubtotal(numOfValentineBear);
    }

    @After
    public void after() {
        driver.close();
    }
}
