package order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String login;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String deliveryDate;
    private String comment;
    private Integer rentTime;
    private Integer metroStation;

    public Order(String json){

    }

    public Order(String firstName, String lastName, String address, Integer metroStation, String phone, Integer rentTime, String deliveryDate, String comment, List color) {
        this.lastName = lastName;
        this.address = address;
        this.firstName = firstName;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.rentTime = rentTime;
        this.metroStation = metroStation;
    }


    private List<String> color = new ArrayList<String>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(Integer metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public void setRentTime(Integer rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

}