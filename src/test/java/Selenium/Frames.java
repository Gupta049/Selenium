package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    @Test
    public void frame_Method() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Sushil/Desktop/javaScriptAutom/page2.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("t1")).sendKeys("Sushil");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("Gupta");
        Thread.sleep(3000);
        driver.switchTo().frame("f1");
        driver.findElement(By.id("t1")).clear();
        driver.findElement(By.id("t1")).sendKeys("b");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).clear();
        driver.findElement(By.id("t2")).sendKeys("b");
        Thread.sleep(3000);
        //using name attribute of the frame -string
        driver.switchTo().frame("n1");
        driver.findElement(By.id("t1")).clear();
        driver.findElement(By.id("t1")).sendKeys("c");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).clear();
        driver.findElement(By.id("t2")).sendKeys("c");
        Thread.sleep(3000);
        //using address of the frame - webElement
        WebElement f = driver.findElement(By.className("c1"));
        driver.switchTo().frame(f);
        driver.findElement(By.id("t1")).clear();
        driver.findElement(By.id("t1")).sendKeys("d");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).clear();
        driver.findElement(By.id("t2")).sendKeys("d");
        driver.close();

    }
}
