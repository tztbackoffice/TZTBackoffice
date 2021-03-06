/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Models;

import java.util.Date;

/**
 * This is the model for a Package
 * @author Andy
 */
public class PackageModel {
    private int idPackage;
    private int idCustomer;
    private Date signupDateTime;
    private double weight;
    private double height;
    private double length;
    private double width;
    private Date pickUpDate;
    private Date deliveryDate;
    private String isDelivered;
    
    private String afzFirstname;
    private String afzLastname;
    private String afzStreetname;
    private String afzHousenumber;
    private String afzZipcode;
    private String afzCity;
    
    private String addrFirstname;
    private String addrLastName;
    private String addrStreetname;
    private String addrHousenumber;
    private String addrZipcode;
    private String addrCity;

    public String getAfzFirstname() {
        return afzFirstname;
    }

    public void setAfzFirstname(String afzFirstname) {
        this.afzFirstname = afzFirstname;
    }

    public String getAfzLastname() {
        return afzLastname;
    }

    public void setAfzLastname(String afzLastname) {
        this.afzLastname = afzLastname;
    }

    public String getAfzStreetname() {
        return afzStreetname;
    }

    public void setAfzStreetname(String afzStreetname) {
        this.afzStreetname = afzStreetname;
    }

    public String getAfzHousenumber() {
        return afzHousenumber;
    }

    public void setAfzHousenumber(String afzHousenumber) {
        this.afzHousenumber = afzHousenumber;
    }

    public String getAfzZipcode() {
        return afzZipcode;
    }

    public void setAfzZipcode(String afzZipcode) {
        this.afzZipcode = afzZipcode;
    }

    public String getAfzCity() {
        return afzCity;
    }

    public void setAfzCity(String afzCity) {
        this.afzCity = afzCity;
    }

    public String getAddrFirstname() {
        return addrFirstname;
    }

    public void setAddrFirstname(String addrFirstname) {
        this.addrFirstname = addrFirstname;
    }

    public String getAddrLastName() {
        return addrLastName;
    }

    public void setAddrLastName(String addrLastName) {
        this.addrLastName = addrLastName;
    }

    public String getAddrStreetname() {
        return addrStreetname;
    }

    public void setAddrStreetname(String addrStreetname) {
        this.addrStreetname = addrStreetname;
    }

    public String getAddrHousenumber() {
        return addrHousenumber;
    }

    public void setAddrHousenumber(String addrHousenumber) {
        this.addrHousenumber = addrHousenumber;
    }

    public String getAddrZipcode() {
        return addrZipcode;
    }

    public void setAddrZipcode(String addrZipcode) {
        this.addrZipcode = addrZipcode;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }
    
    public String getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(String isDelivered) {
        this.isDelivered = isDelivered;
    }

    public int getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(int idPackage) {
        this.idPackage = idPackage;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getSignupDateTime() {
        return signupDateTime;
    }

    public void setSignupDateTime(Date signupDateTime) {
        this.signupDateTime = signupDateTime;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
