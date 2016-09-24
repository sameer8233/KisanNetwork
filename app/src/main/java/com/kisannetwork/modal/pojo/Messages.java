package com.kisannetwork.modal.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Messages
{
    private String to;
    @SerializedName("message-price")
    @Expose
    private String messageprice;

    private String status;


    @SerializedName("error-text")
    @Expose
    private String errortext;

    @SerializedName("message-id")
    @Expose
    private String messageid;

    @SerializedName("remaining-balance")
    @Expose
    private String remainingbalance;

    private String network;

    public String getTo ()
    {
        return to;
    }

    public void setTo (String to)
    {
        this.to = to;
    }

    public String getMessageprice ()
    {
        return messageprice;
    }

    public void setMessageprice (String messageprice)
    {
        this.messageprice = messageprice;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getMessageid ()
    {
        return messageid;
    }

    public void setMessageid (String messageid)
    {
        this.messageid = messageid;
    }

    public String getRemainingbalance ()
    {
        return remainingbalance;
    }

    public void setRemainingbalance (String remainingbalance)
    {
        this.remainingbalance = remainingbalance;
    }
    public String getErrortext() {
        return errortext;
    }

    public void setErrortext(String errortext) {
        this.errortext = errortext;
    }


    public String getNetwork ()
    {
        return network;
    }

    public void setNetwork (String network)
    {
        this.network = network;
    }


}