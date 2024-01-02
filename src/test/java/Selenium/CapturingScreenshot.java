package Selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CapturingScreenshot {
    public WebDriver driver;
    @Test
    public void takingScreenshot_login() throws InterruptedException, AWTException, IOException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.mouseMove(300, 400);
        Thread.sleep(3000);
        robot.mouseWheel(3);
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);
        File file = new File("D:\\BridgeLabz\\RestAssuredAPI\\RestAssuredAPI\\Screenshot\\screenshot1.png");
        Thread.sleep(3000);
        FileHandler.copy(srcFile, file);
        driver.close();
    }
}
