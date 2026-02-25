package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));

        // Step 1
        try {
            driver.manage().window().maximize();driver.manage().window().maximize();
            // 1. Ensure we are looking at the main page, not trapped in an iframe
            driver.switchTo().defaultContent();

// 2. Wait for the job results container to actually render

            // 1. Go to LinkedIn login page
            driver.get("https://www.linkedin.com/login");

            // 2. Enter username
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("jonas.albaira@uoit.net");

            // 3. Enter password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("jA2892009792#");

            // 4. Click submit button
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();

            wait.until(ExpectedConditions.urlContains("feed"));
            // OR wait for some known homepage element:
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-nav-search")));

            System.out.println("Step 1 successful.");

        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            driver.quit();
            return; // Stop execution if login fails
        }
        Thread.sleep(2000);


        // Step 2
        try {

            //WebElement searchButton = driver.findElement(By.cssSelector(
            //        "button.search-global-typeahead__collapsed-search-button"));

            // Click the button
            //searchButton.click();
            Thread.sleep(1500);
            // Locate the search input by its class attribute
//            WebElement searchInput = driver.findElement(By.cssSelector(
//                    "input.basic-input.search-global-typeahead__input"));

            WebElement searchInput = driver.findElement(
                    By.cssSelector("input[data-testid='typeahead-input']")
            );

            // Type the search term
            searchInput.sendKeys("Software Engineer Javascript Remote Easy Apply");
            Thread.sleep(2000);
            // Optionally, submit the form or press Enter
            // searchInput.submit();
            // or
            searchInput.sendKeys(Keys.ENTER);

        } finally {
            // Close the browser after some time or operations
            //driver.quit();
        }
        Thread.sleep(2000);
        Thread.sleep(7000);
        WebElement seeAllJobsLink = driver.findElement(By.partialLinkText("Show all job results"));
        seeAllJobsLink.click();
        Thread.sleep(2000);

        // WebElement remoteLink = driver.findElement(
         //       By.xpath("//a[contains(normalize-space(.), 'Remote')]")
        //);
        //remoteLink.click();

        Thread.sleep(2000);

        //WebElement easyApplyBtn = wait.until(
        //        ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Easy Apply filter.']"))
        //);
        //easyApplyBtn.click();
        // Locate the input using the class and aria-label
//        WebElement locationInput = driver.findElement(
//                By.cssSelector("input.jobs-search-box__text-input[aria-label='City, state, or zip code']")
//        );
//
//        // Click to focus the input
//        locationInput.click();
//
//        // Clear any existing text or placeholder
//        locationInput.clear();
//        // Type the desired location
//        locationInput.sendKeys("United States");
//        Thread.sleep(500);
//        // Simulate down arrow key and then enter
//        locationInput.sendKeys(Keys.ARROW_DOWN);
//        locationInput.sendKeys(Keys.ENTER);
//        Thread.sleep(1500);
//        //WebElement easyApplyButton = driver.findElement(By.id("searchFilter_applyWithLinkedin"));
//        //easyApplyButton.click();
//
//        // Click the button by aria-label
//        WebElement allFiltersButton = driver.findElement(By.cssSelector("button[aria-label='Show all filters. Clicking this button displays all available filter options.']"));
//        allFiltersButton.click();
//
//        Thread.sleep(500);
//        WebElement remoteCheckboxLabel = driver.findElement(
//                By.cssSelector("label[for='advanced-filter-workplaceType-2']")
//        );
//
//// click only if NOT already selected
//        WebElement actualCheckbox = driver.findElement(
//                By.id("advanced-filter-workplaceType-2")
//        );
//
//        if (!actualCheckbox.isSelected()) {
//            remoteCheckboxLabel.click();
//        }
//        Thread.sleep(500);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(
//                "var el = document.querySelector(\"input[data-artdeco-toggle-button='true']\");" +
//                        "if(el){ el.click(); } else { console.log('Toggle not found'); }"
//        );
//
//        Thread.sleep(500);
//
//        WebElement showResultsButton = driver.findElement(
//                By.cssSelector("button[aria-label^='Apply current filters to show']")
//        );
//        showResultsButton.click();

        // Optionally, submit the form or press Enter
        // searchInput.submit();
        // or
        // searchInput.sendKeys(Keys.ENTER);
        //Step 2
        /*
        try {
            // Try block: Navigate to Jobs page
            WebElement jobsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='https://www.linkedin.com/jobs/?']")));
            jobsButton.click();

            wait.until(ExpectedConditions.urlToBe("https://www.linkedin.com/jobs/"));

            WebElement showAllButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='https://www.linkedin.com/jobs/collections/recommended?discover=recommended&discoveryOrigin=JOBS_HOME_JYMBII']")));
            showAllButton.click();

            System.out.println("Navigated to Jobs List Page.");

            wait.until(ExpectedConditions.urlContains("jobs"));
            // OR wait for some known homepage element:
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-nav-search")));

            System.out.println("Step 2 successful.");
        } catch (Exception e) {
            System.out.println("Navigation to Jobs failed: " + e.getMessage());
        }*/

        /*
        try {
            // Click the Easy Apply tab
            WebElement easyApplyTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/jobs/collections/easy-apply')]")));
            easyApplyTab.click();

            System.out.println("Clicked on Easy Apply tab.");
            wait.until(ExpectedConditions.urlContains("easy"));
        } catch (Exception e) {
            System.out.println("Clicking Easy Apply tab failed: " + e.getMessage());
        }*/

