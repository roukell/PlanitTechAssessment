package org.jupiter.pages;

import org.jupiter.GenericMethods.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;
    GenericMethods genericMethods;

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement contactBtn;

    @FindBy(xpath = "//a[text()='Shop']")
    private WebElement shopBtn;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartBtn;

    public Home(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        genericMethods = new GenericMethods(driver, wait);
    }

    public Home clickContact() {
        System.out.println("click on contact button");
        genericMethods.clickElement(contactBtn);
        return this;
    }

    public Home clickShop() {
        System.out.println("click on shop button");
        genericMethods.clickElement(shopBtn);
        return this;
    }

    public Home clickCart() {
        System.out.println("click on cart button");
        genericMethods.clickElement(cartBtn);
        return this;
    }
}
