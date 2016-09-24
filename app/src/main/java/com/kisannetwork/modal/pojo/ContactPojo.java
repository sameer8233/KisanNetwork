package com.kisannetwork.modal.pojo;

import java.io.Serializable;

/**
 * Created by Admin on 23-09-2016.
 */
public class ContactPojo implements Serializable{

    public String first_name;
    public String last_name;
    public String contact_number;

    public ContactPojo(String first_name, String last_name, String contact_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_number = contact_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
}