//        int startPage =4; // Change this to the page you want to start from
//        int totalPages = 4;
//
//// Navigate to the desired start page first (only if greater than 1)
//        if (startPage > 0) {
//            try {
//                String startPageLabel = "Page " + startPage;
//                //WebElement startPageButton = driver.findElement(By.cssSelector("button[aria-label='" + startPageLabel + "']"));
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", startPageButton);
//                Thread.sleep(3000); // Wait for page to load
//            } catch (Exception e) {
//                System.out.println("Could not go to start page: " + e.getMessage());
//            }
//        }
        System.out.println("Did i get here");
        System.out.println("Press ENTER to continue...");
        new java.util.Scanner(System.in).nextLine();

// Now begin the loop from startPage
        //for (int page = startPage; page < startPage + totalPages; page++) {
        //    processJobListings(driver);
        //try {

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
               By.cssSelector("iframe[data-testid='interop-iframe']")
        ));

// switch into iframe
        driver.switchTo().frame(iframe);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, 500)");
       Thread.sleep(1500);
//        Thread.sleep(3000);
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//        }

// 2. Ensure we are not stuck in any iframes from Step 1
        //driver.switchTo().defaultContent();
//        System.out.println("Waiting for job cards to hydrate...");
//        WebDriverWait hydrationWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        try {
//            // This targets the data-view-name attribute which IS in your HTML
//            hydrationWait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.cssSelector("li.scaffold-layout__list-item")
//            ));
//        } catch (TimeoutException e) {
//            System.out.println("FAILED: Job cards never appeared in the DOM.");
//        }
        // This selector targets the list items directly using the data attribute found in your etc.html
        // This looks for any div that contains the specific job-card tracking attribute
        // 3. Get the list using the stable data-view-name attribute
// 1. Scoped selector for the job card
// This targets the div that actually holds the click listener
        //By jobCardSelector = By.cssSelector("div[role='button'][componentkey]");

// 2. Re-find the list inside your loop to avoid StaleElementReferenceException
        //List<WebElement> jobList = driver.findElements(jobCardSelector);
        //System.out.println("Jobs found: " + jobList.size());
        List<WebElement> jobList = driver.findElements(By.cssSelector("div.scaffold-layout__list ul li.scaffold-layout__list-item"));
//        List<WebElement> jobList = driver.findElements(
//                By.xpath("//div[@data-view-name='job-search-job-card']/ancestor::div[@data-display-contents='true'][2]")
//        );
        System.out.println("After scroll: " + jobList.size());


// 1. Get the list of job cards
        List<WebElement> jobItems = driver.findElements(By.cssSelector("div.scaffold-layout__list ul li.scaffold-layout__list-item"));
        System.out.println("Jobs found: " + jobItems.size());

        //System.out.println("Jobs found: " + jobList.size());
        // Store your search URL at the beginning
        //String searchUrl = "https://www.linkedin.com/jobs/search/?keywords=React...";

        for (int i = 0; i < 25; i++) {
            // Check if we were redirected to the feed
            try {
                // Re-find the list inside the loop to avoid StaleElementReferenceException
                List<WebElement> currentCards = driver.findElements(By.cssSelector("li.scaffold-layout__list-item"));
                WebElement card = currentCards.get(i);

                // 2. Scroll the card into view so it's clickable
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);

                // 3. Click the card
                card.click();

                // Optional: Add a short wait here to let the job details panel load
                Thread.sleep(1000);

                System.out.println("Clicked card #" + (i + 1));

                fillOutForm2(driver);

            } catch (Exception e) {
                System.out.println("Could not click card " + i + ": " + e.getMessage());
            }
        }
