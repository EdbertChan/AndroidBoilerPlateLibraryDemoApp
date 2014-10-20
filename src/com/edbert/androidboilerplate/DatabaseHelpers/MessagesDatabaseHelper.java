package com.edbert.androidboilerplate.DatabaseHelpers;

import com.edbert.library.database.DatabaseHelperInterface;

public class MessagesDatabaseHelper implements DatabaseHelperInterface {

	public static final String AUTHORITY = "";

	public static final String TABLE_NAME = "messages";

	public static final String COLUMN_ID = "_id";

	public static final String COLUMN_UNREAD = "unread";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_AUTHOR = "author";
	public static final String COLUMN_MESSAGE = "message";

	public static final String COLUMN_TRIGGERED_ON_FORMATTED = "FORMATTED";

	public static final String[] COLUMNS = { COLUMN_ID, COLUMN_UNREAD,
			COLUMN_DATE, COLUMN_AUTHOR, COLUMN_MESSAGE,
			COLUMN_TRIGGERED_ON_FORMATTED };

	public static final String TABLE_CREATE_ROUTES = "CREATE TABLE "
			+ TABLE_NAME + "(" + COLUMN_ID + " TEXT NOT NULL primary key, "
			+ COLUMN_UNREAD + " TEXT NOT NULL, " + COLUMN_AUTHOR
			+ " TEXT NOT NULL, " + COLUMN_DATE + " TEXT NOT NULL, "
			+ COLUMN_MESSAGE + " TEXT NOT NULL, "
			+ COLUMN_TRIGGERED_ON_FORMATTED  + " TEXT NOT NULL);";

	

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getColumnID() {
		return COLUMN_ID;
	}

	@Override
	public String getCreateTableCommand() {
		return TABLE_CREATE_ROUTES;
	}

	@Override
	public String[] getColumns() {
		return COLUMNS;
	}
}
