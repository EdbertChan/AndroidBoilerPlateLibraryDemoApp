package com.edbert.androidboilerplate.MessagesSync;

import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import com.edbert.androidboilerplate.DatabaseHelpers.MessagesDatabaseHelper;
import com.edbert.androidboilerplate.core.BoilerPlateContentProvider;
import com.edbert.androidboilerplate.core.BoilerPlateRequest;
import com.edbert.library.network.sync.JsonResponseInterface;

public class MessagesRequest extends BoilerPlateRequest {

	@Override
	public JsonResponseInterface makeRequest(Bundle b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getJSONclass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeToDatabase(Context c, Object o) {
		// for now we will write random dummy stuff to the database
	
		ContentValues cv = new ContentValues();

		cv.put(MessagesDatabaseHelper.COLUMN_AUTHOR, "Author");
		cv.put(MessagesDatabaseHelper.COLUMN_DATE, System.currentTimeMillis());
		cv.put(MessagesDatabaseHelper.COLUMN_ID, System.currentTimeMillis());
		cv.put(MessagesDatabaseHelper.COLUMN_MESSAGE, "Message " + counter);

		cv.put(MessagesDatabaseHelper.COLUMN_UNREAD, "true");

		cv.put(MessagesDatabaseHelper.COLUMN_TRIGGERED_ON_FORMATTED,
				"Formatted time");

		c.getContentResolver()
				.insert(BoilerPlateContentProvider
						.contentURIbyTableName(MessagesDatabaseHelper.TABLE_NAME),
						cv);

		counter++;
		return false;
	}

	// for testing purposes
	public static int counter = 0;
}