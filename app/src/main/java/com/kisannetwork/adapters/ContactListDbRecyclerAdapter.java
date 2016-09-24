package com.kisannetwork.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kisannetwork.R;
import com.kisannetwork.modal.pojo.ContactPojo;
import com.kisannetwork.modal.pojo.DbContactPojo;
import com.kisannetwork.presenter.ContactListPresenter;
import com.kisannetwork.views.fragment.ContactListFragment;
import com.kisannetwork.views.fragment.MessageSentFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 23-09-2016.
 */
public class ContactListDbRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DbContactPojo> contact_list = new ArrayList<>();
    private MessageSentFragment context;

    public ContactListDbRecyclerAdapter(MessageSentFragment context)
    {
        this.context=context;
    }

    public void setData(List<DbContactPojo> list) {
        contact_list = list;
        Collections.reverse(contact_list);
        notifyDataSetChanged();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView contact_name,status,otp;

        public TextViewHolder(View itemView) {
            super(itemView);
            contact_name = (TextView) itemView.findViewById(R.id.contact_name);
            status = (TextView) itemView.findViewById(R.id.status);
            otp = (TextView) itemView.findViewById(R.id.otp);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactlist_db_recyclerview, parent, false);

        viewHolder = new TextViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((TextViewHolder) holder).contact_name.setText(contact_list.get(position).getContact_name());
        ((TextViewHolder) holder).otp.setText(contact_list.get(position).getOtp());
        ((TextViewHolder) holder).status.setText(contact_list.get(position).getMessage_status());


    }

    @Override
    public int getItemCount() {
        return contact_list.size();
    }
}
