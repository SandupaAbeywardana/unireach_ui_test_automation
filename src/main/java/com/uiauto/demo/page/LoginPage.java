package com.uiauto.demo.page;

import org.openqa.selenium.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {

    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userNameStr, String passwordStr) throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        userName.sendKeys(userNameStr);
        Thread.sleep(1000);
        password.sendKeys(passwordStr);
        Thread.sleep(1000);
        submitButton.click();
    }

    public boolean invalidLogin() {
        try {
            WebElement lblLoginErrorMsg = driver.findElement(By.className("error-message-container"));
            if (lblLoginErrorMsg.isDisplayed()) {
                return true;
            }
        } catch(Exception e) {
            System.out.println("Exception thrown");
        }

        return false;
    }

}
