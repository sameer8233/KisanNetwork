package com.kisannetwork.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kisannetwork.R;
import com.kisannetwork.adapters.ContactRecyclerAdapter;
import com.kisannetwork.modal.pojo.ContactPojo;
import com.kisannetwork.presenter.ContactListPresenter;
import com.kisannetwork.views.activity.ContactDetail;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 23-09-2016.
 */

public class ContactListFragment extends Fragment implements View.OnClickListener {
    private View view;
    private static ContactListPresenter contactListPresenter;
    private RecyclerView recyclerView;
    private ContactRecyclerAdapter contactRecyclerAdapter;

    public static ContactListFragment newInstance() {

        return new ContactListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactRecyclerAdapter = new ContactRecyclerAdapter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contactlist_fragment, container, false);

        init();

        if (contactListPresenter == null) {
            //requesting data from presenter.
            contactListPresenter = new ContactListPresenter();
            contactListPresenter.requestData(this);

        } else {
            // in case of screen is rotation this method called.
            // getting data from presenter.
            // NO API HIT TO SERVER AGAIN.
            contactListPresenter.publish(this);

        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!(getActivity()).isChangingConfigurations()) {
            contactListPresenter = null;
        }
    }

    // getting data from presenter.
    public void setData(List<ContactPojo> contact_list)
    {
        //sending data to recycler view to dislpay on screen.
        contactRecyclerAdapter.setData(contact_list);
    }

    public void init(){
        recyclerView=(RecyclerView)view.findViewById(R.id.contact_list_recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(contactRecyclerAdapter);
    }

    // implemented click listener for every contact which redirect to contactDetail activity
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.contact_name:
                   ContactPojo contact = (ContactPojo) view.getTag();
                    Intent i=new Intent(getActivity(),ContactDetail.class);
                    //sending contact object through intent
                    //contact object is serialized
                    i.putExtra("contact", contact);
                    startActivity(i);

                break;
        }
    }
}
