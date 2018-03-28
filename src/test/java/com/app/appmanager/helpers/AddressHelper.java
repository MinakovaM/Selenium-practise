package com.app.appmanager.helpers;

import com.app.appmanager.model.AddressData;
import com.app.appmanager.model.Addresses;
import com.app.appmanager.page.AccountPage;
import com.app.appmanager.page.FormAddressPage;
import com.app.appmanager.page.MyAddressPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AddressHelper {

    private WebDriver driver;
    private Addresses addressesCache = null;

    public AddressHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initCreation() {
        new MyAddressPage(driver)
                .clickByAddNewAddress();
    }

    public void goToMyAddressesPage() {
        new AccountPage(driver)
                .clickByAccountLink()
                .clickByMyAddress();
    }

    public void goToMyAccountPage() {
        new AccountPage(driver)
                .clickByAccountLink();
    }

    public void fillForm(AddressData addressData) {
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
                .inputTitle(addressData.getAlias());
    }
    public void submit() {
        new FormAddressPage(driver)
                .confirmAddress();
    }
    public boolean isPresentAlias(String addressAlias) {
        return new MyAddressPage(driver)
                .getAddressAliasList()
                .contains(addressAlias.toUpperCase());
    }
    public void remove(String addressAlias) {
        new MyAddressPage(driver)
                .clickDeleteButton(addressAlias)
                .acceptDeletion();

        addressesCache = null;
    }
    public void create(AddressData address) {
        initCreation();
        fillForm(address);
        submit();
        addressesCache = null;
    }

//    public int getCountAddress() {
//        return new FormAddressPage(driver)
//                .getCountAddressesElements();
//    }

    public Addresses all() {
        if (addressesCache != null)
            return addressesCache;

        addressesCache = new Addresses();

        List<String> firstNames = new MyAddressPage(driver).getFirstNameList();
        List<String> lastNames = new MyAddressPage(driver).getLastNameList();
        List<String> addresses = new MyAddressPage(driver).getAddressList();
        List<String> cities = new MyAddressPage(driver).getCityList();
        List<String> states = new MyAddressPage(driver).getStateList();
        List<String> zipCodes = new MyAddressPage(driver).getZipCodeList();
        List<String> countries = new MyAddressPage(driver).getCountryList();
        List<String> homePhones = new MyAddressPage(driver).getHomePhoneList();
        List<String> mobilePhones = new MyAddressPage(driver).getMobilePhoneList();
        List<String> addressAliases = new MyAddressPage(driver).getAddressAliasList();

        for (int i = 0; i < addressAliases.size(); i++) {
            addressesCache.add(new AddressData()
                    .withFirstName(firstNames.get(i))
                    .withLastName(lastNames.get(i))
                    .withAddress1(addresses.get(i))
                    .withCity(cities.get(i).substring(0, cities.get(i).length()-1))
                    .withState(states.get(i))
                    .withZipCode(zipCodes.get(i))
                    .withCountry(countries.get(i))
                    .withHomePhone(homePhones.get(i))
                    .withMobilePhone(mobilePhones.get(i))
                    .withAddressAlias(addressAliases.get(i))
            );
        }

        return addressesCache;
    }
}