package com.kisannetwork.views.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.kisannetwork.R;
import com.kisannetwork.adapters.PagerAdapter;
import com.kisannetwork.utils.PrefrencesStorege;
import com.kisannetwork.views.fragment.MessageSentFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    public static int count =0;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setSupportActionBar(toolbar);

        //setting adapter for view pager and tabLayout
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    //id initialization of views
    public void init()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.container);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

    }


    /* updating message sent fragment when onresume called.
        we can do this with broadcast listner or callbacks also
        here i had done this with static variable count.
        when the activity is created first time method callme will not called.
    */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MAIN");
       broadcastReceiver=new BroadcastReceiver() {
           @Override
           public void onReceive(Context context, Intent intent) {
               MessageSentFragment messageSentFragment = (MessageSentFragment) getSupportFragmentManager().getFragments().get(1);
               messageSentFragment.callme();
           }
       };
        registerReceiver(broadcastReceiver, intentFilter);
    }
}
