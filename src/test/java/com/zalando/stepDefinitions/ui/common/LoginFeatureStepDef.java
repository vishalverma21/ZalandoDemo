package com.zalando.stepDefinitions.ui.common;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zalando.attachhooks.AttachHooks;
import com.zalando.common.pages.LoginPage;
import com.zalando.common.utils.ConfigManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginFeatureStepDef {

	LoginPage loginPage = new LoginPage(AttachHooks.driver);
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoginFeatureStepDef.class);
	

	@Given("^login with valid credentials$")
	public void login_with_valid_credentials() throws Throwable {
		try {
			//loginPage = new LoginPage(AttachHooks.driver);
			
			loginPage.enterUsername(ConfigManager.getProperty("userName"));
			loginPage.enterPassword(ConfigManager.getProperty("password"));
			loginPage.loginBtn();
			LOGGER.info("Successfully logged In!!");
						
		} catch (Exception e) {
			LOGGER.error("Exception in Login"+e.getMessage());
		}
	}
	
	@Then("^HomePage should be visible$")
	public void validateHomePage() throws Throwable {

		if(!loginPage.HomePage())
		{
			Assert.fail("Home Page Is Not Visible");
		}
	}
}
