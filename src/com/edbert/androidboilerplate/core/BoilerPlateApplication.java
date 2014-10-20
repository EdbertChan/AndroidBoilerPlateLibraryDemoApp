package com.edbert.androidboilerplate.core;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.StrictMode;
import android.provider.SyncStateContract.Constants;

import com.edbert.androidboilerplate.DatabaseHelpers.MessagesDatabaseHelper;
import com.edbert.androidboilerplate.DatabaseHelpers.NeedsDetailsDatabaseHelper;
import com.edbert.androidboilerplate.MessagesSync.MessagesRequest;
import com.edbert.androidboilerplate.MessagesSync.NearlingsSyncHelper;
import com.edbert.androidboilerplate.MessagesSync.NeedsDetailsRequest;
import com.edbert.library.database.DatabaseCommandManager;
import com.edbert.library.sendRequest.SendRequestStrategyManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class BoilerPlateApplication extends Application {

	NearlingsSyncHelper helper;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	public void onCreate() {
		super.onCreate();
		helper = new NearlingsSyncHelper(this);
		initImageLoader(getApplicationContext());
		registerDatabaseTables();
	//	Context c = this;
		DatabaseCommandManager.createAllTables(BoilerPlateContentProvider
				.getDBHelperInstance(this).getWritableDatabase());
		
		SendRequestStrategyManager.register(new MessagesRequest());
		SendRequestStrategyManager.register(new NeedsDetailsRequest());
		
	}

	private void registerDatabaseTables(){
		DatabaseCommandManager.register(new MessagesDatabaseHelper());
		DatabaseCommandManager.register(new NeedsDetailsDatabaseHelper());
	}
	public static void initImageLoader(Context context) {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(50 * 1024 * 1024)
				// 50 Mb
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove for release app
				.build();
		ImageLoader.getInstance().init(config);
	}
	
	public static DisplayImageOptions getDefaultOptions(){
	return new DisplayImageOptions.Builder()
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
	}
	public NearlingsSyncHelper getSyncHelper(){
		return helper;
	}
}