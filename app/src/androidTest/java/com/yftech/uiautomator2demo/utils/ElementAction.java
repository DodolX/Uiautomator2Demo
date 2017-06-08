package com.yftech.uiautomator2demo.utils;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * 模拟用户操作
 * Created by 薛东磊 on 2017/6/4.
 */

public class ElementAction {
    private static String TAG = "ElementAction";

    public static void clickByText(UiObject object, String text) {
        object = new UiObject(new UiSelector().text(text));
        if (!object.exists()) {
            Log.e(TAG, "clickByText: object not find");
            Logger.e("object not find" + text);
        } else {
            try {
                object.clickAndWaitForNewWindow();
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
                Logger.e("object not find" + text);
            }
        }
    }


    public static void clickElement(Object object) {
        if (object == null) {
            Logger.e("object is null");
        } else {
            if (object instanceof UiObject) {
                try {
                    ((UiObject) object).click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                    Logger.e(e.getMessage() + "\nobject not find:" + object.toString());
                }
            }
        }
    }
}
