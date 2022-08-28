package pages.productsPage;

import common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends CommonPage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By shoppingCart = By.xpath("//*[@class='shopping_cart_link']");
    private String addToCartButtonOfProduct = "//*[text()='#productName#']//ancestor::*[@class='inventory_item_description']//*[text()='Add to cart']";
    private String sortDropDown = "//*[@class='product_sort_container']";
    private String products = "//*[@class='inventory_item']";
    private String productName = "//*[@class='inventory_item'][#number#]//*[@class='inventory_item_name']";
    private String productPrice = "//*[@class='inventory_item'][#number#]//*[@class='inventory_item_price']";

    public void addProductToCart(String productName) {
        addToCartButtonOfProduct = addToCartButtonOfProduct.replace("#productName#", productName);
        waitForVisible(By.xpath(addToCartButtonOfProduct));
        driver.findElement(By.xpath(addToCartButtonOfProduct)).click();

    }

    public void openCart() {
        driver.findElement(shoppingCart).click();
    }

    public void selectSortType(String sortType) {
        Select select = new Select(driver.findElement(By.xpath(sortDropDown)));
        select.selectByValue(sortType);
    }

    public int getCountOfProducts() {
        return driver.findElements(By.xpath(products)).size();
    }

    public void checkAZProductsSorting() {
        List<String> actualProducts = getActualProductsList();

        List<String> sortedValues = new LinkedList<>();
        sortedValues.addAll(actualProducts);
        sortedValues = sortedValues.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedValues.size(); i++) {
            Assert.assertEquals(actualProducts.get(i), sortedValues.get(i), "Sorting does not work");
        }
    }

    public void checkZAProductsSorting() {
        List<String> actualProducts = getActualProductsList();

        List<String> sortedValues = new LinkedList<>();
        sortedValues.addAll(actualProducts);
        sortedValues = sortedValues.stream().sorted().collect(Collectors.toList());
        Collections.reverse(sortedValues);
        for (int i = 0; i < sortedValues.size(); i++) {
            Assert.assertEquals(actualProducts.get(i), sortedValues.get(i), "Sorting does not work");
        }
    }

    private List<String> getActualProductsList() {
        int countOfElements = getCountOfProducts();
        List<String> actualProducts = new LinkedList<>();
        for (int i = 1; i <= countOfElements; i++) {
            String locator = productName.replace("#number#", String.valueOf(i));
            actualProducts.add(driver.findElement(By.xpath(locator)).getText());
        }
        return actualProducts;
    }

    public void checkLOHIProductsSorting() {
        List<Double> actualPrices = getActualProductsPricesList();

        List<Double> sortedValues = new LinkedList<>();
        sortedValues.addAll(actualPrices);
        sortedValues = sortedValues.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedValues.size(); i++) {
            Assert.assertEquals(actualPrices.get(i), sortedValues.get(i), "Sorting does not work");
        }
    }

    public void checkHILOProductsSorting() {
        List<Double> actualPrices = getActualProductsPricesList();

        List<Double> sortedValues = new LinkedList<>();
        sortedValues.addAll(actualPrices);
        sortedValues = sortedValues.stream().sorted().collect(Collectors.toList());
        Collections.reverse(sortedValues);
        for (int i = 0; i < sortedValues.size(); i++) {
            Assert.assertEquals(actualPrices.get(i), sortedValues.get(i), "Sorting does not work");
        }
    }

    private List<Double> getActualProductsPricesList() {
        int countOfElements = getCountOfProducts();
        List<Double> actualProductsPrices = new LinkedList<>();
        for (int i = 1; i <= countOfElements; i++) {
            String locator = productPrice.replace("#number#", String.valueOf(i));
            actualProductsPrices.add(Double.valueOf(driver.findElement(By.xpath(locator))
                    .getText().replace("$", "")));
        }
        return actualProductsPrices;
    }
}