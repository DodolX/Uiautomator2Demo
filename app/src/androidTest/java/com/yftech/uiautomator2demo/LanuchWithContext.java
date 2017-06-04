package com.yftech.uiautomator2demo;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.content.ContentValues.TAG;

/**
 * 通过context 启动app
 * Created by 80736 on 2017/5/29.
 */

@RunWith(AndroidJUnit4.class)
public class LanuchWithContext {

    private UiDevice mDevice;
    Context context;
    private String APP_PACKAGE_NAME = "com.android.calculator2";

    @Before
    public void setUp(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    }

    @Test
    public void test() throws UiObjectNotFoundException {
        //Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(APP_PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(APP_PACKAGE_NAME).depth(0)),5000);


        UiCollection collection = new UiCollection(new UiSelector().className("android.view.ViewGroup"));
        if (collection.exists()){
            Log.d(TAG, "test: collection is exist");
        }

        int number = collection.getChildCount(new UiSelector().className("android.widget.Button"));
        Log.d(TAG, "number is "+number);

        //点击button类型，text为1的按钮
//        UiObject btn1 = collection.getChildByText(new UiSelector().className("android.widget.Button"),"1");
//        btn1.click();

        //点击查找到的第一个button按钮
        UiObject btn2 = collection.getChild(new UiSelector().className("android.widget.Button"));
        btn2.click();

        //点击子对象内，text为0的按钮
        UiObject btn3 = collection.getChild(new UiSelector().text("0"));
        btn3.click();








    }
}
