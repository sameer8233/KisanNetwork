package com.kisannetwork.modal.pojo;

/**
 * Created by Admin on 24-09-2016.
 */
public class DbContactPojo {

    private String contact_name;
    private String contact_number;
    private String otp;
    private String message_status;

    public DbContactPojo()
    {

    }

    public DbContactPojo(String contact_name, String contact_number, String otp, String message_status) {
        this.contact_name = contact_name;
        this.contact_number = contact_number;
        this.otp = otp;
        this.message_status = message_status;

    }

    public String getMessage_status() {
        return message_status;
    }

    public void setMessage_status(String message_status) {
        this.message_status = message_status;
    }

    public String getOtp_time() {
        return otp_time;
    }

    public void setOtp_time(String otp_time) {
        this.otp_time = otp_time;
    }

    private String otp_time;

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
