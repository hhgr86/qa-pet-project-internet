import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class CheckBoxTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("BUG-003: Второй чекбокс самовольно возвращается после перезагрузки")
    public void testSecondCheckboxReturnsToChecked() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement secondCheckbox = driver.findElement(By.xpath("//input[2]"));

        if (secondCheckbox.isSelected()) {
            secondCheckbox.click();
            System.out.println("Сняли галочку со второго чекбокса");
        }

        // Проверяем, что галочка снята
        Assertions.assertFalse(secondCheckbox.isSelected(), "Галочка должна быть снята");

        // Обновляем страницу
        driver.navigate().refresh();

        // Находим чекбокс снова
        WebElement secondCheckboxAfterRefresh = driver.findElement(By.xpath("//input[2]"));
        boolean stateAfterRefresh = secondCheckboxAfterRefresh.isSelected();

        // Ожидаем, что галочка НЕ вернулась (тест упадёт, так как это баг)
        Assertions.assertFalse(stateAfterRefresh, 
            "BUG-003: Второй чекбокс должен оставаться НЕотмеченным после перезагрузки!");
    }
}