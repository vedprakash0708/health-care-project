package com.medicure.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class MedicureUITest {
    private WebDriver driver;
    private static final String SCREENSHOT_DIR = "target/screenshots/";
    
    @BeforeSuite
    public void beforeSuite() {
        // Create screenshots directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        // Configuration for CI environments like Jenkins
        if (System.getenv("JENKINS_HOME") != null || System.getenv("CI") != null) {
            options.addArguments(
                "--headless",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--window-size=1920,1080"
            );
        } else {
            options.addArguments("--start-maximized");
        }
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void testDoctorSearch() {
        driver.get("http://medicure-service/doctors");
        driver.findElement(By.id("searchInput")).sendKeys("John");
        driver.findElement(By.id("searchButton")).click();
        assertTrue(driver.getTitle().contains("Doctors"), 
            "Page title should contain 'Doctors'");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String testName) {
        try {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = String.format("%s_%s.png", testName, timestamp);
            Path destination = Paths.get(SCREENSHOT_DIR + fileName);
            Files.copy(screenshot.toPath(), destination);
            System.out.println("Screenshot saved to: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
