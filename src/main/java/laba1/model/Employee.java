package laba1.model;

import java.util.Objects;

public class Employee extends Entity{
    private String name;
    private String mobilePhone;
    private String position;

    public String getName() {
        return name;
    }

    public Employee(Integer id, String name, String mobilePhone, String position) {
        this.id = id;
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.position = position;
    }

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
