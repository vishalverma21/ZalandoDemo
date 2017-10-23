package com.zalando.attachhooks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zalando.common.utils.ConfigManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHooks {

	private Scenario scenario;
	public static WebDriver driver;
	private static Logger LOGGER = LoggerFactory.getLogger(AttachHooks.class);

	@Before
	public void setUp(Scenario scenario) throws IOException {
		LOGGER.info("Inside set up method of before hook");
		ConfigManager.loadConfig();
		this.scenario = scenario;
		System.out.println(scenario.getName());

		if (ConfigManager.getProperty("browserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
		}
		if (ConfigManager.getProperty("browserName").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}
		if (ConfigManager.getProperty("browserName").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\SkilrockAutomation\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		System.out.println("Browrse Opened");
		driver.get(ConfigManager.getProperty("EnvironmentURL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

	@After
	public void tearDown() throws InstantiationException, IllegalAccessException, IOException {
		
			driver.quit();
	}

}