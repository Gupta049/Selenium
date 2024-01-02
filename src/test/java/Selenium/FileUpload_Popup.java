package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUpload_Popup {
    public WebDriver driver;
    @BeforeTest
    public void Driver(){
        driver = new ChromeDriver();
    }
    @Test
    public void file_Upload() throws InterruptedException {
        driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@type='file'][@multiple='']")).sendKeys("C:/Users/Sushil/Downloads/Form6_S04003O6N1412231200026.pdf.pdf");
        Thread.sleep(10000);
    }
    @Test
    public void exeFileUpload_Method() throws InterruptedException, IOException {
        driver.get("https://smallpdf.com/pdf-converter");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Choose Files']")).click();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("C:\\Users\\Sushil\\Desktop\\Abhigyan\\AutoIt\\FileUpload.exe");
        Thread.sleep(5000);
    }

    @Test
    public void pop_Up() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        WebElement forgot = driver.findElement(By.linkText("Forgotten password?"));
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String id = driver.getWindowHandle();
        System.out.println("Current windows id : " + id);
        Actions actions = new Actions(driver);
        actions.contextClick(forgot).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    public void child_Browser(){
        driver.get("https://www.facebook.com/");
        String windows_id = driver.getWindowHandle();
        System.out.println(windows_id);
    }
}
