package tests;

import common.Account;
import common.CommonTest;
import org.testng.annotations.Test;

public class SwagLabsTest extends CommonTest {
    private Account user = Account.STANDARD_USER;

    @Test
    public void successfulPurchase() {
        String searchingProductName = "Sauce Labs Backpack";
        String seccesfullyMessage = "THANK YOU FOR YOUR ORDER";
        pages.loginPage.openLoginPage();
        pages.loginPage.login(user.getLogin(), user.getPassword());
        pages.productPage.addProductToCart(searchingProductName);
        pages.productPage.openCart();
        pages.cartPage.makeCheckout();
        pages.checkoutInfoPage.fillCheckoutInformation("Denys", "Cheran", "1000");
        pages.checkoutOverviewPage.checkCorrectProductNameInTheCart(searchingProductName);
        pages.checkoutOverviewPage.finishOverviewing();
        pages.thankYouPage.checkSeccesfullyOfTheOrder(seccesfullyMessage);
    }

    @Test
    public void removingAnItemFromTheCart() {
        String searchingProductName = "Sauce Labs Fleece Jacket";
        pages.loginPage.openLoginPage();
        pages.loginPage.login(user.getLogin(), user.getPassword());
        pages.productPage.addProductToCart(searchingProductName);
        pages.productPage.openCart();
        pages.cartPage.deleteItemFromTheCart(searchingProductName);
        pages.cartPage.checkProductIsDeleted(searchingProductName);
    }

    @Test
    public void correctSortingByPriceAndName() {
        pages.loginPage.openLoginPage();
        pages.loginPage.login(user.getLogin(), user.getPassword());
        pages.productPage.selectSortType("az");
        pages.productPage.checkAZProductsSorting();

        pages.productPage.selectSortType("za");
        pages.productPage.checkZAProductsSorting();

        pages.productPage.selectSortType("lohi");
        pages.productPage.checkLOHIProductsSorting();

        pages.productPage.selectSortType("hilo");
        pages.productPage.checkHILOProductsSorting();
    }
}