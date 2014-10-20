package com.edbert.androidboilerplate.core;

import android.os.Bundle;
import android.util.Log;

import com.edbert.androidboilerplate.sync.NearlingsSyncAdapter;
import com.edbert.library.sendRequest.SendRequestInterface;
import com.edbert.library.sendRequest.SendRequestStrategyManager;
import com.edbert.library.swipeToRefresh.SwipeToRefreshFragment;

public abstract class BoilerPlateSwipeToRefreshFragment extends
		SwipeToRefreshFragment {

	// we use sourcehelpers
	protected SendRequestInterface helper;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSourceRequestHelper();
	}
	@Override
	public void requestSync() {
	Log.e("NearlingsSwipeFragment", "Sync requested without bundle");
		((BoilerPlateApplication) getActivity().getApplication()).getSyncHelper()
				.performSync();
	}

	@Override
	public void onRefresh() {
		String TAG = NearlingsSyncAdapter.HELPER_FLAG_ID;
		Bundle b = new Bundle();
		b.putString(TAG, SendRequestStrategyManager.generateTag(helper));
		requestSync(b);
	}
	
	public void requestSync(Bundle b) {
		//need to add the flags
		Log.e("NearlingsSwipeFragment", "Sync requested with bundle");
		b.putString(NearlingsSyncAdapter.SYNC_STARTED_FLAG_ID, syncStartedFlag());
		b.putString(NearlingsSyncAdapter.SYNC_FINISHED_FLAG_ID, syncFinishedFlag());
		
		((BoilerPlateApplication) getActivity().getApplication()).getSyncHelper()
				.performSync(b);
	}

	@Override
	public boolean isSyncing() {
		return ((BoilerPlateApplication) getActivity().getApplication())
				.getSyncHelper().isSyncing();
	}
	public SendRequestInterface getHelper(){
		return helper;
	}
	public abstract void setSourceRequestHelper();

}