//            try {
//                // RE-FETCH list inside the loop to prevent "Index out of bounds"
//                jobList = driver.findElements(By.cssSelector("div[role='button'][componentkey]"));
//
//                if (i >= jobList.size()) {
//                    // Try to scroll the left pane to load more jobs
//                    js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
//                            driver.findElement(By.className("jobs-search-results-list")));
//                    Thread.sleep(2000);
//                    jobList = driver.findElements(By.cssSelector("div[role='button'][componentkey]"));
//                }
//
//                WebElement jobCard = jobList.get(i);
//                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", jobCard);
//                js.executeScript("arguments[0].click();", jobCard);
//
//                // Let the right pane load before calling fillOutForm
//                Thread.sleep(2000);
//                fillOutForm(driver);
//
//            } catch (Exception e) {
//                System.out.println("Error on job " + i + ": " + e.getMessage());
//            }

//            for (int i = 0; i < 50 * 1.5; i++) {
//                int index = i;
//                System.out.println("I'm here");
//                try {
//                    //Thread.sleep(5000);
//                    //((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//                    //Thread.sleep(3500);
////                    List<WebElement> jobItems = driver.findElements(
////                            By.cssSelector("li.semantic-search-results-list__list-item")
////                    );
////
////                    System.out.println("Jobs found: " + jobItems.size());
////                    System.out.println("I got the list of jobs" + jobItems.size());
////                    if (index >= jobItems.size()) {
////                        System.out.println("Index out of bounds: " + index);
////                        return;
////                    }
////
////                    WebElement jobItem = jobItems.get(index);
////                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", jobItem);
////                    Thread.sleep(1500);
////
////                    WebElement anchor = jobItem.findElement(By.cssSelector("a.job-card-job-posting-card-wrapper__card-link"));
////                    wait.until(ExpectedConditions.elementToBeClickable(anchor));
////                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", anchor);
////                    System.out.println("Clicked job listing #" + (index + 1));
////                    Thread.sleep(1000);
////
////                    fillOutForm(driver);
//// Re-find list to prevent StaleElementReferenceException
//                    jobItems = driver.findElements(By.cssSelector("div[data-view-name='job-search-job-card']"));
//                    WebElement jobItem = jobItems.get(i);
//
//                    // 2. CRITICAL: Scroll the element into view so it gains "size"
//                    ((JavascriptExecutor) driver).executeScript(
//                            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
//                            jobItem
//                    );
//
//                    // Short pause for the smooth scroll and rendering to finish
//                    Thread.sleep(1500);
//
//                    // 3. Try standard click first, fallback to JS click
//                    try {
//                        wait.until(ExpectedConditions.elementToBeClickable(jobItem)).click();
//                    } catch (Exception e) {
//                        System.out.println("Standard click failed for job " + (i+1) + ", using JS click.");
//                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobItem);
//                    }
//
//                    System.out.println("Successfully clicked job listing #" + (i + 1));
//
//                    // Proceed with your form filling
//                    fillOutForm3(driver);
//
//                } catch (Exception e) {
//                    System.out.println("Error clicking job #" + (index + 1) + ": " + e.getMessage());
//                }
//            }

        //} catch (Exception e) {
       //     System.out.println("Failed to grab or click job listings: " + e.getMessage());
       // }
        System.out.println("Did i get here ..");
        //}

    }

