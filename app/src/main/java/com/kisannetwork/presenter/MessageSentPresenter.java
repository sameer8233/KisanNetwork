package com.kisannetwork.presenter;

import com.kisannetwork.database.config.DatabaseHandler;
import com.kisannetwork.modal.pojo.DbContactPojo;
import com.kisannetwork.views.fragment.ContactListFragment;
import com.kisannetwork.views.fragment.MessageSentFragment;

import java.util.List;

/**
 * Created by Admin on 24-09-2016.
 */
public class MessageSentPresenter {

    private List<DbContactPojo> contact_list;
    private MessageSentFragment context;

    private void getData() {
        // making contacts pojo

        DatabaseHandler db=new DatabaseHandler(context.getActivity());
        List<DbContactPojo> contacts = db.getAllContacts();
        contact_list=contacts;

        publish(context);

    }

    public void requestData(MessageSentFragment context) {
        this.context = context;
        // API Call
        getData();
    }

    public void publish(MessageSentFragment view) {
        if (view != null) {
            if (contact_list != null) {
                // sending data to fragment
                view.setData(contact_list);
            }
        }
    }


}
