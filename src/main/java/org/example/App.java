package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.io.File;
import java.time.Duration;
import java.util.Random;
public class App {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Persistent Profile
        String profilePath = System.getProperty("user.dir") + File.separator + "TinderProfile";
        options.addArguments("user-data-dir=" + profilePath);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in); // Scanner to detect Enter key

        try {
            driver.manage().window().maximize();
            driver.get("https://tinder.com/");

            System.out.println("--------------------------------------------------");
            System.out.println("1. Log in manually if needed.");
            System.out.println("2. Get to the swiping screen.");
            System.out.println("3. COME BACK HERE and press ENTER to start liking.");
            System.out.println("--------------------------------------------------");

            scanner.nextLine(); // THE PAUSE: Script waits here until you hit Enter in the console

            System.out.println("Starting the Like loop...");

            while (true) {
                try {


                    // Find the 'Like' button via the specific 'gamepad-sparks-like' fill
                    String buttonXPath = "//*[contains(@fill, 'gamepad-sparks-like')]/ancestor::button";

                    WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));

                    likeButton.click();
                    System.out.println("Liked!");

                    // Random human-like delay (2 to 5 seconds)
                    Thread.sleep(rand.nextInt(3000) + 2000);

                } catch (Exception e) {
                    System.out.println("Button blocked. Attempting to clear pop-ups with ESC...");

                    // Press ESC to close Gold/Upgrade pop-ups
                    new Actions(driver).sendKeys(Keys.ESCAPE).perform();

                    Thread.sleep(2000);
                }
            }

        } catch (Exception e) {
            System.out.println("Critical error: " + e.getMessage());
        } finally {
            scanner.close();
            // driver.quit();
        }
    }

}
