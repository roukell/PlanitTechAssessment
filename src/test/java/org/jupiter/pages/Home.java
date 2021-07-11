package org.jupiter.pages;

import org.jupiter.GenericMethods.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

public class Home {
    WebDriver driver;
    WebDriverWait wait;
    GenericMethods genericMethods;

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement contactBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-error')]")
    private WebElement alertError;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement alertSuccess;

    @FindBy(id = "forename")
    private WebElement forename;

    @FindBy(id = "surname")
    private WebElement surname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "telephone")
    private WebElement telephone;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(xpath = "//a[text()='Submit']")
    private WebElement submitBtn;

    public Home(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        genericMethods = new GenericMethods(driver, wait);
    }

    public Home clickContact() {
        System.out.println("click on contact button");
        genericMethods.clickElement(contactBtn);
        return  this;
    }

    public Home isErrorPresentIfYesFailTest() {
        if (genericMethods.isElementPresent(alertError)) {
            System.out.println("error detected, test failed");
            fail();
        } else if (genericMethods.isElementPresent(alertSuccess)) {
            System.out.println("form submitted successfully");
        } else {
            System.out.println("no error detected");
        }

        return this;
    }

    public Home validateErrorAndDealWithIt() {
        System.out.println("check if error message present");
        if (genericMethods.isElementPresent(alertError)) {
            System.out.println("error message detected, dealing with it");
            enterForename("Jane");
            enterEmail("test@test.com");
            enterMessage("Hello World");
            clickSubmitBtn();
        } else {
            System.out.println("no error");
        }
        return this;
    }

    public Home enterForename(String firstName) {
        genericMethods.sendKeys(forename, firstName);
        return this;
    }

    public Home enterSurname(String lastName) {
        genericMethods.sendKeys(surname, lastName);
        return this;
    }

    public Home enterEmail(String emailAddress) {
        genericMethods.sendKeys(email, emailAddress);
        return this;
    }

    public Home enterPhone(String phoneNum) {
        genericMethods.sendKeys(telephone, phoneNum);
        return this;
    }

    public Home enterMessage(String msg) {
        genericMethods.sendKeys(message, msg);
        return this;
    }

    public Home clickSubmitBtn() {
        genericMethods.clickElement(submitBtn);
        return this;
    }
}
