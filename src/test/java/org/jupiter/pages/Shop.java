package org.jupiter.pages;

import org.jupiter.GenericMethods.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shop {
    WebDriver driver;
    WebDriverWait wait;
    GenericMethods genericMethods;

    @FindBy(xpath = "//h4[text()='Funny Cow']/..//p//a")
    private WebElement funnyCowBuyBtn;

    @FindBy(xpath = "//h4[text()='Fluffy Bunny']/..//p//a")
    private WebElement fluffyBunnyBuyBtn;

    @FindBy(xpath = "//h4[text()='Stuffed Frog']/..//p//a")
    private WebElement stuffedFrogBuyBtn;

    @FindBy(xpath = "//h4[text()='Valentine Bear']/..//p//a")
    private WebElement valentineBearBuyBtn;

    public Shop(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        genericMethods = new GenericMethods(driver, wait);
    }

    public Shop clickBuyFunnyCow() {
        System.out.println("click buy funny cow");
        genericMethods.clickElement(funnyCowBuyBtn);
        return this;
    }

    public Shop clickBuyFluffyBunny() {
        System.out.println("click buy fluffy bunny");
        genericMethods.clickElement(fluffyBunnyBuyBtn);
        return this;
    }

    public Shop clickBuyStuffedFrog() {
        System.out.println("click buy stuffed frog");
        genericMethods.clickElement(stuffedFrogBuyBtn);
        return this;
    }

    public Shop clickBuyValentineBear() {
        System.out.println("click buy valentine bear");
        genericMethods.clickElement(valentineBearBuyBtn);
        return this;
    }
}
