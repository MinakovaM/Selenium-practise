package com.app.appmanager;

import com.app.appmanager.helpers.AddressHelper;
import com.app.appmanager.helpers.SessionHelper;
import com.app.appmanager.helpers.AddressHelper;
import com.app.appmanager.helpers.SessionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private AddressHelper addressHelper;
    private SessionHelper sessionHelper;
    protected WebDriver driver;
    protected String baseUrl;

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public void init(String browser) throws Exception {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "d:/Java/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "d:/Java/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equals("IE")) {
            File ie = new File("d:/Java/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", ie.getAbsolutePath());
            driver = new InternetExplorerDriver();
        }
        else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "d:/Java/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/index.php");
        addressHelper = new AddressHelper(driver);
        sessionHelper = new SessionHelper(driver);
    }


    public void stop() throws Exception {
        driver.quit();
    }

}