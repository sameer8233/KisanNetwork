package com.kisannetwork.views.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kisannetwork.R;
import com.kisannetwork.adapters.ContactListDbRecyclerAdapter;
import com.kisannetwork.adapters.ContactRecyclerAdapter;
import com.kisannetwork.database.config.DatabaseHandler;
import com.kisannetwork.modal.pojo.DbContactPojo;
import com.kisannetwork.presenter.ContactListPresenter;
import com.kisannetwork.presenter.MessageSentPresenter;
import com.kisannetwork.utils.Dialogs;

import java.util.List;

/**
 * Created by Admin on 23-09-2016.
 */
public class MessageSentFragment extends Fragment{

    private View view;
    private RecyclerView recyclerView;
    private ContactListDbRecyclerAdapter contactListDbRecyclerAdapter;
    private static MessageSentPresenter messageSentPresenter;

    public static MessageSentFragment newInstance() {

        return new MessageSentFragment();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactListDbRecyclerAdapter = new ContactListDbRecyclerAdapter(this);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.messagesent_fragment, container, false);

        init();



        if (messageSentPresenter == null) {
            //requesting data from presenter.
            messageSentPresenter = new MessageSentPresenter();
            messageSentPresenter.requestData(this);

        } else {
            // in case of screen is rotation this method called.
            // getting data from presenter.
            // NO API HIT TO SERVER AGAIN.
            messageSentPresenter.publish(this);

        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!(getActivity()).isChangingConfigurations()) {
            messageSentPresenter = null;
        }
    }

    public void callme()
    {
        messageSentPresenter.requestData(this);
    }

    public void init(){
        recyclerView=(RecyclerView)view.findViewById(R.id.contact_list_recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(contactListDbRecyclerAdapter);
    }


    public void setData(List<DbContactPojo> list)
    {
        if (list.size()>0)
        {
            contactListDbRecyclerAdapter.setData(list);

        }else {
            Dialogs.showMessage(this.getActivity(),"No Messages sent.");
        }

    }



}
