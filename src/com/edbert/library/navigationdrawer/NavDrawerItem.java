package com.edbert.library.navigationdrawer;



import java.util.ArrayList;

import com.edbert.library.navigationdrawer.NavDrawerItemInterface.Type;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

public abstract class NavDrawerItem implements NavDrawerItemInterface {
	protected Type TYPE;
	private String title;
	private int icon;
	private int count = 0;
	// boolean to set visiblity of the counter
	private boolean isCounterVisible = false;
	private String svgImage;

	private String actionBarTitle;

	public void setActionBarTitle(String actionBarTitle) {
		this.actionBarTitle = actionBarTitle;
	}

	public String getActionBarTitle() {
		return actionBarTitle;
	}

	public NavDrawerItem(String title, int icon) {
		this.title = title;
		this.icon = icon;
	}

	public NavDrawerItem(String title, String svgImage) {
		this.title = title;
		this.svgImage = svgImage;
	}

	public String getsvgImage() {
		return svgImage;
	}

	public void setsvgImage(String svgImage) {
		this.svgImage = svgImage;
	}

	public NavDrawerItem(String title, int icon, boolean isCounterVisible,
			int count) {
		this.title = title;
		this.icon = icon;
		this.isCounterVisible = isCounterVisible;
		this.count = count;
	}

	public String getTitle() {
		return this.title;
	}

	public int getIcon() {
		return this.icon;
	}

	public int getCount() {
		return this.count;
	}

	public boolean getCounterVisibility() {
		return this.isCounterVisible;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCounterVisibility(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}

	@Override
	public Fragment getFragment() {
		return null;
	}

	@Override
	public void launchActivity(Context c) {
		return;
	}

	@Override
	public boolean updateActionBarTitle() {
		return true;
	}
	
	public abstract Type navDrawerType();

}