package com.kisannetwork.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kisannetwork.R;
import com.kisannetwork.modal.pojo.ContactPojo;
import com.kisannetwork.presenter.ContactListPresenter;
import com.kisannetwork.views.fragment.ContactListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 23-09-2016.
 */
public class ContactRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ContactPojo> contact_list = new ArrayList<>();
    private ContactListFragment context;

    public ContactRecyclerAdapter(ContactListFragment context)
    {
        this.context=context;
    }

    public void setData(List<ContactPojo> list) {
        contact_list = list;
        notifyDataSetChanged();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView contact_name;

        public TextViewHolder(View itemView) {
            super(itemView);
            contact_name = (TextView) itemView.findViewById(R.id.contact_name);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactlist_layout_recycler, parent, false);

        viewHolder = new TextViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TextViewHolder) holder).contact_name.setText(contact_list.get(position).first_name + " " + contact_list.get(position).getLast_name());
        ((TextViewHolder) holder).contact_name.setOnClickListener(context);
        ((TextViewHolder) holder).contact_name.setTag(contact_list.get(position));
    }

    @Override
    public int getItemCount() {
        return contact_list.size();
    }
}
