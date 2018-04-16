package com.adobe.phonegap.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.android.gms.iid.InstanceIDListenerService;

public class PushInstanceIDListenerService extends InstanceIDListenerService implements PushConstants {
    public static final String LOG_TAG = "Push_InstanceIDListener";

    @Override
    public void onTokenRefresh() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(COM_ADOBE_PHONEGAP_PUSH, Context.MODE_PRIVATE);
        String senderID = sharedPref.getString(SENDER_ID, "");
        if (!"".equals(senderID)) {
            Intent intent = new Intent(this, RegistrationIntentService.class);
                startService(intent);

        }
    }
}
