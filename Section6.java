package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section6 {

    public static void main(String[] args) throws InterruptedException {
        Cont();
    }

    public static void Cont () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.rediff.com/");
        driver.findElement(By.cssSelector("a[title*='Sign']")).click();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Hello");
        driver.findElement(By.xpath("//input[contains(@name,'swd')]")).sendKeys("Sinus");
//        driver.findElement(By.cssSelector("input#password")).sendKeys("Siema");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='div_login_error']")).getText());
    }
}
