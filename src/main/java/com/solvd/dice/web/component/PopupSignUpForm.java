package com.solvd.dice.web.component;

import java.time.Duration;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupSignUpForm extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class = 'mc-closeModal']")
    private ExtendedWebElement closeButton;

    public PopupSignUpForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void closePopupSignupForm(){
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(o -> closeButton.isClickable());
        closeButton.click();
    }
}
