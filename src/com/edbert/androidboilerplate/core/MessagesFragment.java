package com.edbert.androidboilerplate.core;

import swipe.android.nearlings.R;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edbert.androidboilerplate.DatabaseHelpers.MessagesDatabaseHelper;
import com.edbert.androidboilerplate.MessagesSync.MessagesRequest;
import com.edbert.androidboilerplate.viewAdapters.MessagesViewAdapter;
import com.edbert.library.swipeToRefresh.SwipeToRefreshFragment;

public class MessagesFragment extends BoilerPlateSwipeToRefreshFragment {
	ListView lView;
	String MESSAGES_START_FLAG = MessagesFragment.class.getCanonicalName()
			+ "_MESSAGES_START_FLAG";
	String MESSAGES_FINISH_FLAG = MessagesFragment.class.getCanonicalName()
			+ "_MESSAGES_FINISH_FLAG";

	@Override
	public CursorLoader generateCursorLoader() {
		CursorLoader cursorLoader = new CursorLoader(this.getActivity(),
				BoilerPlateContentProvider.contentURIbyTableName(MessagesDatabaseHelper.TABLE_NAME),
				MessagesDatabaseHelper.COLUMNS, null, null,
				MessagesDatabaseHelper.COLUMN_DATE + " DESC");

		return cursorLoader;
	
	}

	@Override
	public void reloadData() {
		getLoaderManager().initLoader(0, null, this);

		Cursor c = generateCursor();

		this.mAdapter = new MessagesViewAdapter(this.getActivity(), c);

		mAdapter.notifyDataSetChanged();
		lView.setAdapter(mAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.pull_to_refresh_single_list,
				container, false);

		swipeView = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe);
		swipeView.setColorScheme(android.R.color.holo_blue_dark,
				android.R.color.holo_blue_light,
				android.R.color.holo_green_light,
				android.R.color.holo_green_light);
		lView = (ListView) rootView.findViewById(R.id.list);

		swipeView.setOnRefreshListener(this);
		lView.setOnItemClickListener(this);
		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public String syncStartedFlag() {
		return MESSAGES_START_FLAG;
	}

	@Override
	public String syncFinishedFlag() {
		return MESSAGES_FINISH_FLAG;
	}

	@Override
	public void setSourceRequestHelper() {
		super.helper = new MessagesRequest();
	}
	@Override
	public void onResume(){
		super.onResume();
		reloadData();
	}

}