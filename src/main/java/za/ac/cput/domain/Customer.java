//Domain  Customer class
// Pojo Customer
// Author: Jordy Meye (220072841)
// Date: 24 03 2023

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    @Id
    private String customerId;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String password;

    public Customer(){}


    public Customer(Builder builder){


        this.customerId=builder.customerId;
        this.name = builder.name;
        this.surname= builder.surname;
        this.email=builder.email;
        this.address=builder.address;
        this.password=builder.password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {

        private String customerId;
        private String name;
        private String surname;
        private String email;
        private String address;
        private String password;


        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy ( Customer customer){
            this.customerId= customer.customerId;
            this.name = customer.name;
            this.surname= customer.surname;
            this.email= customer.email;
            this.address= customer.address;
            this.password= customer.password;
            return this;
        }

        public Customer build(){return new Customer(this);}
    }
}
