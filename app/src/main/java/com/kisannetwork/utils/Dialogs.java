package com.kisannetwork.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kisannetwork.R;

public class Dialogs {


    public static ProgressDialog showLoading(Activity activity) {
        ProgressDialog mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(Constants.LOADING_MESSAGE);
        mProgressDialog.show();
        return mProgressDialog;
    }

    public static void showMessage(Context context, String message) {
        Button OkButtonLogout;
        final Dialog simpledialog = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar);
        simpledialog.setContentView(R.layout.custom_dialog);
        TextView msg_textView = (TextView) simpledialog.findViewById(R.id.text_exit);
        msg_textView.setText(message);
        OkButtonLogout = (Button) simpledialog.findViewById(R.id.btn_yes_exit);
        Button CancelButtonLogout = (Button) simpledialog.findViewById(R.id.btn_no_exit);
        CancelButtonLogout.setVisibility(View.GONE);

        OkButtonLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpledialog.dismiss();
            }
        });
        CancelButtonLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpledialog.dismiss();
            }
        });
        simpledialog.show();
    }


}
