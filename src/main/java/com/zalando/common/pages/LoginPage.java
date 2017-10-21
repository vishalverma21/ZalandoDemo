package com.zalando.common.pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zalando.ui.home.objectrepository.ZalandoLocator;


public class LoginPage extends BasePage {

	String username = null;

	private static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
	BasePage basepage;

	public LoginPage(WebDriver driver) {
		super(driver);
		findElement(ZalandoLocator.myAccountBtn, 5).click();
	}
	
	public boolean HomePage() {
		if (isElementPresent(ZalandoLocator.myAccountBtn, 5)) {
			LOGGER.info("Home Page is visible");
		} else {
			LOGGER.error("Home Page is not visible");
		}
		return true;
	}

	public void enterUsername(String username) {
		findElement(ZalandoLocator.enterEmail, 5).sendKeys(username);
	}

	public void enterPassword(String password) {
		findElement(ZalandoLocator.enterPassword, 5).sendKeys(password);
	}
	
	public void loginBtn() {
		findElement(ZalandoLocator.loginBtn, 5).click();
	}

}
