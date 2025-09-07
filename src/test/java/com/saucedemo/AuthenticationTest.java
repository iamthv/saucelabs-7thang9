package com.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AuthenticationTest extends TestBase {



  @Test
  public void signInSuccessful() {
    driver.get("https://www.saucedemo.com/");

    driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("input[data-test='login-button']")).click();

    Assertions.assertEquals(
        "https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(), "Login Not Successful");
  }


  @Test
  public void signInFailWrongPassword() {
    driver.get("https://www.saucedemo.com/");

    driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("wrong_password");
    driver.findElement(By.cssSelector("input[data-test='login-button']")).click();

    WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
    Assertions.assertTrue(
            errorElement.getText().contains("Username and password do not match any user"),
            "Error message not found");
  }

}
