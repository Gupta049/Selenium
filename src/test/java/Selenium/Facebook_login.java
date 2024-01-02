package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Facebook_login {
    public WebDriver driver;
    @Test
    public void login() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);
        String source = driver.getPageSource();
        System.out.println(source);
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys("sushilgupta049@gmail.com");
        driver.findElement((By.id("pass"))).sendKeys("Sushil@0149");
        driver.findElement(By.name("login")).click();   //driver.findElement(By.xpath("//button[text()='Log in']")).click();
        driver.findElement(By.linkText("Forgotten password?")).click();
        driver.findElement(By.xpath("//a[text()='Not you?']")).click();  //driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[1]/span/div/div[2]/a")).click();
        driver.findElement(By.partialLinkText("Forgotten")).click();
        WebElement elm = driver.findElement(By.id("identify_email"));
        elm.sendKeys("9507462047");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9nq0 textPadding20px _4jy3 _4jy1 selected _51sy']")).click();
        //driver.findElement(By.className("_9o1x marginBottom4px")).click();
        //driver.findElement(By.cssSelector("input[type='radio'][id='password_login']"));
        //driver.findElement(By.xpath("//input[@value='password_login']")).click();
        //driver.findElement(By.linkText("Not you?")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9nq0 textPadding20px _4jy3 _4jy1 selected _51sy']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("recovery_code_entry")).sendKeys("587698");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("a[href='/']"));
        driver.findElement(By.linkText("Cancel")).click();
        Thread.sleep(3000);
        //driver.close();
    }
    @Test
    public void sign_Up() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Create")).click();

    }
}
