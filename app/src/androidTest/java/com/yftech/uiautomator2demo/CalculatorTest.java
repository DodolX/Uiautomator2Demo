package com.yftech.uiautomator2demo;

/**
 * Created by 80736 on 2017/5/28.
 */

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by lihuazhang on 15/11/8.
 */

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class CalculatorTest {

    private UiDevice mDevice;
    private static final int LAUNCH_TIMEOUT = 5000;
    private final String BASIC_SAMPLE_PACKAGE = "com.android.calculator2";

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void calculatorTest() throws InterruptedException {
        mDevice.findObject(By.desc("Apps")).click();
        mDevice.wait(Until.hasObject(By.desc("Calculator")), LAUNCH_TIMEOUT);
        mDevice.findObject(By.desc("Calculator")).click();

        UiObject2 button7 = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "digit_7")), 500);
        UiObject2 buttonX = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "op_mul")), 500);
        UiObject2 button6 = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "digit_6")), 500);
        UiObject2 buttonEqual = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "eq")), 500);
        UiObject2 output = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "result")), 500);

        button7.click();
        buttonX.click();
        button6.click();
        buttonEqual.click();
        Thread.sleep(1000);
        //assertEquals(output.getText(), "42");

    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}