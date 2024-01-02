package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableAssignment {
    public WebDriver driver;
    @Test
    public void webTableAssignment_Method() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Sushil/Desktop/javaScriptAutom/webTable1.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();

        int sum=0;
        for (int i = 1, j=3; i < totalRows-1; i++) {
            int k = i +1;
                WebElement colValue = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + k + "]/td["+ j + "]"));
               String number1 = colValue.getText();
            sum =  sum + Integer.parseInt(String.valueOf(number1));
            System.out.println(Integer.parseInt(String.valueOf(number1)));
        }
        System.out.println("Total sum of all the numeric values is :"+sum);

        // getting Total value from the table and store it into a variable totalValue whose type is WebElement
        WebElement totalValue = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[3]"));
        String total = totalValue.getText();

        //checking that sum and given total value in the table is same or not
        if (sum == Integer.parseInt(String.valueOf(total))){
                System.out.println("Sum of marks present in the table is same as the Total marks");
        }
    }
}
