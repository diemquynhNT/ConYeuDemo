package com.example.conyeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.conyeu.menutab_camnang.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class camnang_Activity extends AppCompatActivity {

    TabLayout menutab;
    ViewPager menuViewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camnang);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nav_camnang);

        menutab=findViewById(R.id.tabmenu);
        menuViewpager=findViewById(R.id.view_papercamnang);

        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        menuViewpager.setAdapter(viewPageAdapter);
        menutab.setupWithViewPager(menuViewpager);


        
    }
        @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}