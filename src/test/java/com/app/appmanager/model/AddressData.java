package com.app.appmanager.model;

import java.util.Objects;

public class AddressData {
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;

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

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAlias() {
        return addressAlias;
    }

    public AddressData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AddressData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AddressData withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }
    public AddressData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public AddressData withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressData withState(String state) {
        this.state = state;
        return this;
    }

    public AddressData withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressData withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public AddressData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public AddressData withAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressData that = (AddressData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address1, that.address1) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(country, that.country) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(addressAlias, that.addressAlias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address1, city, state, zipCode, country, homePhone, mobilePhone, addressAlias);
    }

    @Override
    public String toString() {
        return "AddressData{" +
                ", addressAlias='" + addressAlias + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}

