package com.example.conyeu.menutab_camnang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new chuacocon_Fragment();
            case 1:
                return new dangmangthai_Fragment();
            case 3:
                return new nuoicon_Fragment();

            default: return new nuoicon_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="Chưa có con";
                break;
            case 1:
                title="Đang mang thai";
                break;
            case 2:
                title="Nuôi con";
                break;

        }

        return title;
    }
}


