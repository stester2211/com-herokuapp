package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowser
{
    public static Scanner sc=new Scanner(System.in);
    static String baseURL="http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        System.out.print("Enter the browser name: ");
        String browser=sc.nextLine();

        //1. Setup multi browser
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
            driver=new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Enter only Edge, Chrome or Firefox Browser");
        }

        // 2. Open URL
        driver.get(baseURL);

        //Maximize the browser
        driver.manage().window().maximize();

        //Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 3. Print the title of the page
        System.out.println("--------------------------------------");
        System.out.println("3. Page title is : "+ driver.getTitle());

        //4. Print the current url
        System.out.println("4. Current URL is : "+ driver.getCurrentUrl());

        //5. Print the page source
        System.out.println("5. Page source is :" + driver.getPageSource());

        //6. Enter the email to email field
        //6.1 Find the email element
        WebElement usernameField = driver.findElement(By.name("username"));

        //6.2 Action is to type username
        usernameField.sendKeys("b1@gmail.com");

        //7. Enter the password to password field
        //7.1 Find the password element
        WebElement passwordField= driver.findElement(By.name("password"));

        //7.2 Action is to type password
        passwordField.sendKeys("123456");

        //Hold the screen for sometime
        Thread.sleep(2000);

        //8. Close the browser
        driver.close();
    }
}
