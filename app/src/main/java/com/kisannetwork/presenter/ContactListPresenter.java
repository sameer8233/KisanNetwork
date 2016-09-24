package com.kisannetwork.presenter;

import com.kisannetwork.modal.pojo.ContactPojo;
import com.kisannetwork.utils.ConnectionDetector;
import com.kisannetwork.views.fragment.ContactListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 23-09-2016.
 */
public class ContactListPresenter {

    private List<ContactPojo> contact_list;
    private ContactListFragment context;
    private ConnectionDetector connectionDetector;

    private void addContacts() {
        // making contacts pojo

        contact_list = new ArrayList<>();
        contact_list.add(0, new ContactPojo("Sameer", "Yadav", "9461229855"));
        contact_list.add(1, new ContactPojo("Abhishek", "Yadav", "946139855"));
        contact_list.add(2, new ContactPojo("Jeet", "Nagar", "9461324443"));
        contact_list.add(3, new ContactPojo("Rahul", "Babel", "9461223244"));
        contact_list.add(4, new ContactPojo("Deepu", "Yadav", "9929038585"));
        contact_list.add(5, new ContactPojo("Kisan", "Network", "9111011382"));

        //after building results
        // publish result(contact list)
        publish(context);

    }

    public void requestData(ContactListFragment context) {
        this.context = context;
        connectionDetector = new ConnectionDetector(context.getActivity());
        // API Call
        addContacts();
    }

    public void publish(ContactListFragment view) {
        if (view != null) {
            if (contact_list != null) {
                // sending data to fragment
                view.setData(contact_list);
            }
        }
    }


}
