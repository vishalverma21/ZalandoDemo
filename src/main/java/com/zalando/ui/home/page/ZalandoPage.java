package com.zalando.ui.home.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zalando.common.pages.BasePage;
import com.zalando.ui.home.objectrepository.ZalandoLocator;

public class ZalandoPage extends BasePage {

	public ZalandoPage(WebDriver driver) {
		super(driver);
	}

	static WebDriverWait wait;
	Logger logger = LoggerFactory.getLogger(ZalandoPage.class);

	// Method created to search item
	public boolean searchItem(String item) {
		try {
			findElement(ZalandoLocator.searchBox, 5).sendKeys(item);
			findElement(ZalandoLocator.searchBoxClick, 5).click();
			if (isElementPresent(ZalandoLocator.productNotFound, 5)) {
				logger.info("Product Not Found");
				Assert.fail();
			} else {
				logger.info("item searched successfully");
			}
			return true;
		} catch (Exception e) {
			logger.error("Error in searching item :" + e);
			return false;
		}
	}

	// Method created to add item in cart
	public boolean addToCart() {
		try {
			JavascriptExecutor b = (JavascriptExecutor) driver;
			b.executeScript("scroll(0,500)");
			int count = 2;

			// If item is sold out then check for next variant
			while (isElementPresent(ZalandoLocator.soldOut, 5)) {
				logger.info("Product is sold out");
				b.executeScript("scroll(0,500)");
				String baseString = ".//*[@id='topsection-color-scroller']/div";
				StringBuilder sb = new StringBuilder(baseString);
				sb.append("[").append(count).append("]");
				findElement(By.xpath(sb.toString()), 5).click();
			}
			b.executeScript("scroll(0,500)");
			findElement(ZalandoLocator.addToCartBtn, 5).click();

		} catch (Exception e) {
			logger.error("add to cart selection failed" + e);
			return false;
		}
		return true;
	}

	// Method created to change the quantity of an item
	public boolean changeQuantity(String quantity) {
		try {
			JavascriptExecutor b = (JavascriptExecutor) driver;
			b.executeScript("scroll(0,0)");
			Thread.sleep(500);
			findElement(ZalandoLocator.shoppingCartBtn, 5).click();
			Select qty = new Select(driver.findElement(ZalandoLocator.selectQty));
			qty.selectByVisibleText(quantity);

		} catch (Exception e) {
			logger.error("Quantity can not be changed" + e);
			return false;
		}
		return true;
	}

	// Method created to add the item to wish list
	public boolean addToWishList() {
		try {
			if (isElementPresent(ZalandoLocator.addToWishlistBtn, 5)) {
				Thread.sleep(500);
				findElement(ZalandoLocator.addToWishlistBtn, 5).click();
			} else {
				logger.info("item is already in wishlist");
				Assert.fail();
			}
		} catch (Exception e) {
			logger.error("Failed to add item in wishlist" + e);
			return false;
		}
		return true;
	}

	// Method created to check whether item is moved to wish list or not
	public boolean emptyShoppingCart() {
		try {

			if ((ZalandoLocator.emptyShoppingCart).toString()
					.equals("Leg los und fülle ihn mit den neuesten Fashion Trends.")) {
				logger.info("item is moved to wishlist");
			}

		} catch (Exception e) {
			logger.error("Failed to move item in wishlist" + e);
			return false;
		}
		return true;
	}

	/* Method created to remove item from wish list -- Currently not in use but
	   we can use it to remove item from wish list */
	public boolean removeItemFromWishlist() {
		try {
			findElement(ZalandoLocator.iconWishlist, 5).click();
			if (isElementPresent(ZalandoLocator.removeItemfromWishlist, 5)) {
				findElement(ZalandoLocator.removeItemfromWishlist, 5).click();
				logger.info("item removed successfully from wishlist");
			}
			return true;
		} catch (Exception e) {
			logger.error("Failed to remove item in wishlist" + e);
			return false;
		}
	}

}
