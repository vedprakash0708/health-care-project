public class MedicureUITest {
    WebDriver driver;
    
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
        // Assertions
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
