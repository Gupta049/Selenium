package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ActionClass {
    public WebDriver driver;
//    @BeforeMethod
//    public void Driver(){
//        driver = new ChromeDriver();
//    }

    @Test
    public void using_ContextClick_Method() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
//        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement pass = driver.findElement(By.partialLinkText("Forgotten")); // By.xpath("//a[contains(text(),\"Forgotten account?\")]") using xpath

        Actions actions = new Actions(driver);
//        actions.moveToElement(pass).perform(); //moveToElement() method used to mouse hover on any element on the web page
//        Thread.sleep(3000);
//        actions.contextClick(pass).perform(); // contextClick() method used to right click on any element on the web page
//        Thread.sleep(3000);
        actions.moveToElement(pass).contextClick().build().perform();
        Thread.sleep(3000);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
    String newPageTitle = driver.getTitle();
    System.out.println(newPageTitle);
    }
    @Test
    public void using_DragAndDrop_Method() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src, des).perform();
//         actions.moveToElement(src).clickAndHold().perform();//.clickAndHold(des).perform();
//        actions.release(des).perform();
    //  driver.close();
    }

    @Test
    public void using_DoubleClick_Method() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement  elem = driver.findElement(By.xpath("//div[contains(text(), 'for a celebrity, brand or business.')]"));

        Actions actions = new Actions(driver);
        actions.doubleClick(elem).perform();
        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.cssSelector("a"));
        for (WebElement link : list) {
            System.out.println(link.getText());
            if (("Settings").equalsIgnoreCase(link.getText())) {
//                actions.moveToElement(link).click().perform();
//                Thread.sleep(8000);

                actions.moveToElement(link).contextClick().build().perform();
//                Thread.sleep(3000);
                actions.keyDown(Keys.LEFT_CONTROL)
                        .click()
                        .keyUp(Keys.LEFT_CONTROL)
                        .build()
                        .perform(); }
                Thread.sleep(3000);
        }
        System.out.println("All anchor tag content in list of current web page = " + list.size());
        System.out.println("Tag name with respective links");
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@href or @src]"));
        for(WebElement e : list1){
            String link = e.getAttribute("href");
            if(null==link)
                link=e.getAttribute("src");
            System.out.println(e.getTagName() + "=" + link);
        }
    }
}
