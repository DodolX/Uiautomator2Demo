package com.yftech.uiautomator2demo;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by 80736 on 2017/5/28.
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest2 {
    private UiDevice mDevice;
    private Context mContext;
    private String APP_PACKAGE_NAME = "com.android.calculator2";

    @Before
    public void setUp() throws RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mContext = InstrumentationRegistry.getContext();
        if (!mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }

        mDevice.pressHome();
    }

    @Test
    public void testDemo() {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(APP_PACKAGE_NAME);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //这一行可以不添加，如果添加，每次启动app时候会清空当前数据。
        mContext.startActivity(intent);

        mDevice.waitForWindowUpdate(APP_PACKAGE_NAME, 5000);
        UiObject button1 = mDevice.findObject(new UiSelector().text("1"));
        UiObject sum = mDevice.findObject(new UiSelector().text("+"));
        UiObject button100 = mDevice.findObject(new UiSelector().text("9"));
        UiObject equalsBtn = mDevice.findObject(new UiSelector().text("="));

        try {
            button1.click();
            sum.click();
            button100.click();
            equalsBtn.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

}
