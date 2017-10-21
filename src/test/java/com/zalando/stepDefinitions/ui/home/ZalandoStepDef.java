package com.zalando.stepDefinitions.ui.home;

import org.slf4j.Logger;
import org.junit.Assert;

import com.zalando.attachhooks.AttachHooks;
import com.zalando.ui.home.page.ZalandoPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZalandoStepDef {

	ZalandoPage zPage = new ZalandoPage(AttachHooks.driver);

	Logger logger = org.slf4j.LoggerFactory.getLogger(ZalandoStepDef.class);

	@Given("^Go to the Search box and search for (.*)$")
	public void go_to_the_Search_box_and_search_for_First(String item) throws Throwable {
		if (!zPage.searchItem(item)) {
			Assert.fail(); // Method will fail if wrong item is searched
		}
	}

	@When("^Add item to the cart$")
	public void add_item_to_the_cart() throws Throwable {
		if (!zPage.addToCart()) {
			Assert.fail(); // Method will fail if item is not added in cart
							// successfully
		}
	}

	@When("^Go to the cart and change the (.*) of item$")
	public void go_to_the_cart_and_change_the_of_item(String quantity) throws Throwable {
		if (!zPage.changeQuantity(quantity)) {
			Assert.fail(); /* Method will fail if quantity can not be changed or
							 wrong quantity is passed*/
		}
	}

	@When("^Move the items from the basket to the wishlist$")
	public void move_the_items_from_the_basket_to_the_wishlist() throws Throwable {
		if (!zPage.addToWishList()) {
			Assert.fail(); //Method will fail if item is already available in wish list
		}
	}

	@Then("^Verify item is moved to the wishlist$")
	public void verify_item_is_moved_to_the_wishlist() throws Throwable {
		if (!zPage.emptyShoppingCart()) {
			Assert.fail();  //Method will fail if item is not moved to wish list
		}
	}

}