package com.app.appmanager.model;

public class LoginData {
    private String login;
    private String passwd;
    private String errorMessage;

    public LoginData() {
    }

    public LoginData withLogin(String login) {
        this.login = login;
       return this;
    }
    public LoginData withPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }
    public LoginData withErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

//    public Object [] loginDataToArray(LoginData loginData){
//        Object [] loginDataObject = new Object[3];
//        for (int i = 0; i < 3; i++){
//            loginDataObject[i] =
//        }
//    }

}
