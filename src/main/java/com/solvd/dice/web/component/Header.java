package com.solvd.dice.web.component;

import java.time.Duration;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.dice.web.page.SearchPage;
import com.solvd.dice.web.page.ShoppingCartPage;
import com.solvd.dice.web.page.StorePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class = 'Cart-inner']")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = ".//*[@href = '/store' and @class = 'Header-nav-item']")
    private ExtendedWebElement storeButton;

    @FindBy(xpath = ".//*[@class = 'Header-search']")
    private ExtendedWebElement searchButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShoppingCartPage openShoppingCart(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(o -> shoppingCartButton.isClickable());
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }

    public StorePage goToStore(){
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(o -> storeButton.isPresent());
        storeButton.click();
        return new StorePage(driver);
    }

    public SearchPage goToSearch(){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(o -> searchButton.isClickable());
        searchButton.click();
        return new SearchPage(driver);
    }
}

