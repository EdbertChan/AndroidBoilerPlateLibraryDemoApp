package swipe.android.nearlings.viewAdapters;

import swipe.android.nearlings.R;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessagesViewAdapter extends CursorAdapter {

	private Context mContext;

	private Cursor cr;
	private final LayoutInflater inflater;

	public MessagesViewAdapter(Context context, Cursor c) {
		super(context, c);

		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
		this.cr = c;
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {

		ViewHolder holder = new ViewHolder();
		View view = inflater.inflate(R.layout.messages_item, parent, false);

		holder.dateSent = (TextView) view.findViewById(R.id.message_date);
		holder.sender = (TextView) view.findViewById(R.id.message_sender);
		holder.unread_icon = (ImageView) view.findViewById(R.id.message_unread_icon);

		holder.message = (TextView) view.findViewById(R.id.message_message);

		view.setTag(holder);
		return view;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {

		final ViewHolder holder = (ViewHolder) view.getTag();

		/*
		 * int sender_index = cursor
		 * .getColumnIndexOrThrow(BroadcastDBHelper.COLUMN_AUTHOR); int
		 * time_index = cursor
		 * .getColumnIndexOrThrow(BroadcastDBHelper.COLUMN_SENT); int
		 * message_index = cursor
		 * .getColumnIndexOrThrow(BroadcastDBHelper.COLUMN_MESSAGE);
		 * 
		 * int read_index = cursor
		 * .getColumnIndexOrThrow(BroadcastDBHelper.COLUMN_READ);
		 * 
		 * holder.sender.setText(cursor.getString(sender_index));
		 * 
		 * // problem is processing. this should only happen once.
		 * 
		 * holder.timeStamp.setText(cursor.getString(time_index));
		 * 
		 * holder.message.setText(cursor.getString(message_index));
		 * 
		 * boolean unreadBroadcast =
		 * Boolean.valueOf(cursor.getString(read_index)); if (unreadBroadcast) {
		 * holder.unreadMarker.setVisibility(View.VISIBLE); } else {
		 * holder.unreadMarker.setVisibility(View.GONE); }
		 */

	}

	public static class ViewHolder {
		public TextView dateSent;
		public TextView sender;
		public ImageView unread_icon;

		public TextView message;
	}

}