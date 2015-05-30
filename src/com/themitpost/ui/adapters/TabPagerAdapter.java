package com.themitpost.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.themitpost.ui.frags.CampusFragment;
import com.themitpost.ui.frags.HomeFragment;
import com.themitpost.ui.frags.NationalFragment;
import com.themitpost.ui.frags.WorldFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {

		Fragment fragment = null;
		switch (i) {
		case 0:
			fragment = new HomeFragment();
			break;
		case 1:

			fragment = new CampusFragment();
			break;
		case 2:
			fragment = new NationalFragment();
			break;
		case 3:
			fragment = new WorldFragment();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public CharSequence getPageTitle(int i) {
		switch (i) {
		case 0:
			return "Home";
		case 1:
			return "Campus";
		case 2:
			return "National";
		case 3:
			return "World";
		default:
			return "";
		}
	}
}