package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
    public static WebDriver driver;

    @Test
    public void enter_text_inDisableField() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Sushil/Desktop/javaScriptAutom/DisabledTextBox.html");
        driver.manage().window().maximize();
        JavascriptExecutor jsExe = (JavascriptExecutor)driver;
        Thread.sleep(3000);
        driver.findElement(By.id("t1")).clear();
//        driver.findElement(By.id("t1")).sendKeys("Sheshnath Gupta");
//        driver.findElement(By.id("t2")).sendKeys("gupta");

        jsExe.executeScript("document.getElementById('t1').value='Sushil Kumar Gupta'");
        Thread.sleep(3000);
        jsExe.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(3000);
        jsExe.executeScript("document.getElementById('t2').value='manager'");
        Thread.sleep(3000);
        jsExe.executeScript("document.getElementById('t2').type='button'");
    }

    @Test
    public void scrollUpandDown() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://seleniumhq.org/download");
        JavascriptExecutor jsEx = (JavascriptExecutor)driver;
        for (int i=1; i < 10; i++){
            jsEx.executeScript("window.scrollBy(0, 1000)"); // scroll down
            Thread.sleep(2000);
        }
        for (int i = 1; i < 10; i++){
            jsEx.executeScript("window.scrollBy(0, -1000)"); // scroll up
            Thread.sleep(2000);
        }
    }

    //Finding (Applitool webElement)
    @Test
    public void scrollUpandDowntoSpecificElementErbpage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://seleniumhq.org/download");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//img[contains(@src, 'lambda-test')]"));
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        System.out.println("x coordinate of Lambda test image on this current web page is " + x);
        System.out.println("y coordinate of Lambda test image on this current web page is " + y);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+", "+y+")");
        Thread.sleep(3000);
    }
}
