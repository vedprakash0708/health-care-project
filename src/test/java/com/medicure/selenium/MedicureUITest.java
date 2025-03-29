import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MedicureUITest {
    private WebDriver driver;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    
    @Test
    public void testDoctorSearch() {
        driver.get("http://medicure-service/doctors");
        driver.findElement(By.id("searchInput")).sendKeys("John");
        driver.findElement(By.id("searchButton")).click();
        // TODO: Add assertions to verify search results
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
