package com.app.appmanager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormAddressPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "address1")
    private WebElement address1Input;
    @FindBy(id = "address2")
    private WebElement address2Input;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "id_state")
    private WebElement stateInput;
    @FindBy(id = "postcode")
    private WebElement zipCodeInput;
    @FindBy(id = "id_country")
    private WebElement countryInput;
    @FindBy(id = "phone")
    private WebElement homePhoneInput;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;
    @FindBy(id = "alias")
    private WebElement titleInput;
    @FindBy(id = "submitAddress")
    private WebElement saveButton;
    @FindBy(css = "#center_column > div.addresses ul")
    private List<WebElement> addresses;

    public FormAddressPage(WebDriver driver) {
        super(driver);
    }

    public FormAddressPage inputFirstName(String firstName) {
        type(firstNameInput, firstName);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputsLastName(String lastName) {
        type(lastNameInput, lastName);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputAddress1(String address1) {
        type(address1Input, address1);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputAddress2(String address2) {
        type(address2Input, address2);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputCity(String city) {
        type(cityInput, city);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputState(String state) {
        selectByText(stateInput, state);
        return new FormAddressPage(driver);
    }
    public FormAddressPage inputZipCode(String zip){
        type(zipCodeInput, zip);
        return new FormAddressPage(driver);
    }
    public FormAddressPage inputCountry (String country){
        selectByText(countryInput, country);
        return new FormAddressPage(driver);
    }
    public FormAddressPage inputHomePhone (String phone){
        type(homePhoneInput, phone);
        return new FormAddressPage(driver);
    }
    public FormAddressPage inputMobilePhone(String mobile){
        type(mobilePhoneInput, mobile);
        return new FormAddressPage(driver);
    }
    public FormAddressPage inputTitle(String title){
        type(titleInput, title);
        return new FormAddressPage(driver);
    }
    public MyAddressPage confirmAddress(){
        click(saveButton);
        return new MyAddressPage(driver);
    }

//    public int getCountAddressesElements() {
//        return addresses.size();
//    }
}