package com.example.tab_l2_q3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class TabAdapter extends FragmentStateAdapter {

    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new fragment1();
            case 1: return new fragment2();
            case 2: return new fragment3();
        }

        return new fragment1();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
