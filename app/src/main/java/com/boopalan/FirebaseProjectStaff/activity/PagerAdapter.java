package com.boopalan.FirebaseProjectStaff.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.boopalan.FirebaseProjectStaff.staffDetail;
import com.boopalan.FirebaseProjectStaff.staffDetail4;
import com.boopalan.FirebaseProjectStaff.staffDetail2;
import com.boopalan.FirebaseProjectStaff.staffDetail3;

/**
 * Created by Boopalan on 01-Feb-2017.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                staffDetail tab1 = new staffDetail();
                return tab1;
            case 1:
                staffDetail4 tab2 = new staffDetail4();
                return tab2;
            case 2:
                staffDetail2 tab3 = new staffDetail2();
                return tab3;
            case 3:
                staffDetail3 tab4 = new staffDetail3();
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}