package pragmatic.GIT_SoftTest;
import java.lang.annotation.Repeatable;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HichisChrome {
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		options.addArguments("--user-data-dir=C:\\Users\\iskra\\AppData\\Local\\Google\\Chrome");
		options.addArguments("--start-maximized", "--excludeSwitches", "--disable-component-update");

		driver = new ChromeDriver(options);
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
		WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
		searchBar.sendKeys("химическо чистене софия");

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
		WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
		searchBar.sendKeys("химическо чистене софия");

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

}
