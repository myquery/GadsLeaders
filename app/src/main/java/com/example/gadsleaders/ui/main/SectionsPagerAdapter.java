package com.example.gadsleaders.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaders.GadsLeader;
import com.example.gadsleaders.LearningLeader;
import com.example.gadsleaders.R;
import com.example.gadsleaders.SkillIQLeaders;
import com.example.gadsleaders.SkillLeader;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public List<GadsLeader> gadsLeaders_list = new ArrayList<>();

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.leader_board, R.string.skill_board};
    private final Context mContext;
    private List<GadsLeader> learningLeader;
    private List<SkillLeader> skillLeaders;

    public SectionsPagerAdapter(Context context, FragmentManager fm, List<GadsLeader> learningLeader, List<SkillLeader> skillLeaders) {
        super(fm);
        mContext = context;
        this.learningLeader = learningLeader;
        this.skillLeaders = skillLeaders;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
        switch (position) {
            case 0:
                fragment = new LearningLeader();
                break;

            case 1:
                fragment = new SkillIQLeaders();
                break;

            default:

        }
        return fragment;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}