package com.app.tests;

import com.app.appmanager.model.AddressData;
import com.app.appmanager.model.Addresses;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressTest extends BaseTest {

    @BeforeMethod
    public void preparePreconditions() {
        app.session().login(app.getProperties().getProperty("login"), "12369874");
        app.address().goToMyAddressesPage();
    }

    @Test(dataProvider = "creationAddress", priority = 2)
    public void testAddressAdd(AddressData address) {
        if (app.address().isPresentAlias(address.getAlias())) {
            app.address().remove(address.getAlias());
        }

        Addresses before = app.address().all();
        app.address().create(address);
        Set<AddressData> after = app.address().all();

        assertThat(after.size(), equalTo(before.size()+1));
        assertThat(after, equalTo(before.withAdded(address.withAddressAlias(address.getAlias().toUpperCase()))));
        app.session().logOut();
    }

    @DataProvider(name="creationAddress")
    private Object[] getCreationAddressData() {
        return new Object[]{
                new AddressData()
                        .withFirstName("TestName")
                        .withLastName("TestSurname")
                        .withAddress1("Kirova str.")
                        .withAddress2("38")
                        .withCity("Kharkov")
                        .withState("Alaska")
                        .withZipCode("77777")
                        .withCountry("United States")
                        .withHomePhone("12369874")
                        .withMobilePhone("47896321")
                        .withAddressAlias("TestAddress")
        };
    }
}

