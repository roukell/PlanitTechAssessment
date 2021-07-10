package org.jupiter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='hero-unit']//h1")
    private WebElement title;

    public Home(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void getTitle() {
        wait.until(ExpectedConditions.visibilityOf(title));
        String text = title.getText();
        System.out.println(text);
    }
}
