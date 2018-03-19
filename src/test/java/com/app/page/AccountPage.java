package com.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;
    @FindBy(css = "a[title='Addresses'")
    private WebElement myAddressLink;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getSignOutText() {
        return signOutLink.getText();
    }
    public MyAddressPage goToAddressPage(){
        myAddressLink.click();
        return new MyAddressPage(driver);
    }
}