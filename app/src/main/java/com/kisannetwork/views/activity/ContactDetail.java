package com.kisannetwork.views.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kisannetwork.R;
import com.kisannetwork.modal.pojo.ContactPojo;

public class ContactDetail extends AppCompatActivity implements View.OnClickListener{

    private TextView first_name,last_name,contact_number;
    private Button send_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        Intent i=getIntent();
        ContactPojo contact= (ContactPojo) i.getSerializableExtra("contact");
        init();
        //setting data to the views
        first_name.setText(contact.first_name);
        last_name.setText(contact.last_name);
        contact_number.setText(contact.getContact_number());

    }

    private void init()
    {
        first_name=(TextView)findViewById(R.id.first_name);
        last_name=(TextView)findViewById(R.id.last_name);
        contact_number=(TextView)findViewById(R.id.contact_number);
        send_message=(Button) findViewById(R.id.send_message);
        send_message.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.send_message:
                Intent i=new Intent(getApplicationContext(),SendOTP.class);
                i.putExtra("contact_number",contact_number.getText().toString());
                i.putExtra("contact_name",first_name.getText().toString()+" "+last_name.getText().toString());
                startActivity(i);
                break;
        }

    }
}
