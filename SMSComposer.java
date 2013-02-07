/**
 * 
 * Phonegap SMS composer plugin for Android with multiple attachments handling
 * 
 * Version 1.0
 * 
 * Edit from EmailComposer Guido Sabatini 2012
 *
 */

package com.wishbonemedia.jimsbookingDev;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;

public class SMSComposer extends CordovaPlugin {

  @Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("showSMSComposer".equals(action)) {
			
			try {
				JSONObject parameters = args.getJSONObject(0);
				if (parameters != null) {
					sendSMS(parameters);
				}
			} catch (Exception e) {

			}
			callbackContext.success();
			return true;
		}
		return false;  // Returning false results in a "MethodNotFound" error.
	}

	private void sendSMS(JSONObject parameters) {
		
		final Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
		
		//String callback = parameters.getString("callback");

		smsIntent.setType("vnd.android-dir/mms-sms"); 

		// setting body
		try {
			String body = parameters.getString("body");
			if (body != null && body.length() > 0) {
					smsIntent.putExtra("sms_body", body);
			}
		} catch (Exception e) {
			LOG.e("SMSComposer", "Error handling body param: " + e.toString());
		}

		this.cordova.startActivityForResult(this, smsIntent, 0);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO handle callback
		super.onActivityResult(requestCode, resultCode, intent);
		LOG.e("SMSComposer", "ResultCode: " + resultCode);
		// IT DOESN'T SEEM TO HANDLE RESULT CODES
	}

}
