package com.app.page;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressPage extends BasePage {
    @FindBy(linkText = "Add a new address")
    private WebElement addAddressButton;
    @FindBy(xpath = "//div[@id='center_column']/div/div/div[2]/ul/li[9]/a[2]/span")
    private WebElement secondAddressDeleteButton;
    @FindBy(xpath = "//div[@id='center_column']/div/div/div[2]/ul/li[9]/a/span/i")
    private WebElement secondAddressEditButton;
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "address2")
    private WebElement address2Field;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "id_state")
    private WebElement stateDropdown;
    @FindBy(id = "postcode")
    private WebElement postcodeField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    @FindBy(id = "alias")
    private WebElement addressTitleField;
    @FindBy(id = "submitAddress")
    private WebElement saveButton;
    @FindBy(css = "#center_column > div.addresses > div > div:nth-child(2) > ul > li:nth-child(1) > h3")
    private WebElement secondAddressTitle;



    public MyAddressPage(WebDriver driver) {
        super(driver);
    }
    public MyAddressPage addNewAddress(){
        addAddressButton.click();
        return this;
    }

    public MyAddressPage inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public MyAddressPage inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public MyAddressPage inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
        return this;
    }
    public MyAddressPage inputAddress2(String address2) {
        address2Field.clear();
        address2Field.sendKeys(address2);
        return this;
    }
    public MyAddressPage inputCity (String address) {
        cityField.clear();
        cityField.sendKeys(address);
        return this;
    }

    public MyAddressPage selectState (String value) {
        new Select(stateDropdown)
                .selectByValue(value);
        return this;
    }

    public MyAddressPage inputPostcode (String code) {
        postcodeField.clear();
        postcodeField.sendKeys(code);
        return this;
    }

    public MyAddressPage inputPhoneNumber (String phoneNumber) {
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);
        return this;
    }
    public MyAddressPage inputMobilePhoneNumber (String mobilePhoneNumber) {
        phoneField.clear();
        phoneField.sendKeys(mobilePhoneNumber);
        return this;
    }
    public MyAddressPage inputAddressTitle (String title) {
        addressTitleField.clear();
        addressTitleField.sendKeys(title);
        return this;
    }

    public MyAddressPage submitAddingAddress () {
        saveButton.click();
        return this;
    }

    public MyAddressPage deleteLastAddress(){
        secondAddressDeleteButton.click();
        return this;
    }
    public MyAddressPage editSecondAddress (String newPostCode){
        secondAddressEditButton.click();
        postcodeField.sendKeys(newPostCode);
        saveButton.click();
        return this;
    }
    public String getSecondAddressName(){
        return secondAddressTitle.getText();
    }

}
