package com.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutTest extends TestBase {


  @Test
  public void checkoutSuccessMyVersion() {
    driver.get("https://www.saucedemo.com/");
    // Login
    driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("input[data-test='login-button']")).click();
    // Thêm sản phẩm khác (khác với clone)
    driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-bike-light']")).click();
    // Vào giỏ hàng
    driver.findElement(By.className("shopping_cart_link")).click();
    // Checkout
    driver.findElement(By.cssSelector("button[data-test='checkout']")).click();
    driver.findElement(By.cssSelector("input[data-test='firstName']")).sendKeys("Anna");
    driver.findElement(By.cssSelector("input[data-test='lastName']")).sendKeys("Smith");
    driver.findElement(By.cssSelector("input[data-test='postalCode']")).sendKeys("10001");
    driver.findElement(By.cssSelector("input[data-test='continue']")).click();
    // Hoàn tất checkout
    driver.findElement(By.cssSelector("button[data-test='finish']")).click();
    // Kiểm tra URL hoàn tất và thông báo
    Assertions.assertEquals(
            "https://www.saucedemo.com/checkout-complete.html",
            driver.getCurrentUrl(),
            "Checkout not completed"
    );
    WebElement completeText = driver.findElement(By.className("complete-text"));
    Assertions.assertTrue(completeText.isDisplayed(), "Completion message not shown");
  }
}
