package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminCustomersPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductsPageObject;
import pageObjects.nopCommerce.user.CheckoutPageObject;
import pageObjects.nopCommerce.user.CompareProductsPageObject;
import pageObjects.nopCommerce.user.OrderPageObject;
import pageObjects.nopCommerce.user.RecentlyViewedProductsPageObject;
import pageObjects.nopCommerce.user.ShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserComputersPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserElectronicsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;
import pageObjects.nopCommerce.user.UserProductsNamePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.WishlistPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);

	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);

	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);

	}

	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);

	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);

	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);

	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);

	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);

	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);

	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);

	}

	public static UserComputersPageObject getUserComputersPage(WebDriver driver) {
		return new UserComputersPageObject(driver);

	}

	public static UserElectronicsPageObject getUserElectronicsPage(WebDriver driver) {
		return new UserElectronicsPageObject(driver);

	}

	public static UserDesktopsPageObject getUserDesktopsPage(WebDriver driver) {
		return new UserDesktopsPageObject(driver);

	}

	public static UserNotebooksPageObject getUserNotebooksPage(WebDriver driver) {
		return new UserNotebooksPageObject(driver);

	}

	public static UserProductsNamePageObject getUserProductsNamePage(WebDriver driver) {
		return new UserProductsNamePageObject(driver);

	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);

	}

	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);

	}

	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);

	}

	public static CompareProductsPageObject getCompareProductsPage(WebDriver driver) {
		return new CompareProductsPageObject(driver);

	}

	public static RecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver) {
		return new RecentlyViewedProductsPageObject(driver);

	}

	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);

	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
		
	}
	
	public static AdminProductsPageObject getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPageObject(driver);
		
	}
	
	public static AdminCustomersPageObject getAdminCustomersPage(WebDriver driver) {
		return new AdminCustomersPageObject(driver);
		
	}



}
