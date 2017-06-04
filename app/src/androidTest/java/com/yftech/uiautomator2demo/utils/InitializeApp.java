package com.yftech.uiautomator2demo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 初始化并打开待测试app
 * Created by 薛东磊 on 2017/6/4.
 */

public class InitializeApp {
    private static final String APP_PACKAGE_NAME = "com.yf.smart.lenovogo";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String TAG = "UiAutomator";
    private static UiDevice mDevice;

    @BeforeClass
    public static void startMainActivityFromHomeScreen() throws RemoteException {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (!mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        // no need this code
//        final String launcherPackage = mDevice.getLauncherPackageName();
//        Log.d(TAG, "startMainActivityFromHomeScreen: launcherPackageName" + launcherPackage);
//        assertThat(launcherPackage, notNullValue());
//        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
//                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(APP_PACKAGE_NAME);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(APP_PACKAGE_NAME).depth(0)), LAUNCH_TIMEOUT);
        mDevice.waitForWindowUpdate(APP_PACKAGE_NAME, 5000);
    }
}
