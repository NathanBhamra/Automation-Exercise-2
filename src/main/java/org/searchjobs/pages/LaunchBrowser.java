package org.searchjobs.pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LaunchBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Automation-Exercise-2\\Resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://risk.lexisnexis.co.uk");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Clicking Cookie Settings Button
        try {
            WebElement cookieSettingsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Cookie Settings')]")));
            cookieSettingsButton.click();
        } catch (Exception e) {
            System.out.println("Failed to find or click 'Cookie Settings': " + e.getMessage());
        }

        // Clicking Confirm My Choices Button
        try {
            WebElement confirmMyChoicesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm My Choices')]")));
            confirmMyChoicesButton.click();
        } catch (Exception e) {
            System.out.println("Failed to find or click 'Confirm My Choices': " + e.getMessage());
        }

        // Clicking Collapse Button
        try {
            WebElement collapseMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div/nav/div/div/div[1]/button")));
            collapseMenuButton.click();
        } catch (Exception e) {
            System.out.println("Failed to find or click Collapse Menu: " + e.getMessage());
        }

        // Clicking About Us Button
        try {
            WebElement aboutUsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[4]/a[1]")));
            aboutUsButton.click();
        } catch (Exception e) {
            System.out.println("Failed to find or click 'About Us': " + e.getMessage());
        }

        // Clicking Careers Button
        try {
            WebElement careersButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[4]/ul/li/div/div/div/div[3]/div[4]/div[2]/div[2]/a[2]")));
            careersButton.click();

            // Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); // Switch to the new tab
        } catch (Exception e) {
            System.out.println("Failed to find or click 'Careers': " + e.getMessage());
        }

        // Clicking Search Jobs Button
        try {
            WebElement searchJobsButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Search jobs")));
            searchJobsButton.click();
        } catch (Exception e) {
            System.out.println("Failed to find or click 'Search Jobs': " + e.getMessage());
        }

        // Typing into the Search Box
        try {
            // Change the locator to match the search box's actual locator
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-box-d3ba3a32752d48908f4061d0129326bf")));
            searchBox.sendKeys("gamer");
            searchBox.submit();
        } catch (Exception e) {
            System.out.println("Failed to find or type in the search box: " + e.getMessage());
        }

        //Count and display the number of job results
        try {
            // Wait for the job results to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results-item-title-url")));

            // Locate all job result elements
            List<WebElement> jobResults = driver.findElements(By.className("search-results-item-title-url"));

            // Get the count of job results
            int jobCount = jobResults.size();

            // Display the count
            System.out.println("Number of job results displayed: " + jobCount);
        } catch (Exception e) {
            System.out.println("Failed to count job results: " + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        driver.quit();
    }
}
