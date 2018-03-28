package com.app.appmanager.helpers;

import com.app.appmanager.model.LoginData;
import com.app.appmanager.page.AccountPage;
import com.app.appmanager.page.HomePage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;


public class LoginHelper {
    private Object[] loginData;
    private WebDriver driver;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
    }

    public Object [][] getLoginFromExcelFile(String path, String sheetName) {
        File file = new File(path);
//        List<LoginData> allLoginsFromFile = new ArrayList<>();
        Object[][] allLoginsFromFile = null;
        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            allLoginsFromFile = new Object[sheet.getLastRowNum()+1][3];
            System.out.println();
            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                XSSFRow row = sheet.getRow(r);
                allLoginsFromFile[r][0] = row.getCell(0).getStringCellValue();
                allLoginsFromFile[r][1] = row.getCell(1).getStringCellValue();
                allLoginsFromFile[r][2] = row.getCell(2).getStringCellValue();
                System.out.println(allLoginsFromFile[r][0] + " " + allLoginsFromFile[r][1] + " " + allLoginsFromFile[r][2]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allLoginsFromFile;
    }

    public String signOutText(){
        return new AccountPage(driver).getSignOutText();
    }
    public String invalidLoginError(String login, String password) {
        return new HomePage(driver).goToLoginPage()
                .inputLogin(login)
                .inputPassword(password)
                .checkInvalidLogin()
                .getErrorMessage()
                .getText();
    }

}
