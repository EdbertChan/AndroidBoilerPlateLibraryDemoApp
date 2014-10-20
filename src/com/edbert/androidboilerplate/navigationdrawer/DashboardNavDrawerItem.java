package com.edbert.androidboilerplate.navigationdrawer;


import com.edbert.androidboilerplate.core.DetailFragment;
import com.edbert.library.navigationdrawer.NavDrawerItem;

import android.support.v4.app.Fragment;

public class DashboardNavDrawerItem extends NavDrawerItem {
private static final String TITLE = "Dashboard";
	public DashboardNavDrawerItem(int icon, boolean isCounterVisible, int count) {
		super(TITLE, icon, isCounterVisible, count);
		
	}

	public DashboardNavDrawerItem(String title, int icon) {
		super(title, icon);
	}
	public DashboardNavDrawerItem(String title) {
		super(title);
	}
	public DashboardNavDrawerItem() {
		super(TITLE);
	}
	@Override
	public Fragment getFragment() {
		return new DetailFragment();
	}

	@Override
	public Type getNavDrawerType() {
		return Type.ITEM_TYPE;
	}


}