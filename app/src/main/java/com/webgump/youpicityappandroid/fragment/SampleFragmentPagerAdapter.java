package com.webgump.youpicityappandroid.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;
import com.webgump.youpicityappandroid.account.PageFragment;
import com.webgump.youpicityappandroid.home.HomeFragment;
import com.webgump.youpicityappandroid.R;

/**
 * Created by grim on 05/09/2017.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 4;
    private int tabIcons[] = {R.drawable.ic_parcours2, R.drawable.ic_marker, R.drawable.ic_flag, R.drawable.ic_calendar};

    public SampleFragmentPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public int getCount() {

        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }


}