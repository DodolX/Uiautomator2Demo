package com.yftech.uiautomator2demo.utils;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

/**
 * 模拟用户操作
 * Created by 薛东磊 on 2017/6/4.
 */

public class UserAction {
    private static String TAG = "Action";

    public static void clickByText(UiObject object,String text)  {
        object = new UiObject(new UiSelector().text(text));
        if(!object.exists()){
            Log.e(TAG, "clickByText: object not find" );
        }else {
            try {
                object.clickAndWaitForNewWindow();
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
                Log.e(TAG, "clickByText: "+ e.toString());
            }
        }
    }
}
