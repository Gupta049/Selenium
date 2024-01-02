package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HandlingMouse_Keyboard_Operation {
    public WebDriver driver;
    @Test
    public void mouseAndKeyboard_RobotClass() throws InterruptedException, AWTException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.mouseMove(300, 500);
//        robot.keyPress(KeyEvent.VK_ALT); // press ALT key from keyboard
//        robot.keyPress(KeyEvent.VK_F); // press F key from keyboard
//        robot.keyRelease(KeyEvent.VK_F); // release F key from keyboard
//        robot.keyRelease(KeyEvent.VK_ALT); // release ALT key from keyboard
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_N); // Press W key from keyboard to open a new private window
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        driver.quit(); // it will close all the browser windows opened by Selenium
    }
}
