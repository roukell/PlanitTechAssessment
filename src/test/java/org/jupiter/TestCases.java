package org.jupiter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jupiter.pages.Home;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {
    WebDriver driver;
    Home home;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("https://jupiter.cloud.planittesting.com/");
        home = new Home(driver, wait);
    }

    @Test
    public void testCase1() {
        home.getTitle();
    }

    @After
    public void after() {
        driver.close();
    }
}
