package com.ust.evaluation;

public class Address {
    private Integer houseNo;
    private String streetName;
    private String city;
    private Integer pinCode;

    public Address(Integer houseNo, String streetName, String city, Integer pinCode) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
