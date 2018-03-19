package com.app;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.app.page.HomePage;
import com.app.page.LoginPage;
import com.app.page.MyAddressPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ShopTest extends BaseTest {

    @Test(groups = "login")
    public void loginTest() {
        driver.get(baseUrl + "/index.php");
        String signOutText =
                new HomePage(driver)
                        .goToLoginPage()
                        .inputLogin("testT@gmail.com")
                        .inputPassword("12369874")
                        .submitLogin()
                        .getSignOutText();
        Assert.assertEquals(signOutText, "Sign out");
        HomePage exit = new HomePage(driver).doLogOut();
    }

    @Test(groups = "address", priority = 0)
    public void addNewAddressTest() {
        driver.get(baseUrl + "/index.php");
        String newAddressName =
                new HomePage(driver)
                        .goToLoginPage()
                        .inputLogin("testT@gmail.com")
                        .inputPassword("12369874")
                        .submitLogin()
                        .goToAddressPage()
                        .addNewAddress()
                        .inputFirstName("testFirstName")
                        .inputLastName("testLastName")
                        .inputAddress("testAddress")
                        .inputCity("testCity")
                        .inputPostcode("01011")
                        .inputPhoneNumber("6241805")
                        .selectState("4")
                        .inputAddress2("testAddress2")
                        .inputMobilePhoneNumber("5081426")
                        .inputAddressTitle("TEST ADDRESS")
                        .submitAddingAddress()
                        .getSecondAddressName();
        Assert.assertEquals(newAddressName, "TEST ADDRESS");
        HomePage exit = new HomePage(driver).doLogOut();

//        driver.get(baseUrl);
//        driver.findElement(By.linkText("Sign in")).click();
//        driver.findElement(By.id("email")).click();
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys("testt@gmail.com");
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys("12369874");
//        driver.findElement(By.id("SubmitLogin")).click();
//        driver.findElement(By.xpath("//div[@id='columns']/div[3]")).click();
//        driver.findElement(By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a")).click();
//        driver.findElement(By.cssSelector("#center_column > div.clearfix.main-page-indent > a")).click();
//        driver.findElement(By.id("firstname")).clear();
//        driver.findElement(By.id("firstname")).sendKeys("testName");
//        driver.findElement(By.name("address1")).sendKeys("testAdress");
//        driver.findElement(By.name("address2")).sendKeys("testAdress2");
//        driver.findElement(By.id("city")).sendKeys("testCity");
//        Select selectStateEl = new Select(driver.findElement(By.id("id_state")));
//        selectStateEl.selectByValue("4");
//        driver.findElement(By.id("postcode")).sendKeys("62418");
//        driver.findElement(By.id("phone")).sendKeys("6241803");
//        driver.findElement(By.id("phone_mobile")).sendKeys("6241805");
//        driver.findElement(By.id("alias")).clear();
//        driver.findElement(By.id("alias")).sendKeys("TEST");
//        driver.findElement(By.id("submitAddress")).click();
//        driver.get("http://automationpractice.com/index.php?controller=addresses");
//        assertEquals(driver.findElement(By.cssSelector("#center_column > div.addresses > div > div:nth-child(2) > ul > li:nth-child(1) > h3")).getText(),"TEST");
//        driver.findElement(By.linkText("Sign out")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test(groups = "address", priority = 1)
    public void testEditAddress() throws Exception {
        driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("testT@gmail.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("12369874");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.cssSelector("a[title=\"Addresses\"] > span")).click();
        driver.findElement(By.xpath("//div[@id='center_column']/div/div/div[2]/ul/li[9]/a/span/i")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("62417");
        driver.findElement(By.id("submitAddress")).click();
        assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div/div/div[2]/ul/li[5]/span[3]")).getText(), "62417");
        driver.findElement(By.linkText("Sign out")).click();
    }

    @Test(groups = "address", priority = 2)
    public void testDeleteAddress() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("testT@gmail.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("12369874");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.get(baseUrl + "/index.php?controller=addresses");
        driver.findElement(By.xpath("//div[@id='center_column']/div/div/div[2]/ul/li[9]/a[2]/span")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        //TODO
        assertTrue(!driver.findElement(By.cssSelector("h3.page-subheading")).getText().contains("TEST"));
        driver.findElement(By.linkText("Sign out")).click();
    }


    @Test(groups = "sort")
    public void testSortByPrice() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Women")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Lowest first");
        driver.findElement(By.cssSelector("option[value=\"price:asc\"]")).click();
        try {
            assertEquals(driver.findElement(By.cssSelector("span.price.product-price")).getText(), "$16.40");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(groups = "sort")
    public void testSortByName() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Women")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Product Name: A to Z");
        driver.findElement(By.cssSelector("option[value=\"name:asc\"]")).click();
        try {
            assertEquals(driver.findElement(By.linkText("Blouse")).getText(), "Blouse");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(groups = "filter")
    public void testFilterByColour() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.id("layered_id_attribute_group_11")).click();
        try {
            assertEquals(driver.findElement(By.linkText("Blouse")).getText(), "Blouse");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.linkText("Printed Summer Dress")).getText(), "Printed Summer Dress");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("layered_id_attribute_group_7")).click();
        driver.findElement(By.id("layered_id_attribute_group_11")).click();
        try {
            assertEquals(driver.findElement(By.linkText("Printed Dress")).getText(), "Printed Dress");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("layered_id_attribute_group_15")).click();
        driver.findElement(By.id("layered_id_attribute_group_7")).click();
        try {
            assertEquals(driver.findElement(By.cssSelector("div.right-block > h5 > a.product-name")).getText(), "Printed Chiffon Dress");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}