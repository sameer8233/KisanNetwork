package com.kisannetwork.modal.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageResponse
{
    @SerializedName("message-count")
    @Expose
    private String messagecount;

    private Messages[] messages;

    public String getMessagecount ()
    {
        return messagecount;
    }

    public void setMessagecount (String messagecount)
    {
        this.messagecount = messagecount;
    }

    public Messages[] getMessages ()
    {
        return messages;
    }

    public void setMessages (Messages[] messages)
    {
        this.messages = messages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message-count = "+messagecount+", messages = "+messages+"]";
    }
}