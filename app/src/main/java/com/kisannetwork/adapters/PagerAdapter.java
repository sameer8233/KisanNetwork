package com.kisannetwork.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.kisannetwork.utils.Constants;
import com.kisannetwork.views.fragment.ContactListFragment;
import com.kisannetwork.views.fragment.MessageSentFragment;

/**
 * Created by Admin on 23-09-2016.
 */

public class PagerAdapter extends FragmentPagerAdapter
{

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ContactListFragment.newInstance();
            case 1:
                return MessageSentFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return Constants.TOTAL_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return Constants.FIRST_TAB;
            case 1:
                return Constants.SECOND_TAB;
            default:
                return null;
        }
    }
}
