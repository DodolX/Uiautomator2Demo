package com.yftech.uiautomator2demo;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

/**
 * Created by 80736 on 2017/5/28.
 */

public class UideviceTest {
    private UiDevice mDevice;

    @Test
    public void testDevice() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        mDevice.pressHome();

        UiObject2 uiObject2 = mDevice.findObject(By.desc("Apps"));
        uiObject2.click();



    }
}
