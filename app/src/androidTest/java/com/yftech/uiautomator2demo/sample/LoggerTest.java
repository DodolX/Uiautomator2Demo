package com.yftech.uiautomator2demo.sample;

import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.junit.Test;

import static android.content.ContentValues.TAG;

/**
 * Created by 薛东磊 on 2017/6/4.
 */

public class LoggerTest {

    @Test
    public void testlog(){
        Logger.addLogAdapter(new AndroidLogAdapter());
        Log.d(TAG,"hello");
        Logger.e("this is a log");
    }
}
