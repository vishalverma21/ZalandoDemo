package com.zalando.ui.home.objectrepository;

import org.openqa.selenium.By;

public class ZalandoLocator {

	/* Search Box Locator */
	public static final By searchBox = By.xpath(".//input[@id='searchContent']");
	
	/* Click on search box locator */
	public static final By searchBoxClick = By.xpath("//*[@id='searchButtonTopSubmit']");
	
	/* Add to cart button Locator */
	public static final By addToCartBtn = By.xpath("//button[@id='z-pdp-topSection-addToCartButton']");
	
	/* Sold out message Locator */
	public static final By soldOut = By.xpath("//*[@class='h-text h-color-black title-3 h-m-bottom-m']");

	/* Locator for complete list of item */
	public static final By switchElement = By.xpath("//*[@id='topsection-color-scroller']/div");

	/* Shopping cart button Locator */
	public static final By shoppingCartBtn = By
			.xpath("//*[@class='z-navicat-header_userAccNaviItemText notranslate'][text()='Warenkorb']");
	
	/* Add to wish list button Locator */
	public static final By addToWishlistBtn = By
			.xpath("//*[@class='z-coast-fjord_interactable z-coast-fjord_wishlistText']");
	
	/* On the wish list message locator */
	public static final By onTheWishlistBtn = By
			.xpath("//span[text()='Auf dem Wunschzettel']");
	
	/* My Account Button Locator */
	public static final By myAccountBtn = By.xpath("//*[@id='fieldAccountAccountBox']");

	/* Login Button Locator */
	public static final By loginBtn = By
			.xpath("//button[@class='z-button z-coast-reef_login_button z-button--primary z-button--button']");
	
	/* Log Out Button Locator */
	public static final By logOutBtn = By.xpath("//*[@id='logoutLink']");

	/* Enter Email input box Locator */
	public static final By enterEmail = By.xpath("//input[@name='login.email']");
	
	/* Enter Password input box Locator */
	public static final By enterPassword = By.xpath("//input[@name='login.password']");

	/* Product not found message locator */
	public static final By productNotFound = By.xpath("//*[@class='z-nvg-cognac_info-20ZHn']");

	/* Quantity drop down Locator */
	public static final By selectQty = By.xpath("//*[@class='z-coast-fjord_quantitySelect']");

	/* Wish list icon Locator */
	public static final By iconWishlist = By
			.xpath("//*[@class='z-navicat-header_userAccNaviItem']//a[contains(@href,'/wishlist/')]");

	/* Empty shopping cart message Locator */
	public static final By emptyShoppingCart = By.xpath("//*[@class='z-coast-ui-aligner_wrapper']");

	/* Remove item from wish list Locator */
	public static final By removeItemfromWishlist = By.xpath(
			"//div[@class='z_wishlist_ArticleCard__icon_close___ynls0 z_wishlist_icon__icon_remove___1YAnw z_wishlist_icon__icon___1PeMX z_wishlist_icon__icon-close___M326s']");

}
