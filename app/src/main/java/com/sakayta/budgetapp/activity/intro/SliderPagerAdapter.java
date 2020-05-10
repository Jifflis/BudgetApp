package com.sakayta.budgetapp.activity.intro;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class SliderPagerAdapter extends FragmentPagerAdapter {

  List<Fragment> fragments;

  public SliderPagerAdapter(
          List<Fragment> fragments,
          @NonNull FragmentManager fm,
          int behavior
  ) {
    super(fm, behavior);
    this.fragments = fragments;
  }

  @NonNull @Override public Fragment getItem(int position) {
    return fragments.get(position);
  }


  @Override public int getCount() {
    return fragments.size();
  }

}