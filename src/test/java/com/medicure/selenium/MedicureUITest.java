package com.medicure.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class MedicureUITest {
    WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testDoctorSearch() {
        driver.get("http://medicure-service/doctors");
        driver.findElement(By.id("searchInput")).sendKeys("John");
        driver.findElement(By.id("searchButton")).click();
        assertTrue(driver.getTitle().contains("Doctors"));
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
