package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temp {


    public static void main(String[] arr){

        //System.out.println("test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath(" //input[@id='password']")).sendKeys("secret_sauce");
       // driver.findElement(By.xpath(" //button[@id=login-button']")).click();
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select= new Select(dropdown);
        select.selectByVisibleText("Name (Z to A)");

        List<WebElement> productnames =driver.findElements(By.cssSelector(".inventory_item_name "));
        List <String> names = new ArrayList<>();
        for(WebElement element : productnames){
            names.add(element.getText());
        }
        //names.sort(Collections.reverseOrder());
     ///   for(String ProductNames:names){
         //   System.out.println(ProductNames);

      //  }
for(int i= names.size()-1;i>=0;i--){
    System.out.println(names.get(i));
}









    }



}
