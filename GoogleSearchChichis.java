package pragmatic.GIT_SoftTest;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class GoogleSearchChichis {

	private static WebDriver driver;
	private String keyword;

	@Parameters
	public static String[][] testData() {
		String[][] testData = { { "химическо чистене" }, 
				{ "химическо чистене софия" },
				{ "химическо чистене софия цени" }, 
				{ "химическо чистене софия обекти" },
				{ "химическо чистене услуги" }, 
				{ "химическо чистене боядисване на дрехи" } };

		return testData;
	}

	public GoogleSearchChichis(String keyword) {
		this.keyword = keyword;
	}

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		options.addArguments("--user-data-dir=C:\\Users\\iskra\\AppData\\Local\\Google\\Chrome");
		options.addArguments("--start-maximized", "--excludeSwitches", "--disable-component-update");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.get("https://www.google.bg/");
	}

	@Test
	public void searchHichisOption1() {
		driver.get("https://www.google.bg/");
		WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
		searchBar.sendKeys(keyword);

		WebElement searchButton = driver.findElement(By.xpath("//button[@name='btnG']"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchButton.click();

		WebElement keyword = driver
				.findElement(By.linkText("Хичис: Химическо чистене София. Пране, Гладене, Боядисване."));
		keyword.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement objects = driver.findElement(By.linkText("Обекти"));
		objects.click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchHichis1() {
		driver.get("https://www.google.bg/");
		WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
		searchBar.sendKeys(keyword);

		WebElement searchButton = driver.findElement(By.xpath("//button[@name='btnG']"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchButton.click();

		WebElement keyword = driver
				.findElement(By.linkText("Хичис: Химическо чистене София. Пране, Гладене, Боядисване."));
		keyword.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions builder = new Actions(driver);
		WebElement prices = driver.findElement(By.linkText("Цени"));
		builder.moveToElement(prices).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement tekstil = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Дрехи и домашен текстил")));
		tekstil.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchHichis2() {
		driver.get("https://www.google.bg/");
		WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
		searchBar.sendKeys(keyword);

		WebElement searchButton = driver.findElement(By.xpath("//button[@name='btnG']"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchButton.click();

		WebElement keyword = driver
				.findElement(By.linkText("Хичис: Химическо чистене София. Пране, Гладене, Боядисване."));
		keyword.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions builder = new Actions(driver);
		WebElement prices = driver.findElement(By.linkText("Цени"));
		builder.moveToElement(prices).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement leаther = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Кожени облекла")));
		leаther.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
