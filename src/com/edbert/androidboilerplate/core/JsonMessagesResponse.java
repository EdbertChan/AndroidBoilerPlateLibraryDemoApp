package com.edbert.androidboilerplate.core;

import com.edbert.library.network.sync.JsonResponseInterface;

public class JsonMessagesResponse implements JsonResponseInterface{

	@Override
	public boolean isValid() {
		return true;
	}
	
}