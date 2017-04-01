package pragmatic.GIT_SoftTest;

	import java.util.concurrent.TimeUnit;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Hichis {

		WebDriver driver;

		@Before
		public void setUp() {
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("general.useragent.override",
					"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
			driver = new FirefoxDriver(profile);
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("https://www.google.bg/");
		}

		@After
		public void tearDown() {
			driver.quit();
		}

		@Test
		public void searchHichis() {
			WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
			searchBar.sendKeys("химическо чистене софия");
			driver.findElement(By.xpath("//div[@class='_DZg']//*[@class='_nLg _Ihg _Lhg']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='btnG']")));
//			WebElement searchButton = driver.findElement(By.xpath("//button[@name='btnG']"));
//			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			searchButton.click();

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,400)");
			WebElement keyword = driver.findElement(By.linkText("Хичис: Химическо чистене София. Пране, Гладене, Боядисване."));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			keyword.click();
			
			WebElement services = driver.findElement(By.linkText("Услуги"));
			services.click();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			WebElement aboutUs = driver.findElement(By.linkText("Цени"));
			aboutUs.click();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			

		}
	}

