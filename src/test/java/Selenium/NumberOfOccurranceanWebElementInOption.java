package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class NumberOfOccurranceanWebElementInOption {
    public WebDriver driver;

    @Test
    public void number_Of_Occurrance_of_Poori_Method() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Sushil/Desktop/javaScriptAutom/ListBox_Breakfast.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement list = driver.findElement(By.id("mtr"));
        Select select = new Select(list);
        List<WebElement> allElements = select.getOptions();
        HashMap<String, Integer> hashMapObj = new HashMap<>();
        for (WebElement element : allElements) {
            String text = element.getText();
            System.out.println(text);
            if (hashMapObj.containsKey(text)) {
                Integer value = hashMapObj.get(text);
                value++;
                hashMapObj.put(text, value);
            }else{
                hashMapObj.put(text, 1);
            }
        }
        Set<String> allKeys = hashMapObj.keySet();
        for (String key : allKeys) {
            Integer value = hashMapObj.get(key);
            System.out.println(key +" -->"+ value);
            if (value>1) {
                System.out.println("Occurance of " + key + " is :" + value);
            }
        }
    }
}
