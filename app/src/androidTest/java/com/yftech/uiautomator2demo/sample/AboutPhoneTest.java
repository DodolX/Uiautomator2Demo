package com.yftech.uiautomator2demo.sample;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.content.ContentValues.TAG;

/**
 * 关于手机功能测试，使用自动滑动功能
 * Created by 80736 on 2017/5/29.
 */
@RunWith(AndroidJUnit4.class)
public class AboutPhoneTest {
    public UiDevice mDevice;

    @Rule
    public ReportTest reportTest = new ReportTest(mDevice);


    @Before
    public void setUp() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void aboutPhone() throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject apps = new UiObject(new UiSelector().description("Apps"));
        apps.clickAndWaitForNewWindow();




        UiObject settings = mDevice.findObject(new UiSelector().text("Settings"));
        if (settings.exists()) {
            settings.click();
        } else {
            UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));
            scrollable.setAsHorizontalList();

            UiObject setting = scrollable.getChildByText(new UiSelector().text("Settings"), "Settings");
            settings.clickAndWaitForNewWindow();
        }


        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));
        UiObject aboutPhone = scrollable.getChildByText(new UiSelector().text("About phone"), "About phone");
        String tex = aboutPhone.getText();
        Log.e(TAG, "aboutPhone: " + tex);
        aboutPhone.clickAndWaitForNewWindow();

        int x = scrollable.getChildCount();
        UiObject version = scrollable.getChildByText(new UiSelector().className("android.widget.LinearLayout"), "Build number", true);
        Log.e(TAG, "aboutPhone: " + x);
        int y = version.getChildCount();
        Log.d(TAG, "aboutPhone: "+version.getText());
        Log.d(TAG, "aboutPhone: "+ y);


    }



}
