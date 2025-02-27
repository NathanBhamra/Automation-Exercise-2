package org.searchjobs.stepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class automationtestjobsStepDef {
    WebDriver driver;
    WebDriverWait wait;


    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Automation-Exercise-2\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://risk.lexisnexis.co.uk");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Test Browser & Webpage loaded successfully");
    }

    @When("Clearing cookies pop-up")
    public void clearing_cookies_pop_up() {
        //First Pop-Up - Click 'Cookie Settings'
        try {
            WebElement cookieSettingsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Cookie Settings')]")));
            cookieSettingsButton.click();

            System.out.println("'Cookie Settings' Button clicked");
        } catch (Exception e) {
            Assert.fail("Failed to find or click 'Cookie Settings': " + e.getMessage());
        }

        //Second Pop-Up - Clicking 'Confirm my Choices'
        try {
            WebElement confirmMyChoicesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm My Choices')]")));
            confirmMyChoicesButton.click();

            System.out.println("'Confirm my Choices' Button clicked");
        } catch (Exception e) {
            Assert.fail("Failed to find or click 'Confirm My Choices': " + e.getMessage());
        }
    }

    @And("Navigating from homepage to Careers")
    public void navigating_from_homepage_to_careers() {
        // First Clicking Collapse Button (Collapse)
        try {
            WebElement collapseMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div/nav/div/div/div[1]/button")));
            collapseMenuButton.click();

            System.out.println("Collapse menu Button clicked");
        } catch (Exception e) {
            Assert.fail("Failed to find or click Collapse Menu: " + e.getMessage());
        }

        //Second Clicking About-Us Button (Collapse)
        try {
            WebElement aboutUsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[4]/a[1]")));
            aboutUsButton.click();

            System.out.println("'About Us' Dropdown Button clicked");
        } catch (Exception e) {
            Assert.fail("Failed to find or click 'About Us': " + e.getMessage());
        }

        //Third Clicking Careers Button (Navigate)
        try {
            WebElement careersButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[4]/ul/li/div/div/div/div[3]/div[4]/div[2]/div[2]/a[2]")));
            careersButton.click();

            System.out.println("'Careers' Button clicked");

        } catch (Exception e) {
            Assert.fail("Failed to find or click 'Careers': " + e.getMessage());
        }
    }

    @And("Clicking Search Jobs")
    public void clicking_search_jobs() {
        //First WebElement to control new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println("WebDriver now controlling new tab opened");

        //Second Clicking Search Jobs Button (Navigate)
        try {
            WebElement searchJobsButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Search jobs")));
            searchJobsButton.click();

            System.out.println("'Search Jobs' Button clicked");
        } catch (Exception e) {
            Assert.fail("Failed to find or click 'Search Jobs': " + e.getMessage());
        }
    }

    @And("Searching for Automation Tester")
    public void searching_for_automation_tester() {
        String searchTerm = "Hello World!!!";

        //First find search box & enter Automation Tester
        try {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-box-d3ba3a32752d48908f4061d0129326bf")));
            searchBox.sendKeys(searchTerm);

            System.out.println("Search box located and searching " + searchTerm);
        } catch (Exception e) {
            Assert.fail("Failed to find or type in the search box: " + e.getMessage());
        }
    }

    @Then("Show results of test")
    public void show_results_of_test() {
        try {
            // Wait for the job results to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results-item-title-url")));

            // Locate all job result elements
            List<WebElement> jobResults = driver.findElements(By.className("search-results-item-title-url"));


            // Get the count of job results
            int jobCount = jobResults.size();

            System.out.println("Checked results, waiting on test conclusion" + jobCount);


            if(jobCount > 0){
                Assert.assertTrue("Job results failed. Test has failed.", jobCount > 0);
                System.out.println("Job results successful. Test completed successfully.");
            }

        } catch (Exception e) {
            Assert.fail("Job results failed. Test has failed. " + e.getMessage());
            driver.quit();
        } finally{
            driver.quit();
        }
    }
}
