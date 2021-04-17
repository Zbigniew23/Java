package org.testjava.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Section8 {

    @Test
    public void testMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        staticDropdown();
//        dropdownLooping();
//        dynamicDropdown();
//        autoSuggestiveDropdown();
//        checkboxHandling();
//        calendarUI();
//        e2e();
//        alerts();
    }

    public static void staticDropdown() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());  // gets the text of selected option
        dropdown.selectByVisibleText("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }

    public static void dropdownLooping() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000L);

   /*int i=1;

while(i<5)

{

driver.findElement(By.id("hrefIncAdt")).click();//4 times

i++;

}*/

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        for(int i=1;i<5;i++)

        {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }

    public static void dynamicDropdown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://spicejet.com");

        //  //a[@value='MAA']  - Xpath for chennai

        //  //a[@value='BLR']

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        Thread.sleep(2000);

        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();  // parent:child

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
    }

    public static void autoSuggestiveDropdown() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");

        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // a means <a>

        for(WebElement option :options)

        {
            if(option.getText().equalsIgnoreCase("India"))

            {
                option.click();
                break;
            }
        }
    }

    public static void checkboxHandling () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.spicejet.com/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000L);

        int i = 1;

        while (i < 5) {

            driver.findElement(By.id("hrefIncAdt")).click();//4 times
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adults");
            i++;
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }


    public static void calendarUI () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='GOI']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();  // parent:child

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("It's enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    public static void e2e () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.spicejet.com/"); //URL in the browser

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

//        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
//        {
//            System.out.println("its disabled");
//            Assert.assertTrue(true);
//        }
//
//        else
//        {
//            Assert.assertTrue(false);
//        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();


        driver.findElement(By.id("divpaxinfo")).click();
//        driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();


        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select currencyDropdown = new Select(staticDropdown);
        currencyDropdown.selectByValue("5");



        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown2 = new Select(currency);
        dropdown2.selectByIndex(2);
        System.out.println(dropdown2.getFirstSelectedOption().getText());  // gets the text of selected option

//        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000L);

        for(int i=1;i<5;i++)

        {

            driver.findElement(By.id("hrefIncAdt")).click();

        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

        driver.findElement(By.cssSelector("input[value='Search']")).click();

// driver.findElement(By.xpath("//input[@value='Search']")).click();

// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

    }

    public static void alerts()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        String text = "Rahul";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);

        driver.findElement(By.cssSelector("[id='alertbtn']")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();   // accept() szuka pozytywnej opcji np. ok.

        driver.findElement(By.id("confirmbtn")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();  // dismiss szuka negatywnej opcji np. cancel
    }
}