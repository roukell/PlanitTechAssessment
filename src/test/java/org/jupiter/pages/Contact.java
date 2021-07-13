package org.jupiter.pages;

import org.jupiter.GenericMethods.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

public class Contact {
    WebDriver driver;
    WebDriverWait wait;
    GenericMethods genericMethods;

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

    public Contact(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        genericMethods = new GenericMethods(driver, wait);
    }

    public Contact isErrorPresentIfYesFailTest() {
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

    public Contact validateErrorAndDealWithIt() {
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

    public Contact enterForename(String firstName) {
        System.out.println("enter forename");
        genericMethods.sendKeys(forename, firstName);
        return this;
    }

    public Contact enterSurname(String lastName) {
        System.out.println("enter surname");
        genericMethods.sendKeys(surname, lastName);
        return this;
    }

    public Contact enterEmail(String emailAddress) {
        System.out.println("enter email");
        genericMethods.sendKeys(email, emailAddress);
        return this;
    }

    public Contact enterPhone(String phoneNum) {
        System.out.println("enter phone");
        genericMethods.sendKeys(telephone, phoneNum);
        return this;
    }

    public Contact enterMessage(String msg) {
        System.out.println("enter message");
        genericMethods.sendKeys(message, msg);
        return this;
    }

    public Contact clickSubmitBtn() {
        System.out.println("click submit button");
        genericMethods.clickElement(submitBtn);
        return this;
    }
}
