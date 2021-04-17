package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class Section10 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serwis\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
//        task();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait w = new WebDriverWait(driver,5);

        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver,itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //explicit wait

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static  void addItems(WebDriver driver,String[] itemsNeeded)

    {
        int j=0;

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++)

        {

//Brocolli - 1 Kg

//Brocolli,    1 kg

            String[] name=products.get(i).getText().split("-");

            String formattedName=name[0].trim();

//format it to get actual vegetable name

//convert array into array list for easy search

//  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName))
            {
                j++;

//click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j==itemsNeeded.length)
                {
                    break;
                }
            }
        }
    }

    public static void task()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.xpath("//*[text()='Click to load get data via Ajax!']")).click();

        WebDriverWait w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));
        System.out.println(driver.findElement(By.cssSelector("#results")).getText());
    }

}