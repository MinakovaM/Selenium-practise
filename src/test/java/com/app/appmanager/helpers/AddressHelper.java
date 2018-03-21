package com.app.appmanager.helpers;

import com.app.appmanager.model.AddressData;
import com.app.appmanager.page.AccountPage;
import com.app.appmanager.page.FormAddressPage;
import com.app.appmanager.page.MyAddressPage;
import org.openqa.selenium.WebDriver;

public class AddressHelper {

    private WebDriver driver;

    public AddressHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initCreationAddress() {
        new MyAddressPage(driver)
                .clickByAddNewAddress();
    }

    public void goToMyAddressesPage() {
        new AccountPage(driver)
                .clickByMyAddress();
    }

    public void goToMyAccountPage() {
        new AccountPage(driver)
                .clickByAccountLink();
    }

    public void fillAddressForm(AddressData addressData) {
        new FormAddressPage(driver)
                .inputFirstName(addressData.getFirstName())
                .inputsLastName(addressData.getLastName())
                .inputAddress1(addressData.getAddress1())
                .inputAddress2(addressData.getAddress2())
                .inputCity(addressData.getCity())
                .inputState(addressData.getState())
                .inputZipCode(addressData.getZipCode())
                .inputCountry(addressData.getCountry())
                .inputHomePhone(addressData.getHomePhone())
                .inputMobilePhone(addressData.getMobilePhone())
                .inputTitle(addressData.getTitle());

//        Select selectStateEl = new Select(driver.findElement(By.id("id_state")));
//        selectStateEl.selectByValue("4");
    }


    public MyAddressPage confirmAddress() {
        new FormAddressPage(driver)
                .confirmAddress();
        return new MyAddressPage(driver);
    }
}