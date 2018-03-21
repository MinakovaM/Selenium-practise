package com.app.appmanager.model;

public class AddressData {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address1;
    private final String address2;
    private final String city;
    private final int state;
    private final String zipCode;
    private final int country;
    private final String homePhone;
    private final String mobilePhone;
    private final String title;


//    public AddressData(String firstName, String lastName, String company, String address1,
//                       String address2, String city, String state, String zipCode, String country, String homePhone,
//                       String mobilePhone, String title) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.company = company;
//        this.address1 = address1;
//        this.address2 = address2;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.country = country;
//        this.homePhone = homePhone;
//        this.mobilePhone = mobilePhone;
//        this.title = title;
//    }
    public AddressData(String firstName, String lastName, String company, String address1,
                       String address2, String city, int state, String zipCode, int country, String homePhone,
                       String mobilePhone, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public int getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getTitle() {
        return title;
    }
}