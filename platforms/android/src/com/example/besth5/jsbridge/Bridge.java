package com.example.besth5.jsbridge;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by james-wei on 2016/5/5.
 */
public class Bridge extends CordovaPlugin {
    private static final String TAG = " ----- JSBridge ----- ";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        boolean isSuccess = true;
        if (action.equals("getdevicestatus")) {
            this.getDeviceStatus(callbackContext);
        } else {
            try {
                callbackContext.error(new JSONObject().put("result", "do not support this req."));
            } catch (org.json.JSONException ex) {
                Log.e(TAG, ex.toString());
            }
            isSuccess = false;
        }
        return isSuccess;
    }

    private void getDeviceStatus(CallbackContext callbackContext) {
        JSONObject obj = new JSONObject();
//        try {
//            obj.put("level", batteryIntent.getIntExtra(android.os.BatteryManager.EXTRA_LEVEL, 0));
//            obj.put("isPlugged", batteryIntent.getIntExtra(android.os.BatteryManager.EXTRA_PLUGGED, -1) > 0 ? true : false);
//        } catch (JSONException e) {
//            Log.e(TAG, e.getMessage(), e);
//        }
        callbackContext.success(obj);
    }
}
