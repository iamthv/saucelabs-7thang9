package com.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartTest extends TestBase {

  @Test
  public void addProductToCartExtra() {
    driver.get("https://www.saucedemo.com/");

    // Login
    driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("input[data-test='login-button']")).click();

    // Thêm sản phẩm mới (ví dụ: Sauce Labs Fleece Jacket)
    driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();

    // Kiểm tra badge cart = 1
    WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
    Assertions.assertEquals("1", cartBadge.getText(), "Item not correctly added to cart");
  }

  @Test
  public void removeProductFromCartExtra() {
    driver.get("https://www.saucedemo.com/");

    // Login
    driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("input[data-test='login-button']")).click();

    // Thêm sản phẩm vào giỏ
    driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();

    // Vào giỏ hàng
    driver.findElement(By.className("shopping_cart_link")).click();

    // Xóa sản phẩm
    driver.findElement(By.cssSelector("button[data-test='remove-sauce-labs-fleece-jacket']")).click();

    // Kiểm tra giỏ hàng trống
    Assertions.assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty(),
            "Shopping Cart is not empty");
  }
}