//    private static void fillOutForm(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        try {
//            driver.switchTo().defaultContent();
//
//            // Target the 'Easy Apply' button inside the job details pane
//            WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.cssSelector("button[data-view-name='job-apply-button']")
//            ));
//            js.executeScript("arguments[0].click();", applyBtn);
//
//            // Wait for modal visibility (scoped to avoid background elements)
//            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.cssSelector(".jobs-easy-apply-modal")
//            ));
//
//            boolean applicationSubmitted = false;
//            while (!applicationSubmitted) {
//                String resumeText = "Jonas Albaira\nSoftware Engineer/Developer...";
//                // Process questions...
//                processApplicationQuestions(driver, resumeText);
//
//                // Scoped Button Search inside modal
//                List<WebElement> nextBtns = modal.findElements(By.cssSelector("button[data-easy-apply-next-button]"));
//                List<WebElement> submitBtn = modal.findElements(By.cssSelector("button[data-live-test-easy-apply-submit-button]"));
//
//                if (!nextBtns.isEmpty() && nextBtns.get(0).isDisplayed()) {
//                    js.executeScript("arguments[0].click();", nextBtns.get(0));
//                    Thread.sleep(2000);
//                } else if (!submitBtn.isEmpty()) {
//                    js.executeScript("arguments[0].click();", submitBtn.get(0));
//                    applicationSubmitted = true;
//                    System.out.println("🚀 Application Sent!");
//                } else {
//                    break; // Safety exit
//                }
//            }
//
//            // --- CRITICAL: Close the modal properly to avoid /feed redirect ---
//            Thread.sleep(2000);
//            try {
//                WebElement closeBtn = driver.findElement(By.cssSelector("button[aria-label='Dismiss'], .artdeco-modal__dismiss"));
//                js.executeScript("arguments[0].click();", closeBtn);
//            } catch (Exception e) {
//                // If the application was successful, there might be a "Done" button
//                WebElement doneBtn = driver.findElement(By.cssSelector("button.artdeco-button--primary"));
//                js.executeScript("arguments[0].click();", doneBtn);
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ Modal error: " + e.getMessage());
//            // If error occurs, try to escape the modal via the 'Esc' key instead of refresh
//            new Actions(driver).sendKeys(Keys.ESCAPE).perform();
//        }
//    }


