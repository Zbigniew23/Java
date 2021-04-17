package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RahulTest {

    @Test
    public void testMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        sibling();
//        simpleWeb();
//        selectWeb();
//        alerts();
//        makeMyTrip();
    }

    public static void sibling() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.qaclickacademy.com/interview.php");
        driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();

        driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();

        System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
    }

    public static void simpleWeb()
    {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.pl/");
        System.out.println(chromeDriver.getTitle());
        System.out.println(chromeDriver.getCurrentUrl());  // validate if you landed on correct url
        System.out.println(chromeDriver.getPageSource());  // print page source

        chromeDriver.navigate().to("https://www.yahoo.com/?guccounter=1");
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.close();  // closes current browser
        chromeDriver.quit();   // closes all browsers opened by selenium script
    }

    public static void selectWeb()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pl-pl.facebook.com/");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("aida");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("radames");

        Select d =  new Select(driver.findElement(By.name("birthday_day")));
        d.selectByValue("7");

        Select m =  new Select(driver.findElement(By.name("birthday_month")));
        m.selectByIndex(9);

        Select y =  new Select(driver.findElement(By.name("birthday_year")));
        y.selectByValue("1976");
    }

    public static void makeMyTrip() throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().deleteAllCookies();
        wd.manage().deleteCookieNamed("sessionKey");
        wd.get("https://www.makemytrip.com/");

        WebElement cos = wd.findElement(By.xpath("//div[@class='searchCity ']"));
        cos.clear();
        cos.sendKeys("MUM");
        Thread.sleep(2000);
        cos.sendKeys(Keys.ENTER);

        WebElement tan = wd.findElement(By.xpath("//div[@class='searchToCity ']"));
        tan.clear();
        tan.sendKeys("DEL");
        Thread.sleep(2000);
        tan.sendKeys(Keys.ARROW_DOWN);
        tan.sendKeys(Keys.ENTER);
    }
}