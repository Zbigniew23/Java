package selenium;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class Restaurant {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Edward\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.pl/");

        driver.findElement(By.xpath("//*[@title='Szukaj']")).sendKeys("restaurant");
        driver.findElement(By.xpath("//*[text()='Zgadzam się']")).click();
        driver.findElement(By.xpath("//*[@value='Szukaj w Google']")).click();
        driver.findElement(By.xpath("//*[@text() = 'Mapy']")).click();
        driver.findElement(By.xpath("//*[@class = 'section-result-title'] //*[!contains(aria-label, 'R')]")).click();
        String text = driver.findElement(By.xpath("//*[@class = 'section-star-display']")).getText();
        int stars = Integer.parseInt(text);
        if (stars > 4)
        {
            System.out.println("This restaurant has more than 4 stars");
        }else {
            System.out.println("This restaurant has less or equal than 4 stars");
        }
    }
}