private static void fillOutForm2(WebDriver driver) {
    try {
        String resumeText =
                "Jonas Albaira from Oshawa, Ontario\n" +
                        "Software Engineer/Developer\n\n" +
                        "jonas.albaira@gmail.com 4374845789 Oshawa, Ontario https://techbeats.studio linkedin.com/in/jonas-albaira\n\n" +
                        "EDUCATION\n\n" +
                        "Bachelor of Engineering (Honours) Software Engineering\n" +
                        "OntarioTech University\n\n" +
                        "EXPERIENCE\n\n" +
                        "Code Instructor / Code Sensei\n" +
                        "Code Ninjas\n" +
                        "✨Mentored 100+ students in full-stack and game development, driving mastery of clean code architecture and effective debugging.\n" +
                        "✨Ran Web Development, Python Robotics, Ruby Programming, Visual Design and Game Building classes to enhance learning engagement.\n" +
                        "✨Built a portfolio of 2D games using Javascript, showcasing skills like sprite animation, collisions, tilemaps, and event-driven logic.\n" +
                        "✨Created a web-based dashboard with Python backend, React frontend, and Firebase database to track and display student star counts,\n" +
                        "streamlining progress tracking for Code Ninjas instructors.\n\n" +
                        "Software Developer Python - AI Tutor\n" +
                        "MindRift\n" +
                        "✨Evaluating model prompts and dialogues, refining AI response quality\n" +
                        "✨Performing text annotation and labeling (sentiment, intent, named entities) to train NLP models\n" +
                        "✨Conducting quality assurance, auditing, and improving annotations created by peers\n\n" +
                        "Founder/ CTO\n" +
                        "Leus Digital\n" +
                        "✨Built and scaled a web development side hustle, generating over 5-figures in revenue within the first 3 years.\n" +
                        "✨Successfully built and scaled 10+ different business websites, including e-commerce websites, landing pages and booking websites.\n\n" +
                        "Software Developer (Java)\n" +
                        "Tata Consultancy Services\n" +
                        "✨Deployed a Wire Room application for a leading financial institution (Capital Markets and Inventory & Treasury Services).\n" +
                        "✨Deployed corporate apps, managed Ubuntu servers and IBM WebSphere setups, handled Oracle SQL database tasks.\n" +
                        "✨Built an internal tool to automate injecting message payloads to MQ's reducing manual efforts by 50%.\n" +
                        "✨Automated GUI testing with Java Selenium reducing manual efforts by 85%.\n" +
                        "✨Scripted ISO 20022 data in xml for QA testing, cutting prep time by 80%.\n" +
                        "✨Assisted AML team with Fircosoft and compliance integration, and managed CI/CD with Jenkins and GitHub for DevOps.\n\n" +
                        "Web Developer\n" +
                        "OntarioTech Student Union\n" +
                        "✨Created a custom WordPress website with responsive design using HTML, CSS, PHP, MySQL, jQuery and JavaScript.\n" +
                        "✨Enhanced website performance and security, converted PSD to WordPress, and optimized code/database.\n" +
                        "✨Handled website updates and provided WordPress technical support.\n\n" +
                        "Web Developer\n" +
                        "Medicstox\n" +
                        "✨Developed and scaled an e-commerce site with WooCommerce, WordPress, and custom PHP, MySQL\n" +
                        "✨Implemented front-end pages and its components that adhere to best UI/UX practices, increasing sales by 300%\n" +
                        "✨Optimized the Linux server, NGINX web server and MySQL database to house 60,000 products\n\n" +
                        "SKILLS\n\n" +
                        "Front-end — HTML, CSS, Javascript, React, CI/CD — Jenkins, GitHub, Back-end — Python, Java, Lua, PHP, SpringBoot, Cloud Computing —\n" +
                        "AWS, DigitalOcean, GCP, Database — SQL, MySQL, Firestore\n\n" +
                        "SUMMARY\n\n" +
                        "Experienced Software Developer with 10+ years of expertise in website and application development. Proficient in React and other\n" +
                        "JavaScript libraries. Advanced Java, Python and PHP backend programming. Experienced in Banking, Financial, Education and Marketing\n" +
                        "industries\n\n" +
                        "PERSONAL PROJECTS\n\n" +
                        "BoozeCoin (BUZ)\n" +
                        "Launched a custom ERC‐20 token smart contract on the Polygon network (contract address: 0x96c7…b334), built in Solidity and leveraging\n" +
                        "the efficiency of Polygon’s Thales zkEVM-compatible PoS chain for low-cost, high-speed DeFi operations.\n\n" +
                        "Automated Algorithmic Trading Bot\n" +
                        "Developed a fully automated trading bot in Python that extracts market data, performs technical and fundamental analysis, generates\n" +
                        "signals, backtests strategies, and executes trades in real-time via the PANDA API. The project showcases end-to-end algorithmic trading with\n" +
                        "live market integration and strategy performance tracking.\n";
        // 🕒 Initial wait
        //Thread.sleep(2500);
        moveMouseRandomly(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement easyApplyButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("jobs-apply-button-id")));

        // 3. Click the button
        easyApplyButton.click();
        System.out.println("Easy Apply button clicked!");

        humanPause();

        System.out.println("Opened Easy Apply form.");

        // Wait for modal to load
        Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 3000));
        try {
            WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[contains(@id, 'location-GEO-LOCATION') and @type='text']")));
            hoverOverElement(driver, locationInput);
            moveMouseRandomly(driver);
            humanPause();
            typeLikeHuman(locationInput, "Ontario, Canada");
            Thread.sleep(1000);
            locationInput.sendKeys(Keys.ARROW_DOWN);
            locationInput.sendKeys(Keys.ENTER);
        } catch (TimeoutException e) {
            System.out.println("Location input did not appear in time.");
        }
        humanPause();
        try {
            WebElement submitButton = driver.findElement(By.xpath("//button[@aria-label='Submit application']"));
            hoverOverElement(driver, submitButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth'});", submitButton);
            humanPause();
            submitButton.click();
            System.out.println("🚀 Submitted application");
        } catch (NoSuchElementException e) {
            System.out.println("⚠️ Submit button not found, continuing...");
        }

        // ✅ Handle location question
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        List<WebElement> nextButtons = driver.findElements(By.cssSelector("footer button[data-easy-apply-next-button]"));
        boolean isNextButtonPresent = true;

        while (isNextButtonPresent) {
            try {
                processApplicationQuestions(driver, resumeText);
                // 1. Wait for the Next button to be visible and clickable
                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("footer button[data-easy-apply-next-button], button[aria-label='Review your application']")
                ));

                // 2. Click the button
                nextButton.click();
                System.out.println("Stepping through application...");

                // 3. Short sleep to allow the DOM to transition to the next step
               humanPause();

            } catch (Exception e) {
                // If the button is no longer found, we've likely hit the "Review" or "Submit" page
                isNextButtonPresent = false;
                System.out.println("No more 'Next' buttons found. Moving to review/submit.");
            }
        }

        humanPause();
        try {
            WebElement privacyHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h3[text()='Privacy policy']")));
            if (privacyHeading.isDisplayed()) {
                WebElement agreeCheckbox = driver.findElement(By.xpath(
                        "//label[contains(text(), 'I Agree')]/preceding-sibling::input[@type='checkbox']"));
                if (!agreeCheckbox.isSelected()) {
                    agreeCheckbox.click();
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Privacy policy section not found — skipping 'I Agree' checkbox.");
        }
        humanPause();
        // 1. Define the XPath
        By submitXPath = By.xpath("//button[@aria-label='Submit application']");

        try {
            // 2. Wait for the Submit button to be clickable
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitXPath));

            // 3. Click the button
            submitButton.click();
            System.out.println("Application submitted successfully!");

        } catch (Exception e) {
            System.out.println("Submit button not found or not clickable: " + e.getMessage());
        }

        // x button
        try {
            WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//span[text()='Done']]")));
            hoverOverElement(driver, doneButton);
            humanPause();
            doneButton.click();
            System.out.println("Clicked Done button");
        } catch (TimeoutException e) {
            try {
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[aria-label='Dismiss']")));
                hoverOverElement(driver, closeButton);
                humanPause();
                closeButton.click();
                System.out.println("Clicked Dismiss button");
            } catch (TimeoutException ex) {
                System.out.println("Neither Done nor Dismiss appeared.");
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//
//        List<WebElement> reviewButtons = driver.findElements(
//                By.cssSelector("button[aria-label='Review your application']")
//        );
//
//        if (!reviewButtons.isEmpty()) {
//            reviewButtons.get(0).click();
//            System.out.println("Review button clicked.");
//        } else {
//            System.out.println("Review button not found, continuing...");
//        }
//        //List<WebElement> nextButtons = driver.findElements(By.cssSelector("button[data-easy-apply-next-button], button[aria-label='Continue to next step']"));List<WebElement> nextButtons = driver.findElements(By.xpath("//*[@aria-label='Continue to next step']"));
//
//        // repeat: next button then call gpt api
//
//        // 🚦 Navigation loop through application steps
////        while (true) {
////
////            List<WebElement> h3Elements = driver.findElements(By.xpath("//h3[text()='Additional Questions']"));
////            if (!h3Elements.isEmpty()) {
////                System.out.println("Found the 'Additional Questions' header.");
////                break;
////            }
////
////        }
//
//        System.out.println("Here");
//
//        // 🧠 Resume text (unchanged)
//
//
//        boolean reviewAvailable = false;
//
//        while (!reviewAvailable) {
//            processApplicationQuestions(driver, resumeText);
//            Thread.sleep(ThreadLocalRandom.current().nextInt(1200, 2500));
//
//            try {
//                WebElement nextButton = driver.findElement(
//                        By.xpath("//button[@data-easy-apply-next-button or @data-live-test-easy-apply-next-button]"));
//                hoverOverElement(driver, nextButton);
//                humanPause();
//                nextButton.click();
//                moveMouseRandomly(driver);
//                System.out.println("✅ Clicked Next button");
//            } catch (NoSuchElementException e1) {
//                try {
//                    WebElement reviewButton = driver.findElement(
//                            By.xpath("//button[@data-live-test-easy-apply-review-button]"));
//                    hoverOverElement(driver, reviewButton);
//                    humanPause();
//                    reviewButton.click();
//                    reviewAvailable = true;
//                    System.out.println("✅ Clicked Review button");
//
//
//                } catch (NoSuchElementException e2) {
//                    System.out.println("⚠️ No Review button yet. Retrying...");
//                    Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 2500));
//                }
//
//
//            }
//        }


    } catch (Exception e) {
        System.out.println("Failed to fill out form: " + e.getMessage());
    }

    // ✅ Handle Done/Dismiss
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

}

    public static void processApplicationQuestions(WebDriver driver, String resumeText) throws Exception {
        List<WebElement> legendQuestions = driver.findElements(
                By.xpath("//fieldset/legend//span[@aria-hidden='true']"));
        List<WebElement> labelQuestions2 = driver.findElements(
                By.xpath("//fieldset/label//span[@aria-hidden='true']"));
        List<WebElement> labelQuestions = driver.findElements(
                By.xpath("//label[@class='artdeco-text-input--label']"));
        List<WebElement> generalLabelQuestions = driver.findElements(
                By.xpath("//label//span[@aria-hidden='true']"));
        List<WebElement> locationQuestion = driver.findElements(
                By.xpath("//input[@role='combobox' and contains(@id, 'city')]"));

        List<String> allQuestions = new ArrayList<>();
        allQuestions.addAll(generalLabelQuestions.stream()
                .map(WebElement::getText).map(String::trim)
                .filter(s -> !s.isEmpty()).collect(Collectors.toList()));
        allQuestions.addAll(labelQuestions.stream()
                .map(WebElement::getText).map(String::trim)
                .filter(s -> !s.isEmpty()).collect(Collectors.toList()));

        // Handle text input questions
        List<WebElement> labelElements = driver.findElements(
                By.xpath("//label[contains(@class, 'artdeco-text-input--label') or contains(@class, 'artdeco-text-input--input')]"));

        for (WebElement label : labelElements) {
            String question = label.getText().trim();
            if (question.isEmpty()) continue;

            String answer = callChatGPTApi(resumeText, question);
            System.out.println("Q: " + question);
            System.out.println("A: " + answer);

            String inputId = label.getAttribute("for");
            try {
                WebElement inputField = driver.findElement(By.id(inputId));
                inputField.clear();
                inputField.sendKeys(answer);
            } catch (Exception e) {
                System.out.println("⚠️ Could not find input for: " + question);
            }
        }

        List<WebElement> locationLabels = driver.findElements(
                By.xpath("//label[contains(@class, 'form-element__label-title')]"));
        for (WebElement label : locationLabels) {
            String question = label.getText().trim();
            if (question.isEmpty()) continue;

            String answer = callChatGPTApi(resumeText, question);
            System.out.println("Q: " + question);
            System.out.println("A: " + answer);

            String inputId = label.getAttribute("for");
            try {
                WebElement inputField = driver.findElement(By.id(inputId));
                inputField.clear();
                inputField.sendKeys(answer);
            } catch (Exception e) {
                System.out.println("⚠️ Could not find input for: " + question);
            }
        }
        // Handle dropdowns
        List<WebElement> dropdownLabels = driver.findElements(
                By.xpath("//label[contains(@class, 'fb-dash-form-element__label')]"));

        for (WebElement label : dropdownLabels) {
            String question = label.getText().trim();
            if (question.isEmpty()) continue;

            String selectId = label.getAttribute("for");
            if (selectId == null || selectId.isEmpty()) continue;

            try {
                WebElement selectElement = driver.findElement(By.id(selectId));
                List<WebElement> options = selectElement.findElements(By.tagName("option"));

                List<String> optionTexts = options.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .filter(s -> !s.toLowerCase().contains("select") && !s.isEmpty())
                        .collect(Collectors.toList());

                String prompt = question + "\nOptions: " + String.join(", ", optionTexts)
                        + "\n\nWhich of these options is most appropriate based on the resume?";
                String bestAnswer = callChatGPTApi(resumeText, prompt);

                for (WebElement option : options) {
                    if (option.getText().trim().equalsIgnoreCase(bestAnswer.trim())) {
                        option.click();
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("⚠️ Dropdown issue: " + question);
            }
        }

        // Handle radio button sets
        List<WebElement> fieldsets = driver.findElements(
                By.xpath("//fieldset[@data-test-form-builder-radio-button-form-component='true']"));

        for (WebElement fieldset : fieldsets) {
            try {
                WebElement labelSpan = fieldset.findElement(By.cssSelector("legend .fb-dash-form-element__label"));
                String question = labelSpan.getText().trim();
                List<WebElement> options = fieldset.findElements(By.cssSelector("label span"));

                List<String> optionTexts = options.stream()
                        .map(WebElement::getText).map(String::trim)
                        .filter(s -> !s.isEmpty()).collect(Collectors.toList());

                String prompt = question + "\nOptions: " + String.join(", ", optionTexts)
                        + "\n\nWhich of these should be selected based on the resume?";
                String bestAnswer = callChatGPTApi(resumeText, prompt);

                for (WebElement option : options) {
                    if (option.getText().trim().equalsIgnoreCase(bestAnswer.trim())) {
                        option.click();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("⚠️ Radio button issue");
            }
        }

        for (WebElement legend : legendQuestions) {
            try {
                Thread.sleep(2500); // Wait 2.5 seconds before each question

                String question = legend.getText().trim();
                if (question.isEmpty()) continue;

                // Get parent fieldset to scope the options
                WebElement fieldset = legend.findElement(By.xpath("./ancestor::fieldset[1]"));

                // Get all option labels in this fieldset
                List<WebElement> optionLabels = fieldset.findElements(
                        By.xpath(".//label[@data-test-text-selectable-option__label]")
                );

                List<String> optionTexts = optionLabels.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .filter(t -> !t.isEmpty())
                        .collect(Collectors.toList());

                // Create the prompt for ChatGPT
                String prompt = question + "\nOptions: " + String.join(", ", optionTexts)
                        + "\n\nWhich of these should be selected based on the resume?";
                String bestAnswer = callChatGPTApi(resumeText, prompt);

                // Click the label that matches ChatGPT's answer
                for (WebElement label : optionLabels) {
                    if (label.getText().trim().equalsIgnoreCase(bestAnswer.trim())) {
                        label.click(); // Clicking the label auto-triggers the associated radio
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("⚠️ Issue processing question: " + e.getMessage());
            }
        }
    }

    public static void processJobListings(WebDriver driver) {

    }

    public static String callChatGPTApi(String resume, String question) throws Exception {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null) {
            throw new RuntimeException("OPENAI_API_KEY environment variable not set.");
        }

        String prompt = "You are a job applicant assistant. Based on the resume below, answer this application question truthfully and concisely. Use a non-corporate conversation style of writing. If a question asked How many years of experience just return the integer value answer. If asked what percentage or any question asking for a number, just return an integer/double value. If asked for my location, just return the text Oshawa. if asked for salary just return decimal/integer amount, no text make it 150000. I am Male Filipino Southeast Asian. If asked for Job ID just put in random number or 0. Make the responses at most 20 words if its gonna be an explanation. I am legally allowed to work in US and a Canadian Citizen. Typescript experience 3. Banking 2 years. SpringBoot 2 years.Linux 10 years. Javscript/HTML/CSS, SQL mySQL, PHP 10 years.NoSQL 4 years.  REST API's  5 years. AWS 10 years. my hourly wage is $40/hr. include similar technlogies to the ones i listed if its related eg. react -> uses typescript so same 4 years experience, git/github and other repo softwares are same years,jira 2 years. aws, gcp, azure, digitalocean and all cloud platforms are 10 years experience. and never put 0 as years of experience. put 4 if i dont have it on my resume. react is 5 years experience thats including running my own company. make the responses casual like friendly instead of corporate. when asked how many years of experience just reply with integer amount. python, AI, 2 years. Excel 10 years experience. Dont put comma if asked for salary amount. Put all years of experience as 10 ignore what i wrote ealier Do your best to answer the multiple choice, select any answer if none of the above works. Im heterosexual male, no disabilities and not a veteran. im not related to government. my current company is MindRift. willing to work remote in US and Canada and remote and hybrid in canada and states. Say youre a human, if asked. portfolio link is leuslabs.tech \n\n"
                + "Resume:\n" + resume + "\n\n"
                + "Question:\n" + question + "\n\n"
                + "Answer:";

        // Escape for JSON
        String escapedPrompt = prompt.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n");

        String jsonPayload = String.format(
                "{ \"model\": \"gpt-4o-mini\", \"messages\": [{\"role\":\"user\",\"content\": \"%s\"}], \"temperature\": 0.3 }",
                escapedPrompt
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to call OpenAI API: " + response.body());
        }

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        String answer = jsonResponse
                .getAsJsonArray("choices")
                .get(0)
                .getAsJsonObject()
                .get("message")
                .getAsJsonObject()
                .get("content")
                .getAsString();

        return answer.trim();
    }

    private static void humanPause() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(800, 2500));
    }

    private static void moveMouseRandomly(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            int randomX = ThreadLocalRandom.current().nextInt(0, 800);
            int randomY = ThreadLocalRandom.current().nextInt(0, 600);
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", randomX / 20.0, randomY / 20.0);
        } catch (Exception ignored) {}
    }

    private static void hoverOverElement(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element)
                    .pause(Duration.ofMillis(ThreadLocalRandom.current().nextInt(300, 800)))
                    .perform();
        } catch (Exception ignored) {}
    }

    private static void typeLikeHuman(WebElement input, String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            input.sendKeys(String.valueOf(c));
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200)); // simulate human typing
        }
    }



}
