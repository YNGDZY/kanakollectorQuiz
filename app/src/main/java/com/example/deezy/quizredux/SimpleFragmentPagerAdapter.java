package com.example.deezy.quizredux;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.deezy.quizredux.KatakanaFragment;
import com.example.deezy.quizredux.KanaguideFragment;
import com.example.deezy.quizredux.HiriganaFragment;
import com.example.deezy.quizredux.R;


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new KanaguideFragment();
        } else if (position == 1) {
            return new HiriganaFragment();
        } else{
            return new KatakanaFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.Kanaguide_Title);
        } else if (position == 1) {
            return mContext.getString(R.string.Hirigana_Title);
        } else  {
            return mContext.getString(R.string.Katakana_Title);

        }
    }
}