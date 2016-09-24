package com.kisannetwork.presenter;

import android.app.ProgressDialog;
import android.widget.Toast;

import com.kisannetwork.modal.pojo.ContactPojo;
import com.kisannetwork.modal.pojo.MessageResponse;
import com.kisannetwork.modal.pojo.restclient.RestClient;
import com.kisannetwork.utils.ConnectionDetector;
import com.kisannetwork.utils.Constants;
import com.kisannetwork.utils.Dialogs;
import com.kisannetwork.views.activity.SendOTP;
import com.kisannetwork.views.fragment.ContactListFragment;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 23-09-2016.
 */
public class SendOtpPresenter {

    private ConnectionDetector connectionDetector;
    private SendOTP context;
    private MessageResponse data;


    private void sendMessage(String from,String to,String text) {

        if (connectionDetector.isConnectedToInternet()) {
            final ProgressDialog d = Dialogs.showLoading(context);
            d.setCanceledOnTouchOutside(false);
            Call call = RestClient.get().sendMessage(Constants.API_KEY,Constants.SECRET,from,to,text);
            call.enqueue(new Callback<MessageResponse>() {
                @Override
                public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {

                    if (response.isSuccessful()) {
                        MessageResponse basePojo = response.body();
                            data = basePojo;
                            publish(context);
                        }
                    else {
                        int statusCode = response.code();
                        // handle request errors yourself
                        ResponseBody errorBody = response.errorBody();
                        Toast.makeText(context,errorBody.toString(),Toast.LENGTH_LONG).show();
                    }
                    d.dismiss();

                }

                @Override
                public void onFailure(Call<MessageResponse> call, Throwable t) {
                    Toast.makeText(context, Constants.SOMETHING_WRONG, Toast.LENGTH_LONG).show();
                    d.dismiss();
                }
            });
        } else {
            Toast.makeText(context,Constants.CHECK_CONNECTION_FALSE,Toast.LENGTH_LONG).show();

        }

    }

    public void requestData(SendOTP context,String message,String contact_number) {
        this.context = context;
        connectionDetector = new ConnectionDetector(context);
        // API Call
        contact_number="91"+contact_number;
        sendMessage("NEXMO",contact_number,message);
       // sendMessage("NEXMO","919461229855",message);
    }

    public void publish(SendOTP view) {
        if (view != null) {
            if (data != null) {
                // sending data to fragment
                view.setData(data);
            }
        }
    }

}
