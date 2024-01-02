package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorsExample {
    public WebDriver driver;
    @Test
    public void login_Page_UsingLocator() throws InterruptedException {
        driver = new ChromeDriver();
       // driver.get("https://www.google.com/");
        driver.get("file:///C:/Users/Sushil/Desktop/javaScriptAutom/forLocatorExample.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement userNameTextbox = driver.findElement(By.id("username"));
        userNameTextbox.clear();
        userNameTextbox.sendKeys("sushilgupta049@gmail.com");
        WebElement passwordTextbox = driver.findElement(By.name("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("$u$hiL");
        Thread.sleep(3000);
        WebElement linkText = driver.findElement(By.partialLinkText("Click"));
        linkText.click();
        Thread.sleep(6000);
        driver.close();
    }

    @Test
    public void cssSeectorWebElement() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement loginBut = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBut.click();
    }
}
