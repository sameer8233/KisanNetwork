package com.kisannetwork.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kisannetwork.R;
import com.kisannetwork.database.config.DatabaseHandler;
import com.kisannetwork.modal.pojo.DbContactPojo;
import com.kisannetwork.modal.pojo.MessageResponse;
import com.kisannetwork.presenter.SendOtpPresenter;
import com.kisannetwork.utils.Dialogs;

import java.util.Random;

public class SendOTP extends AppCompatActivity implements View.OnClickListener {

    private TextView message;
    private Button send;
    private int otp;
    private String contact_number, contact_name;
    private DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);
        Intent i = getIntent();
        contact_number = i.getStringExtra("contact_number");
        contact_name = i.getStringExtra("contact_name");
        init();
        Random random = new Random();
        otp = random.nextInt(900000);
        message.setText("Hi. Your OTP is: " + otp);
        db = new DatabaseHandler(this);

    }

    private void init() {
        message = (TextView) findViewById(R.id.message);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        SendOtpPresenter sendOtpPresenter = new SendOtpPresenter();
        sendOtpPresenter.requestData(this, message.getText().toString(), contact_number);

    }

    public void setData(MessageResponse data) {
        if (data.getMessages()[0].getErrortext() == null) {
            db.addContact(new DbContactPojo(contact_name, contact_number, Integer.toString(otp), "Success"));
            Dialogs.showMessage(this, "OTP has been sent successfully.\nYour remaining balance is: " + data.getMessages()[0].getRemainingbalance());

        } else {
            db.addContact(new DbContactPojo(contact_name, contact_number, Integer.toString(otp), "Failure"));
            Dialogs.showMessage(this, "OTP could not sent.\n" + data.getMessages()[0].getErrortext());
        }

    }

}
