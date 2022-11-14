package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.conyeu.fragment_nav.Home_Fragment;
import com.example.conyeu.fragment_nav.canhan_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {

    //navigation_menu
    private DrawerLayout mDrawerLayout;
    ImageButton btnnotification;
    Button btncamnang,btnnhatki,btncanhan,btnlich;
    private static final int FRAGMENT_HOME=0;
    private static final int ACTIVITY_BABY=1;



    private int mCurrentFragment=FRAGMENT_HOME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //event khi click vao item navigation view vd ca nhan
        BottomNavigationView navView=findViewById(R.id.nav_bottom);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.action_home){
                    if (mCurrentFragment!=FRAGMENT_HOME){
                        replaceFragment(new Home_Fragment());
                        mCurrentFragment=FRAGMENT_HOME;

                    }

                }else if (id==R.id.action_baby)
                {
                    if (mCurrentFragment!=ACTIVITY_BABY){
                        replaceFragment(new canhan_Fragment());

                        mCurrentFragment=ACTIVITY_BABY;
                    }
                }


                return true;
            }
        });
        //XU LY KHI CLICK VAO ITEM THI CHO RA LAYOUT TUONG UNG
        replaceFragment(new Home_Fragment());






    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        int id=item.getItemId();
//        if(id==R.id.action_home){
//            if (mCurrentFragment!=FRAGMENT_HOME){
//                replaceFragment(new Home_Fragment());
//                mCurrentFragment=FRAGMENT_HOME;
//
//            }
//
//        }else if (id==R.id.action_baby)
//        {
//            if (mCurrentFragment!=ACTIVITY_BABY){
////                replaceFragment(new canhan_Fragment());
//
//
//                mCurrentFragment=ACTIVITY_BABY;
//            }
//        }
//
//
//        return true;
//    }



    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }


}
