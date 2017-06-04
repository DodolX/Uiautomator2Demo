package com.yftech.uiautomator2demo.sample;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

/**
 * Created by 80736 on 2017/5/28.
 */


public class InstruationTest {

    @Test
    public void instrumentationRegistryTest() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Context context1 = InstrumentationRegistry.getContext();
        Context context2 = InstrumentationRegistry.getTargetContext();
        Context context3 = instrumentation.getContext();

        if (context1 == context2) {
            Log.i("Chris", "InstrumentationRegistry getContext == getTargetContext");
        } else {
            Log.i("Chris", "InstrumentationRegistry getContext != getTargetContext");
        }

        if (context1 == context3) {
            Log.i("Chris", "InstrumentationRegistry getContext == Instrumentation getContext");
        } else {
            Log.i("Chris", "InstrumentationRegistry getContext != Instrumentation getContext");
        }

        Intent intent = context1.getPackageManager().getLaunchIntentForPackage("com.android.calculator2");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context2.startActivity(intent);
    }
}
