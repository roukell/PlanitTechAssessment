package org.jupiter.pages;

import org.jupiter.GenericMethods.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class Cart {
    WebDriver driver;
    WebDriverWait wait;
    GenericMethods genericMethods;

    @FindBy(xpath = "//td[contains(text(),'Funny Cow')]")
    private WebElement funnyCowText;

    @FindBy(xpath = "//td[contains(text(),'Fluffy Bunny')]")
    private WebElement fluffyBunnyText;

    @FindBy(xpath = "//td[contains(text(),'Stuffed Frog')]")
    private WebElement stuffedFrogText;

    @FindBy(xpath = "//td[contains(text(),'Valentine Bear')]")
    private WebElement valentineBearText;

    @FindBy(xpath = "//td[contains(text(),'Fluffy Bunny')]/following-sibling::td")
    private WebElement fluffyBunnyPrice;

    @FindBy(xpath = "//td[contains(text(),'Stuffed Frog')]/following-sibling::td")
    private WebElement stuffedFrogPrice;

    @FindBy(xpath = "//td[contains(text(),'Valentine Bear')]/following-sibling::td")
    private WebElement valentineBearPrice;

    @FindBy(xpath = "//td[contains(text(),'Funny Cow')]/following-sibling::td//input[@name='quantity']")
    private WebElement funnyCowQty;

    @FindBy(xpath = "//td[contains(text(),'Fluffy Bunny')]/following-sibling::td//input[@name='quantity']")
    private WebElement fluffyBunnyQty;

    @FindBy(xpath = "//td[contains(text(),'Stuffed Frog')]/following-sibling::td//input[@name='quantity']")
    private WebElement stuffedFrogQty;

    @FindBy(xpath = "//td[contains(text(),'Valentine Bear')]/following-sibling::td//input[@name='quantity']")
    private WebElement valentineBearQty;

    @FindBy(xpath = "//td[contains(text(),'Fluffy Bunny')]/following-sibling::td/following-sibling::td/following-sibling::td")
    private WebElement fluffyBunnySubtotal;

    @FindBy(xpath = "//td[contains(text(),'Stuffed Frog')]/following-sibling::td/following-sibling::td/following-sibling::td")
    private WebElement stuffedFrogSubtotal;

    @FindBy(xpath = "//td[contains(text(),'Valentine Bear')]/following-sibling::td/following-sibling::td/following-sibling::td")
    private WebElement valentineBearSubtotal;

    public Cart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        genericMethods = new GenericMethods(driver, wait);
    }

    public Cart verifyFunnyCowItem(int num) {
        if (genericMethods.isElementPresent(funnyCowText)) {
            System.out.println("funny cow is in the cart, going to verify quantity");
            int quantity = Integer.parseInt(funnyCowQty.getAttribute("value"));

            assertEquals(num, quantity);
            System.out.println(num + " funny cow bought");
        } else {
            System.out.println("funny cow is not in the cart, test failed.");
            fail();
        }
        return this;
    }

    public Cart verifyFluffyBunnyItem(int num) {
        if (genericMethods.isElementPresent(fluffyBunnyText)) {
            System.out.println("fluffy bunny is in the cart, going to verify quantity");
            int quantity = Integer.parseInt(fluffyBunnyQty.getAttribute("value"));

            assertEquals(num, quantity);
            System.out.println(num + " fluffy bunny bought");
        } else {
            System.out.println("fluffy bunny is not in the cart, test failed.");
            fail();
        }
        return this;
    }

    public Cart verifyFluffyBunnyItemAndSubtotal(int num) {
        if (genericMethods.isElementPresent(fluffyBunnyText)) {
            System.out.println("fluffy bunny is in the cart, going to verify quantity");
            int quantity = Integer.parseInt(fluffyBunnyQty.getAttribute("value"));
            double price = Double.parseDouble(fluffyBunnyPrice.getText().replace("$", ""));
            double totalPrice = Double.parseDouble(fluffyBunnySubtotal.getText().replace("$", ""));

            assertEquals(quantity * price, totalPrice, 0.0);
            System.out.println("fluffy bunny's total price is correct");
        } else {
            System.out.println("fluffy bunny is not in the cart, test failed.");
            fail();
        }
        return this;
    }

    public Cart verifyStuffedFrogItemAndSubtotal(int num) {
        if (genericMethods.isElementPresent(stuffedFrogText)) {
            System.out.println("stuffed frog is in the cart, going to verify quantity");
            int quantity = Integer.parseInt(stuffedFrogQty.getAttribute("value"));
            double price = Double.parseDouble(stuffedFrogPrice.getText().replace("$", ""));
            double totalPrice = Double.parseDouble(stuffedFrogSubtotal.getText().replace("$", ""));

            assertEquals(quantity * price, totalPrice, 0.0);
            System.out.println("stuffed frog's total price is correct");
        } else {
            System.out.println("fluffy bunny is not in the cart, test failed.");
            fail();
        }
        return this;
    }

    public Cart verifyValentineBearItemAndSubtotal(int num) {
        if (genericMethods.isElementPresent(valentineBearText)) {
            System.out.println("valentine bear is in the cart, going to verify quantity");
            int quantity = Integer.parseInt(valentineBearQty.getAttribute("value"));
            double price = Double.parseDouble(valentineBearPrice.getText().replace("$", ""));
            double totalPrice = Double.parseDouble(valentineBearSubtotal.getText().replace("$", ""));

            assertEquals(quantity * price, totalPrice, 0.0);
            System.out.println("valentine bear's total price is correct");
        } else {
            System.out.println("valentine bear is not in the cart, test failed.");
            fail();
        }
        return this;
    }
}
