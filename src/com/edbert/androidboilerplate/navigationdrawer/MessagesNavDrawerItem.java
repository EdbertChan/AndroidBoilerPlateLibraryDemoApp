package com.edbert.androidboilerplate.navigationdrawer;


import com.edbert.androidboilerplate.core.DetailFragment;
import com.edbert.androidboilerplate.core.MessagesFragment;
import com.edbert.library.navigationdrawer.NavDrawerItem;

import android.support.v4.app.Fragment;

public class MessagesNavDrawerItem extends NavDrawerItem {
private static final String TITLE = "Messages";
	public MessagesNavDrawerItem(int icon, boolean isCounterVisible, int count) {
		super(TITLE, icon, isCounterVisible, count);
		
	}

	public MessagesNavDrawerItem(String title, int icon) {
		super(title, icon);
	}
	public MessagesNavDrawerItem(String title) {
		super(title);
	}
	public MessagesNavDrawerItem() {
		super(TITLE);
	}
	@Override
	public Fragment getFragment() {
		return new MessagesFragment();
	}


	@Override
	public Type getNavDrawerType() {
		return Type.ITEM_TYPE;
	}


}