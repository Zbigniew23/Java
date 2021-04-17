package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Intercity {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edward\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.pl/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Zgadzam się']")).click();
        driver.findElement(By.xpath("//*[@title='Szukaj']")).sendKeys("PKP INTERCITY");
        driver.findElement(By.xpath("//*[@aria-label='Szukaj w Google']")).click();
        driver.findElement(By.xpath("//*[text()= 'PKP Intercity']")).click();
        String title = driver.getTitle();

        Assert.assertTrue(title.equals("Kup bilet - www.pkpintercity.pl"));
    }
}