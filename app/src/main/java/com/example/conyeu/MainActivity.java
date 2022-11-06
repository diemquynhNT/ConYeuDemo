package com.example.conyeu;

import androidx.annotation.NonNull;
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
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //navigation_menu
    private DrawerLayout mDrawerLayout;
    ImageButton btnnotification;
    Button btncamnang,btnnhatki,btncanhan,btnlich;
    private static final int FRAGMENT_HOME=0;
    private static final int FRAGMENT_CANHAN=1;
//    private static final int FRAGMENT_THONGBAO=2;
//    private static final int FRAGMENT_CAMNANG=3;
//    private static final int ACTIVITY_CAMNANG=3;
//    private static final int FRAGMENT_NHATKI=4;
//    private static final int ACTIVITY_LICH=5;
//    private static final int FRAGMENT_MAIL=6;
//    private static final int FRAGMENT_DIEUKHOAN=7;
    private static final int ACTIVITY_LOGOUT=8;


    private int mCurrentFragment=FRAGMENT_HOME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //navigation_menu

        //bo ten co0n cung

        Toolbar toolbar=findViewById(R.id.toolbar);

        mDrawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        //tao icon
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //event khi click vao item navigation view vd ca nhan
        NavigationView navView=findViewById(R.id.navigation_view);
        navView.setNavigationItemSelectedListener(this);
        //XU LY KHI CLICK VAO ITEM THI CHO RA LAYOUT TUONG UNG
        replaceFragment(new Home_Fragment());
//        navView.getMenu().findItem(R.id.nav_camnang).setCheckable(true);
//        navView.getMenu().findItem(R.id.nav_nhaki).setCheckable(true);
//        navView.getMenu().findItem(R.id.nav_lich).setCheckable(true);
//        navView.getMenu().findItem(R.id.nav_sendmail).setCheckable(true);
//        navView.getMenu().findItem(R.id.nav_dieukhoan).setCheckable(true);





    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.nav_home){
            if (mCurrentFragment!=FRAGMENT_HOME){
                replaceFragment(new Home_Fragment());
                mCurrentFragment=FRAGMENT_HOME;

            }

        }else if (id==R.id.nav_canhan)
        {
            if (mCurrentFragment!=FRAGMENT_CANHAN){
                replaceFragment(new canhan_Fragment());
                mCurrentFragment=FRAGMENT_CANHAN;
            }
        }

        else if (id==R.id.nav_logout)
        {
            if (mCurrentFragment!=ACTIVITY_LOGOUT){
                Intent intent= new Intent(MainActivity.this,Login_Activity.class);
                startActivity(intent);

            }
        }

        mDrawerLayout.closeDrawer(GravityCompat.START); //dong drawer

        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }


}
